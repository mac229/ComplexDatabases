package com.example.maciej.complexdatabases.object.box.model;


import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Generated;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.apihint.Internal;

/**
 * Created by Maciej on 2017-05-12.
 */
@Entity
public class Artist {

    @Id
    private long id;
    private String name;

    @Generated(437445217)
    @Internal
    /** This constructor was generated by ObjectBox and may change any time. */
    public Artist(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(19829037)
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