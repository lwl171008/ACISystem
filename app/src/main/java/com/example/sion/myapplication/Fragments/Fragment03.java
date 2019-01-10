package com.example.sion.myapplication.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sion.myapplication.Adapter.MyRecyviewAdapter02;
import com.example.sion.myapplication.Adapter.RyLine;
import com.example.sion.myapplication.MyServer.StudentServer;
import com.example.sion.myapplication.MyServer.StudentServerImp;
import com.example.sion.myapplication.R;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class Fragment03 extends Fragment {

    private String Name;
    private RecyclerView MyRv03;
    private List<String> list=new ArrayList<>();
    private Context context;
    private StudentServer studentServer;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment03, container, false);
        TextView viewById = view.findViewById(R.id.MyName);
        viewById.setText(Name);
        context=getContext();
        initView(view);
        return view;
    }

    private void initView(View view) {
        MyRv03 = (RecyclerView) view.findViewById(R.id.MyRv03);
        studentServer=new StudentServerImp(context);
        setRv(MyRv03);
    }

    public Fragment03( String name) {
        Name = name;
    }

    private void setRv(RecyclerView myRv03) {
        List<String> strings = studentServer.StudentSelect(Name);
        if(strings!=null){
            list=strings;
        }
        MyRecyviewAdapter02 myRecyviewAdapter02=new MyRecyviewAdapter02(list,Name);
        myRecyviewAdapter02.notifyDataSetChanged();
        myRv03.setLayoutManager(new LinearLayoutManager(context));
        myRv03.addItemDecoration(new RyLine(20));
        myRv03.setAdapter(myRecyviewAdapter02);
    }


}
