package com.xiaogch.maven.common.databinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/11 16:02 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class StringToDateBinder extends PropertyEditorSupport {

    public final String dateFormatter;

    public StringToDateBinder(String dateFormatter) {
        this.dateFormatter = dateFormatter;
    }
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat format = new SimpleDateFormat(StringUtils.hasText(dateFormatter) ? dateFormatter : "yyyy-MM-dd");
        Date date = null;
        try {
            //防止空数据出错
            if (StringUtils.hasText(text)) {
                date = format.parse(text);
            }
        } catch (ParseException e) {
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
