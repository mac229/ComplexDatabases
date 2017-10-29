package com.example.maciej.complexdatabases.greendao;

import com.example.maciej.complexdatabases.greendao.model.Artist;
import com.example.maciej.complexdatabases.greendao.model.Date;
import com.example.maciej.complexdatabases.greendao.model.Playback;
import com.example.maciej.complexdatabases.greendao.model.Song;
import com.example.maciej.complexdatabases.greendao.model.Time;
import com.example.maciej.complexdatabases.greendao.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej on 2017-05-15.
 */

public class Data {

    private List<Song> songs = new ArrayList<>();
    private List<Artist> artists = new ArrayList<>();
    private List<Playback> playbacks = new ArrayList<>();
    private  List<Date> dates = new ArrayList<>();
    private List<Time> times = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Playback> getPlaybacks() {
        return playbacks;
    }

    public void setPlaybacks(List<Playback> playbacks) {
        this.playbacks = playbacks;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
