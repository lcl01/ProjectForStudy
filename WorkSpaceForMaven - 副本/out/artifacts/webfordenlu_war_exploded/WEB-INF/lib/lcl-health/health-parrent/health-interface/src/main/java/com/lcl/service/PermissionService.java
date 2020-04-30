package com.lcl.service;

import com.lcl.pojo.Permission;

import java.util.Set;

/**
 * @Description:
 * @Author: yp
 */
public interface PermissionService {

    /**
     * 根据角色id查询权限
     * @param roleId
     * @return
     */
     Set<Permission> findByRoleId(Integer roleId);
}
