package com.health.dao;

import com.health.pojo.Permission;

import java.util.Set;

public interface PermissionDao {
    Set<Permission> findByRoleId(Integer id);

}
