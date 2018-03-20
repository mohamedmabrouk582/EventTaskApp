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

public class image extends BaseObservable implements Parcelable {
    @SerializedName("url")
    private String imageUrl;

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.url);
    }

    @Override
    public String toString() {
        return "image{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageUrl);
    }

    public image() {
    }

    protected image(Parcel in) {
        this.imageUrl = in.readString();
    }

    public static final Parcelable.Creator<image> CREATOR = new Parcelable.Creator<image>() {
        @Override
        public image createFromParcel(Parcel source) {
            return new image(source);
        }

        @Override
        public image[] newArray(int size) {
            return new image[size];
        }
    };
}
