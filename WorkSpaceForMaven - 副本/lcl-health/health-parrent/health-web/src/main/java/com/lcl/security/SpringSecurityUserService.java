package com.lcl.security;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lcl.pojo.Permission;
import com.lcl.pojo.Role;
import com.lcl.pojo.User;
import com.lcl.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component("SpringSecurityUserService")
public class SpringSecurityUserService implements UserDetailsService {
    @Reference
    private UserService userService;
//    @Reference
//    private RoleService roleService;
//    @Reference
//    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findUserByUsername(username);
        if (user == null) {
            return null;
        }
        List <GrantedAuthority> grantedAuthorityList = new ArrayList <GrantedAuthority>();
//        Integer userId = user.getId();
//        Set <Role> roles = roleService.findByUid(userId);
        Set<Role> roles = user.getRoles();
        if (roles !=null && roles.size()>0) {
            for (Role role : roles) {
                Integer roleId = role.getId();
//                Set <Permission> permissions = permissionService.findByRoleId(roleId);
                Set<Permission> permissions = role.getPermissions();
                if(permissions !=null && permissions.size()>0) {
                    for (Permission permission : permissions) {
                        grantedAuthorityList.add(new SimpleGrantedAuthority(permission.getKeyword()));

                    }
                }
            }
            System.out.println(grantedAuthorityList.size());
            org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(username, user.getPassword(), grantedAuthorityList);

            return userDetail;
        }
        return null;
    }
}
