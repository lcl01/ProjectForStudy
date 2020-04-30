package com.health.beans;

import java.io.Serializable;

public class AccountUser extends Account implements Serializable {
    private String username;
    private String address;

    public AccountUser(String username, String address) {
        this.username = username;
        this.address = address;
    }

    public AccountUser(Integer id, Integer uid, Double money, String username, String address) {
        super(id, uid, money);
        this.username = username;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString()+"AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
