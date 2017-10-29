package com.example.maciej.complexdatabases;

import android.app.Application;

import com.example.maciej.complexdatabases.greendao.DevOpenHelper;
import com.example.maciej.complexdatabases.greendao.model.DaoMaster;
import com.example.maciej.complexdatabases.greendao.model.DaoSession;
import com.example.maciej.complexdatabases.object.box.model.MyObjectBox;

import org.greenrobot.greendao.database.Database;

import io.objectbox.BoxStore;
import io.realm.Realm;


/**
 * Created by Maciej Kozłowski on 01.05.17.
 */
public class MyApplication extends Application {

    private Realm realm;
    private BoxStore boxStore;
    private DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();
        DevOpenHelper helper = new DevOpenHelper(this);
        Database db = helper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        DaoMaster.createAllTables(daoMaster.getDatabase(), true);

        boxStore = MyObjectBox.builder().androidContext(this).build();

        Realm.init(this);
        realm = Realm.getDefaultInstance();
    }

    public Realm getRealm() {
        return realm;
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
