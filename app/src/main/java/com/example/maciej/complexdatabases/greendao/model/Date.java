package com.example.maciej.complexdatabases.greendao.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Maciej on 2017-05-12.
 */
@Entity
public class Date {

    @Id
    private long id;
    private int year;
    private int month;
    private int day;

    @Generated(hash = 2051965069)
    public Date(long id, int year, int month, int day) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Generated(hash = 753683215)
    public Date() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
