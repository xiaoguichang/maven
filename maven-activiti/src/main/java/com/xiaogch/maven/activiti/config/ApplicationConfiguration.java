package com.xiaogch.maven.activiti.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
@Configuration
@PropertySource({"classpath:config/database.properties"})
@Import({MasterDataBaseConfiguration.class , ActivitiConfiguration.class})
@ComponentScan("com.xiaogch.maven.activiti")
public class ApplicationConfiguration {

    @Bean
    public PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}


