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

public class Promoter extends BaseObservable implements Parcelable {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String des;

    @Bindable
    public String getId() {
        return id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getDes() {
        return des;
    }


    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setDes(String des) {
        this.des = des;
        notifyPropertyChanged(BR.des);
    }

    @Override
    public String toString() {
        return "Promoter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.des);
    }

    public Promoter() {
    }

    protected Promoter(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.des = in.readString();
    }

    public static final Parcelable.Creator<Promoter> CREATOR = new Parcelable.Creator<Promoter>() {
        @Override
        public Promoter createFromParcel(Parcel source) {
            return new Promoter(source);
        }

        @Override
        public Promoter[] newArray(int size) {
            return new Promoter[size];
        }
    };
}
