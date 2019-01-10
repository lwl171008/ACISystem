package com.example.sion.myapplication.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sion.myapplication.EmptyClass.Action1;
import com.example.sion.myapplication.MyServer.AdminServer;
import com.example.sion.myapplication.MyServer.AdminServerImp;
import com.example.sion.myapplication.R;


@SuppressLint("ValidFragment")
public class Fragment04 extends Fragment implements View.OnClickListener {


    private EditText Atitile;
    private EditText APeople;
    private EditText AContext;
    private EditText DeleteTitle;
    private Button deleteBt;
    private Integer body;
    private TextView NM;
    private LinearLayout Ly;
    private AdminServer admin;
    private Context context;
    private Button Fabu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment04, container, false);
        context = getContext();
        admin = new AdminServerImp(context);
        initView(view);
        return view;
    }


    public Fragment04(Integer body) {
        this.body = body;
    }

    private void initView(View view) {
        Atitile = view.findViewById(R.id.Atitile);
        APeople = view.findViewById(R.id.APeople);
        AContext = view.findViewById(R.id.AContext);
        DeleteTitle = view.findViewById(R.id.DeleteTitle);
        deleteBt = view.findViewById(R.id.deleteBt);
        deleteBt.setOnClickListener(this);
        NM = (TextView) view.findViewById(R.id.NM);
        Ly = (LinearLayout) view.findViewById(R.id.Ly);
        if (this.body == 0) {
            Log.i("setVisibility", body + "");
            NM.setVisibility(View.VISIBLE);
            Ly.setVisibility(View.GONE);
        } else {
            NM.setVisibility(View.GONE);
            Ly.setVisibility(View.VISIBLE);
        }


        Fabu = (Button) view.findViewById(R.id.Fabu);
        Fabu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Fabu:
               String name=Atitile.getText()+"";
               String People=APeople.getText()+"";
                String Context=AContext.getText()+"";
                if (name.equals("")||People.equals("")||Context.equals("")){
                    Toast.makeText(context,"请不要留空",Toast.LENGTH_SHORT).show();
                }else {
                    Atitile.setText("");
                    APeople.setText("");
                    AContext.setText("");
                    Action1 action1=new Action1();
                    action1.setAname(name);
                    action1.setAContext(Context);
                    action1.setPeople(People);
                    int i = admin.AdminAdd(action1);
                    if(i!=-1){
                        Toast.makeText(context,"添加成功",Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(context,"添加失败",Toast.LENGTH_SHORT).show();

                    }
                }
                break;
            case R.id.deleteBt:
               String Ti= DeleteTitle.getText()+"";
                if(Ti.equals("")){
                    Toast.makeText(context,"请不要留空",Toast.LENGTH_SHORT).show();

                }else {

                    int i = admin.DeleteAdd(Ti);
                    if(i==1){

                        Toast.makeText(context,"删除成功",Toast.LENGTH_SHORT).show();
                        DeleteTitle.setText("");
                    }else {
                        Toast.makeText(context,"没有这个标题",Toast.LENGTH_SHORT).show();

                    }
                }

                break;
        }

    }
}
