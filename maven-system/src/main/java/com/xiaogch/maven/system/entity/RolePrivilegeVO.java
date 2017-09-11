package com.xiaogch.maven.system.entity;

/**
 * ProjectName: maven <BR>
 * File name: com.xiaogch.maven.springmvc.entity <BR>
 * Author: guich <BR>
 * Project: maven <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/8 11:54 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class RolePrivilegeVO extends PrivilegeInfoBean {
    protected Integer roleId;
    protected String roleName;
    private Integer status;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }
}
