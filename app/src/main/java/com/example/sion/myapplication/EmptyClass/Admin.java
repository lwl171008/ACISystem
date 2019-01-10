package com.example.sion.myapplication.EmptyClass;

public class Admin {
    private  Integer User;
    private  String Psw;
    private String name;


    public Admin() {
    }

    public Admin(String name) {
        this.name = name;
    }

    public Admin(Integer user, String psw) {
        User = user;
        Psw = psw;
    }

    public Admin(Integer user, String psw, String name) {

        User = user;
        Psw = psw;
        this.name = name;
    }

    public Integer getUser() {

        return User;
    }

    public void setUser(Integer user) {
        User = user;
    }

    public String getPsw() {
        return Psw;
    }

    public void setPsw(String psw) {
        Psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
