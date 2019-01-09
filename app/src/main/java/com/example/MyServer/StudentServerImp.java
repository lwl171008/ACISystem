package com.example.sion.myapplication.MyServer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.sion.myapplication.EmptyClass.Action1;
import com.example.sion.myapplication.EmptyClass.Student;
import com.example.sion.myapplication.EmptyClass.UserRegisetr;
import com.example.sion.myapplication.Until.ReadyDate;

import java.util.ArrayList;
import java.util.List;

public class StudentServerImp implements com.example.sion.myapplication.MyServer.StudentServer {
    Context context;
    SQLiteDatabase myData ;
    public StudentServerImp(Context context) {
        this.context = context;
    }

    @Override
    public String StudentLogin(Integer studentID, String psw) {
        String reult=null;
        myData=ReadyDate.GetRead(context,"MyData");
        String sql="select * from Student where num=? and psw=?";
        String[] pares={studentID+"",psw};
        Cursor cursor = myData.rawQuery(sql, pares);
        while (cursor.moveToNext()){
            String string = cursor.getString(cursor.getColumnIndex("name"));
            if(string!=null){
                reult=string;
                break;
            }
        }
        return reult;
    }

    @Override
    public int StudentRegister(UserRegisetr student) {
        try{
            Log.i("StudentRegister", "StudentRegister: ");
            myData = ReadyDate.GetWrite(context, "MyData");
            ContentValues contentValues=new ContentValues();
            contentValues.put("num",student.getUser());
            contentValues.put("psw",student.getPsw());
            contentValues.put("name",student.getName());
            long student1 = myData.insert("Student", null, contentValues);
            return (int) student1;
        }catch (Exception e){
            Log.i("StudentRegisterE", e+"");
            return -1;
        }finally {
            ReadyDate.CloseSQL();
        }

    }

    @Override
    public List<String> StudentSelect(String Name)
    {
        List<String> action1s=new ArrayList<>();
        myData=ReadyDate.GetRead(context,"MyData");
        String sql="select * from Action2 where SName=? ";
        String[] pares={Name};
        Cursor cursor = myData.rawQuery(sql, pares);
        while (cursor.moveToNext()){
            String aname = cursor.getString(cursor.getColumnIndex("Aname"));
            action1s.add(aname);
        }
        return action1s;
    }

    @Override
    public Action1 StudentActionSelect(String AName) {
        try{
            Action1 action1s=null;
            myData=ReadyDate.GetRead(context,"MyData");
            String sql="select * from Action1 where Aname=? ";
            String[] pares={AName};
            Cursor cursor = myData.rawQuery(sql, pares);
            while (cursor.moveToNext()){
                String aname = cursor.getString(cursor.getColumnIndex("Aname"));
                String mName = cursor.getString(cursor.getColumnIndex("AContext"));
                int cursorInt = cursor.getInt(cursor.getColumnIndex("people"));
                Log.i("cursorInt", cursorInt+"");
                action1s=new Action1(aname,mName);
            }
            return action1s;
        }catch ( Exception e){
            return null;
        }
    }

    @Override
    public List<Action1> StudentAction() {
        List<Action1> action1s=new ArrayList<>();
        myData=ReadyDate.GetRead(context,"MyData");
        String sql="select * from Action1 ";
        Cursor cursor = myData.rawQuery(sql, null);
        while (cursor.moveToNext()){
            Integer id = cursor.getInt(cursor.getColumnIndex("id"));
            String aname = cursor.getString(cursor.getColumnIndex("Aname"));
            final String aContext = cursor.getString(cursor.getColumnIndex("AContext"));
            int people = cursor.getInt(cursor.getColumnIndex("people"));
            int jpeople = cursor.getInt(cursor.getColumnIndex("Jpeople"));
            action1s.add(new Action1(id,aname,aContext,people+"",jpeople+""));
        }
        return action1s;
    }

    @Override
    public int Join(String AName, String StudentName) {
        List<String> strings = StudentSelect(StudentName);
        for (int i = 0; i <strings.size() ; i++) {

            String s = strings.get(i); Log.i("aaa", s);

            if(s.equals(AName)) {
                Log.i("aaa", s);
                return 11;

            }
        }
        Action1 check = Check(AName);
        Log.i("check", check.toString());
        int jiayi=0;
        try{
            jiayi=Integer.valueOf( check.getJpeople());
            int rshu=Integer.valueOf(check.getPeople());
            Log.i("getPeople", jiayi+rshu+"");
            if (rshu==jiayi){
                return -1;
            }else {
                String Where="Aname=?";
                String[] stringps={AName};
                Log.i("StudentRegister", "StudentRegister: ");
                myData = ReadyDate.GetWrite(context, "MyData");
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("Jpeople", jiayi+1);
                myData.update("Action1", contentValues2, Where,stringps);
                ContentValues contentValues = new ContentValues();
                contentValues.put("Aname", AName);
                contentValues.put("SName", StudentName);
                long student1 = myData.insert("Action2", null, contentValues);
                return (int) student1;}
        }
        catch (Exception e){
            Log.i("点太快", e.toString());

            return -1;}
        finally {
            ReadyDate.CloseSQL();
        }
    }



    @Override
    public int NoJoin(String AName,String student) {
        try {
            String Where="Aname=?";
            String[] ms={AName};
            String sql="delete from Action2 where Aname=? and SName=?";
            Action1 check = Check(AName);
            int  jiayi=Integer.valueOf( check.getJpeople());
            myData=ReadyDate.GetWrite(context,"MyData");
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("Jpeople", jiayi-1);
            int  action1 = myData.update("Action1", contentValues2, Where, ms);
            Object[] objects={AName,student};
            myData.execSQL(sql,objects);
            return action1;
        }catch (Exception e){
            return -1;
        }finally {
            myData.close();
        }

    }

    public Action1 Check(String AName){
        try{
            Action1 action1s=null;
            myData=ReadyDate.GetRead(context,"MyData");
            String sql="select * from Action1 where Aname=? ";
            String[] pares={AName};
            Cursor cursor = myData.rawQuery(sql, pares);
            while (cursor.moveToNext()){
                int cursorInt = cursor.getInt(cursor.getColumnIndex("people"));
                int cursorInt2 = cursor.getInt(cursor.getColumnIndex("Jpeople"));
                Log.i("cursorInt", cursorInt+"");
                action1s=new Action1();
                action1s.setPeople(cursorInt+"");
                action1s.setJpeople(cursorInt2+"");
            }
            return action1s;
        }catch ( Exception e){
            return null;
        }

    }
}
