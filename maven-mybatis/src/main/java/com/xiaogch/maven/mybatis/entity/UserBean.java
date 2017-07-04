package com.xiaogch.maven.mybatis.entity;

import java.io.Serializable;

/**
 * @author guichang
 *
 */
public class UserBean  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String phoneId;
	String provinceCode;
	
	public String getPhoneId() {
		return phoneId;
	}
	
	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}
	
	public String getProvinceCode() {
		return provinceCode;
	}
	
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	@Override
	public String toString() {
		return phoneId + "\t" + provinceCode;
	}
}
