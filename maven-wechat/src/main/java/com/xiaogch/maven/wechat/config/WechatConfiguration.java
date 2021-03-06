package com.xiaogch.maven.wechat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:redis.properties" , "classpath:wechat.properties"})
@Import({RedisConfiguration.class})
public class WechatConfiguration {

}
