package com.itheima.domain;

import java.util.Date;

public class User {
    private String username;
    private Integer age;
    private Date birthday;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User(String username, Integer age, Date birthday) {
        this.username = username;
        this.age = age;
        this.birthday = birthday;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
