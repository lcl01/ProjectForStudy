package com.itheima.ssm.domain;

public class User {
    private String number;
    private String name;
    private String password;
    private String mobile;
    private String qq;
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(String number, String name, String password, String mobile, String qq, String email) {
        this.number = number;
        this.name = name;
        this.password = password;
        this.mobile = mobile;
        this.qq = qq;
        this.email = email;
    }
}
