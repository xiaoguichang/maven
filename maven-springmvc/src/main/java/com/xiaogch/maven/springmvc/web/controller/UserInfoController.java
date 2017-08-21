package com.xiaogch.maven.springmvc.web.controller;

import com.xiaogch.maven.springmvc.entity.UserInfoBean;
import com.xiaogch.maven.springmvc.service.UserInfoService;
import com.xiaogch.maven.springmvc.util.StringToDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/register")
    @ResponseBody
    public String register(HttpServletRequest request , HttpServletResponse response , UserInfoBean userInfoBean) {
        logger.info("user info of request {}" , userInfoBean);
        try  {
            int result = userInfoService.insert(userInfoBean);
            logger.info("insert user info to database table result is {} , {}", result , userInfoBean);
            return "success";
        } catch (Exception e) {
            logger.error("insert user info to database table exception {}" , userInfoBean);
            logger.error(e.getMessage() , e);
            return "fail";
        }
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo(HttpServletRequest request , HttpServletResponse response ,
                              @RequestParam(value = "id") Integer id) {
        Assert.notNull(id , "id can't be null");
        UserInfoBean userInfoBean =  userInfoService.selectById(id);
        if (userInfoBean == null)  {
           return null;
        } else {
            return userInfoBean.toString();
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Date.class , new StringToDateUtil());
    }
}
