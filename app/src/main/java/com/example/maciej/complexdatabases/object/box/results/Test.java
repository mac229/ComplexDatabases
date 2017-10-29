package com.example.maciej.complexdatabases.object.box.results;

import com.example.maciej.complexdatabases.Timings;

import java.util.List;

/**
 * Created by Maciej on 2017-05-21.
 */

public class Test {

    private Timings timings = new Timings("test");

    public void run(IAnswers answers, List<Result> results) {
        Result result = new Result("most popular songs");
        for (int i = 0; i < 10; i++) {
            timings.start();
            answers.rankingMostPopularSongs();
            result.addTime(timings.getTime());
        }
        results.add(result);

        result = new Result("user");
        for (int i = 0; i < 10; i++) {
            timings.start();
            answers.userWhichListen();
            result.addTime(timings.getTime());
        }
        results.add(result);

        result = new Result("songs");
        for (int i = 0; i < 10; i++) {
            timings.start();
            answers.songsListen();
            result.addTime(timings.getTime());
        }
        results.add(result);

        result = new Result("month");
        for (int i = 0; i < 10; i++) {
            timings.start();
            answers.months();
            result.addTime(timings.getTime());
        }
        results.add(result);

        result = new Result("count");
        for (int i = 0; i < 10; i++) {
            timings.start();
            answers.count();
            result.addTime(timings.getTime());
        }
        results.add(result);

        new Saver().save(results);
    }
}
