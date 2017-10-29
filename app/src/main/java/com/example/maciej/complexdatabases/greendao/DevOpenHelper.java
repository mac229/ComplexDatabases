package com.example.maciej.complexdatabases.greendao;

import android.content.Context;

import org.greenrobot.greendao.database.DatabaseOpenHelper;

/**
 * Created by Maciej Kozłowski on 02.05.17.
 */
public class DevOpenHelper extends DatabaseOpenHelper {

    private static final String DATABASE_NAME = "dao.db";

    public DevOpenHelper(Context context) {
        super(context, DATABASE_NAME, 1);
    }
}
