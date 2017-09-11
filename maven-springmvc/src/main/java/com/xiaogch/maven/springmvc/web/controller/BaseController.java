package com.xiaogch.maven.springmvc.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/8 16:47 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class BaseController {

    protected final int resultCodeSuccess = 1;
    protected final int resultCodeFailure = 0;

    protected final String defaultDateFormat = "yyyy-MM-dd HH:mm:ss";

    protected String toFailureResponseContent(Errors errors) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (ObjectError error : errors.getAllErrors()) {
            if (index == 0) {
                sb.append(error.getDefaultMessage());
            } else {
                sb.append(" ; ").append(error.getDefaultMessage());
            }
        }
        return toFailureResponseContent(sb.toString());
    }

    protected String toFailureResponseContent(String message) {
        return toFailureResponseContent(message , new JSONObject());
    }

    protected String toSuccessResponseContent() {
        return toSuccessResponseContent(new JSONObject());
    }

    protected String toSuccessResponseContent(Object data) {
        return toResponseContent(resultCodeSuccess , "ok" , data , defaultDateFormat);
    }

    protected String toSuccessResponseContent(Object data , String dateFormat) {
        return toResponseContent(resultCodeSuccess , "ok" , data , dateFormat);
    }

    protected String toFailureResponseContent(String message , Object data) {
        return toResponseContent(resultCodeFailure , message , data , defaultDateFormat);
    }

    protected String toFailureResponseContent(String message , Object data , String dateFormat) {
        return toResponseContent(resultCodeFailure , message , data , dateFormat);
    }

    public String toResponseContent(int resultCode , String message , Object data) {
        return toResponseContent(resultCode , message , data , defaultDateFormat);
    }

    public String toResponseContent(int resultCode , String message , Object data , String dateFormat) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("resultCode" , resultCode);
        jsonObject.put("message" , message);
        jsonObject.put("data" , data == null ? new JSONObject() : data);
        return JSONObject.toJSONStringWithDateFormat(jsonObject , dateFormat , SerializerFeature.WriteMapNullValue);
    }

//    public static void main(String...argvs){
//        BaseController controller = new BaseController();
//        SystemUserInfoBean userInfoBean = new SystemUserInfoBean();
//        System.out.println(controller.toSuccessResponseContent(userInfoBean));
//        userInfoBean.setCreateTime(new Date());
//        System.out.println(controller.toSuccessResponseContent(userInfoBean));
//        userInfoBean.setNickname("xiaozhanggui");
//        System.out.println(controller.toSuccessResponseContent(userInfoBean));
//    }
}
