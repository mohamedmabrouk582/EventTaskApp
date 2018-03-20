package com.example.mabrouk.eventtaskapp.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.mabrouk.eventtaskapp.R;

/**
 * Created by Mabrouk on 3/18/2018.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity{

    public abstract Fragment CreateFragment();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.Fragment_Container,CreateFragment()).commit();
    }
}
