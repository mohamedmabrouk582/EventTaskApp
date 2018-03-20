package com.example.mabrouk.eventtaskapp.models;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.mabrouk.eventtaskapp.BR;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import io.realm.annotations.PrimaryKey;

/**
 * Created by Mabrouk on 3/18/2018.
 */

public class Event extends BaseObservable implements Parcelable {
    @SerializedName("name")
    private String name;
    @PrimaryKey
    @SerializedName("id")
    private String id;
    @SerializedName("url")
    private String url;
    @SerializedName("dates")
    private DateResponse dateResponse;
    @SerializedName("images")
    private ArrayList<image> imgs;
    @SerializedName("classifications")
    private ArrayList<Classfication> classfications;
    @SerializedName("promoters")
    private ArrayList<Promoter> promoters;
    @SerializedName("priceRanges")
    private ArrayList<PriceRange> priceRanges;
    @SerializedName("_embedded")
    private Embedded embedded;
    @SerializedName("sales")
    private Sales sales;

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getId() {
        return id;
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    @Bindable
    public DateResponse getDateResponse() {
        return dateResponse;
    }

    @Bindable
    public ArrayList<image> getImgs() {
        return imgs;
    }

    @Bindable
    public ArrayList<Classfication> getClassfications() {
        return classfications;
    }

    @Bindable
    public ArrayList<Promoter> getPromoters() {
        return promoters;
    }

    @Bindable
    public ArrayList<PriceRange> getPriceRanges() {
        return priceRanges;
    }

    @Bindable
    public Embedded getEmbedded() {
        return embedded;
    }

    @Bindable
    public Sales getSales() {
        return sales;
    }


    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    public void setDateResponse(DateResponse dateResponse) {
        this.dateResponse = dateResponse;
        notifyPropertyChanged(BR.dateResponse);
    }

    public void setImgs(ArrayList<image> imgs) {
        this.imgs = imgs;
        notifyPropertyChanged(BR.imgs);
    }

    public void setClassfications(ArrayList<Classfication> classfications) {
        this.classfications = classfications;
        notifyPropertyChanged(BR.classfications);
    }

    public void setPromoters(ArrayList<Promoter> promoters) {
        this.promoters = promoters;
        notifyPropertyChanged(BR.promoters);
    }

    public void setPriceRanges(ArrayList<PriceRange> priceRanges) {
        this.priceRanges = priceRanges;
        notifyPropertyChanged(BR.priceRanges);
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
        notifyPropertyChanged(BR.embedded);
    }

    public void setSales(Sales sales) {
        this.sales = sales;
        notifyPropertyChanged(BR.sales);
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", dateResponse=" + dateResponse +
                ", imgs=" + imgs +
                ", classfications=" + classfications +
                ", promoters=" + promoters +
                ", priceRanges=" + priceRanges +
                ", embedded=" + embedded +
                ", sales=" + sales +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.id);
        dest.writeString(this.url);
        dest.writeParcelable(this.dateResponse, flags);
        dest.writeList(this.imgs);
        dest.writeTypedList(this.classfications);
        dest.writeList(this.promoters);
        dest.writeList(this.priceRanges);
        dest.writeParcelable(this.embedded, flags);
        dest.writeParcelable(this.sales, flags);
    }

    public Event() {
    }

    protected Event(Parcel in) {
        this.name = in.readString();
        this.id = in.readString();
        this.url = in.readString();
        this.dateResponse = in.readParcelable(DateResponse.class.getClassLoader());
        this.imgs = new ArrayList<image>();
        in.readList(this.imgs, image.class.getClassLoader());
        this.classfications = in.createTypedArrayList(Classfication.CREATOR);
        this.promoters = new ArrayList<Promoter>();
        in.readList(this.promoters, Promoter.class.getClassLoader());
        this.priceRanges = new ArrayList<PriceRange>();
        in.readList(this.priceRanges, PriceRange.class.getClassLoader());
        this.embedded = in.readParcelable(Embedded.class.getClassLoader());
        this.sales = in.readParcelable(Sales.class.getClassLoader());
    }

    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
}
