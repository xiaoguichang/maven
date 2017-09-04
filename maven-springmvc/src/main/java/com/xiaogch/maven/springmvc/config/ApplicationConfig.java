package com.xiaogch.maven.springmvc.config;

import com.xiaogch.maven.wechat.config.WechatConfig;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import({WechatConfig.class , MasterDataBaseConfig.class})
@PropertySource({"classpath:database.properties"})
@ComponentScan({"com.xiaogch.maven.springmvc.*"})
public class ApplicationConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
