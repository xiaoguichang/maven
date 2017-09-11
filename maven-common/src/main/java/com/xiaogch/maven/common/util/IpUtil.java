package com.xiaogch.maven.common.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/11 17:37 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class IpUtil {

    public static String getRequestIp(HttpServletRequest request) {
        //X-Forwarded-For: client1, proxy1, proxy2, proxy3
        String srcIp = request.getHeader("X-Forwarded-For");
        if (StringUtils.hasText(srcIp) && !"unknown".equalsIgnoreCase(srcIp)) {
            String[] ips = srcIp.split(",");
            if (StringUtils.hasText(ips[0]) && !"unknown".equalsIgnoreCase(ips[0])) {
                return ips[0];
            }
        }
        srcIp = request.getHeader("Proxy-Client-IP");
        if (StringUtils.hasText(srcIp) && !"unknown".equalsIgnoreCase(srcIp)) {
            return srcIp;
        }

        srcIp = request.getHeader("WL-Proxy-Client-IP");
        if (StringUtils.hasText(srcIp) && !"unknown".equalsIgnoreCase(srcIp)) {
            return srcIp;
        }

        srcIp = request.getHeader("HTTP_CLIENT_IP");
        if (StringUtils.hasText(srcIp) && !"unknown".equalsIgnoreCase(srcIp)) {
            return srcIp;
        }

        srcIp = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (StringUtils.hasText(srcIp) && !"unknown".equalsIgnoreCase(srcIp)) {
            return srcIp;
        }
        return request.getRemoteAddr();
    }
}
