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

public class Country extends BaseObservable implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("countryCode")
    private String countryCode;

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getCountryCode() {
        return countryCode;
    }


    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        notifyPropertyChanged(BR.countryCode);
    }

    @Override
    public String
    toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.countryCode);
    }

    public Country() {
    }

    protected Country(Parcel in) {
        this.name = in.readString();
        this.countryCode = in.readString();
    }

    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel source) {
            return new Country(source);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}
