package com.example.maciej.complexdatabases.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej Kozłowski on 12.12.16.
 */
public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cities-sqlite.db";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    public void createTables(SQLiteDatabase db) {
        db.execSQL(Queries.ARTISTS_TABLE_CREATE);
        db.execSQL(Queries.PLAYBACKS_TABLE_CREATE);
        db.execSQL(Queries.SONGS_TABLE_CREATE);
        db.execSQL(Queries.DATES_TABLE_CREATE);
        db.execSQL(Queries.TIMES_TABLE_CREATE);
        db.execSQL(Queries.USERS_TABLE_CREATE);
    }

    public void dropTables() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(Queries.DROP_TABLE_ARTISTS);
        db.execSQL(Queries.DROP_TABLE_PLAYBACKS);
        db.execSQL(Queries.DROP_TABLE_SONGS);
        db.execSQL(Queries.DROP_TABLE_DATES);
        db.execSQL(Queries.DROP_TABLE_TIMES);
        db.execSQL(Queries.DROP_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public List<Object> get() {
        List<Object> cities = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("table name", null, null, null, null, null, null);
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            //CitySql city = new CitySql(cursor.getInt(0), cursor.getString(1), cursor.getDouble(2), cursor.getDouble(3));
            //cities.add(city);
        }

        cursor.close();
        db.close();

        return cities;
    }

    @Nullable
    public Object get(String cityId) {
        String selection = Queries.NAME + " = ?";
        String[] args = {cityId};

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("table name", null, selection, args, null, null, null);

        Object object = null;
        if (cursor.moveToFirst()) {
            //CitySql = new CitySql(cursor.getInt(0), cursor.getString(1), cursor.getDouble(2), cursor.getDouble(3));
        }

        cursor.close();
        db.close();

        return new Object();
    }
}
