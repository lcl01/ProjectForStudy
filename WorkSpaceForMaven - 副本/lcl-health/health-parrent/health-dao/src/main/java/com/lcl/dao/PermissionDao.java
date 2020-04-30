package com.lcl.dao;

import com.lcl.pojo.Permission;

import java.util.Set;

public interface PermissionDao {
    Set<Permission> findByRoleId(Integer roleId);

}
