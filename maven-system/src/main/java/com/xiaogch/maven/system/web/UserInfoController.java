package com.xiaogch.maven.system.web;

import com.xiaogch.maven.common.config.AuthConfig;
import com.xiaogch.maven.common.databinder.StringToDateBinder;
import com.xiaogch.maven.common.util.MessageDigestUtil;
import com.xiaogch.maven.common.controller.BaseController;
import com.xiaogch.maven.system.entity.UserInfoBean;
import com.xiaogch.maven.system.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@Controller
@RequestMapping("/system/user")
public class UserInfoController extends BaseController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthConfig authConfig;

    @Autowired
    private UserInfoService userInfoService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Date.class , new StringToDateBinder("yyyy-MM-dd HH:mm:ss"));
    }


    @RequestMapping("/index")
    public String index(HttpServletRequest request , HttpServletResponse response , ModelMap modelMap) throws IOException {
        try {
            return "system/user/index";
        } catch (Exception e) {
            return "system/user/index";
        }
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(HttpServletRequest request , HttpServletResponse response ,
                      UserInfoBean userInfoBean , Errors errors) {
        logger.info("request parameter is {}" , userInfoBean);
//        if (errors.hasErrors()) {
//            return toFailureResponseContent(errors);
//        }
//        try {
//            String password = MessageDigestUtil.md5(userInfoBean.getPassword());
//            userInfoBean.setPassword(password);
//            userInfoService.insert(userInfoBean);
//            return toSuccessResponseContent();
//        } catch (Exception e) {
//            logger.error("add user exception" , e);
//            return toFailureResponseContent("新增用户失败，请联系系统管理员");
//        }
        return "";
    }


    @RequestMapping("add")
    @ResponseBody
    public String add(HttpServletRequest request , HttpServletResponse response ,
                   @Valid UserInfoBean userInfoBean , Errors errors) {
        logger.info("request parameter is {}" , userInfoBean);
        if (errors.hasErrors()) {
            return toFailureResponseContent(errors);
        }
        try {
            String password = MessageDigestUtil.md5(userInfoBean.getPassword());
            userInfoBean.setPassword(password);
            userInfoService.insert(userInfoBean);
            return toSuccessResponseContent();
        } catch (Exception e) {
            logger.error("add user exception" , e);
            return toFailureResponseContent("新增用户失败，请联系系统管理员");
        }
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(HttpServletRequest request , HttpServletResponse response ,
                         UserInfoBean userInfoBean) throws IOException {
        return "";
    }
}
