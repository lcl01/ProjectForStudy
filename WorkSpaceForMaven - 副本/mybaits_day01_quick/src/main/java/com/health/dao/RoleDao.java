package com.health.dao;

import com.health.beans.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll03();
    Role findById(Integer id);
    List<Role> findByRoleUserList();
}
