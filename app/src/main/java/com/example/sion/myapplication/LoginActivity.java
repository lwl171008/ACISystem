package com.example.sion.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sion.myapplication.EmptyClass.Admin;
import com.example.sion.myapplication.EmptyClass.UserRegisetr;
import com.example.sion.myapplication.MyServer.AdminServer;
import com.example.sion.myapplication.MyServer.AdminServerImp;
import com.example.sion.myapplication.MyServer.StudentServer;
import com.example.sion.myapplication.MyServer.StudentServerImp;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private StudentServer studentServer;
    private Button SLogin;
    private Button SReg;
    private Button Student;
    private Button Teacher;
    private LinearLayout Button;
    private EditText Suser;
    private EditText Spsw;
    private EditText Tuser;
    private EditText Tpsw;
    private CardView S;
    private CardView T;
    private Context context;
    private AdminServer adminServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {

        context=this;
        SLogin = (Button) findViewById(R.id.SLogin);
        SReg = (Button) findViewById(R.id.SReg);
        Student = (Button) findViewById(R.id.Student);
        Teacher = (Button) findViewById(R.id.Teacher);
        Button = (LinearLayout) findViewById(R.id.Button);
        Suser = (EditText) findViewById(R.id.Suser);
        Spsw = (EditText) findViewById(R.id.Spsw);
        Tuser = (EditText) findViewById(R.id.Tuser);
        Tpsw = (EditText) findViewById(R.id.Tpsw);

        SLogin.setOnClickListener(this);
        SReg.setOnClickListener(this);
        Student.setOnClickListener(this);
        Teacher.setOnClickListener(this);
        S = (CardView) findViewById(R.id.S);
        S.setOnClickListener(this);
        T = (CardView) findViewById(R.id.T);
        T.setOnClickListener(this);
        studentServer=new StudentServerImp(context);
        adminServer=new AdminServerImp(context);
    }

    @Override
    public void onClick(View v) {
        int St=S.getVisibility();
        int Tt = T.getVisibility();
        switch (v.getId()) {
            case R.id.SLogin:
                if(St==0){
                   String user= Suser.getText()+"";
                    String psw= Spsw.getText()+"";
                    if(user.equals("")||psw.equals("")){
                        Toast.makeText(this,"请不要留空",Toast.LENGTH_SHORT).show();
                    }else {
                        try{
                            Integer integer = Integer.valueOf(user);
                            String s = studentServer.StudentLogin(integer, psw);
                            if(s!=null){
                                Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                intent.putExtra("Name",s);
                                intent.putExtra("Body",0);

                                startActivity(intent);

                            }else {
                                Toast.makeText(this,"账号或者密码错误",Toast.LENGTH_SHORT).show();
                            }

                        }catch (Exception e){
                            Toast.makeText(this,"请输入学号",Toast.LENGTH_SHORT).show();
                        }
                    }

                      //学生登陆

                }
                  if(Tt==0){
                    //老师登陆
                      String user= Tuser.getText()+"";
                      String psw= Tpsw.getText()+"";
                      if(user.equals("")||psw.equals("")){
                          Toast.makeText(this,"请不要留空",Toast.LENGTH_SHORT).show();
                      }else {
                          try{
                              Integer integer = Integer.valueOf(user);
                              String s = adminServer.AdminLogin(new Admin(integer, psw));
                              if(s!=null){
                                  Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
                                  Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                  intent.putExtra("Name",s);
                                  intent.putExtra("Body",1);
                                  startActivity(intent);

                              }else {
                                  Toast.makeText(this,"账号或者密码错误",Toast.LENGTH_SHORT).show();
                              }
                          }catch (Exception e){
                              Toast.makeText(this,"请输入学号",Toast.LENGTH_SHORT).show();
                          }
                      }
                  }
                break;
            case R.id.SReg:
                if(St==0){
                    //学生注册
              showDlog(0);

                }
                if(Tt==0){
                    //老师注册
                    showDlog(1);
                }
                break;
            case R.id.Student:

                Student.setTextColor(Color.RED);
                Teacher.setTextColor(Color.WHITE);
                S.setVisibility(View.VISIBLE);
                T.setVisibility(View.GONE);
                break;
            case R.id.Teacher:
                Student.setTextColor(Color.WHITE);
                Teacher.setTextColor(Color.RED);
                S.setVisibility(View.GONE);
                T.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void showDlog(final int i){

        final View[] inflate = {LayoutInflater.from(this).inflate(R.layout.alterdalog, null)};
        final AlertDialog.Builder student = new AlertDialog.Builder(this);
        if(i==0){
            student.setTitle("学生注册");
        }else {
            student.setTitle("老师注册");
        }

        student.setView(inflate[0]);
       final EditText viewById2 = inflate[0].findViewById(R.id.myuser);
        final  EditText viewById1 = inflate[0].findViewById(R.id.mypsw);
        final  EditText viewById = inflate[0].findViewById(R.id.twopsw);
        final  EditText viewById3 = inflate[0].findViewById(R.id.name);

        student.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    String user= viewById2.getText()+"";
                    Integer muse=Integer.valueOf(user);
                    String psw=viewById1.getText()+"";
                    String psw2= viewById.getText()+"";
                    String name=viewById3.getText()+"";
                    if(user.equals("")||psw.equals("")||psw2.equals("")||name.equals("")){
                        Toast.makeText(LoginActivity.this,"请不要留空",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        showDlog(i);
                    }
                    else if(!psw.equals(psw2)){
                        AlertDialog alertDialog = student.create();
                        alertDialog.setCanceledOnTouchOutside(false);
                        alertDialog.setCancelable(false);
                        Toast.makeText(LoginActivity.this,"两次密码不正确",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        showDlog(i);
                    }else {
                        UserRegisetr userRegisetr = new UserRegisetr(muse, psw, name);
                        Log.i("userRegisetr", userRegisetr.toString());
                        student.setCancelable(true);
                        Jonp(userRegisetr,i);
                        dialog.dismiss();
                    }
                }catch (Exception e){
                    Toast.makeText(LoginActivity.this,e.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        student.setNegativeButton("返回", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LoginActivity.this,"返回",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        student.setCancelable(false);
        student.show();

    }


    public synchronized void Jonp(UserRegisetr userRegisetr,int sa){

       if(sa==0&&userRegisetr!=null){
               int i = studentServer.StudentRegister(userRegisetr);
            if(i!=-1){
                Toast.makeText(LoginActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(LoginActivity.this,"学生用户已经存在",Toast.LENGTH_SHORT).show();
            }
       }else if(sa==1&&userRegisetr!=null){
           int i = adminServer.AdminRegister(userRegisetr);
           if(i!=-1){
               Toast.makeText(LoginActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
           }else {
               Toast.makeText(LoginActivity.this,"老师用户已经存在",Toast.LENGTH_SHORT).show();

           }
       }else {

       }
    }
}
