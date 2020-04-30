package com.health.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User02 implements Serializable {
    private int id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;
    private List<Account> accounts;
    private List<Role> roles=new ArrayList<Role>();

    @Override
    public String toString() {
        return "User02{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                ", roles=" + roles +
                '}';
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User02(int id, String username, String sex, Date birthday, String address, List<Account> accounts, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.accounts = accounts;
        this.roles = roles;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public User02(int id, String username, String sex, Date birthday, String address, List<Account> accounts) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.accounts = accounts;
    }

    public User02() {
    }

    public User02(int id, String username, String sex, Date birthday, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public  void setUsername(String username) {
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

}
