package com.example.maciej.complexdatabases.sqlite.model;

/**
 * Created by Maciej on 2017-05-12.
 */

public class Song {

    private long id;
    private String title;

    public Song(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
