package com.xiaogch.maven.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Administrator on 2017/6/25 0025.
 */

@Configuration
@Import({MasterDataBaseConfig.class})
@PropertySource({"classpath:database.properties"})
@ComponentScan("com.xiaogch.maven.springmvc")
public class ApplicationConfig {

}
