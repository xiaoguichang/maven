package com.xiaogch.maven.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static <T> T getBean(String beanName) {
        Assert.notNull(applicationContext , "applicationContext is null");
        Assert.notNull(beanName , "beanName must be not null");
        return (T) applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> classz)  {
        Assert.notNull(applicationContext , "applicationContext is null");
        Assert.notNull(classz , "classz must be not null");
        return (T) applicationContext.getBean(classz);
    }

    public static <T> T getBean(String beanName , Class<T> classz)  {
        Assert.notNull(applicationContext , "applicationContext is null");
        Assert.notNull(classz , "classz must be not null");
        return (T) applicationContext.getBean(beanName , classz);
    }

    public static ApplicationContext getApplicationContext() {
        Assert.notNull(applicationContext , "applicationContext is null");
        return applicationContext;
    }
}
