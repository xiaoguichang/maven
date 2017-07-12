package com.xiaogch.maven.springmvc;


import com.xiaogch.maven.springmvc.config.ApplicationConfig;
import com.xiaogch.maven.springmvc.config.WebConfig;
import com.xiaogch.maven.springmvc.web.servlet.MyServlet;
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
        FilterRegistration.Dynamic filterDynamic = servletContext.addFilter("encodeFilter" , CharacterEncodingFilter.class);
        filterDynamic.addMappingForUrlPatterns(null , false , "/*");
    }

    private void registerServlet(ServletContext servletContext) {
        ServletRegistration.Dynamic servletDynamic = servletContext.addServlet("myServlet" , new MyServlet());
        servletDynamic.addMapping("/myServlet.do");
    }

    private void registerListener(ServletContext servletContext) {
//        servletContext.addListener("");
    }
}
