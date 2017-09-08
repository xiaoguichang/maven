package com.xiaogch.maven.springmvc.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiaogch.maven.springmvc.dao.SystemRoleInfoDao;
import com.xiaogch.maven.common.db.bean.PagedList;
import com.xiaogch.maven.springmvc.entity.SystemRoleInfoBean;
import com.xiaogch.maven.springmvc.service.SystemRoleInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping("role")
public class SystemRoleInfoController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SystemRoleInfoService systemRoleInfoService;

    @RequestMapping("insert")
    public String insert(HttpServletResponse response , HttpServletRequest request , SystemRoleInfoBean sysRoleInfoBean) {
        logger.info("request parameter is {} " , sysRoleInfoBean);
        if (sysRoleInfoBean != null){
            int insertReuslt = systemRoleInfoService.insert(sysRoleInfoBean);
            return "insertReuslt is " + insertReuslt + " roleId=" + sysRoleInfoBean.getRoleId();
        } else {
            return "request parameter is null";
        }
    }

    @RequestMapping("getList")
    public String getList(HttpServletResponse response , HttpServletRequest request ,
                         @RequestParam(value = "pageNo") int pageNo,
                         @RequestParam(value = "pageSize") int pageSize) {
        logger.info("request parameter is pageNo={} , pageSize={}" , pageNo , pageSize);
        PagedList<SystemRoleInfoBean> list = systemRoleInfoService.selectList(new HashMap<>() , pageNo , pageSize);
        return JSONObject.toJSONString(list);
    }

}
