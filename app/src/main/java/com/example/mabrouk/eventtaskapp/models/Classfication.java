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


public class Classfication extends BaseObservable implements Parcelable {
    @SerializedName("segment")
    private Type segment;
    @SerializedName("genre")
    private Type genre;
    @SerializedName("subGenre")
    private Type subGenre;
    @SerializedName("family")
    private boolean family;

    @Bindable
    public Type getSegment() {
        return segment;
    }

    @Bindable
    public Type getGenre() {
        return genre;
    }

    @Bindable
    public Type getSubGenre() {
        return subGenre;
    }

    @Bindable
    public boolean isFamily() {
        return family;
    }

    public void setSegment(Type segment) {
        this.segment = segment;
        notifyPropertyChanged(BR.segment);
    }

    public void setGenre(Type genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    public void setSubGenre(Type subGenre) {
        this.subGenre = subGenre;
        notifyPropertyChanged(BR.subGenre);
    }

    public void setFamily(boolean family) {
        this.family = family;
        notifyPropertyChanged(BR.family);
    }

    @Override
    public String toString() {
        return "Classfication{" +
                "segment=" + segment +
                ", genre=" + genre +
                ", subGenre=" + subGenre +
                ", family=" + family +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.segment, flags);
        dest.writeParcelable(this.genre, flags);
        dest.writeParcelable(this.subGenre, flags);
        dest.writeByte(this.family ? (byte) 1 : (byte) 0);
    }

    public Classfication() {
    }

    protected Classfication(Parcel in) {
        this.segment = in.readParcelable(Type.class.getClassLoader());
        this.genre = in.readParcelable(Type.class.getClassLoader());
        this.subGenre = in.readParcelable(Type.class.getClassLoader());
        this.family = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Classfication> CREATOR = new Parcelable.Creator<Classfication>() {
        @Override
        public Classfication createFromParcel(Parcel source) {
            return new Classfication(source);
        }

        @Override
        public Classfication[] newArray(int size) {
            return new Classfication[size];
        }
    };
}
