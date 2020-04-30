package com.lcl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lcl.dao.PermissionDao;
import com.lcl.dao.RoleDao;
import com.lcl.dao.UserDao;
import com.lcl.pojo.Permission;
import com.lcl.pojo.Role;
import com.lcl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
       User user= userDao.findUserByUsername(username);
        if (user !=null) {
            //根据用户id查询角色
            Set<Role> roles =  roleDao.findByUid(user.getId());
            //根据角色id查询角色
            if(roles != null && roles.size() > 0){
                for (Role role : roles) {
                    Integer roleId = role.getId();
                    Set<Permission> permissions =  permissionDao.findByRoleId(roleId);
                    role.setPermissions(permissions);
                }
                user.setRoles(roles);
            }
        }
        return userDao.findUserByUsername(username);
    }
}
