package com.example.sion.myapplication.MyServer;

import com.example.sion.myapplication.EmptyClass.Action1;
import com.example.sion.myapplication.EmptyClass.Admin;
import com.example.sion.myapplication.EmptyClass.UserRegisetr;

public interface AdminServer {
    public int AdminRegister(UserRegisetr admin);
    public String AdminLogin(Admin admin);
    public int AdminAdd(Action1 action1);
    public int DeleteAdd(String Aname);
    public int Update(String Aname,Action1 action1);

}
