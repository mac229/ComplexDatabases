package com.example.maciej.complexdatabases.greendao.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Maciej on 2017-05-12.
 */

@Entity
public class Song {

    @Id
    private long id;
    private String oldId;
    private String title;

    @Generated(hash = 229314160)
    public Song(long id, String oldId, String title) {
        this.id = id;
        this.oldId = oldId;
        this.title = title;
    }

    @Generated(hash = 87031450)
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
