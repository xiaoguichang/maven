package com.xiaogch.maven.springmvc.entity;


import java.io.Serializable;
import java.util.Date;

public class SystemPrivilegeInfoBean implements Serializable {
    protected Integer privilegeId;
    protected String privilegeName;
    protected Integer privilegeType;
    protected Integer parentPrivilegeId;
    protected String privilegeEntity;
    private Integer status;
    private Date createTime;

    public Integer getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public Integer getPrivilegeType() {
        return privilegeType;
    }

    public void setPrivilegeType(Integer privilegeType) {
        this.privilegeType = privilegeType;
    }

    public Integer getParentPrivilegeId() {
        return parentPrivilegeId;
    }

    public void setParentPrivilegeId(Integer parentPrivilegeId) {
        this.parentPrivilegeId = parentPrivilegeId;
    }

    public String getPrivilegeEntity() {
        return privilegeEntity;
    }

    public void setPrivilegeEntity(String privilegeEntity) {
        this.privilegeEntity = privilegeEntity;
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
}
