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

import com.example.sion.myapplication.Adapter.MyRecyviewAdapter;
import com.example.sion.myapplication.Adapter.RyLine;
import com.example.sion.myapplication.EmptyClass.Action1;
import com.example.sion.myapplication.EmptyClass.Student;
import com.example.sion.myapplication.MyServer.StudentServer;
import com.example.sion.myapplication.MyServer.StudentServerImp;
import com.example.sion.myapplication.R;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class Fragment01 extends Fragment {
    private String name;

    public Fragment01(String name) {
        this.name = name;
    }

    private RecyclerView MyRV;
    private List<Action1> msgs=new ArrayList<>();
    private Context context;
    private StudentServer student;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01, container, false);
        Log.i("0msg1", "fragment01: ");
        initView(view);
        return view;
    }

    private void initView(View view) {
        context=getContext();
        MyRV = (RecyclerView) view.findViewById(R.id.MyRV);
        MyRv(MyRV);


    }
    public void MyRv(RecyclerView myRV){
        student=new StudentServerImp(context);
        msgs=initDate();
        MyRecyviewAdapter myRecyviewAdapter=new MyRecyviewAdapter(student,msgs,name);
        myRecyviewAdapter.notifyDataSetChanged();
        myRV.addItemDecoration(new RyLine(30));
        myRV.setLayoutManager(new LinearLayoutManager(context));
        myRV.setAdapter(myRecyviewAdapter);
    }
    public List<Action1> initDate(){
        List<Action1> action1s = student.StudentAction();
        if(action1s==null){
            action1s=new ArrayList<>();
        }
        return  action1s;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i("vvonViewCreated", "onViewCreated: ");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i("onStart", "onViewCreated: ");
        super.onStart();
    }
}
