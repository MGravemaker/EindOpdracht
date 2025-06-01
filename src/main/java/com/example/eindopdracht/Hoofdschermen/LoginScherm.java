package com.example.eindopdracht.Hoofdschermen;

import com.example.eindopdracht.AndereSchermen.DatabaseManager;
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

public class LoginScherm {

    private StackPane root;

    public LoginScherm(Stage primaryStage) {
        root = new StackPane();
        VBox vbox = new VBox(40);
        vbox.setAlignment(Pos.CENTER);

        Text title = new Text("MOC 17 Gegevens beheer systeem");
        title.setId("text1");
        title.setTranslateY(-50);

        TextField gebruikersnaam = new TextField();
        gebruikersnaam.setPromptText("Gebruikersnaam");
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
                SchermNavigator.openLedenPagina(primaryStage);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Mislukt");
                alert.setHeaderText("Ongeldige gebruikersnaam of wachtwoord");
                alert.setContentText("Probeer opnieuw.");
                alert.showAndWait();
            }
        });

        vbox.getChildren().addAll(title, gebruikersnaam, wachtwoord, inlog);
        root.getChildren().add(vbox);
    }

    public StackPane getRoot() {
        return root;
    }
}
