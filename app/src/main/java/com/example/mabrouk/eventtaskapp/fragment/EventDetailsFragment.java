package com.example.mabrouk.eventtaskapp.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mabrouk.eventtaskapp.BR;
import com.example.mabrouk.eventtaskapp.R;
import com.example.mabrouk.eventtaskapp.adapter.Adapter;
import com.example.mabrouk.eventtaskapp.adapter.VenuAdapter;
import com.example.mabrouk.eventtaskapp.data.dataBase.RealmManager;
import com.example.mabrouk.eventtaskapp.models.Classfication;
import com.example.mabrouk.eventtaskapp.models.Event;
import com.example.mabrouk.eventtaskapp.models.FavEvents;
import com.example.mabrouk.eventtaskapp.models.PriceRange;
import com.example.mabrouk.eventtaskapp.models.Promoter;
import com.example.mabrouk.eventtaskapp.presenter.eventDetails.EventDetailsViewPresenter;
import com.example.mabrouk.eventtaskapp.utils.RxBus;
import com.example.mabrouk.eventtaskapp.view.EventDetailsView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

/**
 * Created by Mohammad mabrouk
 * 0201152644726
 * on 3/19/2018.  time :17:30
 */

public class EventDetailsFragment extends Fragment implements EventDetailsView{
    private static final String EVENT = "event";
    private EventDetailsViewPresenter presenter;
    private RecyclerView promoterRecyclerView,priceRecyclerView;
    private ViewPager venue;
    private FloatingActionButton addTOfav;
    private ImageView eventImg;
    private TextView type,date;
    private Event event;
    private View view;
    private Adapter<Promoter> promoterAdapter;
    private Adapter<PriceRange> priceRangeAdapter;

    public static EventDetailsFragment newFragment(Event event){
        Bundle bundle=new Bundle();
        bundle.putParcelable(EVENT,event);
        EventDetailsFragment fragment=new EventDetailsFragment();
        fragment.setArguments(bundle);
    return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_event_details,container,false);
         ini();
        return view;
    }

    private void ini() {
        RealmManager.open();
        event=getArguments().getParcelable(EVENT);
        presenter= ViewModelProviders.of(this).get(EventDetailsViewPresenter.class);
        presenter.attachView(this);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(event.getName());
        addTOfav = view.findViewById(R.id.fab);
        venue=view.findViewById(R.id.venue_view_pager);
        eventImg=view.findViewById(R.id.event_d_img);
        promoterRecyclerView=view.findViewById(R.id.promoter_recycler);
        priceRecyclerView=view.findViewById(R.id.price_recycler);
        type=view.findViewById(R.id.event_type_d);
        date=view.findViewById(R.id.event_date_d);
        promoterRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true));
        priceRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true));

        priceRangeAdapter=new Adapter<>(getContext(),R.layout.price_item, BR.price);
        promoterAdapter=new Adapter<>(getContext(),R.layout.promoter_item,BR.promoter);
        setData(event);
    }

    @Override
    public void setData(Event data) {
        if (RealmManager.createUserDao().isFav(data.getId())){
            addTOfav.setImageResource(R.drawable.ic_heart);
        }else {
            addTOfav.setImageResource(R.drawable.ic_favorites);
        }
        Log.d("data", data.toString() + "");
        date.setText(data.getDateResponse().getStart().getLocalDate());
        Classfication classfication = data.getClassfications().get(0);
        type.setText(classfication.getSegment().getName().concat("/").concat(classfication.getGenre().getName()).concat("/").concat(classfication.getSubGenre().getName()));
        try {
            Picasso.with(getActivity()).load(Uri.parse(event.getImgs().get(event.getImgs().size()-1).getImageUrl()))
                    .placeholder(R.drawable.img_error).into(eventImg);
        }catch (Exception data1){}
        VenuAdapter venuAdapter = new VenuAdapter(getChildFragmentManager(), event.getEmbedded().getVenues());
        venue.setAdapter(venuAdapter);

        promoterAdapter.setData(data.getPromoters());
        priceRangeAdapter.setData(data.getPriceRanges());

        promoterRecyclerView.setAdapter(promoterAdapter);
        priceRecyclerView.setAdapter(priceRangeAdapter);
       // binding.setVariable(BR.event,event);
        AddTOfav();
    }

    private void AddTOfav(){
        addTOfav.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FavEvents favEvents=new FavEvents(event.getId(),new Gson().toJson(event));
                Log.d("favEvents",  favEvents.toString() + "");
                RxBus.getRxBus().sendFav(event);
                if (RealmManager.createUserDao().isFav(event.getId())){
                    RealmManager.createUserDao().deleteFavEvent(event.getId());
                    addTOfav.setImageResource(R.drawable.ic_favorites);

                }else {
                    RealmManager.createUserDao().insertFavEvent(favEvents);
                    addTOfav.setImageResource(R.drawable.ic_heart);

                }
              //  presenter.addToFav(event,RealmManager.createUserDao().isFav(event.getId()));
            }
        });

    }
}
