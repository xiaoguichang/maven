package com.xiaogch.maven.springmvc.config;

import com.xiaogch.maven.wechat.config.WechatWebConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Administrator on 2017/6/25 0025.
 */

@Configuration
@EnableWebMvc
@ComponentScan({"com.xiaogch.maven.springmvc.web"})
@Import({WechatWebConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("/jsp/");
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    /** servlet 3.0 以上 文件上传处理（推荐）*/
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

//    @Bean
//    /** servlet 3.0 以下 文件上传处理（推荐）*/
//    public CommonsMultipartResolver multipartResolver() {
//        return new CommonsMultipartResolver();
//    }
}
