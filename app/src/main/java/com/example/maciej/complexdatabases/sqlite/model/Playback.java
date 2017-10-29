package com.example.maciej.complexdatabases.sqlite.model;

/**
 * Created by Maciej on 2017-05-12.
 */

public class Playback {

    private long id;
    private long songId;
    private long dateId;
    private long timeId;
    private long artistId;
    private long userId;

    public Playback(long id, long songId, long dateId, long timeId, long artistId, long userId) {
        this.id = id;
        this.songId = songId;
        this.dateId = dateId;
        this.timeId = timeId;
        this.artistId = artistId;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSongId() {
        return songId;
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }

    public long getDateId() {
        return dateId;
    }

    public void setDateId(long dateId) {
        this.dateId = dateId;
    }

    public long getTimeId() {
        return timeId;
    }

    public void setTimeId(long timeId) {
        this.timeId = timeId;
    }

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
