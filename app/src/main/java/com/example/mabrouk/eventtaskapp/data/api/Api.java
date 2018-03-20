package com.example.mabrouk.eventtaskapp.data.api;


import android.arch.lifecycle.LiveData;

import com.example.mabrouk.eventtaskapp.models.EventEmbedded;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mabrouk on 3/18/2018.
 */

public interface Api {
    @GET("events.json?countryCode=US")
    Observable<EventEmbedded> getEvents(@Query("apikey") String apiKey);

    @GET("events.json?")
    Observable<EventEmbedded> getSearchedEvent(@Query("segmentName") String segmentName,@Query("apikey") String KEY);
}
