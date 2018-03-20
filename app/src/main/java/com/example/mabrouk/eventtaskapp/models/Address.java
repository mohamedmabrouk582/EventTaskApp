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

public class Address extends BaseObservable implements Parcelable {
    @SerializedName("line1")
    private String line1;

    public void setLine1(String line1) {
        this.line1 = line1;
        notifyPropertyChanged(BR.line1);
    }

    @Bindable
    public String getLine1() {
        return line1;
    }

    @Override
    public String toString() {
        return "Address{" +
                "line1='" + line1 + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.line1);
    }

    public Address() {
    }

    protected Address(Parcel in) {
        this.line1 = in.readString();
    }

    public static final Parcelable.Creator<Address> CREATOR = new Parcelable.Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel source) {
            return new Address(source);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };
}
