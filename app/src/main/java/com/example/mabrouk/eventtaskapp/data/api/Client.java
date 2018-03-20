package com.example.mabrouk.eventtaskapp.data.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mabrouk on 3/18/2018.
 */

public class Client {
    private static final String baseUrl="https://app.ticketmaster.com/discovery/v2/";
    private static Retrofit mRetrofit;

    public static Retrofit getmRetrofit(){
        if (mRetrofit==null){
            synchronized (Client.class){
                mRetrofit=new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
            }
        }
        return mRetrofit;
    }

}
