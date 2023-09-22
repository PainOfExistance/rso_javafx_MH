package com.example.rso_java_mh;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.TextAlignment;

import org.controlsfx.control.spreadsheet.Grid;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();

        Button button1 = new Button("Neki Tekst");
        Text tekst= new Text("hdjfshdjlfsd");
        tekst.setX(200);
        tekst.setY(300);
        root.getChildren().add(button1);
        root.getChildren().add(tekst);
        button1.setOnAction(e -> {
            tekst.setText("Hello Java!!");
        });

        Scene scene = new Scene(root, 800, 600, Color.HOTPINK);
        stage.setTitle("JavaFX MH!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}