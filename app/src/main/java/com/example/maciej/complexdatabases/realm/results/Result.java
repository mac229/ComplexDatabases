package com.example.maciej.complexdatabases.realm.results;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej on 2017-05-17.
 */

public class Result {

    private String type;
    private List<Long> times = new ArrayList<>();

    public Result(String type) {
        this.type = type;
    }

    public void addTime(long time) {
        times.add(time);
    }

    public String getType() {
        return type;
    }

    public List<Long> getTimes() {
        return times;
    }
}
