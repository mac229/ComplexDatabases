package com.example.maciej.complexdatabases.realm.results;

import android.text.TextUtils;
import android.util.Log;

import com.example.maciej.complexdatabases.realm.model.Playback;
import com.example.maciej.complexdatabases.realm.model.Song;
import com.example.maciej.complexdatabases.realm.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Maciej on 2017-05-20.
 */

public class Answers implements IAnswers {

    private final Realm realm;

    public Answers(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void rankingMostPopularSongs() {
        List<Result> results = new ArrayList<>();
        List<Song> songs = realm.where(Song.class).findAll();
        for (Song song : songs) {
            long count = realm.where(Playback.class).equalTo("song.id", song.getId()).count();
            results.add(new Result(song.getTitle(), (int) count));
        }

        Collections.sort(results, new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                return o2.count - o1.count;
            }
        });
    }

    @Override
    public void userWhichListen() {
        RealmQuery<Playback> query = realm.where(Playback.class);
        RealmResults<Playback> all = query.equalTo("artist.name", "3 Doors Down").findAll();

        List<User> results = new ArrayList<>();
        for (Playback playback : all) {
            results.add(playback.getUser());
        }

        Log.d("###", "userWhichListen: " + results.size());
    }

    @Override
    public void songsListen() {
        RealmQuery<Playback> query = realm.where(Playback.class);
        RealmResults<Playback> all = query.greaterThanOrEqualTo("date.year", 2005).findAll();
        List<User> results = new ArrayList<>();
        for (Playback playback : all) {
            results.add(playback.getUser());
        }
        Log.d("###", "songsListen: " + results.size());
    }

    @Override
    public void months() {
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            RealmQuery<Playback> query = realm.where(Playback.class);
            query.equalTo("date.month", i);
            List<Playback> list = query.findAll();
            sizes.add(list.size());
        }
        Log.d("###", "months: " + TextUtils.join(", ", sizes));
    }

    @Override
    public void count() {
        RealmQuery<Playback> query = realm.where(Playback.class);
        query.greaterThanOrEqualTo("time.hour", 8);
        query.lessThan("time.hour", 16);
        long count = query.count();
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
