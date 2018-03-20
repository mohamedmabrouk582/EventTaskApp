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

public class PriceRange extends BaseObservable implements Parcelable {
    @SerializedName("type")
    private String type;
    @SerializedName("currency")
    private String currency;
    @SerializedName("min")
    private float min;
    @SerializedName("max")
    private float max;

    @Bindable
    public String getType() {
        return type;
    }

    @Bindable
    public String getCurrency() {
        return currency;
    }

    @Bindable
    public float getMin() {
        return min;
    }

    @Bindable
    public float getMax() {
        return max;
    }

    public void setType(String type) {
        this.type = type;
        notifyPropertyChanged(BR.type);
    }

    public void setCurrency(String currency) {
        this.currency = currency;
        notifyPropertyChanged(BR.currency);
    }

    public void setMin(float min) {
        this.min = min;
        notifyPropertyChanged(BR.min);
    }

    public void setMax(float max) {
        this.max = max;
        notifyPropertyChanged(BR.max);
    }

    @Override
    public String toString() {
        return "PriceRange{" +
                "type='" + type + '\'' +
                ", currency='" + currency + '\'' +
                ", min=" + min +
                ", max=" + max +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.currency);
        dest.writeFloat(this.min);
        dest.writeFloat(this.max);
    }

    public PriceRange() {
    }

    protected PriceRange(Parcel in) {
        this.type = in.readString();
        this.currency = in.readString();
        this.min = in.readFloat();
        this.max = in.readFloat();
    }

    public static final Parcelable.Creator<PriceRange> CREATOR = new Parcelable.Creator<PriceRange>() {
        @Override
        public PriceRange createFromParcel(Parcel source) {
            return new PriceRange(source);
        }

        @Override
        public PriceRange[] newArray(int size) {
            return new PriceRange[size];
        }
    };
}
