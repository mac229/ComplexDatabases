package com.example.maciej.complexdatabases.greendao;

import android.content.Context;

import com.example.maciej.complexdatabases.Timings;
import com.example.maciej.complexdatabases.greendao.model.DaoSession;
import com.example.maciej.complexdatabases.greendao.results.Result;

import org.greenrobot.greendao.AbstractDao;

import java.io.IOException;

public class GreenDaoProcessor {

    public static final String SEPARATOR = "<SEP>";

    private Timings timer = new Timings("###dao");
    private Result result;

    public GreenDaoProcessor() {
        result = new Result("Loading data");
    }

    public Result execute(Context context, DaoSession daoSession) {
        try {
            executeInLoop(context, daoSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void executeInLoop(Context context, DaoSession daoSession) throws IOException {
        Data data = new Loader().getData(context);

        for (int i = 0; i < 10; i++) {
            deleteData(daoSession);
            loadToNewSchema(data, daoSession);
        }
    }

    private void deleteData(DaoSession daoSession) {
        timer.start();
        for (AbstractDao abstractDao : daoSession.getAllDaos()) {
            abstractDao.deleteAll();
        }
        timer.logTime("Deleted in");
    }

    private void loadToNewSchema(Data data, DaoSession daoSession) throws IOException {
        timer.start();
        daoSession.getArtistDao().insertInTx(data.getArtists());
        daoSession.getSongDao().insertInTx(data.getSongs());
        daoSession.getPlaybackDao().insertInTx(data.getPlaybacks());
        daoSession.getDateDao().insertInTx(data.getDates());
        daoSession.getTimeDao().insertInTx(data.getTimes());
        daoSession.getUserDao().insertInTx(data.getUsers());
        result.addTime(timer.getTime());
        timer.logTime("Finished new schema in");
    }
}
