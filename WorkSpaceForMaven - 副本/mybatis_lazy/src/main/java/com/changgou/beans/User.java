package com.changgou.beans;

import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                '}';
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public User(int id, String username, String sex, Date birthday, String address, List<Account> accounts) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.accounts = accounts;
    }

    public User() {
    }

    public User(int id, String username, String sex, Date birthday, String address) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
