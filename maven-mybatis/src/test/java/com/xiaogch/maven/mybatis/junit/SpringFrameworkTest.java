package com.xiaogch.maven.mybatis.junit;

import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFrameworkTest {
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:conf/applicationContext.xml");
		
		
		DefaultSqlSessionFactory bean = (DefaultSqlSessionFactory)context.getBean("sqlSessionFactory");
		
		System.out.println("end ...");
	}
}
