package com.xiaogch.maven.system.service.impl;

import com.xiaogch.maven.common.db.BaseDao;
import com.xiaogch.maven.common.db.impl.BaseServiceImpl;
import com.xiaogch.maven.system.dao.UserInfoDao;
import com.xiaogch.maven.system.entity.UserInfoBean;
import com.xiaogch.maven.system.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("userInfoService")
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoBean> implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public BaseDao<UserInfoBean> getBaseDao() {
        return userInfoDao;
    }

    @Override
    public UserInfoBean selectByUserNameAndPasswod(String userName, String password) {
        Map<String , String> queryParam = new HashMap<>();
        queryParam.put("userName" , userName);
        queryParam.put("password" , password);
        return userInfoDao.selectOne("selectByUserNameAndPasswod" , queryParam);
    }

    @Override
    public UserInfoBean selectByUserName(String userName) {
        return userInfoDao.selectOne("selectByUserName" , userName);
    }


}
