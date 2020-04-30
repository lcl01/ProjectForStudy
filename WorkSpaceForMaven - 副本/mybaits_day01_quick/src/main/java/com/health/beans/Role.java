package com.health.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    private List<User02> user02s=new ArrayList<User02>();

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", user02s=" + user02s +
                '}';
    }

    public List<User02> getUser02s() {
        return user02s;
    }

    public void setUser02s(List<User02> user02s) {
        this.user02s = user02s;
    }

    public Role(Integer roleId, String roleName, String roleDesc, List<User02> user02s) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.user02s = user02s;
    }

    public Role(Integer roleId, String roleName, String roleDesc) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }

    public Role() {
    }

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

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
