package com.example.sion.myapplication.Fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sion.myapplication.EmptyClass.Action1;
import com.example.sion.myapplication.MyServer.StudentServer;
import com.example.sion.myapplication.MyServer.StudentServerImp;
import com.example.sion.myapplication.R;
import com.qmuiteam.qmui.layout.QMUIButton;

@SuppressLint("ValidFragment")
public class Fragment02 extends Fragment implements View.OnClickListener {
    private Action1 action1 ;
    private EditText Title;
    private Button sousuo;
    private String Name;

    public Fragment02(String name) {
        Name = name;
    }

    private TextView AcName;
    private TextView AcCon;
    private QMUIButton Baoming;
    private QMUIButton Next;
    private Context context;
    private StudentServer studentServer;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment02, container, false);
        initView(view);
        context=getContext();
        studentServer=new StudentServerImp(context);
        return view;
    }

    private void initView(View view) {
        
        Title = (EditText) view.findViewById(R.id.Title);
        sousuo = (Button) view.findViewById(R.id.sousuo);
        AcName = (TextView) view.findViewById(R.id.AcName);
        AcCon = (TextView) view.findViewById(R.id.AcCon);
        Baoming = (QMUIButton) view.findViewById(R.id.Baoming);


        sousuo.setOnClickListener(this);
        Baoming.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sousuo:
                String Titles=Title.getText()+"";
                if(Titles.equals("")){
                    Toast.makeText(context,"请不要留空",Toast.LENGTH_SHORT).show();
                }else {
                     action1 = studentServer.StudentActionSelect(Titles);
                    if(action1!=null){
                    AcName.setText(action1.getAname());
                    AcCon.setText(action1.getAContext());}
                    else {
                        Toast.makeText(context,"查询不到",Toast.LENGTH_SHORT).show();
                    }
                }
                InputMethodManager inputMethodManager =
                        (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getView().getWindowToken(),0);

                break;
            case R.id.Baoming:
                String titile=AcName.getText()+"";
                if (titile.equals("")){
                    Toast.makeText(context,"请查询",Toast.LENGTH_SHORT).show();
                }else {
                int join = studentServer.Join(action1.getAname(), Name);
                if(join!=-1){
                    Toast.makeText(context,"报名成功",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(context,"报名失败",Toast.LENGTH_SHORT).show();
                }}
                break;

        }
    }


}
