package com.example.mabrouk.eventtaskapp.presenter.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.example.mabrouk.eventtaskapp.presenter.base.BasePresenter;
import com.example.mabrouk.eventtaskapp.view.BaseView;


/**
 * Created by Mabrouk on 3/18/2018.
 */

public class BaseViewPresenter<v extends BaseView> extends AndroidViewModel implements BasePresenter<v> {
    private v view;

    public BaseViewPresenter(@NonNull Application application) {
        super(application);
    }


    @Override
    public void attachView(v view) {
        this.view=view;
    }

    @Override
    public void showSnakeBar(View view, String msg) {
        Snackbar snackbar = Snackbar
                .make(view, msg, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public v getView(){
        return this.view;
    }
}
