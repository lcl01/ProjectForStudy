package com.itheima.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName User
 * @Description TODO
 * @Author ly
 * @Company 深圳黑马程序员
 * @Date 2019/5/23 9:13
 * @Version V1.0
 */
public class User implements Serializable{

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    private List<Account> accounts;
    private List<Role> roles=new ArrayList <Role>();

    public List <Role> getRoles() {
        return roles;
    }

    public void setRoles(List <Role> roles) {
        this.roles = roles;
    }

    public List <Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List <Account> accounts) {
        this.accounts = accounts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                ", roles=" + roles +
                '}';
    }
}
