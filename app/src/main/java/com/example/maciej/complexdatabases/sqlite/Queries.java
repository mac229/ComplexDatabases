package com.example.maciej.complexdatabases.sqlite;

class Queries {

    static final String TABLE_SONGS = "SONGS";
    static final String TABLE_ARTISTS = "ARTISTS";
    static final String TABLE_PLAYBACKS = "PLAYBACKS";
    static final String TABLE_DATES = "DATES";
    static final String TABLE_TIMES = "TIMES";
    static final String TABLE_USERS = "USERS";

    static final String ID = "ID";
    static final String TITLE = "TITLE";

    static final String NAME = "NAME";

    static final String SONG_ID = "SONG_ID";
    static final String ARTIST_ID = "ARTIST_ID";
    static final String DATE_ID = "DATE_ID";
    static final String TIME_ID = "TIME_ID";
    static final String USER_ID = "USER_ID";

    static final String YEAR = "YEAR";
    static final String MONTH = "MONTH";
    static final String DAY = "DAY";

    static final String HOUR = "HOUR";
    static final String MINUTE = "MINUTE";

    static String SONGS_TABLE_CREATE = "CREATE TABLE SONGS " +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "TITLE STRING)";

    static String ARTISTS_TABLE_CREATE = "CREATE TABLE ARTISTS " +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "NAME STRING NOT NULL)";

    static String PLAYBACKS_TABLE_CREATE = "CREATE TABLE PLAYBACKS " +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "SONG_ID INTEGER NOT NULL," +
            "ARTIST_ID INTEGER NOT NULL," +
            "DATE_ID INTEGER NOT NULL," +
            "TIME_ID INTEGER NOT NULL," +
            "USER_ID INTEGER NOT NULL," +
            "FOREIGN KEY (SONG_ID) REFERENCES SONGS (ID)," +
            "FOREIGN KEY (ARTIST_ID) REFERENCES ARTISTS (ID)," +
            "FOREIGN KEY (DATE_ID) REFERENCES DATES (ID)," +
            "FOREIGN KEY (TIME_ID) REFERENCES TIMES (ID)," +
            "FOREIGN KEY (USER_ID) REFERENCES USERS (ID))";

    static String DATES_TABLE_CREATE = "CREATE TABLE DATES " +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "YEAR INTEGER NOT NULL," +
            "MONTH INTEGER NOT NULL," +
            "DAY INTEGER NOT NULL)";

    static String TIMES_TABLE_CREATE = "CREATE TABLE TIMES " +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "HOUR INTEGER NOT NULL," +
            "MINUTE INTEGER NOT NULL)";

    static String USERS_TABLE_CREATE = "CREATE TABLE USERS " +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "NAME STRING NOT NULL)";

    //New schema indexes queries
    static String indexOnSongIdFkCreateQuery = "CREATE INDEX SONG_ID_FK ON PLAYBACKS (SONG_ID)";
    static String indexOnArtistIdFkCreateQuery = "CREATE INDEX ARTIST_ID_FK ON PLAYBACKS (ARTIST_ID)";
    static String indexOnDateIdFkCreateQuery = "CREATE INDEX DATE_ID_FK ON PLAYBACKS (DATE_ID)";
    static String indexOnTimeIdFkCreateQuery = "CREATE INDEX TIME_ID_FK ON PLAYBACKS (TIME_ID)";
    static String indexOnUserIdFkCreateQuery = "CREATE INDEX USER_ID_FK ON PLAYBACKS (USER_ID)";

    //Drop tables
    static String DROP_TABLE_SONGS = "DROP TABLE IF EXISTS " + TABLE_SONGS;
    static String DROP_TABLE_ARTISTS = "DROP TABLE IF EXISTS " + TABLE_ARTISTS;
    static String DROP_TABLE_PLAYBACKS = "DROP TABLE IF EXISTS " + TABLE_PLAYBACKS;
    static String DROP_TABLE_DATES = "DROP TABLE IF EXISTS " + TABLE_DATES;
    static String DROP_TABLE_TIMES = "DROP TABLE IF EXISTS " + TABLE_TIMES;
    static String DROP_TABLE_USERS = "DROP TABLE IF EXISTS " + TABLE_USERS;
}
