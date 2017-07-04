package com.xiaogch.maven.spring;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Required;

import com.xiaogch.maven.spring.service.RequiredService;

public class RequiredBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private RequiredService service;

	
	public RequiredService getService() {
		return service;
	}

	@Required
	public void setService(RequiredService service) {
		this.service = service;
	}
	
	public void helloWorld() {
		service.helloWorld();
	}
}
