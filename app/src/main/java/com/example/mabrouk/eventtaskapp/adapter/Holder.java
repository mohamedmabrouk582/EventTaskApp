package com.example.mabrouk.eventtaskapp.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Mabrouk on 3/19/2018.
 */

public class Holder extends RecyclerView.ViewHolder {
    private ViewDataBinding viewDataBinding;
    public Holder(View itemView) {
        super(itemView);
        viewDataBinding= DataBindingUtil.bind(itemView);
    }

    public ViewDataBinding getBinding(){
        return viewDataBinding;
    }
}
