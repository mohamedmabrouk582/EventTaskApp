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

public class Attracion extends BaseObservable implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("images")
    private ArrayList<image> imgs;

    @SerializedName("classfications")
    private ArrayList<Classfication> classfications;

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    @Bindable
    public ArrayList<image> getImgs() {
        return imgs;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    public void setImgs(ArrayList<image> imgs) {
        this.imgs = imgs;
        notifyPropertyChanged(BR.imgs);
    }

    public void setClassfications(ArrayList<Classfication> classfications) {
        this.classfications = classfications;
        notifyPropertyChanged(BR.classfications);
    }

    @Bindable
    public ArrayList<Classfication> getClassfications() {
        return classfications;
    }

    @Override
    public String toString() {
        return "Attracion{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", imgs=" + imgs +
                ", classfications=" + classfications +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeList(this.imgs);
        dest.writeList(this.classfications);
    }

    public Attracion() {
    }

    protected Attracion(Parcel in) {
        this.name = in.readString();
        this.url = in.readString();
        this.imgs = new ArrayList<image>();
        in.readList(this.imgs, image.class.getClassLoader());
        this.classfications = new ArrayList<Classfication>();
        in.readList(this.classfications, Classfication.class.getClassLoader());
    }

    public static final Parcelable.Creator<Attracion> CREATOR = new Parcelable.Creator<Attracion>() {
        @Override
        public Attracion createFromParcel(Parcel source) {
            return new Attracion(source);
        }

        @Override
        public Attracion[] newArray(int size) {
            return new Attracion[size];
        }
    };
}
