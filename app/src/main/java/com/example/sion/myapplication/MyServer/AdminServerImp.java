package com.example.sion.myapplication.MyServer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sion.myapplication.EmptyClass.Action1;
import com.example.sion.myapplication.EmptyClass.Admin;
import com.example.sion.myapplication.EmptyClass.UserRegisetr;
import com.example.sion.myapplication.Until.ReadyDate;

public class AdminServerImp implements AdminServer {
    Context context;
    SQLiteDatabase myData;
    public AdminServerImp(Context context) {
        this.context = context;
    }

    @Override
    public int AdminRegister(UserRegisetr admin) {
         myData = ReadyDate.GetWrite(context, "MyData");
        ContentValues contentValues=new ContentValues();
        contentValues.put("num",admin.getUser());
        contentValues.put("psw",admin.getPsw());
        contentValues.put("name",admin.getName());
        long student1 = myData.insert("Admin", null, contentValues);
        return (int) student1;

    }

    @Override
    public String AdminLogin(Admin admin) {
        String result=null;
        myData=ReadyDate.GetRead(context,"MyData");
        String sql="select * from Admin where num=? and psw=?";
        String[] pares={admin.getUser()+"",admin.getPsw()};
        Cursor cursor = myData.rawQuery(sql, pares);
        while (cursor.moveToNext()){
            String string = cursor.getString(cursor.getColumnIndex("name"));
            if(string!=null){
                result=string;
                break;
            }
        }
        return result;
    }

    @Override
    public int AdminAdd(Action1 action1) {
   try {
       myData = ReadyDate.GetWrite(context, "MyData");
       ContentValues contentValues=new ContentValues();
       contentValues.put("Aname",action1.getAname());
       contentValues.put("AContext",action1.getAContext());
       contentValues.put("people",Integer.valueOf(action1.getPeople()));
       long student1 = myData.insert("Action1", null, contentValues);
       return (int) student1;
   }catch (Exception e){
       Log.i("AdminAdd", e.toString());
       return -1;
   }

    }

    @Override
    public int DeleteAdd(String Aname) {
       try {
           String Where="Aname=?";
           myData=ReadyDate.GetWrite(context,"MyData");
           String[] objects={Aname};
           int action1 = myData.delete("Action1", Where, objects);
           return action1;
       }catch (Exception e){
           return -1;
       }finally {
           myData.close();
       }

    }

    @Override
    public int Update(String Aname, Action1 action1) {
        return 0;
    }
}
