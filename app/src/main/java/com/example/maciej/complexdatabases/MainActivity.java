package com.example.maciej.complexdatabases;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.example.maciej.complexdatabases.sqlite.results.Answers;
import com.example.maciej.complexdatabases.sqlite.results.Result;
import com.example.maciej.complexdatabases.sqlite.results.Test;
import com.example.maciej.complexdatabases.sqlite.Database;
import com.example.maciej.complexdatabases.sqlite.SqlProcessor;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyApplication application = (MyApplication) getApplication();
        Database database = new Database(this);

        List<Result> results = process(database);
        SQLiteDatabase readableDatabase = database.getReadableDatabase();
        Answers answers = new Answers(readableDatabase);

        //exampleRun(answers);
        //testRun(results, answers);
        readableDatabase.close();
    }

    private void testRun(List<Result> results, Answers answers) {
        new Test().run(answers, results);
    }

    @NonNull
    private List<Result> process(Database database) {
        List<Result> results = new ArrayList<>();
        Result result = new SqlProcessor().execute(this, database);
        results.add(result);
        return results;
    }

    private void exampleRun(Answers answers) {
        answers.rankingMostPopularSongs();
        answers.userWhichListen();
        answers.songsListen();
        answers.months();
        answers.count();
    }
}
