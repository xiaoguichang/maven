package com.xiaogch.maven.springmvc.service.impl;

import com.xiaogch.maven.springmvc.dao.scan.UserInfoDao;
import com.xiaogch.maven.springmvc.entity.UserInfoBean;
import com.xiaogch.maven.springmvc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public int insert(UserInfoBean userInfoBean) {
        return userInfoDao.insert(userInfoBean);
    }

    @Override
    public UserInfoBean selectById(Integer id) {
        return userInfoDao.selectById(id);
    }
}
