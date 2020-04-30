package com.lcl.domain;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String usernaem;
    private String password;
    private String address;

    public User(String usernaem, String password, String address) {
        this.usernaem = usernaem;
        this.password = password;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsernaem() {
        return usernaem;
    }

    public void setUsernaem(String usernaem) {
        this.usernaem = usernaem;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
