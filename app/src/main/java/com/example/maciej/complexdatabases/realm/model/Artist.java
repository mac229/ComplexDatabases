package com.example.maciej.complexdatabases.realm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Maciej on 2017-05-12.
 */
public class Artist extends RealmObject{

    @PrimaryKey
    private long id;
    private String name;

    public Artist(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
