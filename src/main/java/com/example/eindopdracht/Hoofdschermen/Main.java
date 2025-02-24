package com.example.eindopdracht.Hoofdschermen;

import com.example.eindopdracht.AndereSchermen.DatabaseManager;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class  Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        VBox vbox = new VBox(40);
        vbox.setAlignment(Pos.CENTER);

        // UI Elements
        Text text = new Text("MOC 17 Gegevens beheer systeem");
        text.setId("text1");
        text.setTranslateY(-50);

        TextField gebruikersnaam = new TextField();
        gebruikersnaam.setPromptText("Gebruikersnaam"); // Placeholder text
        gebruikersnaam.setId("gebruikersnaam");
        gebruikersnaam.setMaxWidth(500);
        gebruikersnaam.setMinHeight(50);

        PasswordField wachtwoord = new PasswordField();
        wachtwoord.setPromptText("Wachtwoord");
        wachtwoord.setId("wachtwoord");
        wachtwoord.setMaxWidth(500);
        wachtwoord.setMinHeight(50);

        Button inlog = new Button("Inloggen");
        inlog.setId("inlog");
        inlog.setMaxWidth(200);
        inlog.setMinHeight(50);
        inlog.setTranslateY(20);

        inlog.setOnAction(e -> {
            String inputGebruikersnaam = gebruikersnaam.getText();
            String inputWachtwoord = wachtwoord.getText();

            if (DatabaseManager.authenticateUser(inputGebruikersnaam, inputWachtwoord)) {
                LedenPaginaTeams ledenPage = new LedenPaginaTeams(primaryStage);
                Scene ledenScene = new Scene(ledenPage.getRoot(), 1280, 720);
                primaryStage.setScene(ledenScene);
                ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Mislukt");
                alert.setHeaderText("Ongeldige gebruikersnaam of wachtwoord");
                alert.setContentText("Probeer opnieuw.");
                alert.showAndWait();
            }
        });

        vbox.getChildren().addAll(text, gebruikersnaam, wachtwoord, inlog);

        root.getChildren().add(vbox);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Eindopdracht");
        primaryStage.show();

        scene.getStylesheets().add(getClass().getResource("/stylesheets/inlogpagina.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
    }
}
