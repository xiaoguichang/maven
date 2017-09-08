package com.xiaogch.maven.springmvc.entity;

public class SystemRoleInfoBean {

    private Integer roleId;
    private String roleName;
    private String roleRemark;

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

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }

    @Override
    public String toString() {
        return "SysRoleInfoBean{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleRemark='" + roleRemark + '\'' +
                '}';
    }
}
