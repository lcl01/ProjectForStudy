package com.lcl.dao;

import com.lcl.pojo.Role;

import java.util.Set;

public interface RoleDao {
    Set<Role> findByUid(Integer userId);

}
