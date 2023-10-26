package com.example.rso_java_mh;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Display display = new Display();
        MenuBar menuBar = new MenuBar();
        Menu viewMenu = new Menu("View");
        MenuItem displayItem = new MenuItem("Display View");
        MenuItem inputBoxes = new MenuItem("Input View");

        VBox root = new VBox(10, menuBar, display.getInputBox(), display.getDisplayButton(), display.getDisplayLabel(),display.getListView(), display.getDeleteButton(), display.getSaveButton(), display.getLoadButton());

        displayItem.setOnAction(event -> {
            root.getChildren().set(1, display.getInputBox());
            root.getChildren().set(2, display.getDisplayButton());
            root.getChildren().set(3, display.getDisplayLabel());
        });

        /*inputBoxes.setOnAction(event -> {
            root.getChildren().set(1, input.getInputLabels());
            root.getChildren().remove(2); // Remove Display button
            root.getChildren().remove(3); // Remove Display label
        });*/

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setTitle("Text Display");
        primaryStage.show();
    }
}