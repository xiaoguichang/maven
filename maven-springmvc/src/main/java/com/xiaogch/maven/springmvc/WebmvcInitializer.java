package com.xiaogch.maven.springmvc;


import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import com.xiaogch.maven.springmvc.config.ApplicationConfig;
import com.xiaogch.maven.springmvc.config.WebConfig;
import com.xiaogch.maven.springmvc.web.filter.AuthFilter;
import com.xiaogch.maven.springmvc.web.servlet.MyServlet;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
public class WebmvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        registerListener(servletContext);
        registerServlet(servletContext);
        registerFilter(servletContext);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
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

    private void registerFilter(ServletContext servletContext) {
        CharacterEncodingFilter encodeFilter = new CharacterEncodingFilter();
        encodeFilter.setEncoding("utf-8");
        FilterRegistration.Dynamic filterDynamic = servletContext.addFilter("encodeFilter" , encodeFilter);
        filterDynamic.addMappingForUrlPatterns(null , false , "/*");
        filterDynamic = servletContext.addFilter("authFilter" , AuthFilter.class);
        filterDynamic.addMappingForUrlPatterns(null , false , "/*");

    }

    private void registerServlet(ServletContext servletContext) {
        ServletRegistration.Dynamic servletDynamic = servletContext.addServlet("myServlet" , new MyServlet());
        servletDynamic.addMapping("/myServlet.do");
    }

    private void registerListener(ServletContext servletContext) {
        servletContext.setInitParameter("logbackConfigLocation" , "classpath:logback.xml");
        servletContext.addListener(LogbackConfigListener.class);
    }
}
