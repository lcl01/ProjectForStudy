package com.lcl.security;

import com.lcl.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SpringSecurityUserService implements UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1.根据用户名查询数据库,获得User
        User user = findUserByUname(username);
        //2.判断是否为null
        if (user == null) {
            return null;
        }

        //3.把用户名,数据库的密码,以及查询出来的权限访问,创建UserDetails对象返回
        List<GrantedAuthority> list = new ArrayList <GrantedAuthority>();//先把角色和权限写死,后面从数据库查询出来
        list.add(new SimpleGrantedAuthority("add"));
        list.add(new SimpleGrantedAuthority("delete"));
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        UserDetails userDetails = new UserDetails(username, "{noop}" + user.getPassword(), list);
        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(username, user.getPassword(), list);




        return userDetails;

    }
    //模拟从数据库查询
        public User findUserByUname (String username){
            if ("admin".equals(username)) {
                User user = new User();
                user.setUsername(username);
//            user.setPassword("199656");
                user.setPassword(encoder.encode("199656"));
                System.out.println(encoder.encode("199656"));
                return user;
            }
            return null;
        }



}
