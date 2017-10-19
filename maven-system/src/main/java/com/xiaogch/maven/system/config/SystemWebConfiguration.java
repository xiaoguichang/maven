package com.xiaogch.maven.system.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/11 16:09 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.xiaogch.maven.system.web")
public class SystemWebConfiguration {
}
