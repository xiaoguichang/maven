package com.xiaogch.maven.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class WeiXinQrcodeInfoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer sceneId;
	private String ticket;
	private String url;
	private Integer usedStatus;
	private Date createTime;
	private Integer expireSeconds;
	
	public Integer getSceneId() {
		return sceneId;
	}
	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getUsedStatus() {
		return usedStatus;
	}
	public void setUsedStatus(Integer usedStatus) {
		this.usedStatus = usedStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getExpireSeconds() {
		return expireSeconds;
	}
	public void setExpireSeconds(Integer expireSeconds) {
		this.expireSeconds = expireSeconds;
	}
	
}
