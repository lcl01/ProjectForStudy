package com.health.beans;

import java.io.Serializable;
import java.util.Date;

public class User03 implements Serializable {
    private int userid;
    private String username;
    private String usersex;
    private Date userbirthday;
    private String useraddress;

    public User03() {
    }

    public User03(int userid, String username, String usersex, Date userbirthday, String useraddress) {
        this.userid = userid;
        this.username = username;
        this.usersex = usersex;
        this.userbirthday = userbirthday;
        this.useraddress = useraddress;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public Date getUserbirthday() {
        return userbirthday;
    }

    public void setUserbirthday(Date userbirthday) {
        this.userbirthday = userbirthday;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    @Override
    public String toString() {
        return "User03{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", usersex='" + usersex + '\'' +
                ", userbirthday=" + userbirthday +
                ", useraddress='" + useraddress + '\'' +
                '}';
    }
}
