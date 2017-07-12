package com.xiaogch.maven.springmvc.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
public class HttpRequestUtil {

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
