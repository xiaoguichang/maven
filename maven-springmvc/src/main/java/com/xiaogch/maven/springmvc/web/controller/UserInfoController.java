package com.xiaogch.maven.springmvc.web.controller;

import com.xiaogch.maven.springmvc.config.AuthConfig;
import com.xiaogch.maven.springmvc.entity.SysUserInfoBean;
import com.xiaogch.maven.springmvc.util.StringToDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthConfig authConfig;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Date.class , new StringToDateUtil());
    }

    @RequestMapping("login")
    public void login(HttpServletRequest request , HttpServletResponse response ,
                              @RequestParam(value = "userName") String userName,
                        @RequestParam(value = "password") String password) throws IOException {
        logger.info("userName={} , password={}" , userName , password);
        SysUserInfoBean sysUserInfoBean = new SysUserInfoBean();
        sysUserInfoBean.setUserName(userName);
        request.getSession().setAttribute(authConfig.getUserInfo() , sysUserInfoBean);
        response.sendRedirect(request.getContextPath() + "/user/index");
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request , HttpServletResponse response) throws IOException {
        return "user/index";
    }

    @RequestMapping("home")
    public String home(HttpServletRequest request , HttpServletResponse response) throws IOException {
        return "user/login";
    }
}
