package com.example.mabrouk.eventtaskapp.models;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.mabrouk.eventtaskapp.BR;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Mabrouk on 3/18/2018.
 */

public class EventEmbedded extends BaseObservable implements Parcelable {
    @SerializedName("_embedded")
    private Events events;

    @Bindable
    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
        notifyPropertyChanged(BR.events);
    }

    @Override
    public String toString() {
        return "EventEmbedded{" +
                "events=" + events +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.events, flags);
    }

    public EventEmbedded() {
    }

    protected EventEmbedded(Parcel in) {
        this.events = in.readParcelable(Events.class.getClassLoader());
    }

    public static final Parcelable.Creator<EventEmbedded> CREATOR = new Parcelable.Creator<EventEmbedded>() {
        @Override
        public EventEmbedded createFromParcel(Parcel source) {
            return new EventEmbedded(source);
        }

        @Override
        public EventEmbedded[] newArray(int size) {
            return new EventEmbedded[size];
        }
    };
}
