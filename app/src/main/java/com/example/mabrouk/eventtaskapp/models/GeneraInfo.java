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

public class GeneraInfo extends BaseObservable implements Parcelable {
    @SerializedName("generalRule")
    private String generalInfo;
    @SerializedName("childRule")
    private String childInfo;

    @Bindable
    public String getGeneralInfo() {
        return generalInfo;
    }

    @Bindable
    public String getChildInfo() {
        return childInfo;
    }

    public void setGeneralInfo(String generalInfo) {
        this.generalInfo = generalInfo;
        notifyPropertyChanged(BR.generalInfo);
    }

    public void setChildInfo(String childInfo) {
        this.childInfo = childInfo;
        notifyPropertyChanged(BR.childInfo);
    }

    @Override
    public String toString() {
        return "GeneraInfo{" +
                "generalInfo='" + generalInfo + '\'' +
                ", childInfo='" + childInfo + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.generalInfo);
        dest.writeString(this.childInfo);
    }

    public GeneraInfo() {
    }

    protected GeneraInfo(Parcel in) {
        this.generalInfo = in.readString();
        this.childInfo = in.readString();
    }

    public static final Parcelable.Creator<GeneraInfo> CREATOR = new Parcelable.Creator<GeneraInfo>() {
        @Override
        public GeneraInfo createFromParcel(Parcel source) {
            return new GeneraInfo(source);
        }

        @Override
        public GeneraInfo[] newArray(int size) {
            return new GeneraInfo[size];
        }
    };
}
