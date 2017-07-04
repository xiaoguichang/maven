package com.xiaogch.maven.mybatis.service;

import com.xiaogch.maven.mybatis.entity.WeiXinQrcodeInfoBean;

public interface WeiXinQrcodeInfoService {
	
	void updateStatus(WeiXinQrcodeInfoBean bean , boolean throwException) throws Exception;
	
	void updateUrl(WeiXinQrcodeInfoBean bean , boolean throwException) throws Exception;
	
	void insert(WeiXinQrcodeInfoBean bean);
	
	void update(WeiXinQrcodeInfoBean bean, String url, Integer status , boolean updateUrlThrow , boolean updateStatusThrow) throws Exception;
}
