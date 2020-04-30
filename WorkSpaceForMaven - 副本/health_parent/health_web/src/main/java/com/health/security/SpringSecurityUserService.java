package com.health.security;

import com.alibaba.dubbo.config.annotation.Reference;
import com.health.pojo.Permission;
import com.health.pojo.Role;
import com.health.pojo.User;
import com.health.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class SpringSecurityUserService implements UserDetailsService {
    @Reference
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userService.findUserByUsername(username);
        if (user==null) {
            return null;
        }
        List<GrantedAuthority> grantedAuthorityArrayList = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            Set<Permission> permissions = role.getPermissions();
            for (Permission permission : permissions) {
                grantedAuthorityArrayList.add(new SimpleGrantedAuthority(permission.getKeyword()));
            }
        }
        org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(username, user.getPassword(), grantedAuthorityArrayList);

        return userDetail;
    }
}
