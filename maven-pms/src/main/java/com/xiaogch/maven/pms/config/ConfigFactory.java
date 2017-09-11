package com.xiaogch.maven.pms.config;

import com.xiaogch.maven.common.config.AuthConfig;
import com.xiaogch.maven.common.util.SpringContextHolder;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/11 11:43 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class ConfigFactory {

    private static final AuthConfig authConfig = SpringContextHolder.getBean(AuthConfig.class);

    public static AuthConfig getAuthConfig() {
        return authConfig;
    }
}
