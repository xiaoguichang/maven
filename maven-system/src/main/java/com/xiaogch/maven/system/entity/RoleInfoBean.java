package com.xiaogch.maven.system.entity;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class RoleInfoBean implements Serializable {

    private Integer roleId;
    @NotEmpty(message = "角色标识不能为空")
    private String roleKey;
    @NotEmpty(message = "角色名不能为空")
    private String roleName;
    private String roleRemark;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
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
        return "RoleInfoBean{" +
                "roleId=" + roleId +
                ", roleKey='" + roleKey + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleRemark='" + roleRemark + '\'' +
                '}';
    }
}
