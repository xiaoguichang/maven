package com.xiaogch.maven.wechat.core.service;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/28 14:18 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class WechatException extends Exception {

    public WechatException() {
        super();
    }

    public WechatException(String message) {
        super(message);
    }

    public WechatException(String message, Throwable cause) {
        super(message , cause);
    }

}