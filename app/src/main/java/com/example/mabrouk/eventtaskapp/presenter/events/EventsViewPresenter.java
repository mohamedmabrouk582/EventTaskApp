package com.example.mabrouk.eventtaskapp.presenter.events;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.Toast;

import com.example.mabrouk.eventtaskapp.activity.EventDetailsActivity;
import com.example.mabrouk.eventtaskapp.data.api.Api;
import com.example.mabrouk.eventtaskapp.data.api.Client;
import com.example.mabrouk.eventtaskapp.models.Event;
import com.example.mabrouk.eventtaskapp.models.EventEmbedded;
import com.example.mabrouk.eventtaskapp.presenter.base.BaseViewPresenter;
import com.example.mabrouk.eventtaskapp.view.EventsView;


import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Mabrouk on 3/18/2018.
 */

public class EventsViewPresenter<v extends EventsView> extends BaseViewPresenter<v>  implements EventsPresenter<v>{
   private Activity activity;
   private Api api;

    private final String API_KEY="d5xUgGtUoWaPS1cOUZuAv21UwmhQK9RB";

    public EventsViewPresenter(Application application){
        super(application);
    }

    public void load(Activity activity){
        this.activity=activity;
        api= Client.getmRetrofit().create(Api.class);
    }

    @Override
    public void clickEvent(Event event) {
        activity.startActivity(EventDetailsActivity.newIntent(activity,event));
    }

    @Override
    public void reqEvents(Observer<EventEmbedded> observer) {
        api.getEvents(API_KEY).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(observer);
    }

    @Override
    public void reqSearch(Observer<EventEmbedded> observer, String query) {
        api.getSearchedEvent(query,API_KEY).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(observer);
    }


}
