package com.example.sion.myapplication.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sion.myapplication.R;

public class MyActionitem extends RecyclerView.ViewHolder {


    public View rootView;
    public TextView MyTitle;
    public Button Nojion;
    public MyActionitem(@NonNull View itemView) {
        super(itemView);
        this.rootView = itemView;
        this.MyTitle = (TextView) rootView.findViewById(R.id.MyTitle);
        this.Nojion = (Button) rootView.findViewById(R.id.Nojion);}

}
