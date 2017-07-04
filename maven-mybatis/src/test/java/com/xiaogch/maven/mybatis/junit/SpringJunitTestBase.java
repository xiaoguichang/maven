package com.xiaogch.maven.mybatis.junit;

import java.io.FileNotFoundException;
import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conf/applicationContext.xml"})
public class SpringJunitTestBase {
	static {
		try {
			String resolvedLocation = SystemPropertyUtils.resolvePlaceholders("classpath:conf/log4j.properties");
			URL url = ResourceUtils.getURL(resolvedLocation);
			if (("file".equals(url.getProtocol())) && (!(ResourceUtils.getFile(url).exists()))) {
				throw new FileNotFoundException("Log4j config file [" + resolvedLocation + "] not found");
			}
			
			if (resolvedLocation.toLowerCase().endsWith(".xml")) {
				DOMConfigurator.configure(url);
			} else {
				PropertyConfigurator.configure(url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
