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

public class BoxOfficeInfo extends BaseObservable implements Parcelable {

    @SerializedName("phoneNumberDetail")
    private String phoneNumberDetail;
    @SerializedName("openHoursDetail")
    private String openHours;
    @SerializedName("acceptedPaymentDetail")
    private String acceptedPayment;
    @SerializedName("willCallDetail")
    private String willCall;

    @Bindable
    public String getPhoneNumberDetail() {
        return phoneNumberDetail;
    }

    public void setPhoneNumberDetail(String phoneNumberDetail) {
        this.phoneNumberDetail = phoneNumberDetail;
        notifyPropertyChanged(BR.phoneNumberDetail);
    }

    @Bindable
    public String getOpenHours() {
        return openHours;
    }

    @Bindable
    public String getAcceptedPayment() {
        return acceptedPayment;
    }

    @Bindable
    public String getWillCall() {
        return willCall;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
        notifyPropertyChanged(BR.openHours);
    }

    public void setAcceptedPayment(String acceptedPayment) {
        this.acceptedPayment = acceptedPayment;
        notifyPropertyChanged(BR.acceptedPayment);
    }

    public void setWillCall(String willCall) {
        this.willCall = willCall;
        notifyPropertyChanged(BR.willCall);
    }

    @Override
    public String
    toString() {
        return "BoxOfficeInfo{" +
                "openHours='" + openHours + '\'' +
                ", acceptedPayment='" + acceptedPayment + '\'' +
                ", willCall='" + willCall + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.phoneNumberDetail);
        dest.writeString(this.openHours);
        dest.writeString(this.acceptedPayment);
        dest.writeString(this.willCall);
    }

    public BoxOfficeInfo() {
    }

    protected BoxOfficeInfo(Parcel in) {
        this.phoneNumberDetail = in.readString();
        this.openHours = in.readString();
        this.acceptedPayment = in.readString();
        this.willCall = in.readString();
    }

    public static final Parcelable.Creator<BoxOfficeInfo> CREATOR = new Parcelable.Creator<BoxOfficeInfo>() {
        @Override
        public BoxOfficeInfo createFromParcel(Parcel source) {
            return new BoxOfficeInfo(source);
        }

        @Override
        public BoxOfficeInfo[] newArray(int size) {
            return new BoxOfficeInfo[size];
        }
    };
}
