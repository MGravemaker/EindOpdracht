package com.example.eindopdracht.AndereSchermen;

import com.example.eindopdracht.Hoofdschermen.LedenPaginaTeams;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane(); // StackPane to keep everything centered

        VBox vbox = new VBox(10); // VBox to organize elements vertically with spacing
        vbox.setAlignment(Pos.CENTER); // Center the VBox itself

        // UI Elements
        Text text = new Text("MOC 17 Gegevens beheer systeem");
        text.setId("text1");
        text.setTranslateY(-175);

        TextField gebruikersnaam = new TextField();
        gebruikersnaam.setPromptText("Gebruikersnaam"); // Placeholder text
        gebruikersnaam.setId("gebruikersnaam");
        gebruikersnaam.setMaxWidth(500);

        TextField wachtwoord = new TextField();
        wachtwoord.setPromptText("Wachtwoord");
        wachtwoord.setId("wachtwoord");
        wachtwoord.setMaxWidth(500);

        Button inlog = new Button("Inlog");
        inlog.setOnAction(e -> {
            LedenPaginaTeams ledenPage = new LedenPaginaTeams(primaryStage);
            // Instead of directly setting the scene, use the getRoot() to get the layout
            Scene ledenScene = new Scene(ledenPage.getRoot(), 1280, 720);  // Getting the root from LedenPaginaTeams
            primaryStage.setScene(ledenScene);  // Set the new scene

            ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });

        // Add elements to VBox
        vbox.getChildren().addAll(text, gebruikersnaam, wachtwoord, inlog);

        // Add VBox to StackPane
        root.getChildren().add(vbox);

        // Create scene and set stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Eindopdracht");
        primaryStage.show();

        scene.getStylesheets().add(getClass().getResource("/stylesheets/inlogpagina.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
    }
}
