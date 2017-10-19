package com.xiaogch.maven.wechat.core.service;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/27 12:38 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public interface TokenAndTicketService {

    /**
     * 获取微信AccessToken
     * @return 成功返回accessToken ， 失败返回 null
     */
    public String getJsapiTicket() throws WechatException;

    /**
     * 获取微信AccessToken
     * @return 成功返回accessToken ， 失败返回 null
     */
    public String getWxCardTicket() throws WechatException;


    public String getAccessToken() throws WechatException;
}
