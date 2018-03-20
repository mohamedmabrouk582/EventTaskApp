package com.example.mabrouk.eventtaskapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mabrouk.eventtaskapp.R;
import com.example.mabrouk.eventtaskapp.models.Classfication;
import com.example.mabrouk.eventtaskapp.models.Event;
import com.example.mabrouk.eventtaskapp.utils.EventLisenter;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mabrouk on 3/18/2018.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.Holder>{
   private Context activity;
   private ArrayList<Event> events;
   private EventLisenter lisenter;
   public EventAdapter(Context activity, EventLisenter lisenter){
       this.activity=activity;
       this.lisenter=lisenter;
   }

   public void setData(ArrayList<Event> data){
       events=data;
   }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.event_item_view,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
       holder.bind(events.get(position));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView eventImageView;
        private TextView name,date,type,url;
        private ProgressBar imgLoad;

        public Holder(View itemView) {
            super(itemView);
            ini();
            itemView.setOnClickListener(this);
            url.setOnClickListener(this);
        }
        private void ini(){
            eventImageView=itemView.findViewById(R.id.event_img);
            name=itemView.findViewById(R.id.event_name);
            date=itemView.findViewById(R.id.event_date);
            type=itemView.findViewById(R.id.event_type);
            url=itemView.findViewById(R.id.event_url);
            imgLoad=itemView.findViewById(R.id.img_load);
        }

        public void bind(Event event){

                try {
                    Picasso.with(activity).load(Uri.parse(event.getImgs().get(event.getImgs().size()-1).getImageUrl()))
                            .placeholder(R.drawable.img_error).into(eventImageView, new Callback() {
                        @Override
                        public void onSuccess() {
                            imgLoad.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError() {

                        }
                    });
                }catch (Exception e){}


            name.setText(event.getName());
            date.setText(event.getDateResponse().getStart().getLocalDate());
            Classfication classfication = event.getClassfications().get(0);
            type.setText(classfication.getSegment().getName().concat("/").concat(classfication.getGenre().getName()).concat("/").concat(classfication.getSubGenre().getName()));
            url.setText(event.getUrl());
        }

        @Override
        public void onClick(View v) {
            if (v.getId()==R.id.event_url){
                lisenter.onClick(events.get(getAdapterPosition()),url);
            }else {
                lisenter.onClick(events.get(getAdapterPosition()),itemView);
            }
        }
    }
}
