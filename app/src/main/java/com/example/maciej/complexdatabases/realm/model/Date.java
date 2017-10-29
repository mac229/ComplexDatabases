package com.example.maciej.complexdatabases.realm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Maciej on 2017-05-12.
 */
public class Date extends RealmObject {

    @PrimaryKey
    private long id;
    private int year;
    private int month;
    private int day;

    public Date(long id, int year, int month, int day) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date() {
    }
}
