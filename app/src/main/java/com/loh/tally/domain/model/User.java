package com.loh.tally.domain.model;

/**
 * File: User.java
 * Date: 10/03/2017
 * Created By: Liam O'Hanlon
 */
public class User {

    private String email;
    private String uid;

    public User() {
    }

    public User(String email, String uid) {
        this.email = email;
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
