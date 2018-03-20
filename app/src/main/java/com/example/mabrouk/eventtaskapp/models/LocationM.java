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

public class LocationM extends BaseObservable implements Parcelable {
    @SerializedName("lat")
    private double lat;
    @SerializedName("lang")
    private double lang;

    @Bindable
    public double getLat() {
        return lat;
    }

    @Bindable
    public double getLang() {
        return lang;
    }

    public void setLat(double lat) {
        this.lat = lat;
        notifyPropertyChanged(BR.lat);
    }

    public void setLang(double lang) {
        this.lang = lang;
        notifyPropertyChanged(BR.lang);
    }

    @Override
    public String toString() {
        return "LocationM{" +
                "lat=" + lat +
                ", lang=" + lang +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.lat);
        dest.writeDouble(this.lang);
    }

    public LocationM() {
    }

    protected LocationM(Parcel in) {
        this.lat = in.readDouble();
        this.lang = in.readDouble();
    }

    public static final Parcelable.Creator<LocationM> CREATOR = new Parcelable.Creator<LocationM>() {
        @Override
        public LocationM createFromParcel(Parcel source) {
            return new LocationM(source);
        }

        @Override
        public LocationM[] newArray(int size) {
            return new LocationM[size];
        }
    };
}
