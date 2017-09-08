package com.xiaogch.maven.springmvc.service.impl;

import com.xiaogch.maven.common.db.BaseDao;
import com.xiaogch.maven.common.db.impl.BaseServiceImpl;
import com.xiaogch.maven.springmvc.dao.SystemUserInfoDao;
import com.xiaogch.maven.springmvc.entity.SystemUserInfoBean;
import com.xiaogch.maven.springmvc.service.SystemUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("systemUserInfoService")
public class SystemUserInfoServiceImpl extends BaseServiceImpl<SystemUserInfoBean> implements SystemUserInfoService {


    @Autowired
    private SystemUserInfoDao systemUserInfoDao;

    @Override
    public BaseDao<SystemUserInfoBean> getBaseDao() {
        return systemUserInfoDao;
    }

    @Override
    public SystemUserInfoBean selectByUserNameAndPasswod(String userName, String password) {
        Map<String , String> queryParam = new HashMap<>();
        queryParam.put("userName" , userName);
        queryParam.put("password" , password);
        return systemUserInfoDao.selectOne("selectByUserNameAndPasswod" , queryParam);
    }
}
