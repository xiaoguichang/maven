package com.xiaogch.maven.springmvc.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiaogch.maven.springmvc.dao.SysRoleInfoDao;
import com.xiaogch.maven.springmvc.entity.PagedList;
import com.xiaogch.maven.springmvc.entity.SysRoleInfoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
public class SystemRoleInfoController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SysRoleInfoDao sysRoleInfoDao;

    @RequestMapping("roleInfo/insert")
    public String insert(HttpServletResponse response , HttpServletRequest request , SysRoleInfoBean sysRoleInfoBean) {
        logger.info("request parameter is {} " , sysRoleInfoBean);
        if (sysRoleInfoBean != null){
            int insertReuslt = sysRoleInfoDao.insert(sysRoleInfoBean);
            return "insertReuslt is " + insertReuslt;
        } else {
            return "request parameter is null";
        }
    }

    @RequestMapping("roleInfo/getList")
    public String getList(HttpServletResponse response , HttpServletRequest request ,
                         @RequestParam(value = "pageNo") int pageNo,
                         @RequestParam(value = "pageSize") int pageSize) {
        logger.info("request parameter is pageNo={} , pageSize={}" , pageNo , pageSize);

        PagedList<SysRoleInfoBean> list = sysRoleInfoDao.selectList("selectAll" , new HashMap<>() , pageNo , pageSize);
        return JSONObject.toJSONString(list);
    }

}
