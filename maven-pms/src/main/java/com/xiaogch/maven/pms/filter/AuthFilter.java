package com.xiaogch.maven.pms.filter;

import com.alibaba.fastjson.JSONObject;
import com.xiaogch.maven.common.config.AuthConfig;
import com.xiaogch.maven.common.controller.BaseController;
import com.xiaogch.maven.common.util.SpringContextHolder;
import com.xiaogch.maven.system.entity.UserInfoBean;
import com.xiaogch.maven.system.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter(filterName = "authFilter" , urlPatterns = "/*")
public class AuthFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("AuthFilter is initing ....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        AuthConfig authConfig = SpringContextHolder.getBean(AuthConfig.class);
        Object userObject = request.getSession().getAttribute(authConfig.getUserInfo());
        String url = request.getRequestURL().toString();
        String contextPath = request.getContextPath();
        String path = url.substring(url.indexOf(contextPath) + contextPath.length());

        logger.info("url={} , contextPath={} , path={}" , url , contextPath , path);
        if (isStaticResource(url , authConfig.getRegular())) {
            filterChain.doFilter(servletRequest , servletResponse);
            return;
        }

        if (hasPrivilege(path , authConfig.getNologinPrivileges())) {
            filterChain.doFilter(servletRequest , servletResponse);
            return;
        }

        if (userObject == null) {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect(contextPath + authConfig.getLoginPagePath());
            return;
        }

        if (hasPrivilege(path , authConfig.getCommonPrivileges())) {
            filterChain.doFilter(servletRequest , servletResponse);
            return;
        }

        if (hasPrivilege(path , authConfig.getWebsocketPath())) {
            filterChain.doFilter(servletRequest , servletResponse);
            return;
        }

        AuthService authService = SpringContextHolder.getBean("authService");
        UserInfoBean userInfoBean = (UserInfoBean) userObject;
        if (authService != null && authService.canVisit(userInfoBean.getUserName() , path)) {
            filterChain.doFilter(servletRequest , servletResponse);
            return;
        }

        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            BaseController baseController = new BaseController();
            servletResponse.setContentType("text/plain;charset=UTF-8");
            ServletOutputStream outputStream = servletResponse.getOutputStream();
            outputStream.println(baseController.toResponseContent(-1 , "" , new JSONObject()));
            outputStream.flush();
        } else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect(contextPath + authConfig.getLoginPagePath());
        }

    }

    @Override
    public void destroy() {

    }


    private boolean isStaticResource(String url , String regular) {
        Pattern pattern = Pattern.compile(regular);
        return pattern.matcher(url).matches();
    }

    private boolean hasPrivilege(String url , String privileges) {
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
