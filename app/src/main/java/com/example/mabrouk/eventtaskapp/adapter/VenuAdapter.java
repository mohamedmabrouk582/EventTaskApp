package com.example.mabrouk.eventtaskapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.mabrouk.eventtaskapp.models.Venue;
import com.example.mabrouk.eventtaskapp.fragment.VenueFragment;

import java.util.ArrayList;

/**
 * Created by Mabrouk on 3/19/2018.
 */

public class VenuAdapter extends FragmentPagerAdapter {
    private ArrayList<Venue> venues;
    public VenuAdapter(FragmentManager fm, ArrayList<Venue> venues) {
        super(fm);
        this.venues=venues;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("dddddddd", venues.get(position).toString() + "");
        return VenueFragment.newFragment(venues.get(position));
    }

    @Override
    public int getCount() {
        Log.d("dddddddd", venues.size() + "");

        return venues.size();
    }
}
