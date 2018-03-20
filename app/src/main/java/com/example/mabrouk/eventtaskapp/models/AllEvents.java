package com.example.mabrouk.eventtaskapp.models;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Mohammad mabrouk
 * 0201152644726
 * on 3/20/2018.  time :01:57
 */

public class AllEvents extends RealmObject{
    private String data;

    public AllEvents(){}

    public AllEvents(String data) {

        this.data = data;
    }


    public String getData() {
        return data;
    }


    public void setData(String data) {
        this.data = data;
    }
}
