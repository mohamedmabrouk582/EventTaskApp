package com.example.mabrouk.eventtaskapp.models;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.mabrouk.eventtaskapp.BR;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Mabrouk on 3/18/2018.
 */

public class Embedded extends BaseObservable implements Parcelable {
    @SerializedName("venues")
    private ArrayList<Venue> venues;
    @SerializedName("attractions")
    private ArrayList<Attracion> attracions;

    @Bindable
    public ArrayList<Venue> getVenues() {
        return venues;
    }

    @Bindable
    public ArrayList<Attracion> getAttracions() {
        return attracions;
    }



    public void setVenues(ArrayList<Venue> venues) {
        this.venues = venues;
        notifyPropertyChanged(BR.venues);
    }

    public void setAttracions(ArrayList<Attracion> attracions) {
        this.attracions = attracions;
        notifyPropertyChanged(BR.attracions);
    }

    @Override
    public String toString() {
        return "Embedded{" +
                "venues=" + venues +
                ", attracions=" + attracions +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.venues);
        dest.writeTypedList(this.attracions);
    }

    public Embedded() {
    }

    protected Embedded(Parcel in) {
        this.venues = new ArrayList<Venue>();
        in.readList(this.venues, Venue.class.getClassLoader());
        this.attracions = in.createTypedArrayList(Attracion.CREATOR);
    }

    public static final Parcelable.Creator<Embedded> CREATOR = new Parcelable.Creator<Embedded>() {
        @Override
        public Embedded createFromParcel(Parcel source) {
            return new Embedded(source);
        }

        @Override
        public Embedded[] newArray(int size) {
            return new Embedded[size];
        }
    };
}
