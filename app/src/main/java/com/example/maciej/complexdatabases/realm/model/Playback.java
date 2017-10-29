package com.example.maciej.complexdatabases.realm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Maciej on 2017-05-12.
 */
public class Playback extends RealmObject {

    @PrimaryKey
    private long id;

    private Song song;

    private Artist artist;

    private Date date;

    private Time time;

    private User user;

    public Playback() {
    }

    public Playback(long id, Song song, Artist artist, Date date, Time time, User user) {
        this.id = id;
        this.song = song;
        this.artist = artist;
        this.date = date;
        this.time = time;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
