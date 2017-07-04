package com.xiaogch.maven.springmvc;


import com.xiaogch.maven.springmvc.config.ApplicationConfig;
import com.xiaogch.maven.springmvc.config.WebConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
public class WebmvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        super.onStartup();
        return new Class[]{ApplicationConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    public void registerLi() {

    }

    private void registerServlet(ServletContext servletContext) {
        FilterRegistration.Dynamic filterDynamic = servletContext.addFilter("characterEncodingFilter" , new CharacterEncodingFilter());
    }

}
