package com.example.breweryservice.entity;

import java.math.BigInteger;

public class User {
    private BigInteger userid;
    private BigInteger beerid;
    private String username;
    private String email;

    public User() {
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public BigInteger getBeerid() {
        return beerid;
    }

    public void setBeerid(BigInteger beerid) {
        this.beerid = beerid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", beerid=" + beerid +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
