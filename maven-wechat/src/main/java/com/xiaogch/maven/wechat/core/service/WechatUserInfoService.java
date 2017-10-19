package com.xiaogch.maven.wechat.core.service;


import com.xiaogch.maven.wechat.common.user.dto.WechatUserInfoDto;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/28 11:34 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public interface WechatUserInfoService {

    String getOpenIdByCode(String code) throws WechatException;

    WechatUserInfoDto getUserInfoByOpenId(String openId) throws WechatException;

}
