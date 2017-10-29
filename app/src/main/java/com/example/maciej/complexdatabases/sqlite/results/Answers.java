package com.example.maciej.complexdatabases.sqlite.results;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;

import com.example.maciej.complexdatabases.sqlite.model.Song;
import com.example.maciej.complexdatabases.sqlite.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej on 2017-05-20.
 */

public class Answers implements IAnswers {



    public static final String USERS = "SELECT USERS.ID, USERS.NAME FROM USERS JOIN PLAYBACKS ON USERS.ID = PLAYBACKS.USER_ID JOIN ARTISTS ON PLAYBACKS.ARTIST_ID = ARTISTS.ID WHERE ARTISTS.NAME=\"3 Doors Down\"";

    public static final String SONGS = "SELECT SONGS.ID, SONGS.TITLE FROM SONGS JOIN PLAYBACKS ON SONGS.ID=PLAYBACKS.SONG_ID JOIN DATES ON PLAYBACKS.DATE_ID = DATES.ID WHERE DATES.YEAR>=2005";

    public static final String MONTHS = "SELECT PLAYBACKS.ID, PLAYBACKS.SONG_ID, PLAYBACKS.DATE_ID, PLAYBACKS.TIME_ID, PLAYBACKS.ARTIST_ID, PLAYBACKS.USER_ID, COUNT(DATES.MONTH) FROM PLAYBACKS JOIN DATES ON PLAYBACKS.DATE_ID = DATES.ID GROUP BY DATES.MONTH";

    public static final String COUNT = "SELECT COUNT(*) FROM PLAYBACKS JOIN TIMES ON PLAYBACKS.TIME_ID = TIMES.ID WHERE TIMES.HOUR BETWEEN 8 AND 16";

    private final SQLiteDatabase db;

    public Answers(SQLiteDatabase db) {
        this.db = db;
    }

    public static final String POPULAR = "SELECT TITLE, COUNT(PLAYBACKS.ID) AS PLAYBACKS_COUNT " +
            "FROM PLAYBACKS JOIN SONGS ON PLAYBACKS.SONG_ID = SONGS.ID " +
            "GROUP BY SONG_ID ORDER BY PLAYBACKS_COUNT DESC LIMIT 5";

    @Override
    public void rankingMostPopularSongs() {
        List<Result> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(POPULAR, null);
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            Result result = new Result(cursor.getString(0), cursor.getInt(1));
            list.add(result);
        }

        cursor.close();
    }

    @Override
    public void userWhichListen() {
        List<User> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(USERS, null);
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            User user = new User(cursor.getLong(0), cursor.getString(1));
            list.add(user);
        }

        cursor.close();
        Log.d("###", "userWhichListen: " + list.size());
    }

    @Override
    public void songsListen() {
        List<Song> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(SONGS, null);
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            Song song = new Song(cursor.getLong(0), cursor.getString(1));
            list.add(song);
        }

        cursor.close();
        Log.d("###", "songsListen: " + list.size());
    }

    @Override
    public void months() {
        List<Integer> sizes = new ArrayList<>();
        Cursor cursor = db.rawQuery(MONTHS, null);
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            Result result = new Result(cursor.getString(0), cursor.getInt(6));
            sizes.add(result.count);
        }

        cursor.close();
        Log.d("###", "months: " + TextUtils.join(", ", sizes));
    }

    @Override
    public void count() {
        Cursor cursor = db.rawQuery(COUNT, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);

        cursor.close();
        Log.d("###", "count: " + count);
    }

    private static class Result {

        private String title;
        private int count;

        public Result(String title, int count) {
            this.title = title;
            this.count = count;
        }

        @Override
        public String toString() {
            return title + "\t" + count;
        }
    }
}
