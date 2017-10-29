package com.example.maciej.complexdatabases.realm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Maciej on 2017-05-12.
 */
public class Song extends RealmObject {

    @PrimaryKey
    private long id;
    private String oldId;
    private String title;

    public Song(long id, String oldId, String title) {
        this.id = id;
        this.oldId = oldId;
        this.title = title;
    }

    public Song() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOldId() {
        return oldId;
    }

    public void setOldId(String oldId) {
        this.oldId = oldId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
