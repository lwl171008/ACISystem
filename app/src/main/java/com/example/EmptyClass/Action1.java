package com.example.sion.myapplication.EmptyClass;

public class Action1 {
    private  Integer id;
    private String Aname;
    private String AContext;
    private String people;
    private String Jpeople;

    public Action1(String aname) {
        Aname = aname;
    }

    public Action1(String aname, String AContext) {
        Aname = aname;
        this.AContext = AContext;
    }

    public Action1(String aname, String AContext, String people, String jpeople) {
        Aname = aname;
        this.AContext = AContext;
        this.people = people;
        Jpeople = jpeople;
    }

    public Action1() {
    }

    public Action1(Integer id, String aname, String people, String jpeople) {
        this.id = id;
        Aname = aname;
        this.people = people;
        Jpeople = jpeople;
    }

    public Action1(Integer id, String aname, String AContext, String people, String jpeople) {
        this.id = id;
        Aname = aname;
        this.AContext = AContext;
        this.people = people;
        Jpeople = jpeople;
    }

    public Action1(String aname, String people, String jpeople) {
        Aname = aname;
        this.people = people;
        Jpeople = jpeople;
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

    public String getAContext() {
        return AContext;
    }

    public void setAContext(String AContext) {
        this.AContext = AContext;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getJpeople() {
        return Jpeople;
    }

    public void setJpeople(String jpeople) {
        Jpeople = jpeople;
    }

    @Override
    public String toString() {
        return "Action1{" +
                "id=" + id +
                ", Aname='" + Aname + '\'' +
                ", AContext='" + AContext + '\'' +
                ", people='" + people + '\'' +
                ", Jpeople='" + Jpeople + '\'' +
                '}';
    }
}
