package com.xiaogch.maven.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesConfig {

    Logger logger = LoggerFactory.getLogger(getClass());

    protected Properties properties;

    public Properties load(String resource) {
        logger.info("load properties from classpath file {}" , resource);

        Properties properties = new Properties();

        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
            Enumeration<?> pns = properties.propertyNames();
            while (pns.hasMoreElements()) {
                Object object = pns.nextElement();
                if (object != null) {
                    logger.info("{} = {}" , object , properties.getProperty(object.toString()));
                }
            }
        } catch (IOException e) {
            logger.error("load propties from classpath file:" + resource + " exception" , e);
        }
        return properties;

    }

    public String getValue(String propertyName) {
        return getValue(propertyName , null);
    }

    public String getValue(String propertyName , String defaultValue) {
        if (properties.contains(propertyName)) {
            return properties.getProperty(propertyName);
        }
        return defaultValue;
    }

    public Integer getIntegerValue(String propertyName) {
        return getIntegerValue(propertyName , null);
    }

    public Integer getIntegerValue(String propertyName , Integer defaultValue){
        if (!properties.contains(propertyName)) {
            return defaultValue;
        }
        return Integer.parseInt(properties.getProperty(propertyName));
    }
}
