package com.example.mabrouk.eventtaskapp.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.example.mabrouk.eventtaskapp.R;
import com.example.mabrouk.eventtaskapp.adapter.Adapter;
import com.example.mabrouk.eventtaskapp.databinding.VenueViewBinding;
import com.example.mabrouk.eventtaskapp.models.Venue;
import com.example.mabrouk.eventtaskapp.models.image;

/**
 * Created by Mohammad mabrouk
 * 0201152644726
 * on 3/19/2018.  time :19:03
 */

public class VenueFragment extends Fragment {
    private static final String VENUE = "VENUE";
    private View view;
    private RecyclerView mRecyclerView;
    private Venue venue;
    private VenueViewBinding venueViewBinding;

    public static VenueFragment newFragment(Venue venue){
        Bundle  bundle=new Bundle();
        bundle.putParcelable(VENUE,venue);
        VenueFragment fragment=new VenueFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // view=inflater.inflate(R.layout.venue_view,container,false);
        venueViewBinding= DataBindingUtil.inflate(inflater,R.layout.venue_view,container,false);
         view=venueViewBinding.getRoot();
        ini();
        return view;
    }

    private void ini() {
        venue=getArguments().getParcelable(VENUE);
        Log.d("getArguments", venue.toString() + "");
        mRecyclerView=view.findViewById(R.id.venus_imges_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true));

       setData((Venue) getArguments().getParcelable(VENUE));
    }

    private void setData(Venue data){
        venueViewBinding.setVariable(BR.venue,data);
        Adapter<image> imageAdapter=new Adapter<>(getContext(),R.layout.img_item, BR.img);
        if (data.getImages()!=null) {
            imageAdapter.setData(data.getImages());
            mRecyclerView.setAdapter(imageAdapter);
        }
    }
}
