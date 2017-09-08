package com.xiaogch.maven.springmvc.service;

import com.xiaogch.maven.common.db.BaseService;
import com.xiaogch.maven.springmvc.entity.SystemUserInfoBean;

public interface SystemUserInfoService extends BaseService<SystemUserInfoBean> {

    SystemUserInfoBean selectByUserNameAndPasswod(String userName , String password);

}
