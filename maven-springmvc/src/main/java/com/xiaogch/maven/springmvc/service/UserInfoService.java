package com.xiaogch.maven.springmvc.service;

import com.xiaogch.maven.springmvc.entity.UserInfoBean;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
public interface UserInfoService {

    int insert(UserInfoBean userInfoBean);

    UserInfoBean selectById(Integer id);
}
