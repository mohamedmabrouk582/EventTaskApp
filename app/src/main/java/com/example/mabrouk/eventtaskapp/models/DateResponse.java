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

public class DateResponse extends BaseObservable implements Parcelable {
    @SerializedName("start")
    private Start start;
    @SerializedName("timezone")
    private String timezone;

    @Bindable
    public String getTimezone() {
        return timezone;
    }

    @Bindable
    public Start getStart() {
        return start;
    }

    public void setStart(Start start) {
        this.start = start;
        notifyPropertyChanged(BR.start);
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
        notifyPropertyChanged(BR.timezone);
    }

    @Override
    public String toString() {
        return "DateResponse{" +
                "start=" + start +
                ", timezone='" + timezone + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.start, flags);
        dest.writeString(this.timezone);
    }

    public DateResponse() {
    }

    protected DateResponse(Parcel in) {
        this.start = in.readParcelable(Start.class.getClassLoader());
        this.timezone = in.readString();
    }

    public static final Parcelable.Creator<DateResponse> CREATOR = new Parcelable.Creator<DateResponse>() {
        @Override
        public DateResponse createFromParcel(Parcel source) {
            return new DateResponse(source);
        }

        @Override
        public DateResponse[] newArray(int size) {
            return new DateResponse[size];
        }
    };
}
