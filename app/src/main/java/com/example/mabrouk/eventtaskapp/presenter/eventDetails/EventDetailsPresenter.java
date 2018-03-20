package com.example.mabrouk.eventtaskapp.presenter.eventDetails;

import com.example.mabrouk.eventtaskapp.models.Event;
import com.example.mabrouk.eventtaskapp.presenter.base.BasePresenter;
import com.example.mabrouk.eventtaskapp.view.EventDetailsView;

/**
 * Created by Mabrouk on 3/19/2018.
 */

public interface EventDetailsPresenter<v extends EventDetailsView> extends BasePresenter<v> {
    void addToFav(Event event,boolean isFav);
}
