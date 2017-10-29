package com.example.maciej.complexdatabases.greendao.results;

import android.text.TextUtils;
import android.util.Log;

import com.example.maciej.complexdatabases.greendao.model.Artist;
import com.example.maciej.complexdatabases.greendao.model.ArtistDao;
import com.example.maciej.complexdatabases.greendao.model.DaoSession;
import com.example.maciej.complexdatabases.greendao.model.Date;
import com.example.maciej.complexdatabases.greendao.model.DateDao;
import com.example.maciej.complexdatabases.greendao.model.Playback;
import com.example.maciej.complexdatabases.greendao.model.PlaybackDao;
import com.example.maciej.complexdatabases.greendao.model.Song;
import com.example.maciej.complexdatabases.greendao.model.SongDao;
import com.example.maciej.complexdatabases.greendao.model.Time;
import com.example.maciej.complexdatabases.greendao.model.TimeDao;
import com.example.maciej.complexdatabases.greendao.model.User;
import com.example.maciej.complexdatabases.greendao.model.UserDao;

import org.greenrobot.greendao.query.Join;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej on 2017-05-20.
 */

public class Answers implements IAnswers {

    private final DaoSession daoSession;

    public Answers(DaoSession daoSession) {
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
        this.daoSession = daoSession;
    }

    @Override
    public void rankingMostPopularSongs() {
        List<Result> result = new ArrayList<>();

        List<Song> songs = daoSession.getSongDao()
                .queryRaw("JOIN PLAYBACK ON PLAYBACK.SONG_ID = T.\"_id\" GROUP BY SONG_ID ORDER BY COUNT(PLAYBACK.\"_id\") DESC LIMIT 5");
        for (Song song : songs) {
            long count = daoSession.getPlaybackDao().queryBuilder().where(PlaybackDao.Properties.SongId.eq(song.getId())).count();
            result.add(new Result(song.getTitle(), (int) count));
        }

    }

    @Override
    public void userWhichListen() {
        QueryBuilder<User> userQueryBuilder = daoSession.getUserDao().queryBuilder();
        Join join = userQueryBuilder.join(UserDao.Properties.Id, Playback.class, PlaybackDao.Properties.UserId);
        userQueryBuilder.join(join, PlaybackDao.Properties.ArtistId, Artist.class, ArtistDao.Properties.Id).where(ArtistDao.Properties.Name.eq("3 Doors Down"));
        List<User> list = userQueryBuilder.list();
        Log.d("###", "userWhichListen: " + list.size());
    }

    @Override
    public void songsListen() {
        QueryBuilder<Song> songQueryBuilder = daoSession.getSongDao().queryBuilder();
        Join join = songQueryBuilder.join(SongDao.Properties.Id, Playback.class, PlaybackDao.Properties.SongId);
        songQueryBuilder.join(join, PlaybackDao.Properties.DateId, Date.class, DateDao.Properties.Id).where(DateDao.Properties.Year.ge(2005));
        List<Song> list = songQueryBuilder.list();
        Log.d("###", "songsListen: " + list.size());
    }

    @Override
    public void months() {
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            QueryBuilder<Playback> playbackQueryBuilder = daoSession.getPlaybackDao().queryBuilder();
            playbackQueryBuilder.join(PlaybackDao.Properties.DateId, Date.class, DateDao.Properties.Id).where(DateDao.Properties.Month.eq(i));
            List<Playback> list = playbackQueryBuilder.list();
            sizes.add(list.size());
        }
        Log.d("###", "months: " + TextUtils.join(", ", sizes));
    }

    @Override
    public void count() {
        QueryBuilder<Playback> playbackQueryBuilder = daoSession.getPlaybackDao().queryBuilder();
        playbackQueryBuilder.join(PlaybackDao.Properties.TimeId, Time.class, TimeDao.Properties.Id).where(TimeDao.Properties.Hour.between(8, 16));
        long count = playbackQueryBuilder.count();
        Log.d("###", "count: " + count);
    }

    private static class Result {

        private String title;
        private int count;

        public Result(String title, int count) {
            this.title = title;
            this.count = count;
        }
    }
}
