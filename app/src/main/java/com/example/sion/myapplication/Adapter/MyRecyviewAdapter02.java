package com.example.sion.myapplication.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sion.myapplication.EmptyClass.Student;
import com.example.sion.myapplication.MyServer.StudentServer;
import com.example.sion.myapplication.MyServer.StudentServerImp;
import com.example.sion.myapplication.R;
import com.example.sion.myapplication.ViewHolders.MyActionitem;

import java.util.List;

public class MyRecyviewAdapter02  extends RecyclerView.Adapter<MyActionitem> {
    private List<String> titles;
    private String Name;

    public MyRecyviewAdapter02(List<String> titles, String name) {
        this.titles = titles;
        Name = name;
    }

    private StudentServer studentServer;
    @NonNull
    @Override
    public MyActionitem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MyActionitem myActionitem1=new MyActionitem(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.myactionitem,viewGroup,false));
        studentServer =new StudentServerImp(viewGroup.getContext());
        return myActionitem1;
    }

    @Override
    public void onBindViewHolder(@NonNull MyActionitem myActionitem,final int i) {
        myActionitem.MyTitle.setText(titles.get(0));
        myActionitem.Nojion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删除数据库的表
                int i1 = studentServer.NoJoin(titles.get(i), Name);
                titles = studentServer.StudentSelect(Name);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public MyRecyviewAdapter02(List<String> titles) {
        this.titles = titles;
    }
}
