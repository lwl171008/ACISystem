package com.example.sion.myapplication.MySQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {
    //学生登陆表（id,学生学号，密码，学生名字）(id,num.psw,name) Student
    private  String Mytable1="Create table Student (id integer primary key autoincrement,num integer unique," +
            "psw text,name text)";
    //管理员表（id,管理员账号，密码)(id,num,psw,name) Admin
    private String Mytable2="Create table Admin (id integer primary key autoincrement,num integer unique," +
            "psw text,name text)";
    //活动表(id,活动名字，活动内容，发布报名人数，剩余报名人数)(id, Aname,AContext,people,Jpeople)Action1
    private String Mytable3="Create table Action1 (id integer primary key autoincrement,Aname text," +
            "AContext text,people integer  default 0,Jpeople integer default 0)";
    //报名表(id,活动名字，报名人)(id,Aname,SName)Action2
    private String Mytable4="Create table Action2 (id integer primary key autoincrement,Aname text," +
            "SName text)";
    public SQLHelper(Context context,  String name) {
        super(context, name,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Mytable1);
        db.execSQL(Mytable2);
        db.execSQL(Mytable3);
        db.execSQL(Mytable4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
