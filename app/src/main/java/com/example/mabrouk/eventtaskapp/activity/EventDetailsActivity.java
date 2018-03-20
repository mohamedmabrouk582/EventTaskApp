package com.example.mabrouk.eventtaskapp.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;


import com.example.mabrouk.eventtaskapp.R;
import com.example.mabrouk.eventtaskapp.adapter.VenuAdapter;
import com.example.mabrouk.eventtaskapp.fragment.EventDetailsFragment;
import com.example.mabrouk.eventtaskapp.models.Event;
import com.example.mabrouk.eventtaskapp.utils.SingleFragmentActivity;
import com.example.mabrouk.eventtaskapp.view.EventDetailsView;

public class EventDetailsActivity extends SingleFragmentActivity{
    private static final String EVENT = "event";


    public static Intent newIntent(Context context, Event event){
        Intent intent=new Intent(context,EventDetailsActivity.class);
        intent.putExtra(EVENT,event);
        return  intent;
    }

    @Override
    public Fragment CreateFragment() {
        return EventDetailsFragment.newFragment((Event) getIntent().getParcelableExtra(EVENT));
    }
}
