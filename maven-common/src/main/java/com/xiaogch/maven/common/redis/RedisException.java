package com.xiaogch.maven.common.redis;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/30 16:18 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class RedisException extends Exception {

    public RedisException() {
        super();
    }

    public RedisException(String message) {
        super(message);
    }

    public RedisException(String message, Throwable cause) {
        super(message , cause);
    }

}
