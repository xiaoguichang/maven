package com.xiaogch.maven.wechat.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaogch.maven.common.redis.JedisCache;
import com.xiaogch.maven.common.redis.JedisStringCache;
import com.xiaogch.maven.common.redis.RedisException;
import com.xiaogch.maven.common.util.HttpRequestUtil;
import com.xiaogch.maven.wechat.config.RedisKeyConstants;
import com.xiaogch.maven.wechat.config.WeiXinParamterConfiguration;
import com.xiaogch.maven.wechat.core.entity.AccessTokenEntitiy;
import com.xiaogch.maven.wechat.core.service.AccessTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accessTokenService")
public class AccessTokenServiceImpl implements AccessTokenService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WeiXinParamterConfiguration weixinConfig;

    @Autowired
    private JedisCache jedisCache;


    @Override
    public String getAccessToken() {
        AccessTokenEntitiy accessTokenEntitiy = getAccessTokenFromRedis();
        if (!isExpired(accessTokenEntitiy)) {
            return accessTokenEntitiy.getAccessToken();
        }
        try {
            accessTokenEntitiy = genAccessToken();
            return accessTokenEntitiy.getAccessToken();
        } catch (RedisException e) {
            logger.error("genAccessToken exception" , e);
        }
        return null;
    }

    private boolean isExpired(AccessTokenEntitiy entitiy) {
        if (entitiy == null || entitiy.getExpireTimeStamp() == null) {
            return true;
        }
        if (System.currentTimeMillis() > entitiy.getExpireTimeStamp()) {
            return false;
        } else {
            return true;
        }
    }

    public AccessTokenEntitiy getAccessTokenFromRedis() {
        JedisStringCache accessTokenCache = new JedisStringCache(jedisCache.getPool() , RedisKeyConstants.ACCESS_TOKEN_KEY);
        try {
            String result = accessTokenCache.get();
            logger.info("weixin accesstoken in redis is:{}" , result);
            if (result != null) {
                return JSONObject.parseObject(result , AccessTokenEntitiy.class);
            }
        } catch (Exception e) {
            logger.error("getAccessToken exception" , e);
        }
        return null;
    }



    private AccessTokenEntitiy genAccessToken() throws RedisException {
        JedisStringCache accessTokenCache = new JedisStringCache(jedisCache.getPool() , RedisKeyConstants.ACCESS_TOKEN_KEY);
        if (!accessTokenCache.getLock(RedisKeyConstants.ACCESS_TOKEN_LOCK_KEY , 5*60*1000 , 1*60*1000l)) {
            logger.info("get lock to fresh access_token failure , key={}" , RedisKeyConstants.ACCESS_TOKEN_LOCK_KEY);
            return null;
        }

        AccessTokenEntitiy accessTokenEntitiy = getAccessTokenFromRedis();
        if (!isExpired(accessTokenEntitiy)) {
            accessTokenCache.releaseLock(RedisKeyConstants.ACCESS_TOKEN_LOCK_KEY);
            return accessTokenEntitiy;
        }

        StringBuilder url = new StringBuilder();
        url.append(weixinConfig.getTokenUrl())
                .append("&appid=").append(weixinConfig.getAppId())
                .append("&secret=").append(weixinConfig.getAppSecret());
        try {
            String responseStr = HttpRequestUtil.doGetAndReturnString(url.toString());
            logger.info("get access_token from weixin server response is:{}" , responseStr);
            JSONObject responseJson = JSON.parseObject(responseStr);
            if (responseJson.containsKey("access_token")) {
                accessTokenEntitiy = new AccessTokenEntitiy();
                accessTokenEntitiy.setAccessToken(responseJson.getString("access_token"));
                accessTokenEntitiy.setAppId(weixinConfig.getAppId());
                long currentTime = System.currentTimeMillis();
                accessTokenEntitiy.setCreateTimestamp(currentTime);
                int expiresIn = responseJson.getIntValue("expires_in");
                accessTokenEntitiy.setExpiresIn(expiresIn);
                //提前五分钟失效
                accessTokenEntitiy.setExpireTimeStamp(currentTime + (expiresIn-5*60)*1000);

                //设置redis信息
                accessTokenCache.set(JSONObject.toJSONString(accessTokenEntitiy));

                accessTokenCache.releaseLock(RedisKeyConstants.ACCESS_TOKEN_LOCK_KEY);
                return accessTokenEntitiy;
            }
        } catch (RedisException e) {
            accessTokenCache.releaseLock(RedisKeyConstants.ACCESS_TOKEN_LOCK_KEY);
            throw e;
        } catch (Exception e){
            logger.error("get access_token from weixin server exception" , e);
        }
        return null;
    }
}
