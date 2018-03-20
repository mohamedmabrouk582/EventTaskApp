package com.example.mabrouk.eventtaskapp.view;

import com.example.mabrouk.eventtaskapp.utils.ConnectivityReceiver;
import com.example.mabrouk.eventtaskapp.utils.EventLisenter;

/**
 * Created by Mabrouk on 3/18/2018.
 */

public interface EventsView extends BaseView ,EventLisenter,  ConnectivityReceiver.ConnectivityReceiverListener{
    void showProgress();
    void hideProgress();
    void loadData();
}
