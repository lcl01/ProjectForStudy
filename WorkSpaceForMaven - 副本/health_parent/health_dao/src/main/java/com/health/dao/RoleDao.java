package com.health.dao;

import com.health.pojo.Role;

import java.util.Set;

public interface RoleDao {

    Set<Role> findByUid(Integer id);

}
