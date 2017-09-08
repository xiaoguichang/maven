package com.xiaogch.maven.springmvc.entity;

/**
 * ProjectName: maven <BR>
 * File name: com.xiaogch.maven.springmvc.entity <BR>
 * Author: guich <BR>
 * Project: maven <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/8 11:35 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class UserRolePrivilegeRelVO extends UserRoleRelVO {
    protected Integer privilegeId;
    protected String privilegeName;
    protected Integer privilegeType;
    protected Integer parentPrivilegeId;
    protected String privilegeEntity;

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
}
