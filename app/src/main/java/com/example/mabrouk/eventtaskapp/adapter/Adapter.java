package com.example.mabrouk.eventtaskapp.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Mabrouk on 3/19/2018.
 */

public class Adapter<model> extends RecyclerView.Adapter<Holder> {
    private ArrayList<model> models=new ArrayList<>();
    private int viewId,varId;
    private Context mContext;

    public Adapter(Context context, int viewId, int varId){
        this.viewId=viewId;
        this.varId=varId;
        this.mContext=context;
    }

    public void setData(ArrayList<model> data){
        models=data;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(viewId,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
     model model=models.get(position);
     holder.getBinding().setVariable(varId,model);
     holder.getBinding().executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
