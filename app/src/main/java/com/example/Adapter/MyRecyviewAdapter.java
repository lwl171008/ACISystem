package com.example.sion.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sion.myapplication.EmptyClass.Action1;
import com.example.sion.myapplication.MyServer.StudentServer;
import  com.example.sion.myapplication.R;
import com.example.sion.myapplication.ViewHolders.HomeViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MyRecyviewAdapter extends RecyclerView.Adapter<HomeViewHolder> {
    StudentServer studentServer;
    List<Action1> actionMsgs;
    String StudentName;
    Context context;
    public MyRecyviewAdapter(StudentServer studentServer, List<Action1> actionMsgs, String studentName) {
        this.studentServer = studentServer;
        this.actionMsgs = actionMsgs;
        StudentName = studentName;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        HomeViewHolder holder=new HomeViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.homeitem,viewGroup,false));
        context=viewGroup.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder homeViewHolder,final int i) {
        homeViewHolder.ActionName.setText(actionMsgs.get(i).getAname());
        homeViewHolder.ActionPeo.setText(actionMsgs.get(i).getPeople());
        homeViewHolder.Residue.setText(actionMsgs.get(i).getJpeople());
        homeViewHolder.MyID.setText(actionMsgs.get(i).getId()+"");
        homeViewHolder.Join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int join = studentServer.Join(actionMsgs.get(i).getAname(), StudentName);

                if(join==11){
                    Toast.makeText(context,"你已经报过名",Toast.LENGTH_SHORT).show();
                }else if(join==-1) {
                    Toast.makeText(context,"人数已经满了",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context,"报名成功",Toast.LENGTH_SHORT).show();
                    actionMsgs = studentServer.StudentAction();
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return actionMsgs.size();
    }
}
