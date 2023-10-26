package com.example.rso_java_mh;

import java.io.Serializable;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Display {
    private TextField inputBox;
    private Button displayButton;
    private Button deleteButton;
    private Button saveButton;
    private Button loadButton;
    private Label displayLabel;
    private Serialiser serialiser;
    private ListView<Event> listView; // Add ListView for displaying strings
    private ObservableList<Event> items; // Observable list to hold strings
    private int selectedItem=-1; // Observable list to hold strings

    public Display() {
        inputBox = new TextField();
        displayButton = new Button("Add");
        deleteButton = new Button("Delete");
        saveButton = new Button("Save");
        loadButton = new Button("Load");
        displayLabel = new Label();
        listView = new ListView<>();
        items = FXCollections.observableArrayList(); // Initialize the observable list
        serialiser=new Serialiser();

        displayButton.setOnAction(event -> {
            String text = inputBox.getText();
            displayLabel.setText(text);
            System.out.println(text);

            // Add the text to the ListView
            Event obj=new Event("tmp",text, Date.from(java.time.Instant.now()));
            items.add(obj);
            inputBox.clear(); // Clear the input box
        });

        deleteButton.setOnAction(event -> {
            if(selectedItem!=-1){
                items.remove(selectedItem);
            }
            inputBox.clear(); // Clear the input box
        });

        saveButton.setOnAction(event -> {
            serialiser.serialise(items,"E:\\SERŠ\\rso_javafx_MH\\src\\main\\java\\com\\example\\rso_java_mh\\events.ser");
        });

        loadButton.setOnAction(event -> {
            items=serialiser.deserialise("E:\\SERŠ\\rso_javafx_MH\\src\\main\\java\\com\\example\\rso_java_mh\\events.ser");
            listView.setItems(items);
        });

        // Set the ListView's items to the observable list
        listView.setItems(items);

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                String selectedText = newSelection.toString();
                selectedItem = listView.getSelectionModel().getSelectedIndex();
                System.out.println("Selected item: " + selectedText);
                System.out.println("Selected index: " + selectedItem);
            }
        });
    }

    public TextField getInputBox() {
        return inputBox;
    }

    public Button getDisplayButton() {
        return displayButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Label getDisplayLabel() {
        return displayLabel;
    }

    public ListView<Event> getListView() {
        return listView;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getLoadButton() {
        return loadButton;
    }
}