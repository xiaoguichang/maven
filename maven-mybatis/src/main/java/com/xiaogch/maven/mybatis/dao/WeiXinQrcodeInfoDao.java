package com.xiaogch.maven.mybatis.dao;

import com.xiaogch.maven.mybatis.entity.WeiXinQrcodeInfoBean;

public interface WeiXinQrcodeInfoDao {
	
	void updateStatus(WeiXinQrcodeInfoBean bean) throws Exception;
	
	void updateUrl(WeiXinQrcodeInfoBean bean);
	
	void insert(WeiXinQrcodeInfoBean bean);
}
