package com.xiaogch.maven.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiaogch.maven.mybatis.dao.WeiXinQrcodeInfoDao;
import com.xiaogch.maven.mybatis.entity.WeiXinQrcodeInfoBean;
import com.xiaogch.maven.mybatis.service.WeiXinQrcodeInfoService;

@Service
public class WeiXinQrcodeInfoServiceImpl implements WeiXinQrcodeInfoService{
	
	@Autowired
	WeiXinQrcodeInfoDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateStatus(WeiXinQrcodeInfoBean bean , boolean throwException) throws Exception {
		dao.updateStatus(bean);
		if (throwException) {
			throw new Exception();
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateUrl(WeiXinQrcodeInfoBean bean , boolean throwException) throws Exception {
		dao.updateUrl(bean);
		if (throwException) {
			throw new Exception();
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insert(WeiXinQrcodeInfoBean bean) {
		dao.insert(bean);
	}

	public void update(WeiXinQrcodeInfoBean bean, String url, Integer status , boolean updateUrlThrow , boolean updateStatusThrow) throws Exception {
		dao.insert(bean);
		bean.setUrl(url);
		bean.setUsedStatus(status);
		updateStatus(bean, updateStatusThrow);
		updateUrl(bean, updateUrlThrow);
	}
}
