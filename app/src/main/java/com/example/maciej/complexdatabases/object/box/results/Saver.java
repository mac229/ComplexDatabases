package com.example.maciej.complexdatabases.object.box.results;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


/**
 * Created by Maciej on 2017-05-10.
 */

public class Saver {

    public static final String FILE_NAME = "objectbox.csv";
    public static final String TAG = "###";
    public static final String SEPARATOR = ";";
    public static final String NEW_LINE = "\n";

    private FileOutputStream outputStream;
    private boolean opened;

    public void open() {
        if (!opened) {
            try {
                File file = new File(Environment.getExternalStorageDirectory(), FILE_NAME);
                if (file.exists()) {
                    file.delete();
                }

                outputStream = new FileOutputStream(file);
                opened = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void write(String data) {
        if (opened) {
            try {
                outputStream.write(data.getBytes());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            Log.e(TAG, "NOT OPENED");
        }
    }

    public void close() {
        if (opened) {
            try {
                outputStream.close();
                opened = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void save(List<Result> resultSet) {
        open();

        for (Result result : resultSet) {
            saveResult(result);
        }

        close();
    }

    private void saveResult(Result result) {
        write(result.getType() + SEPARATOR);
        for (long time : result.getTimes()) {
            write(time + SEPARATOR);
        }
        write(NEW_LINE);
    }
}
