package com.xiaogch.maven.springmvc.entity;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

public class SystemUserInfoBean implements Serializable {

    protected String userId;
    @NotEmpty(message = "userName 不能为空")
    protected String userName;
    @NotEmpty(message = "nickname 不能为空")
    protected String nickname;
    @NotEmpty(message = "password 不能为空")
    private String password;
    private String phone;
    private String email;
    private String openId;
    private Integer status;
    private Date createTime;
    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SystemUserInfoBean{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", openId='" + openId + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
