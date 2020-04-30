package com.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.health.dao.PermissionDao;
import com.health.dao.RoleDao;
import com.health.dao.UserDao;
import com.health.pojo.Permission;
import com.health.pojo.Role;
import com.health.pojo.User;
import com.health.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service(interfaceClass = UserService.class)
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
        private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public User findUserByUsername(String username) {

        User user=userDao.findUserByUsername(username);
        if (user !=null) {
            Set<Role> roles=roleDao.findByUid(user.getId());
            for (Role role : roles) {
                Set<Permission> permissions=permissionDao.findByRoleId(role.getId());
                role.setPermissions(permissions);
            }
            user.setRoles(roles);
            return user;
        }
        return user;

    }
}
