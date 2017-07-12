package com.xiaogch.maven.springmvc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
public class StringToDateUtil extends PropertyEditorSupport {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            //防止空数据出错
            if (StringUtils.hasText(text)) {
                date = format.parse(text);
            }
        } catch (ParseException e) {
            format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = format.parse(text);
            } catch (ParseException e1) {
                format = new SimpleDateFormat("yyyy-MM");

                try {
                    date = format.parse(text);
                } catch (Exception e2) {
                    logger.error("自动绑定日期数据出错", e);
                }
            }
        }
        setValue(date);
    }

}
