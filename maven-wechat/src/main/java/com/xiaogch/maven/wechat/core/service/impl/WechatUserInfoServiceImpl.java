package com.xiaogch.maven.wechat.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiaogch.maven.common.redis.JedisStringService;
import com.xiaogch.maven.common.util.HttpRequestUtil;
import com.xiaogch.maven.wechat.common.user.dto.WechatUserInfoDto;
import com.xiaogch.maven.wechat.config.WechatConfig;
import com.xiaogch.maven.wechat.core.service.TokenAndTicketService;
import com.xiaogch.maven.wechat.core.service.WechatException;
import com.xiaogch.maven.wechat.core.service.WechatUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/28 11:37 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
@Service
public class WechatUserInfoServiceImpl implements WechatUserInfoService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    WechatConfig wechatConfig;

    @Autowired
    TokenAndTicketService tokenAndTicketService;

    @Autowired
    private JedisStringService jedisStringService;

    @Override
    public String getOpenIdByCode(String code) throws WechatException {
        String url = wechatConfig.getAuthorizetokenUrl();
        url = url.replaceAll("@appid" , wechatConfig.getAppId());
        url = url.replaceAll("@secret" , wechatConfig.getSecret());
        url = url.replaceAll("@code" , code);
        try {
            JSONObject result = HttpRequestUtil.getRequestByJson(url);
            logger.info("send request to {} result is {}" , url , result);
            if (result != null && result.containsKey("openid")) {
                return result.getString("openid");
            }
        } catch (Exception e) {
            throw new WechatException("getOpenIdByCode api call exception,\n" + e.getMessage() , e);
        }
        throw new WechatException("getOpenIdByCode api call failure");
    }

    @Override
    public WechatUserInfoDto getUserInfoByOpenId(String openId) throws WechatException {

        String accessToken = tokenAndTicketService.getAccessToken();

        String url = wechatConfig.getUserInfoUrl();
        url = url.replaceAll("@accessToken" , accessToken);
        url = url.replaceAll("@openid" , openId);
        try {
            JSONObject result = HttpRequestUtil.getRequestByJson(url);
            logger.info("send request to {} result is {}" , url , result);
            if (result != null && result.containsKey("subscribe")) {
                WechatUserInfoDto dto = new WechatUserInfoDto();
                dto.setSubscribe(result.getInteger("subscribe"));
                dto.setOpenid(result.getString("openid"));
                dto.setNickname(result.getString("nickname"));
                dto.setSex(result.getInteger("sex"));
                dto.setLanguage(result.getString("language"));
                dto.setCity(result.getString("city"));
                dto.setProvince(result.getString("province"));
                dto.setCountry(result.getString("country"));
                dto.setHeadimgurl(result.getString("headimgurl"));
                dto.setSubscribeTime(result.getLong("subscribe_time"));
                dto.setUnionid(result.getString("unionid"));
                dto.setRemark(result.getString("remark"));
                dto.setGroupid(result.getInteger("groupid"));
                dto.setRemark(result.getString("remark"));
                JSONArray array = result.getJSONArray("tagid_list");
                List<Integer> tagidList = new ArrayList<>();
                if (array != null ) {
                    for (int index = 0 ; index < array.size() ; index ++ ) {
                        tagidList.add(array.getInteger(index));
                    }
                }
                dto.setTagidList(tagidList);
                return dto;
            }
        } catch (Exception e) {
            throw new WechatException("getUserInfoByOpenId api call exception,\n" + e.getMessage() , e);
        }
        throw new WechatException("getUserInfoByOpenId api call failure");
    }
}
