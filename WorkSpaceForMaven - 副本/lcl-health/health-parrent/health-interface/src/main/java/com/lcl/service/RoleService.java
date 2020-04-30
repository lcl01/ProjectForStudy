package com.lcl.service;

import com.lcl.pojo.Role;

import java.util.Set;

/**
 * @Description:
 * @Author: yp
 */
public interface RoleService {

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     */
    Set<Role> findByUid(Integer userId);
}
