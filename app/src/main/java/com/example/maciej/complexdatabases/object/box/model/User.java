package com.example.maciej.complexdatabases.object.box.model;


import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Generated;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.apihint.Internal;

/**
 * Created by Maciej on 2017-05-12.
 */

@Entity
public class User {

    @Id
    private long id;
    private String oldId;

    @Generated(1765369866)
    @Internal
    /** This constructor was generated by ObjectBox and may change any time. */
    public User(long id, String oldId) {
        this.id = id;
        this.oldId = oldId;
    }

    @Generated(586692638)
    public User() {
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
}