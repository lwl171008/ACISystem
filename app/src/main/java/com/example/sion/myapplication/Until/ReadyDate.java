package com.example.sion.myapplication.Until;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.sion.myapplication.MySQLite.SQLHelper;

public class ReadyDate {
    static SQLHelper sqlHelper;
    static SQLiteDatabase Database;

    public static SQLiteDatabase GetWrite(Context context,String DateBase){
        sqlHelper=new SQLHelper(context,DateBase);
        Database= sqlHelper.getWritableDatabase();
        return Database;
    }
    public static SQLiteDatabase GetRead(Context context,String DateBase){
        sqlHelper=new SQLHelper(context,DateBase);
        Database= sqlHelper.getReadableDatabase();
        return Database;
    }

    public static void CloseSQL(){
        if(Database!=null){
            Database.close();
            if(sqlHelper!=null){
                sqlHelper.close();
            }
        }
    }
}
