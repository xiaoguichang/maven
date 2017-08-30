package com.xiaogch.maven.wechat.config;

public class RedisKeyConstants {

    /** 微信accessToken redis key */
    public static final String ACCESS_TOKEN_KEY = "weixin:accesstoken";

    /** 微信accessToken 刷新锁 reids key */
    public static final String ACCESS_TOKEN_LOCK_KEY = "weixin:accesstoken:lock";


}
