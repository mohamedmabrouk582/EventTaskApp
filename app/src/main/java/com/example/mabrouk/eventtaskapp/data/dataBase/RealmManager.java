package com.example.mabrouk.eventtaskapp.data.dataBase;

import io.realm.Realm;

/**
 * Created by Mohammad mabrouk
 * 0201152644726
 * on 3/20/2018.  time :18:25
 */

public class RealmManager {
    private static Realm mRealm;
    public static Realm open() {
        if (mRealm==null) {
            mRealm = Realm.getDefaultInstance();
        }
        return mRealm;
    }

    public static void close() {
        if (mRealm != null) {
            mRealm.close();
        }
    }
    public static RealmDao createUserDao() {
        checkForOpenRealm();
        return new RealmDao(mRealm);
    }

    private static void checkForOpenRealm() {
        if (mRealm == null || mRealm.isClosed()) {
            throw new IllegalStateException("RealmManager: Realm is closed, call open() method first");
        }
    }
}
