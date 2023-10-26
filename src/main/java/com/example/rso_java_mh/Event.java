package com.example.rso_java_mh;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {
    private String id;
    private String ime;
    private Date datum;

    public Event(String id, String ime, Date date) {
        this.id = id;
        this.ime = ime;
        this.datum = date;
    }

    public Date getDatum() {
        return datum;
    }

    public String getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String toString() {
        return id + "  " + ime + "  " + datum.toString();
    }
}
