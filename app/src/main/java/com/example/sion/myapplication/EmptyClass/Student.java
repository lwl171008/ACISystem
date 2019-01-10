package com.example.sion.myapplication.EmptyClass;

public class Student {
    private  String Name;
    private  Integer StudentID;
    private  String psw;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getStudentID() {
        return StudentID;
    }

    public Student(Integer studentID, String psw) {
        StudentID = studentID;
        this.psw = psw;
    }

    public Student(String name, Integer studentID, String psw) {
        Name = name;
        StudentID = studentID;
        this.psw = psw;
    }

    public void setStudentID(Integer studentID) {
        StudentID = studentID;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
