package com.example.mabrouk.eventtaskapp.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.mabrouk.eventtaskapp.BR;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Mabrouk on 3/18/2018.
 */

public class Events extends BaseObservable implements Parcelable {
    @SerializedName("events")
    private ArrayList<Event> events;

    @Bindable
    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
        notifyPropertyChanged(BR.events);
    }

    @Override
    public String toString() {
        return "Events{" +
                "events=" + events +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.events);
    }

    public Events() {
    }

    protected Events(Parcel in) {
        this.events = in.createTypedArrayList(Event.CREATOR);
    }

    public static final Parcelable.Creator<Events> CREATOR = new Parcelable.Creator<Events>() {
        @Override
        public Events createFromParcel(Parcel source) {
            return new Events(source);
        }

        @Override
        public Events[] newArray(int size) {
            return new Events[size];
        }
    };
}
