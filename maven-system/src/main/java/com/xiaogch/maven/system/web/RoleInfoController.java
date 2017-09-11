package com.xiaogch.maven.system.web;

import com.alibaba.fastjson.JSONObject;
import com.xiaogch.maven.common.db.bean.PagedList;
import com.xiaogch.maven.system.entity.RoleInfoBean;
import com.xiaogch.maven.system.service.RoleInfoService;
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
@RequestMapping("/system/role")
public class RoleInfoController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RoleInfoService roleInfoService;

    @RequestMapping("insert")
    public String insert(HttpServletResponse response , HttpServletRequest request , RoleInfoBean sysRoleInfoBean) {
        logger.info("request parameter is {} " , sysRoleInfoBean);
        if (sysRoleInfoBean != null){
            int insertReuslt = roleInfoService.insert(sysRoleInfoBean);
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
        PagedList<RoleInfoBean> list = roleInfoService.selectList(new HashMap<>() , pageNo , pageSize);
        return JSONObject.toJSONString(list);
    }

}
