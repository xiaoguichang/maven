package com.xiaogch.maven.wechat.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xiaogch.maven.common.exception.HttpRequestException;
import com.xiaogch.maven.common.redis.JedisStringService;
import com.xiaogch.maven.common.redis.RedisException;
import com.xiaogch.maven.common.util.HttpRequestUtil;
import com.xiaogch.maven.wechat.common.constant.RedisKeyConstants;
import com.xiaogch.maven.wechat.common.core.dto.AccessTokenDto;
import com.xiaogch.maven.wechat.common.core.dto.TicketDto;
import com.xiaogch.maven.wechat.config.WechatConfig;
import com.xiaogch.maven.wechat.core.service.TokenAndTicketService;
import com.xiaogch.maven.wechat.core.service.WechatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/27 12:40 <BR>
 * Description: <BR>
 * Function List: <BR>
 */

@Service("tokenAndTicketService")
public class TokenAndTicketServiceImpl implements TokenAndTicketService {


    public static final String TICKET_TYPE_WX_CARD = "wx_card";
    public static final String TICKET_TYPE_JSAPI = "jsapi";


    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WechatConfig wechatConfig;

    @Autowired
    private JedisStringService jedisStringService;


    /**
     * 获取微信AccessToken
     * @return 成功返回accessToken ， 失败返回 null
     */
    @Override
    public String getJsapiTicket() throws WechatException {
        return getTicket(TICKET_TYPE_JSAPI);
    }


    /**
     * 获取微信AccessToken
     * @return 成功返回accessToken ， 失败返回 null
     */
    @Override
    public String getWxCardTicket() throws WechatException {
        return getTicket(TICKET_TYPE_WX_CARD);
    }

    private String getTicket(String ticketType) throws WechatException {
        //从redis中获取Ticket
        TicketDto ticketDto = getTicketFromRedis(ticketType);
        if (ticketDto != null && !isExpired(ticketDto.getExpireTimeStamp())) {
            return ticketDto.getTicket();
        }

        //重新生成Ticket
        ticketDto = genTicket(ticketType);
        return ticketDto.getTicket();
    }

    /**
     * 判断是否过期
     * @param expireTimeStamp 过期时间戳
     * @return
     */
    private boolean isExpired(Long expireTimeStamp) {
        if (expireTimeStamp == null) {
            return true;
        }
        if (System.currentTimeMillis() > expireTimeStamp) {
            return false;
        } else {
            return true;
        }
    }

    /***
     *
     * @param ticketType
     * @return
     */
    public TicketDto getTicketFromRedis(String ticketType) throws WechatException {
        String keyName = getRedisKey(ticketType);
        try {
            return jedisStringService.getValue(keyName , TicketDto.class);
        } catch (RedisException e) {
            throw new WechatException("getTicketFromRedis redis exception");
        }
    }

    private TicketDto genTicket(String ticketType) throws WechatException {
        String lockName = getRedisLockKey(ticketType);
        String keyName = getRedisKey(ticketType);
        //JedisStringService ticketJedisService = new JedisStringService(jedisService.getPool() , keyName);
        try {
            if (!jedisStringService.getLock(lockName, 5 * 60 * 1000, 1 * 60 * 1000l)) {
                logger.info("get lock to fresh access_token failure , key={}", lockName);
                return null;
            }

            TicketDto ticketDto = getTicketFromRedis(ticketType);
            if (ticketDto != null && !isExpired(ticketDto.getExpireTimeStamp())) {
                jedisStringService.releaseLock(lockName);
                return ticketDto;
            }
            String url = wechatConfig.getTicketUrl();
            url = url.replaceAll("@accessToken", getAccessToken());
            url = url.replaceAll("@ticketType", ticketType);
            JSONObject responseJson = HttpRequestUtil.getRequestByJson(url);
            logger.info("get ticket from weixin server response={} url={}", responseJson, url);
            if (responseJson != null && responseJson.containsKey("ticket")) {
                TicketDto ticketDtoTmp = new TicketDto();
                ticketDtoTmp.setTicket(responseJson.getString("ticket"));
                ticketDtoTmp.setAppId(wechatConfig.getAppId());
                long currentTime = System.currentTimeMillis();
                ticketDtoTmp.setCreateTimestamp(currentTime);
                int expiresIn = responseJson.getIntValue("expires_in");
                ticketDtoTmp.setExpiresIn(expiresIn);
                //提前五分钟失效
                ticketDtoTmp.setExpireTimeStamp(currentTime + (expiresIn - 5 * 60) * 1000);
                //设置redis信息
                jedisStringService.set(keyName , JSONObject.toJSONString(ticketDtoTmp));
                return ticketDtoTmp;
            }
        } catch (Exception e) {
            if (e instanceof HttpRequestException) {
                throw new WechatException("genTicket http request exception,\n" + e.getMessage() , e);
            } else if (e instanceof RedisException) {
                throw new WechatException("genTicket redis exception,\n" + e.getMessage() , e);
            } else {
                throw new WechatException("genTicket unkown exception,\n" + e.getMessage() , e);
            }
        } finally {
            try {
                jedisStringService.releaseLock(lockName);
            } catch (RedisException e) {
                logger.error("releaseLock lockName=" + lockName + " exception" , e);
            }
        }
        throw new WechatException("genTicket api call failure");
    }

    private String getRedisKey(String ticketType) {
        if (TICKET_TYPE_JSAPI.equals(ticketType)) {
            return RedisKeyConstants.JSAPI_TICKET_KEY;
        } else if (TICKET_TYPE_WX_CARD.equals(ticketType)){
            return RedisKeyConstants.WX_CARD_TICKET_KEY;
        } else {
            throw new IllegalArgumentException("无效的ticketType，目前支持jsapi、wx_card");
        }
    }

    private String getRedisLockKey(String ticketType) {
        if (TICKET_TYPE_JSAPI.equals(ticketType)) {
            return RedisKeyConstants.JSAPI_TICKET_LOCK_KEY;
        } else if (TICKET_TYPE_WX_CARD.equals(ticketType)){
            return RedisKeyConstants.WX_CARD_TICKET_LOCK_KEY;
        } else {
            throw new IllegalArgumentException("无效的ticketType，目前支持jsapi、wx_card");
        }
    }



    @Override
    public String getAccessToken() throws WechatException {
        AccessTokenDto accessTokenDto = getAccessTokenFromRedis();
        if (accessTokenDto != null && !isExpired(accessTokenDto.getExpireTimeStamp())) {
            return accessTokenDto.getAccessToken();
        }
        return genAccessToken().getAccessToken();
    }

    public AccessTokenDto getAccessTokenFromRedis() throws WechatException {
        try {
            return jedisStringService.getValue(RedisKeyConstants.ACCESS_TOKEN_KEY , AccessTokenDto.class);
        } catch (RedisException e) {
            throw new WechatException("getAccessTokenFromRedis redis exception" , e);
        }
    }


    private AccessTokenDto genAccessToken() throws WechatException {
        String lockName = RedisKeyConstants.ACCESS_TOKEN_LOCK_KEY;
        String keyName = RedisKeyConstants.ACCESS_TOKEN_KEY;
        try {
            if (!jedisStringService.getLock(lockName , 5*60*1000 , 1*60*1000l)) {
                logger.info("get lock to fresh access_token failure , key={}" , lockName);
                throw new WechatException("get the lock to fresh accessToken failure");
            }

            AccessTokenDto accessTokenDto = getAccessTokenFromRedis();
            if (accessTokenDto != null && !isExpired(accessTokenDto.getExpireTimeStamp())) {
                jedisStringService.releaseLock(lockName);
                return accessTokenDto;
            }

            String url = wechatConfig.getTokenUrl();
            url = url.replaceAll("@appid" , wechatConfig.getAppId());
            url = url.replaceAll("@secret" , wechatConfig.getSecret());

            JSONObject responseJson = HttpRequestUtil.getRequestByJson(url);
            logger.info("get access_token from weixin server response={} url={}" , responseJson, url);
            if (responseJson != null && responseJson.containsKey("access_token")) {
                accessTokenDto = new AccessTokenDto();
                accessTokenDto.setAccessToken(responseJson.getString("access_token"));
                accessTokenDto.setAppId(wechatConfig.getAppId());
                long currentTime = System.currentTimeMillis();
                accessTokenDto.setCreateTimestamp(currentTime);
                int expiresIn = responseJson.getIntValue("expires_in");
                accessTokenDto.setExpiresIn(expiresIn);
                //提前五分钟失效
                accessTokenDto.setExpireTimeStamp(currentTime + (expiresIn-5*60)*1000);
                //设置redis信息
                jedisStringService.set(keyName , JSONObject.toJSONString(accessTokenDto));
                return accessTokenDto;
            }
        } catch (Exception e) {
            if (e instanceof HttpRequestException) {
                throw new WechatException("genAccessToken http request exception,\n" + e.getMessage() , e);
            } else if (e instanceof RedisException) {
                throw new WechatException("genAccessToken redis exception,\n" + e.getMessage() , e);
            } else {
                throw new WechatException("genAccessToken unkown exception,\n" + e.getMessage() , e);
            }
        } finally {
            try {
                jedisStringService.releaseLock(lockName);
            } catch (RedisException e) {
                logger.error("releaseLock lockName=" + lockName + " exception" , e);
            }
        }
        throw new WechatException("genAccessToken api call failure");
    }
}
