package com.xiaogch.maven.mybatis.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xiaogch.maven.mybatis.dao.UserDao;
import com.xiaogch.maven.mybatis.entity.UserBean;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<UserBean> queryUserList(Map<String, Object> parameter) {
		return sqlSession.selectList("t_log_partner_response.selectUserList", parameter);
	}
}
