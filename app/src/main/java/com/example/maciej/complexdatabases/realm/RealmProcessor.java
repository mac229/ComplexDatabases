package com.example.maciej.complexdatabases.realm;

import android.content.Context;

import com.example.maciej.complexdatabases.Timings;
import com.example.maciej.complexdatabases.realm.model.Artist;
import com.example.maciej.complexdatabases.realm.model.Date;
import com.example.maciej.complexdatabases.realm.model.Playback;
import com.example.maciej.complexdatabases.realm.model.Song;
import com.example.maciej.complexdatabases.realm.model.Time;
import com.example.maciej.complexdatabases.realm.model.User;
import com.example.maciej.complexdatabases.realm.results.Result;

import java.io.IOException;

import io.realm.Realm;

public class RealmProcessor {

    public static final String SEPARATOR = "<SEP>";

    private Timings timer = new Timings("###realm");
    private Result result;

    public RealmProcessor() {
        result = new Result("Loading data");
    }

    public Result execute(Context context, Realm realm) {
        try {
            executeInLoop(context, realm);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void executeInLoop(Context context, Realm realm) throws IOException {
        Data data = new Loader().getData(context);

        for (int i = 0; i < 10; i++) {
            deleteData(realm);
            loadToNewSchema(realm, data);
        }
    }

    private void deleteData(Realm realm) {
        realm.beginTransaction();
        realm.delete(Artist.class);
        realm.delete(Date.class);
        realm.delete(Playback.class);
        realm.delete(Song.class);
        realm.delete(Time.class);
        realm.delete(User.class);
        realm.commitTransaction();
    }

    private void loadToNewSchema(Realm realm, Data data) throws IOException {
        timer.start();
        realm.beginTransaction();
        //realm.insert(data.getArtists());
        //realm.insert(data.getDates());
        realm.insert(data.getPlaybacks());
        //realm.insert(data.getSongs());
        //realm.insert(data.getTimes());
        //realm.insert(data.getUsers());
        realm.commitTransaction();
        result.addTime(timer.getTime());
        timer.logTime("Finished new schema in ");
    }
}
