package com.xiaogch.maven.pms.config;

import com.xiaogch.maven.common.util.SpringContextHolder;
import com.xiaogch.maven.wechat.config.WechatConfig;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import({WechatConfig.class , MasterDataBaseConfig.class})
@PropertySource({"classpath:system.properties"})
@ComponentScan({"com.xiaogch.maven.*"})
public class ApplicationConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public SpringContextHolder getSpringContextHolder() {
        return new SpringContextHolder();
    }
}
