package com.example.maciej.complexdatabases.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.maciej.complexdatabases.Timings;
import com.example.maciej.complexdatabases.sqlite.results.Result;
import com.example.maciej.complexdatabases.sqlite.model.Artist;
import com.example.maciej.complexdatabases.sqlite.model.Date;
import com.example.maciej.complexdatabases.sqlite.model.Playback;
import com.example.maciej.complexdatabases.sqlite.model.Song;
import com.example.maciej.complexdatabases.sqlite.model.Time;
import com.example.maciej.complexdatabases.sqlite.model.User;

import java.io.IOException;

public class SqlProcessor {

    public static final String SEPARATOR = "<SEP>";

    private Timings timer = new Timings("###lite");
    private Result result;

    public SqlProcessor() {
        result = new Result("Loading data");
    }

    public Result execute(Context context, Database database) {
        try {
            executeInLoop(context, database);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void executeInLoop(Context context, Database database) throws IOException {
        Data data = new Loader().getData(context);

        for (int i = 0; i < 1; i++) {
            database.dropTables();
            database.createTables(database.getWritableDatabase());
            loadToNewSchema(data, database);
        }
    }

    private void setupIndexes(SQLiteDatabase db) {
        db.execSQL(Queries.indexOnSongIdFkCreateQuery);
        db.execSQL(Queries.indexOnArtistIdFkCreateQuery);
        db.execSQL(Queries.indexOnDateIdFkCreateQuery);
        db.execSQL(Queries.indexOnTimeIdFkCreateQuery);
        db.execSQL(Queries.indexOnUserIdFkCreateQuery);
    }

    private void loadToNewSchema(Data data, Database database) throws IOException {
        timer.start();
        SQLiteDatabase db = database.getWritableDatabase();
        db.beginTransaction();

        for (Artist artist : data.getArtists()) {
            insert(db, artist);
        }

        for (Song song : data.getSongs()) {
            insert(db, song);
        }

        for (Playback playback : data.getPlaybacks()) {
            insert(db, playback);
        }

        for (Date date : data.getDates()) {
            insert(db, date);
        }

        for (Time time : data.getTimes()) {
            insert(db, time);
        }

        for (User user : data.getUsers()) {
            insert(db, user);
        }

        setupIndexes(db);

        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
        result.addTime(timer.getTime());
        timer.logTime("Finished new schema in");
    }

    private void insert(SQLiteDatabase db, Artist artist) {
        ContentValues values = new ContentValues();
        values.put(Queries.ID, artist.getId());
        values.put(Queries.NAME, artist.getName());

        db.insert(Queries.TABLE_ARTISTS, null, values);
    }

    private void insert(SQLiteDatabase db, Date date) {
        ContentValues values = new ContentValues();
        values.put(Queries.ID, date.getId());
        values.put(Queries.DAY, date.getDay());
        values.put(Queries.MONTH, date.getMonth());
        values.put(Queries.YEAR, date.getYear());

        db.insert(Queries.TABLE_DATES, null, values);
    }

    private void insert(SQLiteDatabase db, Time time) {
        ContentValues values = new ContentValues();
        values.put(Queries.ID, time.getId());
        values.put(Queries.HOUR, time.getHour());
        values.put(Queries.MINUTE, time.getMinute());

        db.insert(Queries.TABLE_TIMES, null, values);
    }

    private void insert(SQLiteDatabase db, Song song) {
        ContentValues values = new ContentValues();
        values.put(Queries.ID, song.getId());
        values.put(Queries.TITLE, song.getTitle());

        db.insert(Queries.TABLE_SONGS, null, values);
    }

    private void insert(SQLiteDatabase db, Playback playback) {
        ContentValues values = new ContentValues();
        values.put(Queries.ID, playback.getId());
        values.put(Queries.SONG_ID, playback.getSongId());
        values.put(Queries.ARTIST_ID, playback.getArtistId());
        values.put(Queries.DATE_ID, playback.getDateId());
        values.put(Queries.TIME_ID, playback.getTimeId());
        values.put(Queries.USER_ID, playback.getUserId());

        db.insert(Queries.TABLE_PLAYBACKS, null, values);
    }

    private void insert(SQLiteDatabase db, User user) {
        ContentValues values = new ContentValues();
        values.put(Queries.ID, user.getId());
        values.put(Queries.NAME, user.getName());

        db.insert(Queries.TABLE_USERS, null, values);
    }
}
