package com.example.sion.myapplication.MyServer;

import com.example.sion.myapplication.EmptyClass.Action1;
import com.example.sion.myapplication.EmptyClass.Student;
import com.example.sion.myapplication.EmptyClass.UserRegisetr;

import java.util.List;

public interface StudentServer {
    //登陆
    public String StudentLogin(Integer studentID,String psw);
    //注册
    public int StudentRegister(UserRegisetr student);
    //学生查询自己活动
    public List<String> StudentSelect(String Name);
    //学生根据活动名字查询活动详细
    public Action1 StudentActionSelect(String AName);
    public List<Action1> StudentAction();
    public int Join(String AName,String StudentName);
    public int NoJoin(String AName,String StudentName);

}
