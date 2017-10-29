package com.example.maciej.complexdatabases.object.box.model;


import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.relation.ToOne;

/**
 * Created by Maciej on 2017-05-12.
 */
@Entity
public class Playback {

    @Id
    private long id;

    @Index
    private long songId;

    private ToOne<Song> song;

    @Index
    private long dateId;
    private ToOne<Date> date;

    @Index
    private long timeId;
    private ToOne<Time> time;

    @Index
    private long artistId;
    private ToOne<Artist> artist;

    @Index
    private long userId;
    private ToOne<User> user;

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

    public ToOne<Song> getSong() {
        return song;
    }

    public ToOne<Date> getDate() {
        return date;
    }

    public ToOne<Time> getTime() {
        return time;
    }

    public ToOne<Artist> getArtist() {
        return artist;
    }

    public ToOne<User> getUser() {
        return user;
    }
}
