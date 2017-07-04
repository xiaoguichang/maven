package com.xiaogch.maven.mybatis.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xiaogch.maven.mybatis.entity.WeiXinQrcodeInfoBean;
import com.xiaogch.maven.mybatis.junit.SpringJunitTestBase;
import com.xiaogch.maven.mybatis.service.WeiXinQrcodeInfoService;


public class WeiXinQrcodeInfoServiceTest extends SpringJunitTestBase {

	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	WeiXinQrcodeInfoService service;
	
	
	@Test
	public void testUpdateStatus() {
		long id = (System.currentTimeMillis() - 1496656366995l) / 10 ;
		WeiXinQrcodeInfoBean bean = new WeiXinQrcodeInfoBean();
		bean.setSceneId((int)id);
		bean.setCreateTime(new Date());
		bean.setExpireSeconds(6000);
		bean.setUsedStatus(1);
		bean.setTicket("ticket_" + id);
		bean.setUrl("url_" + id);
		try {
			service.update(bean  , "ticket_u" , 2 , false , false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}

}
