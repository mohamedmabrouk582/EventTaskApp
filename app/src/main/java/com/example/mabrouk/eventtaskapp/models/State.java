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

public class State extends BaseObservable implements Parcelable {
    @SerializedName("name")
    private String name;

    @SerializedName("stateCode")
    private String stateCode;

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getStateCode() {
        return stateCode;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
        notifyPropertyChanged(BR.stateCode);
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.stateCode);
    }

    public State() {
    }

    protected State(Parcel in) {
        this.name = in.readString();
        this.stateCode = in.readString();
    }

    public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator<State>() {
        @Override
        public State createFromParcel(Parcel source) {
            return new State(source);
        }

        @Override
        public State[] newArray(int size) {
            return new State[size];
        }
    };
}
