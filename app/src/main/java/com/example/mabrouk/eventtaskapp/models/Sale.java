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

public class Sale extends BaseObservable implements Parcelable {
    @SerializedName("startDateTime")
    private String startDateTime;
    @SerializedName("endDateTime")
    private String endDateTime;
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("description")
    private String des;


    @Bindable
    public String getDes() {
        return des;
    }

    @Bindable
    public String getStartDateTime() {
        return startDateTime;
    }

    @Bindable
    public String getEndDateTime() {
        return endDateTime;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
        notifyPropertyChanged(BR.startDateTime);
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
        notifyPropertyChanged(BR.endDateTime);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    public void setDes(String des) {
        this.des = des;
        notifyPropertyChanged(BR.des);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "startDateTime='" + startDateTime + '\'' +
                ", endDateTime='" + endDateTime + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", des='" + des + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.startDateTime);
        dest.writeString(this.endDateTime);
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeString(this.des);
    }

    public Sale() {
    }

    protected Sale(Parcel in) {
        this.startDateTime = in.readString();
        this.endDateTime = in.readString();
        this.name = in.readString();
        this.url = in.readString();
        this.des = in.readString();
    }

    public static final Parcelable.Creator<Sale> CREATOR = new Parcelable.Creator<Sale>() {
        @Override
        public Sale createFromParcel(Parcel source) {
            return new Sale(source);
        }

        @Override
        public Sale[] newArray(int size) {
            return new Sale[size];
        }
    };
}
