package com.xiaogch.maven.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RequiredBeanTest {

	@Test
	public void testHelloWorld() {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/config/applicationContext.xml");
		RequiredBean requiredBean = (RequiredBean) applicationContext.getBean("requiredBean");
	
		requiredBean.helloWorld();
	}

}
