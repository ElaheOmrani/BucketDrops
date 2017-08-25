package com.example.elahe.bucketdrops;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Elahe on 8/14/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}