package com.example.elahe.bucketdrops.beans;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Elahe on 8/14/2017.
 */

public class Drop extends RealmObject {
    private String what;
    @PrimaryKey
    private long added;
    private long when;
    private int completed;

    public Drop() {
    }
    public Drop(String what, long added, long when, int completed) {
        this.what = what;
        this.added = added;
        this.when = when;
        this.completed = completed;
    }
    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public long getAdded() {
        return added;
    }

    public void setAdded(long added) {
        this.added = added;
    }

    public long getWhen() {
        return when;
    }

    public void setWhen(long when) {
        this.when = when;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }
}
