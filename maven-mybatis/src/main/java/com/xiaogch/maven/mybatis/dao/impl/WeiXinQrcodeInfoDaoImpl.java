package com.xiaogch.maven.mybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiaogch.maven.mybatis.dao.WeiXinQrcodeInfoDao;
import com.xiaogch.maven.mybatis.entity.WeiXinQrcodeInfoBean;

@Repository
public class WeiXinQrcodeInfoDaoImpl implements WeiXinQrcodeInfoDao {
	
	@Autowired
	private SqlSession sqlSession;

	public void updateStatus(WeiXinQrcodeInfoBean bean) throws Exception {
		sqlSession.update("t_wx_qrcode_info.updateStatus" , bean);
	}

	public void updateUrl(WeiXinQrcodeInfoBean bean) {
		sqlSession.update("t_wx_qrcode_info.updateUrl" , bean);
	}

	public void insert(WeiXinQrcodeInfoBean bean) {
		sqlSession.update("t_wx_qrcode_info.insert" , bean);
	}
}
