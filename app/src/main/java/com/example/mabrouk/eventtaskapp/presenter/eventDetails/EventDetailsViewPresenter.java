package com.example.mabrouk.eventtaskapp.presenter.eventDetails;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.mabrouk.eventtaskapp.models.Event;
import com.example.mabrouk.eventtaskapp.presenter.base.BaseViewPresenter;
import com.example.mabrouk.eventtaskapp.view.EventDetailsView;

/**
 * Created by Mabrouk on 3/19/2018.
 */

public class EventDetailsViewPresenter<v extends EventDetailsView> extends BaseViewPresenter<v> implements EventDetailsPresenter<v>  {

    public EventDetailsViewPresenter(@NonNull Application application) {
        super(application);
    }

    @Override
    public void addToFav(Event event,boolean isFav) {
      if (isFav){

      }else {

      }
    }
}
