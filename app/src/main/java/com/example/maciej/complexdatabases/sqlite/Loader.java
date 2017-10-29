package com.example.maciej.complexdatabases.sqlite;

import android.content.Context;
import android.util.Log;

import com.example.maciej.complexdatabases.sqlite.model.Artist;
import com.example.maciej.complexdatabases.sqlite.model.Date;
import com.example.maciej.complexdatabases.sqlite.model.Playback;
import com.example.maciej.complexdatabases.sqlite.model.Song;
import com.example.maciej.complexdatabases.sqlite.model.Time;
import com.example.maciej.complexdatabases.sqlite.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;
import static com.example.maciej.complexdatabases.sqlite.SqlProcessor.SEPARATOR;

/**
 * Created by Maciej on 2017-05-15.
 */

public class Loader {

    private BufferedReader uniqueTracks;
    private BufferedReader tripletsSample;

    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");
    private Calendar calendar = new GregorianCalendar();

    public Data getData(Context context) {
        Data result = null;
        try {
            openFiles(context);
            result = load();
            closeFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private void openFiles(Context context) throws IOException {
        uniqueTracks = new BufferedReader(new InputStreamReader(context.getAssets().open("songs.txt")));
        tripletsSample = new BufferedReader(new InputStreamReader(context.getAssets().open("triplets.txt")));
    }

    private void closeFiles() throws IOException {
        uniqueTracks.close();
        tripletsSample.close();
    }

    private Data load() throws IOException {
        Data data = new Data();

        Map<String, Long> songsOldIdToIdMap = new HashMap<>();
        Map<String, Long> songsOldIdToArtistIdMap = new HashMap<>();
        Map<String, Long> artistNameToIdMap = new HashMap<>();
        Map<String, Long> dateToIdMap = new HashMap<>();
        Map<String, Long> timeToIdMap = new HashMap<>();
        Map<String, Long> usersOldIdToIdMap = new HashMap<>();

        long playbackCounter = 1;
        long songIdCounter = 1;
        long artistIdCounter = 1;
        long dateIdCounter = 1;
        long timeIdCounter = 1;
        long userIdCounter = 1;

        String line;
        String[] splitLine;

        while ((line = uniqueTracks.readLine()) != null) {
            splitLine = line.split(SEPARATOR);

            String artistName = splitLine[2];
            if (!artistNameToIdMap.containsKey(artistName)) {
                artistNameToIdMap.put(artistName, artistIdCounter);

                Artist artist = new Artist(artistIdCounter, artistName);
                data.getArtists().add(artist);
                artistIdCounter++;
            }

            String oldSongId = splitLine[1];
            if (!songsOldIdToIdMap.containsKey(oldSongId)) {
                songsOldIdToIdMap.put(oldSongId, songIdCounter);
                songsOldIdToArtistIdMap.put(oldSongId, artistNameToIdMap.get(artistName));

                Song song = new Song(songIdCounter, getTitle(splitLine));
                data.getSongs().add(song);
                songIdCounter++;
            }
        }

        Log.d(TAG, "Finished first file");

        while ((line = tripletsSample.readLine()) != null) {
            splitLine = line.split(SEPARATOR);

            String oldSongId = splitLine[1];
            if (songsOldIdToArtistIdMap.containsKey(oldSongId)) {
                calendar.setTimeInMillis(Long.parseLong(splitLine[2]) * 1000);

                if (!dateToIdMap.containsKey(format1.format(calendar.getTime()))) {
                    dateToIdMap.put(format1.format(calendar.getTime()), dateIdCounter);

                    Date date = new Date(dateIdCounter, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                    data.getDates().add(date);
                    dateIdCounter++;
                }

                if (!timeToIdMap.containsKey(format2.format(calendar.getTime()))) {
                    timeToIdMap.put(format2.format(calendar.getTime()), timeIdCounter);

                    Time time = new Time(timeIdCounter, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE));
                    data.getTimes().add(time);
                    timeIdCounter++;
                }

                String oldUserId = splitLine[0];
                if (!usersOldIdToIdMap.containsKey(oldUserId)) {
                    usersOldIdToIdMap.put(oldUserId, userIdCounter);

                    User user = new User(userIdCounter, oldUserId);
                    data.getUsers().add(user);
                    userIdCounter++;
                }

                Playback playback = new Playback(playbackCounter, songsOldIdToIdMap.get(oldSongId),
                        dateToIdMap.get(format1.format(calendar.getTime())), timeToIdMap.get(format2.format(calendar.getTime())),
                        songsOldIdToArtistIdMap.get(oldSongId), usersOldIdToIdMap.get(oldUserId));
                data.getPlaybacks().add(playback);
                playbackCounter++;
            }
        }

        return data;
    }

    private String getTitle(String[] splitLine) {
        if (splitLine.length == 4) {
            return splitLine[3];
        } else {
            return null;
        }
    }
}
