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

public class Sales extends BaseObservable implements Parcelable {
    @SerializedName("public")
    private Sale sale;
    @SerializedName("presales")
    private ArrayList<Sale> sales;

    @Bindable
    public Sale getSale() {
        return sale;
    }

    @Bindable
    public ArrayList<Sale> getSales() {
        return sales;
    }


    public void setSale(Sale sale) {
        this.sale = sale;
        notifyPropertyChanged(BR.sale);
    }

    public void setSales(ArrayList<Sale> sales) {
        this.sales = sales;
        notifyPropertyChanged(BR.sales);
    }

    @Override
    public String toString() {
        return "Sales{" +
                "sale=" + sale +
                ", sales=" + sales +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.sale, flags);
        dest.writeTypedList(this.sales);
    }

    public Sales() {
    }

    protected Sales(Parcel in) {
        this.sale = in.readParcelable(Sale.class.getClassLoader());
        this.sales = in.createTypedArrayList(Sale.CREATOR);
    }

    public static final Parcelable.Creator<Sales> CREATOR = new Parcelable.Creator<Sales>() {
        @Override
        public Sales createFromParcel(Parcel source) {
            return new Sales(source);
        }

        @Override
        public Sales[] newArray(int size) {
            return new Sales[size];
        }
    };
}
