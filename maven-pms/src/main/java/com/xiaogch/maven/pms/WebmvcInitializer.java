package com.xiaogch.maven.pms;


import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import com.xiaogch.maven.pms.config.ApplicationConfiguration;
import com.xiaogch.maven.pms.config.WebConfiguration;
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
        registerListener(servletContext);
        registerFilter(servletContext);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    private void registerFilter(ServletContext servletContext) {
        CharacterEncodingFilter encodeFilter = new CharacterEncodingFilter();
        encodeFilter.setEncoding("utf-8");
        FilterRegistration.Dynamic filterDynamic = servletContext.addFilter("encodeFilter" , encodeFilter);
        filterDynamic.addMappingForUrlPatterns(null , false , "/*");
    }

    private void registerListener(ServletContext servletContext) {
        servletContext.setInitParameter("logbackConfigLocation" , "classpath:logback.xml");
        servletContext.addListener(LogbackConfigListener.class);
    }
}