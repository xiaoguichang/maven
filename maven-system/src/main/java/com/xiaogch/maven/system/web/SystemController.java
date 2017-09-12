package com.xiaogch.maven.system.web;

import com.alibaba.fastjson.JSONObject;
import com.xiaogch.maven.common.config.AuthConfig;
import com.xiaogch.maven.common.config.ConfigFactory;
import com.xiaogch.maven.common.controller.BaseController;
import com.xiaogch.maven.common.util.MessageDigestUtil;
import com.xiaogch.maven.system.entity.MenuVO;
import com.xiaogch.maven.system.entity.UserInfoBean;
import com.xiaogch.maven.system.service.UserInfoService;
import com.xiaogch.maven.system.service.UserRolePrivilegeRelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/12 11:28 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
@Controller
@RequestMapping("system")
public class SystemController extends BaseController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthConfig authConfig;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserRolePrivilegeRelService userRolePrivilegeRelService;


    @RequestMapping("index")
    public String index(HttpServletRequest request , HttpServletResponse response , ModelMap modelMap) throws IOException {
        try {
            UserInfoBean userInfoBean = (UserInfoBean) request.getSession().getAttribute(authConfig.getUserInfo());
            modelMap.put("nickname", userInfoBean.getNickname());
            List<MenuVO> menuVOS = userRolePrivilegeRelService.selectMenuByUserId(userInfoBean.getUserId());
            genMenuTree(menuVOS);
            modelMap.put("menuList", JSONObject.toJSONString(menuVOS));
            logger.info("menuList is {}" , JSONObject.toJSONString(menuVOS));
            return "system/index";
        } catch (Exception e) {
            return "system/index";
        }
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(HttpServletRequest request , HttpServletResponse response , ModelMap modelMap ,
                        @RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password) {
        logger.info("userName={} , password={}" , userName , password);
        try {
            String finalPassword = MessageDigestUtil.md5(password);
            UserInfoBean userInfoBean = userInfoService.selectByUserName(userName);
            if (userInfoBean == null) {
                return toFailureResponseContent("该用户名不存在，请确认用户名是否正确！");
            } else if (! new Integer(1).equals(userInfoBean.getStatus())) {
                return toFailureResponseContent("该用户名已失效，请联系系统管理员！");
            } else if (! finalPassword.equals(userInfoBean.getPassword())){
                return toFailureResponseContent("输入的密码有误，请确认密码是否正确！");
            } else {
                request.getSession().setAttribute(authConfig.getUserInfo(), userInfoBean);
                request.getSession().setMaxInactiveInterval(authConfig.getExpiredTime());
                return toSuccessResponseContent();
            }
        } catch (Exception e) {
            logger.error("login exception " , e);
            return toFailureResponseContent("用户名或密码错误！");
        }
    }


    @RequestMapping("home")
    public String home(HttpServletRequest request , HttpServletResponse response) throws IOException {
        return "system/login";
    }

    @RequestMapping("signOut")
    @ResponseBody
    public String signOut(HttpServletRequest request , HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute(authConfig.getUserInfo());
        return toSuccessResponseContent();
    }


    private List<MenuVO> genMenuTree(List<MenuVO> menuVOS) {
        for (int index = 0 ; index < menuVOS.size(); index ++) {
            MenuVO menuVO = menuVOS.get(index);
            if (menuVO != null) {
                menuVO.getChildMenus().addAll(getChildMenus(index + 1 , menuVO.getMenuId() , menuVOS));
                int parentMenuIndex = getParentMenuIndex(index + 1 , menuVO.getParentMenuId() , menuVOS);
                if (parentMenuIndex != -1) {
                    menuVOS.get(parentMenuIndex).getChildMenus().add(menuVO);
                    menuVOS.remove(index);
                    index --;
                }
            } else {
                menuVOS.remove(index);
                index --;
            }
        }
        return menuVOS;
    }

    private int getParentMenuIndex(int from , Integer parentMenuId , List<MenuVO> menuVOS) {
        for (; from < menuVOS.size(); from ++) {
            MenuVO tmp = menuVOS.get(from);
            if (tmp != null && parentMenuId.equals(tmp.getMenuId())) {
                return from;
            }
        }
        return -1;
    }

    public List<MenuVO> getChildMenus(int from , Integer parentMenuId , List<MenuVO> menuVOS) {
        List<MenuVO> childMenus = new ArrayList<>();
        for (; from < menuVOS.size() ; from ++) {
            MenuVO menuVO = menuVOS.get(from);
            if (menuVO != null && parentMenuId.equals(menuVO.getParentMenuId())) {
                menuVO.getChildMenus().addAll(getChildMenus(from + 1 ,menuVO.getMenuId() , menuVOS));
                childMenus.add(menuVO);
                menuVOS.remove(from);
                from --;
            }
        }
        return childMenus;
    }
}
