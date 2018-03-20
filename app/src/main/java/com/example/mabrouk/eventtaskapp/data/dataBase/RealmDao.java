package com.example.mabrouk.eventtaskapp.data.dataBase;

import com.example.mabrouk.eventtaskapp.models.Ada;
import com.example.mabrouk.eventtaskapp.models.AllEvents;
import com.example.mabrouk.eventtaskapp.models.Event;
import com.example.mabrouk.eventtaskapp.models.FavEvents;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import retrofit2.http.PUT;

/**
 * Created by Mohammad mabrouk
 * 0201152644726
 * on 3/20/2018.  time :18:01
 */

public class RealmDao {
    private Realm mRealm;
    public RealmDao(Realm realm){
        this.mRealm=realm;
    }
    public void insertAllEvents(final AllEvents event){
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(event);
            }
        });
    }

    public boolean isFav(String id){
        return getFavEvent(id)==null?false:true;
    }

    public void insertFavEvent(final FavEvents favEvents){
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(favEvents);
            }
        });
    }

    public RealmObject getAllEvents(){
        return mRealm.where(AllEvents.class).findFirst();
    }

    public RealmResults<FavEvents> getFavEvents(){
        return mRealm.where(FavEvents.class).findAll();
    }

    public RealmObject getFavEvent(String id){
        return mRealm.where(FavEvents.class).equalTo("id",id).findFirst();
    }

    public void clearAllEvent(){
    mRealm.executeTransaction(new Realm.Transaction() {
        @Override
        public void execute(Realm realm) {
            realm.delete(AllEvents.class);
        }
    });
    }

    public void clearFavEvents(){
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(FavEvents.class);
            }
        });
    }

    public void deleteFavEvent(final  String id){
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                getFavEvent(id).deleteFromRealm();
            }
        });
    }
}
