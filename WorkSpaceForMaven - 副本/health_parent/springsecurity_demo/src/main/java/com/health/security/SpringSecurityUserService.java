package com.health.security;

import com.health.bean.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SpringSecurityUserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//1.根据用户名查询数据库,获得User
        User user = findUserByUname(username);
        //2.判断是否为null
        if (user == null) {
            return null;
        }
        //3.把用户名,数据库的密码,以及查询出来的权限访问,创建UserDetails对象返回
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();//先把角色和权限写死,后面从数据库查询出来
        list.add(new SimpleGrantedAuthority("add"));
        list.add(new SimpleGrantedAuthority("delete"));
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(username,"{noop}"+user.getPassword(),list);
        return userDetails;
    }
    //模拟从数据库查询
    private User findUserByUname(String username) {
        if ("admin".equals(username)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword("123456");
            return user;
        }
        return null;
    }
}
