package com.example.mabrouk.eventtaskapp.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mabrouk.eventtaskapp.R;
import com.example.mabrouk.eventtaskapp.adapter.EventAdapter;
import com.example.mabrouk.eventtaskapp.application.MyApp;
import com.example.mabrouk.eventtaskapp.data.dataBase.RealmManager;
import com.example.mabrouk.eventtaskapp.models.AllEvents;
import com.example.mabrouk.eventtaskapp.models.Event;
import com.example.mabrouk.eventtaskapp.models.EventEmbedded;
import com.example.mabrouk.eventtaskapp.models.FavEvents;
import com.example.mabrouk.eventtaskapp.presenter.events.EventsViewPresenter;
import com.example.mabrouk.eventtaskapp.utils.ConnectivityReceiver;
import com.example.mabrouk.eventtaskapp.utils.RxBus;
import com.example.mabrouk.eventtaskapp.view.EventsView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Mabrouk on 3/18/2018.
 */

public class EventFragment extends Fragment implements EventsView, Observer<EventEmbedded> {
    private View view;
    private EventAdapter mEventAdapter;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private EventsViewPresenter presenter;
    private static int currentPostion;
    private int isFv;
    private Disposable disposable;
    private SearchView searchView;
   // private DbOperations dbOperations;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
        MenuItem SearchItem=menu.findItem(R.id.app_bar_search_menu);
        searchView = (SearchView) SearchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                showProgress();
                presenter.reqSearch(EventFragment.this,query);
                searchView.onActionViewCollapsed();
                searchView.setQuery("", false);
                isFv=2;
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.all_item:
                isFv=2;
                loadData();
                break;
            case R.id.fav_item:
                isFv=1;
                loadData();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.events_fragment, container, false);
        iniRecycler();
        iniSwipe();
        ini();
        return view;
    }

    private void ini(){
      //  dbOperations=ViewModelProviders.of(this).get(DbOperations.class);
        RealmManager.open();
        presenter= ViewModelProviders.of(getActivity()).get(EventsViewPresenter.class);
        presenter.load(getActivity());
        presenter.attachView(this);
        mEventAdapter =new EventAdapter(getActivity(),this);
        loadData();
        disposable=RxBus.getRxBus().subscribeFav(this::update);
    }

    private void update(Event event){
      loadData();
      mEventAdapter.notifyDataSetChanged();
    }

    private void  iniRecycler(){
        mSwipeRefreshLayout = view.findViewById(R.id.my_events_stl);
        mRecyclerView=view.findViewById(R.id.events_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void iniSwipe() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
    }


    @Override
    public void showProgress() {
        if (!mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    mSwipeRefreshLayout.setRefreshing(true);
                }
            });
        }
    }

    @Override
    public void hideProgress() {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void loadData() {
        // dbOperations.deleteAll();
        if (isFv==1) {
            mEventAdapter.setData(getFavEventsFROMdB());
            mRecyclerView.setAdapter(mEventAdapter);
        } else {
            showProgress();
            if (!ConnectivityReceiver.isConnected()){
                hideProgress();
                mEventAdapter.setData(getEventsFromDb());
                mRecyclerView.setAdapter(mEventAdapter);
            }else {
                presenter.reqEvents(this);
            }
     }

    }


    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onNext(EventEmbedded eventEmbedded) {
        if (eventEmbedded.getEvents()!=null) {
            ArrayList<Event> events = eventEmbedded.getEvents().getEvents();
            mEventAdapter.setData(events);
            mEventAdapter.notifyDataSetChanged();
            insertEvent(events);
        }else {
            Toast.makeText(getActivity(), "no data", Toast.LENGTH_SHORT).show();
        }
    }

    private void insertEvent(ArrayList<Event> events){
        RealmManager.createUserDao().clearAllEvent();
        String s=new Gson().toJson(events);
        AllEvents allEvents=new AllEvents(s);
        RealmManager.createUserDao().insertAllEvents(allEvents);

    }

    private ArrayList<Event>  getEventsFromDb(){
        Type listType = new TypeToken<ArrayList<Event>>() {}.getType();
        RealmObject allEvents1 = RealmManager.createUserDao().getAllEvents();
        AllEvents allEvents2= (AllEvents) allEvents1;
        ArrayList<Event> list=new Gson().fromJson(allEvents2.getData(),listType);
        Log.d("allEvents1", list.size()+ "");

        return list;
    }

    private ArrayList<Event> getFavEventsFROMdB(){
        hideProgress();
        RealmResults<FavEvents> favEvents = RealmManager.createUserDao().getFavEvents();
        ArrayList<Event> list=new ArrayList<>();
        for (FavEvents events:favEvents) {
            Log.d("eeeeee", new Gson().fromJson(events.getData(),Event.class).toString() + "");
            list.add(new Gson().fromJson(events.getData(),Event.class));
        }

        return list;
    }

    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onComplete() {
        hideProgress();
        mRecyclerView.setAdapter(mEventAdapter);

       // Log.d("hello", dbOperations.getEvents().size() + "");
    }


    @Override
    public void onClick( Event event, View view) {
        if (view.getId()==R.id.event_url){
            Toast.makeText(getActivity(), "event_url", Toast.LENGTH_SHORT).show();
        }else {
            presenter.clickEvent(event);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MyApp.getInstance().setConnectivityListener(this);
        if (isFv==0) {
            checkConnection();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //RealmManager.close();
    }

    @Override
    public void onStop() {
        super.onStop();
        //RxBus.getRxBus().unSubscribe(disposable);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
      showSnack(isConnected);
    }

    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        showSnack(isConnected);
    }

    // Showing the status in Snackbar
    private void showSnack(boolean isConnected) {
        String message="";
        int color = 0;
        if (!isConnected) {
            hideProgress();
            mEventAdapter.setData(getEventsFromDb());
            mRecyclerView.setAdapter(mEventAdapter);
            message = "Sorry! Not connected to internet";
            color = Color.RED;

        }

        Snackbar snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();
    }
}
