package com.example.maciej.complexdatabases.object.box.results;

import android.text.TextUtils;
import android.util.Log;

import com.example.maciej.complexdatabases.object.box.model.Playback;
import com.example.maciej.complexdatabases.object.box.model.Playback_;
import com.example.maciej.complexdatabases.object.box.model.Song;
import com.example.maciej.complexdatabases.object.box.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.objectbox.BoxStore;

/**
 * Created by Maciej on 2017-05-20.
 */

public class Answers implements IAnswers {

    private final BoxStore boxStore;

    public Answers(BoxStore boxStore) {
        this.boxStore = boxStore;
    }

    @Override
    public void rankingMostPopularSongs() {
        List<Result> results = new ArrayList<>();
        List<Song> songs = boxStore.boxFor(Song.class).getAll();
        for (Song song : songs) {
            long count = boxStore.boxFor(Playback.class).query().equal(Playback_.songId, song.getId()).build().count();
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
        List<User> results = new ArrayList<>();
        List<Playback> all = boxStore.boxFor(Playback.class).getAll();
        for (Playback playback : all) {
            if (playback.getArtist().getTarget().getName().equals("3 Doors Down")) {
                results.add(playback.getUser().getTarget());
            }
        }
        Log.d("###", "userWhichListen: " + results.size());
    }

    @Override
    public void songsListen() {
        List<Song> results = new ArrayList<>();
        List<Playback> all = boxStore.boxFor(Playback.class).getAll();
        for (Playback playback : all) {
            int year = playback.getDate().getTarget().getYear();
            if (year >= 2005) {
                results.add(playback.getSong().getTarget());
            }
        }
        Log.d("###", "songsListen: " + results.size());
    }

    @Override
    public void months() {
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            List<Playback> all = boxStore.boxFor(Playback.class).getAll();
            List<Playback> result = new ArrayList<>();
            for (Playback playback : all) {
                if (playback.getDate().getTarget().getMonth() == i) {
                    result.add(playback);
                }
            }
            sizes.add(result.size());
        }
        Log.d("###", "months: " + TextUtils.join(", ", sizes));
    }

    @Override
    public void count() {
        List<Playback> results = new ArrayList<>();
        List<Playback> all = boxStore.boxFor(Playback.class).getAll();
        for (Playback playback : all) {
            int hour = playback.getTime().getTarget().getHour();
            if (8 <= hour && hour < 16) {
                results.add(playback);
            }
        }
        Log.d("###", "count: " + results.size());
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
