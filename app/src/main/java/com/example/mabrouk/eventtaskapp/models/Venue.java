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

public class Venue extends BaseObservable implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("city")
    private City city;
    @SerializedName("timezone")
    private String timeZone;
    @SerializedName("country")
    private Country country;
    @SerializedName("state")
    private State state;
    @SerializedName("url")
    private String url;
    @SerializedName("address")
    private Address address;
    @SerializedName("location")
    private LocationM locationM;
    @SerializedName("parkingDetail")
    private String parkingDetails;

    @SerializedName("boxOfficeInfo")
    private BoxOfficeInfo boxOfficeInfo;
    @SerializedName("generalInfo")
    private GeneraInfo generaInfo;

    @SerializedName("images")
    private ArrayList<image> imgs;
    private Ada ada;

    @Bindable
    public ArrayList<image> getImages() {
        return imgs;
    }

    public void setImages(ArrayList<image> images) {
        this.imgs = images;
        notifyPropertyChanged(BR.imgs);
    }

    @Bindable
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
        notifyPropertyChanged(BR.timeZone);
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public City getCity() {
        return city;
    }

    @Bindable
    public Country getCountry() {
        return country;
    }

    @Bindable
    public State getState() {
        return state;
    }

    @Bindable
    public Address getAddress() {
        return address;
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    @Bindable
    public LocationM getLocationM() {
        return locationM;
    }

    @Bindable
    public String getParkingDetails() {
        return parkingDetails;
    }


    @Bindable
    public BoxOfficeInfo getBoxOfficeInfo() {
        return boxOfficeInfo;
    }

    @Bindable
    public GeneraInfo getGeneraInfo() {
        return generaInfo;
    }

    @Bindable
    public Ada getAda() {
        return ada;
    }

    @Bindable
    public String getFullAdress(){
        return getAddress().getLine1()+"/"+getCity().getName()+"/"+getState().getName()+"/"+getCountry().getName();
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setCity(City city) {
        this.city = city;
        notifyPropertyChanged(BR.city);
    }

    public void setCountry(Country country) {
        this.country = country;
        notifyPropertyChanged(BR.country);
    }

    public void setState(State state) {
        this.state = state;
        notifyPropertyChanged(BR.state);
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    public void setAddress(Address address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }

    public void setLocationM(LocationM locationM) {
        this.locationM = locationM;
        notifyPropertyChanged(BR.locationM);
    }

    public void setParkingDetails(String parkingDetails) {
        this.parkingDetails = parkingDetails;
        notifyPropertyChanged(BR.parkingDetails);
    }

    public void setBoxOfficeInfo(BoxOfficeInfo boxOfficeInfo) {
        this.boxOfficeInfo = boxOfficeInfo;
        notifyPropertyChanged(BR.boxOfficeInfo);
    }

    public void setGeneraInfo(GeneraInfo generaInfo) {
        this.generaInfo = generaInfo;
        notifyPropertyChanged(BR.generalInfo);
    }

    public void setAda(Ada ada) {
        this.ada = ada;
        notifyPropertyChanged(BR.ada);
    }

    @Override
    public String toString() {
        return "Venue{" +
                "name='" + name + '\'' +
                ", city=" + city +
                ", country=" + country +
                ", state=" + state +
                ", url='" + url + '\'' +
                ", address=" + address +
                ", locationM=" + locationM +
                ", parkingDetails='" + parkingDetails + '\'' +
                ", boxOfficeInfo=" + boxOfficeInfo +
                ", generaInfo=" + generaInfo +
                ", ada=" + ada +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeParcelable(this.city, flags);
        dest.writeString(this.timeZone);
        dest.writeParcelable(this.country, flags);
        dest.writeParcelable(this.state, flags);
        dest.writeString(this.url);
        dest.writeParcelable(this.address, flags);
        dest.writeParcelable(this.locationM, flags);
        dest.writeString(this.parkingDetails);
        dest.writeParcelable(this.boxOfficeInfo, flags);
        dest.writeParcelable(this.generaInfo, flags);
        dest.writeParcelable(this.ada, flags);
    }

    public Venue() {
    }

    protected Venue(Parcel in) {
        this.name = in.readString();
        this.city = in.readParcelable(City.class.getClassLoader());
        this.timeZone = in.readString();
        this.country = in.readParcelable(Country.class.getClassLoader());
        this.state = in.readParcelable(State.class.getClassLoader());
        this.url = in.readString();
        this.address = in.readParcelable(Address.class.getClassLoader());
        this.locationM = in.readParcelable(LocationM.class.getClassLoader());
        this.parkingDetails = in.readString();
        this.boxOfficeInfo = in.readParcelable(BoxOfficeInfo.class.getClassLoader());
        this.generaInfo = in.readParcelable(GeneraInfo.class.getClassLoader());
        this.ada = in.readParcelable(Ada.class.getClassLoader());
    }

    public static final Parcelable.Creator<Venue> CREATOR = new Parcelable.Creator<Venue>() {
        @Override
        public Venue createFromParcel(Parcel source) {
            return new Venue(source);
        }

        @Override
        public Venue[] newArray(int size) {
            return new Venue[size];
        }
    };
}
