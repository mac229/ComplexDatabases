package com.example.maciej.complexdatabases.object.box.model;


import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Generated;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.apihint.Internal;

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

    @Generated(251670762)
    @Internal
    /** This constructor was generated by ObjectBox and may change any time. */
    public Date(long id, int year, int month, int day) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Generated(753683215)
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