package com.example.eindopdracht.Hoofdschermen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        LoginScherm loginScherm = new LoginScherm(primaryStage);
        Scene scene = new Scene(loginScherm.getRoot(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Eindopdracht");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
