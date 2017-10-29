package com.example.maciej.complexdatabases.greendao.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Maciej on 2017-05-12.
 */
@Entity
public class Artist {

    @Id
    private long id;
    private String name;

    @Generated(hash = 727981075)
    public Artist(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 19829037)
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
