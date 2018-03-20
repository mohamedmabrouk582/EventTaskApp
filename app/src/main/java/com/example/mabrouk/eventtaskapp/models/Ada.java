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


public class Ada extends BaseObservable implements Parcelable {
    private String adaPhone;
    private String adaCustomCopy;
    private String adaHours;



    @Bindable
    public String getAdaPhone() {
        return adaPhone;
    }

    @Bindable
    public String getAdaCustomCopy() {
        return adaCustomCopy;
    }

    @Bindable
    public String getAdaHours() {
        return adaHours;
    }


    public void setAdaPhone(String adaPhone) {
        this.adaPhone = adaPhone;
        notifyPropertyChanged(BR.adaPhone);
    }

    public void setAdaCustomCopy(String adaCustomCopy) {
        this.adaCustomCopy = adaCustomCopy;
        notifyPropertyChanged(BR.adaCustomCopy);
    }

    public void setAdaHours(String adaHours) {
        this.adaHours = adaHours;
        notifyPropertyChanged(BR.adaHours);
    }

    @Override
    public String toString() {
        return "Ada{" +
                "adaPhone='" + adaPhone + '\'' +
                ", adaCustomCopy='" + adaCustomCopy + '\'' +
                ", adaHours='" + adaHours + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.adaPhone);
        dest.writeString(this.adaCustomCopy);
        dest.writeString(this.adaHours);
    }

    public Ada() {
    }

    protected Ada(Parcel in) {
        this.adaPhone = in.readString();
        this.adaCustomCopy = in.readString();
        this.adaHours = in.readString();
    }

    public static final Parcelable.Creator<Ada> CREATOR = new Parcelable.Creator<Ada>() {
        @Override
        public Ada createFromParcel(Parcel source) {
            return new Ada(source);
        }

        @Override
        public Ada[] newArray(int size) {
            return new Ada[size];
        }
    };
}
