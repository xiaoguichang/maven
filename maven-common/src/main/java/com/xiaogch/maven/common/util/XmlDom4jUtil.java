package com.xiaogch.maven.common.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

public class XmlDom4jUtil {

    static Logger logger = LoggerFactory.getLogger(XmlDom4jUtil.class);

    public static <T> T praseToBean(InputStream inputStream , Class<T> tClass) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputStream);
        if (document != null) {
            T t = tClass.newInstance();
            Element element = document.getRootElement();
            parseElement(element , t);
            return t;
        }
        return null;
    }

    private static <T> void parseElement(Element element , T t) {
        if (element == null || t == null) {
            return;
        }
        Class tClass = t.getClass();

        Iterator<Element> iterator = element.elementIterator();
        while (iterator.hasNext()) {
            parseElement(iterator.next() , t);
        }

        String tagName = element.getName();
        String text = element.getText();

        String setMethodName = "set" + tagName.substring(0 , 1).toUpperCase() + tagName.substring(1);
        try {
            Method method = tClass.getMethod(setMethodName , String.class);
            method.invoke(t ,text);
        } catch (NoSuchMethodException e) {
            logger.error("parseElement NoSuchMethodException" , e);
        } catch (IllegalAccessException e) {
            logger.error("parseElement IllegalAccessException" , e);
        } catch (InvocationTargetException e) {
            logger.error("parseElement InvocationTargetException" , e);
        }
    }

}
