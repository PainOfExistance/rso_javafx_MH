package com.example.rso_java_mh;

import java.util.ArrayList;

public class EventList {
    private String id;
    private ArrayList<Event> dogodki;
    private int timeDiff;

    public EventList(String id) {
        this.id = id;
        dogodki = new ArrayList<Event>();
        timeDiff = Integer.MAX_VALUE;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    private int CalculateTimeDiff(Event e){
        /*TODO*/
        return 0;
    }

    public void add(Event evenet) {
        dogodki.add(evenet);

    }

    public ArrayList<Event> getDogodki() {
        return dogodki;
    }

    public int getTimeDiff() {
        return timeDiff;
    }
}
