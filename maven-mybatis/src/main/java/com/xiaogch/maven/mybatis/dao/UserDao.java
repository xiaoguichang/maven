package com.xiaogch.maven.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.xiaogch.maven.mybatis.entity.UserBean;

public interface UserDao {
	
	List<UserBean> queryUserList(Map<String , Object> parameter); 
}
