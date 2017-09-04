package com.xiaogch.maven.wechat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({"com.xiaogch.maven.wechat.web"})
public class WechatWebConfig {
}
