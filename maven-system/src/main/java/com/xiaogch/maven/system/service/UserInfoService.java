package com.xiaogch.maven.system.service;

import com.xiaogch.maven.common.db.BaseService;
import com.xiaogch.maven.system.entity.UserInfoBean;

public interface UserInfoService extends BaseService<UserInfoBean> {

    UserInfoBean selectByUserNameAndPasswod(String userName , String password);

    UserInfoBean selectByUserName(String userName);

}
