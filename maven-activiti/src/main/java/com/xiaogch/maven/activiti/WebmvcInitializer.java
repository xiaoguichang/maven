package com.xiaogch.maven.activiti;


import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import com.xiaogch.maven.activiti.config.ApplicationConfiguration;
import com.xiaogch.maven.activiti.config.WebConfiguration;
import org.activiti.engine.delegate.JavaDelegate;
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
        registerServlet(servletContext);
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
        FilterRegistration.Dynamic filterDynamic = servletContext.addFilter("encodeFilter" , CharacterEncodingFilter.class);
        filterDynamic.addMappingForUrlPatterns(null , false , "/*");
    }

    private void registerServlet(ServletContext servletContext) {

    }

    private void registerListener(ServletContext servletContext) {
        servletContext.setInitParameter("logbackConfigLocation" , "classpath:config/logback.xml");
        servletContext.addListener(LogbackConfigListener.class);
    }
}
