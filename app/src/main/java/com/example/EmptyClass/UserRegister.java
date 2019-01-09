package com.example.sion.myapplication.EmptyClass;

public class UserRegisetr {
    private Integer user;
    private String psw;
    private String name;

    public UserRegisetr() {
    }

    @Override
    public String toString() {
        return "UserRegisetr{" +
                "user='" + user + '\'' +
                ", psw='" + psw + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


    public UserRegisetr(Integer user, String psw, String name) {
        this.user = user;
        this.psw = psw;
        this.name = name;
    }

    public Integer getUser() {

        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
