package com.xiaogch.maven.wechat.common.constant;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/27 10:48 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class RedisKeyConstants {

    /** 微信accessToken redis key */
    public static final String ACCESS_TOKEN_KEY = "wechat.accesstoken";
    /** 微信accessToken 刷新锁 reids key */
    public static final String ACCESS_TOKEN_LOCK_KEY = "wechat.accesstoken.lock";

    /** 微信jsapi ticket redis key */
    public static final String JSAPI_TICKET_KEY = "wechat.jsapi.ticket";
    /** 微信jsapi ticket 刷新锁 reids key */
    public static final String JSAPI_TICKET_LOCK_KEY = "wechat.jsapi.ticket.lock";

    /** 微信wx_card ticket redis key */
    public static final String WX_CARD_TICKET_KEY = "wechat.wxcard.ticket";
    /** 微信wx_card ticket 刷新锁 reids key */
    public static final String WX_CARD_TICKET_LOCK_KEY = "wechat.wxcard.ticket.lock";
}
