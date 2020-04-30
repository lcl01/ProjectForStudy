package com.health.beans;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;
    private User02 user02;

    public User02 getUser02() {
        return user02;
    }

    public void setUser02(User02 user02) {
        this.user02 = user02;
    }

    public Account(Integer id, Integer uid, Double money, User02 user02) {
        this.id = id;
        this.uid = uid;
        this.money = money;
        this.user02 = user02;
    }

    public Account() {
    }

    public Account(Integer id, Integer uid, Double money) {
        this.id = id;
        this.uid = uid;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                ", user02=" + user02 +
                '}';
    }
}
