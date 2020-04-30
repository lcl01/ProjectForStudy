package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();

    Role findById(Integer id);
    List<Role> findRoleUserList();
    List<Role> findRoleUserList1();
}
