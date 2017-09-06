package com.xiaogch.maven.springmvc.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

        if (isStaticResource(url)) {
            filterChain.doFilter(request , servletResponse);
        }

        if (userObject == null) {

        } else {

        }
    }

    @Override
    public void destroy() {

    }


    private boolean isStaticResource(String url) {
        String reg = "\\.(jsp|html|htm|bmp|jpg|png|tiff|gif|svg|jpeg|css|less|js|otf|eot|ttf|woff|woff2)$";
        Pattern pattern = Pattern.compile(reg);
        return pattern.matcher(url).matches();
    }
}
