package com.example.mabrouk.eventtaskapp.activity;

import android.support.v4.app.Fragment;

import com.example.mabrouk.eventtaskapp.fragment.EventFragment;
import com.example.mabrouk.eventtaskapp.utils.SingleFragmentActivity;

/**
 * Created by Mabrouk on 3/18/2018.
 */

public class EventActivity extends SingleFragmentActivity {
    @Override
    public Fragment CreateFragment() {
        return new EventFragment();
    }
}
