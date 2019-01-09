package com.example.sion.myapplication.EmptyClass;

public class Action2 {
    private  Integer id;
    private String Aname;
    private String SName;

    public Action2(String aname, String SName) {
        Aname = aname;
        this.SName = SName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAname() {
        return Aname;
    }

    public void setAname(String aname) {
        Aname = aname;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public Action2(String SName) {
        this.SName = SName;
    }
}
