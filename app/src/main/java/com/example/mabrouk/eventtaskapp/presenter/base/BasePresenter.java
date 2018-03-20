package com.example.mabrouk.eventtaskapp.presenter.base;

import android.view.View;

import com.example.mabrouk.eventtaskapp.view.BaseView;


/**
 * Created by Mabrouk on 3/18/2018.
 */

public interface BasePresenter<v extends BaseView> {
    void attachView(v view);
    void showSnakeBar(View view, String msg);
}
