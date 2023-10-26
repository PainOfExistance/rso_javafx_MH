package com.example.rso_java_mh;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialiser {
    public void serialise(ObservableList<Event> obj, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(new ArrayList<>(obj));
            out.close();
            fileOut.close();
            System.out.println("Serialised data is saved in " + filename);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public ObservableList<Event> deserialise(String filename) {
        ObservableList<Event> items = FXCollections.observableArrayList();
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            items = FXCollections.observableList((List<Event>) objectInputStream.readObject()); // Change here

            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return items;
    }
}
