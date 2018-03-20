package com.example.mabrouk.eventtaskapp.models;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Mohammad mabrouk
 * 0201152644726
 * on 3/20/2018.  time :01:59
 */

public class FavEvents extends RealmObject{
    @PrimaryKey
    private String id;
    private String data;

    public FavEvents(){}

    public FavEvents(String id, String data) {
        this.id = id;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FavEvents{" +
                "id='" + id + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
