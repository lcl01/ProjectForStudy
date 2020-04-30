package com.changgou.application.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private String name;
    private Integer age;
    private String sex;
    private List<User> userListObj;

    public User(String name, Integer age, String sex, List<User> userListObj) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.userListObj = userListObj;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", userListObj=" + userListObj +
                '}';
    }

    public List<User> getUserListObj() {
        return userListObj;
    }

    public void setUserListObj(List<User> userListObj) {
        this.userListObj = userListObj;
    }

    public User() {
    }

    public User(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
