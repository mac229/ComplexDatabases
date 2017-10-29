package com.example.maciej.complexdatabases.greendao.model;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by Maciej on 2017-05-12.
 */
@Entity
public class Playback {

    @Id
    private long id;

    @Index
    private long songId;

    @ToOne(joinProperty = "songId")
    private Song song;

    @Index
    private long dateId;

    @ToOne(joinProperty = "dateId")
    private Date date;

    @Index
    private long timeId;

    @ToOne(joinProperty = "timeId")
    private Time time;

    @Index
    private long artistId;

    @ToOne(joinProperty = "artistId")
    private Artist artist;

    @Index
    private long userId;

    @ToOne(joinProperty = "userId")
    private User user;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1625294778)
    private transient PlaybackDao myDao;

    @Generated(hash = 119665583)
    private transient Long song__resolvedKey;

    @Generated(hash = 491602140)
    private transient Long date__resolvedKey;

    @Generated(hash = 1997689751)
    private transient Long time__resolvedKey;

    @Generated(hash = 110881223)
    private transient Long artist__resolvedKey;

    @Generated(hash = 251390918)
    private transient Long user__resolvedKey;

    @Generated(hash = 335095025)
    public Playback(long id, long songId, long dateId, long timeId, long artistId,
            long userId) {
        this.id = id;
        this.songId = songId;
        this.dateId = dateId;
        this.timeId = timeId;
        this.artistId = artistId;
        this.userId = userId;
    }
    @Generated(hash = 95508297)
    public Playback() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getSongId() {
        return this.songId;
    }
    public void setSongId(long songId) {
        this.songId = songId;
    }
    public long getDateId() {
        return this.dateId;
    }
    public void setDateId(long dateId) {
        this.dateId = dateId;
    }
    public long getTimeId() {
        return this.timeId;
    }
    public void setTimeId(long timeId) {
        this.timeId = timeId;
    }
    public long getArtistId() {
        return this.artistId;
    }
    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1350890817)
    public Song getSong() {
        long __key = this.songId;
        if (song__resolvedKey == null || !song__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SongDao targetDao = daoSession.getSongDao();
            Song songNew = targetDao.load(__key);
            synchronized (this) {
                song = songNew;
                song__resolvedKey = __key;
            }
        }
        return song;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1807618614)
    public void setSong(@NotNull Song song) {
        if (song == null) {
            throw new DaoException(
                    "To-one property 'songId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.song = song;
            songId = song.getId();
            song__resolvedKey = songId;
        }
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 961139428)
    public Date getDate() {
        long __key = this.dateId;
        if (date__resolvedKey == null || !date__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DateDao targetDao = daoSession.getDateDao();
            Date dateNew = targetDao.load(__key);
            synchronized (this) {
                date = dateNew;
                date__resolvedKey = __key;
            }
        }
        return date;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1962958050)
    public void setDate(@NotNull Date date) {
        if (date == null) {
            throw new DaoException(
                    "To-one property 'dateId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.date = date;
            dateId = date.getId();
            date__resolvedKey = dateId;
        }
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 466473103)
    public Time getTime() {
        long __key = this.timeId;
        if (time__resolvedKey == null || !time__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TimeDao targetDao = daoSession.getTimeDao();
            Time timeNew = targetDao.load(__key);
            synchronized (this) {
                time = timeNew;
                time__resolvedKey = __key;
            }
        }
        return time;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 298503609)
    public void setTime(@NotNull Time time) {
        if (time == null) {
            throw new DaoException(
                    "To-one property 'timeId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.time = time;
            timeId = time.getId();
            time__resolvedKey = timeId;
        }
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1152039020)
    public Artist getArtist() {
        long __key = this.artistId;
        if (artist__resolvedKey == null || !artist__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ArtistDao targetDao = daoSession.getArtistDao();
            Artist artistNew = targetDao.load(__key);
            synchronized (this) {
                artist = artistNew;
                artist__resolvedKey = __key;
            }
        }
        return artist;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1701126613)
    public void setArtist(@NotNull Artist artist) {
        if (artist == null) {
            throw new DaoException(
                    "To-one property 'artistId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.artist = artist;
            artistId = artist.getId();
            artist__resolvedKey = artistId;
        }
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 115391908)
    public User getUser() {
        long __key = this.userId;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
                user__resolvedKey = __key;
            }
        }
        return user;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 462495677)
    public void setUser(@NotNull User user) {
        if (user == null) {
            throw new DaoException(
                    "To-one property 'userId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.user = user;
            userId = user.getId();
            user__resolvedKey = userId;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 371248150)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPlaybackDao() : null;
    }


}
