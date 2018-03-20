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

public class Start extends BaseObservable implements Parcelable {
    @SerializedName("localDate")
    private String localDate ;
    @SerializedName("localTime")
    private String localTime;
    @SerializedName("dateTime")
    private String dateTime;

    @Bindable
    public String getDateTime() {
        return dateTime;
    }

    @Bindable
    public String getLocalDate() {
        return localDate;
    }

    @Bindable
    public String getLocalTime() {
        return localTime;
    }


    public void setLocalDate(String localDate) {
        this.localDate = localDate;
        notifyPropertyChanged(BR.localDate);
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
        notifyPropertyChanged(BR.localTime);
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
        notifyPropertyChanged(BR.dateTime);
    }

    @Override
    public String toString() {
        return "Start{" +
                "localDate='" + localDate + '\'' +
                ", localTime='" + localTime + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.localDate);
        dest.writeString(this.localTime);
        dest.writeString(this.dateTime);
    }

    public Start() {
    }

    protected Start(Parcel in) {
        this.localDate = in.readString();
        this.localTime = in.readString();
        this.dateTime = in.readString();
    }

    public static final Parcelable.Creator<Start> CREATOR = new Parcelable.Creator<Start>() {
        @Override
        public Start createFromParcel(Parcel source) {
            return new Start(source);
        }

        @Override
        public Start[] newArray(int size) {
            return new Start[size];
        }
    };
}
