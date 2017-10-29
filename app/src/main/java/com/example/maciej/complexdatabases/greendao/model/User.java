package com.example.maciej.complexdatabases.greendao.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Maciej on 2017-05-12.
 */

@Entity
public class User {

    @Id
    private long id;
    private String oldId;

    @Generated(hash = 1136648160)
    public User(long id, String oldId) {
        this.id = id;
        this.oldId = oldId;
    }

    @Generated(hash = 586692638)
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
