package com.example.mabrouk.eventtaskapp.utils;


import com.example.mabrouk.eventtaskapp.models.Event;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by Mohammad mabrouk
 * 0201152644726
 * on 3/20/2018.  time :20:05
 */

public class RxBus {
    private static RxBus mRxBus;
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    private Subject<Event> favSubject;

    private Subject getFavSubject(){
        if (favSubject==null){
            favSubject= PublishSubject.create();
            favSubject.observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io());
        }
        return favSubject;
    }

    public void sendFav(Event event){
        getFavSubject().onNext(event);
    }

    public Disposable subscribeFav(Consumer<Event> consumer){
        Disposable subscribe = getFavSubject().subscribe(consumer);
        compositeDisposable.add(subscribe);
        return subscribe;
    }

    public void unSubscribe(Disposable disposable){
        compositeDisposable.remove(disposable);
    }

    public static RxBus getRxBus(){
        if (mRxBus==null){
            mRxBus=new RxBus();
        }
        return mRxBus;
    }
}
