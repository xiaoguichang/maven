package com.xiaogch.maven.springmvc.web.filter;

import com.xiaogch.maven.common.util.SpringContextHolder;
import com.xiaogch.maven.springmvc.config.AuthConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

public class AuthFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        Object userObject = request.getSession().getAttribute("user");
        String url = request.getRequestURL().toString();
        AuthConfig authConfig = SpringContextHolder.getBean(AuthConfig.class);
        if (isStaticResource(url , authConfig.getRegular())) {
            filterChain.doFilter(request , servletResponse);
        }
        String contextPath = request.getContextPath();
        String path = url.substring(url.indexOf(contextPath) + contextPath.length());
        if (userObject == null && isNologinPrivilege(path , authConfig.getPrivileges())) {

        } else {

        }
    }

    @Override
    public void destroy() {

    }


    private boolean isStaticResource(String url , String regular) {
        Pattern pattern = Pattern.compile(regular);
        return pattern.matcher(url).matches();
    }

    private boolean isNologinPrivilege(String url , String privileges) {
        if (url == null || !StringUtils.hasText(privileges)) {
            return false;
        }
        String[] privilegesArr = privileges.split(",");
        for (String privilege : privilegesArr) {
            if (url.equals(privilege)) {
                return true;
            }
        }
        return false;
    }
}
