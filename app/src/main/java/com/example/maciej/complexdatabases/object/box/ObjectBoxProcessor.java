package com.example.maciej.complexdatabases.object.box;

import android.content.Context;

import com.example.maciej.complexdatabases.Timings;
import com.example.maciej.complexdatabases.object.box.model.Artist;
import com.example.maciej.complexdatabases.object.box.model.Date;
import com.example.maciej.complexdatabases.object.box.model.Playback;
import com.example.maciej.complexdatabases.object.box.model.Song;
import com.example.maciej.complexdatabases.object.box.model.Time;
import com.example.maciej.complexdatabases.object.box.model.User;
import com.example.maciej.complexdatabases.object.box.results.Result;

import java.io.IOException;

import io.objectbox.BoxStore;

public class ObjectBoxProcessor {

    public static final String SEPARATOR = "<SEP>";

    private Timings timer = new Timings("###dao");
    private Result result;

    public ObjectBoxProcessor() {
        result = new Result("Loading data");
    }


    public Result execute(Context context, BoxStore boxStore) {
        try {
            executeInLoop(context, boxStore);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void executeInLoop(Context context, BoxStore boxStore) throws IOException {
        Data data = new Loader().getData(context);

        for (int i = 0; i < 1; i++) {
            deleteData(boxStore);
            loadToNewSchema(data, boxStore);
        }
    }

    private void deleteData(BoxStore boxStore) {
        boxStore.boxFor(Artist.class).removeAll();
        boxStore.boxFor(Song.class).removeAll();
        boxStore.boxFor(Playback.class).removeAll();
        boxStore.boxFor(Date.class).removeAll();
        boxStore.boxFor(Time.class).removeAll();
        boxStore.boxFor(User.class).removeAll();
    }

    private void loadToNewSchema(Data data, BoxStore boxStore) throws IOException {
        timer.start();
        boxStore.boxFor(Artist.class).put(data.getArtists());
        boxStore.boxFor(Song.class).put(data.getSongs());
        boxStore.boxFor(Playback.class).put(data.getPlaybacks());
        boxStore.boxFor(Date.class).put(data.getDates());
        boxStore.boxFor(Time.class).put(data.getTimes());
        boxStore.boxFor(User.class).put(data.getUsers());
        result.addTime(timer.getTime());
        timer.logTime("Finished new schema in ");
    }
}
