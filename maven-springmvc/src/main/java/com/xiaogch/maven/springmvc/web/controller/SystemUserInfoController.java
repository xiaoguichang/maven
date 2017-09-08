package com.xiaogch.maven.springmvc.web.controller;

import com.xiaogch.maven.common.util.MessageDigestUtil;
import com.xiaogch.maven.springmvc.config.AuthConfig;
import com.xiaogch.maven.springmvc.entity.SystemUserInfoBean;
import com.xiaogch.maven.springmvc.service.SystemUserInfoService;
import com.xiaogch.maven.springmvc.util.StringToDateUtil;
import org.apache.ibatis.annotations.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@Controller
@RequestMapping("user")
public class SystemUserInfoController extends BaseController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthConfig authConfig;

    @Autowired
    private SystemUserInfoService systemUserInfoService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Date.class , new StringToDateUtil());
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(HttpServletRequest request , HttpServletResponse response ,
                @RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password) {
        logger.info("userName={} , password={}" , userName , password);

        try {
            String finalPassword = MessageDigestUtil.md5(password);
            SystemUserInfoBean userInfoBean = systemUserInfoService.selectByUserNameAndPasswod(userName , finalPassword);
            if (userInfoBean == null) {
                return toFailureResponseContent("用户名或密码错误！");
            } else {
                request.getSession().setAttribute(authConfig.getUserInfo() , userInfoBean);
                return toSuccessResponseContent();
            }
        } catch (Exception e) {
            logger.error("login exception " , e);
            return toFailureResponseContent("用户名或密码错误！");
        }
        //response.sendRedirect(request.getContextPath() + "/user/index");
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(HttpServletRequest request , HttpServletResponse response ,
                   @Valid SystemUserInfoBean userInfoBean , Errors errors) {
        logger.info("request parameter is {}" , userInfoBean);
        if (errors.hasErrors()) {
            return toFailureResponseContent(errors);
        }

        try {
            String password = MessageDigestUtil.md5(userInfoBean.getPassword());
            userInfoBean.setPassword(password);
            systemUserInfoService.insert(userInfoBean);
            return toSuccessResponseContent();
        } catch (Exception e) {
            logger.error("add user exception" , e);
            return toFailureResponseContent("新增用户失败，请联系系统管理员");
        }
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(HttpServletRequest request , HttpServletResponse response ,
                         SystemUserInfoBean userInfoBean) throws IOException {
        return "";
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
