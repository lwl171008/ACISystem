package com.example.sion.myapplication.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.sion.myapplication.R;
import com.qmuiteam.qmui.layout.QMUIButton;

public class HomeViewHolder extends RecyclerView.ViewHolder {

    public View rootView;
    public TextView ActionName;
    public TextView ActionPeo;
    public QMUIButton Join;
    public TextView Residue;
    public TextView MyID;

    public HomeViewHolder(@NonNull  View rootView) {
        super(rootView);
        this.rootView = rootView;
        this.ActionName = (TextView) rootView.findViewById(R.id.ActionName);
        this.ActionPeo = (TextView) rootView.findViewById(R.id.ActionPeo);
        this.Join = (QMUIButton) rootView.findViewById(R.id.Join);
        this.Residue = (TextView) rootView.findViewById(R.id.Residue);
        this.MyID=rootView.findViewById(R.id.MyID);
    }

}
