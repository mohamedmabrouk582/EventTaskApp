package com.example.mabrouk.eventtaskapp.presenter.events;

import com.example.mabrouk.eventtaskapp.models.Event;
import com.example.mabrouk.eventtaskapp.models.EventEmbedded;
import com.example.mabrouk.eventtaskapp.presenter.base.BasePresenter;
import com.example.mabrouk.eventtaskapp.view.EventsView;

import io.reactivex.Observer;


/**
 * Created by Mabrouk on 3/18/2018.
 */

public interface EventsPresenter<v extends EventsView> extends BasePresenter<v> {
    void clickEvent(Event event);
    void reqEvents(Observer<EventEmbedded> observer);
    void reqSearch(Observer<EventEmbedded> observer,String query);
}
