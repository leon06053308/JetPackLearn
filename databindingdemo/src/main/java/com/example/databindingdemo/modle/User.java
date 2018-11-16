package com.example.databindingdemo.modle;

public class User {
    private String name;
    private String password;

    public User(String na, String pw){
        this.name = na;
        this.password = pw;
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
}
