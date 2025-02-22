package com.example.eindopdracht.AndereSchermen;

import com.example.eindopdracht.Hoofdschermen.LedenPaginaLeden;
import com.example.eindopdracht.Hoofdschermen.LedenPaginaTeams;
import com.example.eindopdracht.Hoofdschermen.VeldenPaginaWedstrijden;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class VeldenPaginaWedstrijdenToevoegScherm extends Application {
    private Stage stage7;

    public static void main(String[] args) {
        launch(args);
    }

    public VeldenPaginaWedstrijdenToevoegScherm(Stage stage7) {
        this.stage7 = stage7;
    }

    public VeldenPaginaWedstrijdenToevoegScherm() {
        // JavaFX will call this constructor when launching the app
    }

    @Override
    public void start(Stage stage) {

        this.stage7 = stage;
        // Create the root node for the scene
        Parent root = getRoot7();

        // Create the scene
        Scene scene = new Scene(root, 800, 600);

        // Set the scene for the stage (now using the correct 'stage' variable)
        stage.setScene(scene);
        stage.setTitle("LedenPaginaTeamsToevoegScherm");

        // Add the CSS stylesheet to the scene
        scene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/stylesheets/inlogpagina.css").toExternalForm());

        // Disable resizing
        stage.setResizable(false);

        // Show the stage
        stage.show();


    }

    public Parent getRoot7() {
        VBox vbox = new VBox(10); // VBox to organize elements vertically with spacing
        vbox.setAlignment(Pos.CENTER); // Center the VBox itself

        // Create the "terug" button
        Button btnterug = new Button("Terug");
        btnterug.setMinWidth(50);
        btnterug.setMinHeight(50);
        btnterug.setTranslateY(-400);
        btnterug.setTranslateX(-350);
        btnterug.setOnAction(e -> {
            VeldenPaginaWedstrijden VeldenPage = new VeldenPaginaWedstrijden(stage7);
            Scene ledenScene = new Scene(VeldenPage.getRoot3(), 1280, 720);
            stage7.setScene(ledenScene);
            ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });

        // Title text
        Text text = new Text("Wedstrijd Toevoegen");
        text.setId("text1");
        text.setTranslateY(0);

        // Team 1 ComboBox
        ComboBox<String> team1ComboBox = new ComboBox<>();
        team1ComboBox.setMaxWidth(600);
        team1ComboBox.setMinHeight(40);
        team1ComboBox.getItems().add("Geen team");
        List<String> teams = DatabaseManager.getTeamNames();
        if (!teams.isEmpty()) {
            team1ComboBox.getItems().addAll(teams);
            team1ComboBox.setValue(teams.get(0)); // Default value
        } else {
            team1ComboBox.setPromptText("Geen teams gevonden");
        }

        // Team 2 TextField (manual input)
        TextField team2TextField = new TextField();
        team2TextField.setPromptText("Voer tegenstander in");
        team2TextField.setMaxWidth(600);
        team2TextField.setMinHeight(40);

        // DateTime Picker for selecting match date and time
        TextField dateTimeField = new TextField();
        dateTimeField.setPromptText("Kies datum en tijd (yyyy-MM-dd HH:mm)");
        dateTimeField.setMaxWidth(600);
        dateTimeField.setMinHeight(40);

        // ComboBox for selecting field (Veld 1 - 8)
        ComboBox<Integer> veldComboBox = new ComboBox<>();
        for (int i = 1; i <= 8; i++) {
            veldComboBox.getItems().add(i);
        }
        veldComboBox.setPromptText("Kies een veld (1-8)");
        veldComboBox.setMaxWidth(600);
        veldComboBox.setMinHeight(40);

        // Save Button
        Button btnOpslaan = new Button("Opslaan");
        btnOpslaan.setMaxWidth(300);
        btnOpslaan.setMaxHeight(40);
        btnOpslaan.setMinHeight(50);
        btnOpslaan.setTranslateY(85);

        // Button Action Handler
        btnOpslaan.setOnAction(e -> {
            String team1 = team1ComboBox.getValue();
            String team2 = team2TextField.getText();
            String dateTimeInput = dateTimeField.getText();
            Integer selectedVeld = veldComboBox.getValue();

            // Validate input fields
            if (team1 == null || team2.isEmpty() || dateTimeInput.isEmpty() || selectedVeld == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Vul alle velden in!");
                alert.showAndWait();
                return;
            }

            try {
                // Convert date-time string to LocalDateTime
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime selectedDateTime = LocalDateTime.parse(dateTimeInput, formatter);

                // Get Team1ID based on team1 name
                int team1Id = DatabaseManager.getTeamIdByName(team1);

                // Save match data to database
                boolean success = DatabaseManager.insertWedstrijd(team1Id, team2, selectedDateTime, selectedVeld);

                if (success) {
                    // Show success alert
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Wedstrijd succesvol toegevoegd!");
                    alert.showAndWait();

                    VeldenPaginaWedstrijden veldenPage = new VeldenPaginaWedstrijden(stage7);
                    Scene veldenScene = new Scene(veldenPage.getRoot3(), 1280, 720);
                    stage7.setScene(veldenScene);
                    veldenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
                } else {
                    // Show error alert
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Fout bij opslaan van wedstrijd!");
                    alert.showAndWait();

                }
            } catch (Exception ex) {
                // Show invalid date-time format alert
                Alert alert = new Alert(Alert.AlertType.ERROR, "Ongeldig datum- en tijdformaat!");
                alert.showAndWait();
            }
        });

        // Add all components to the VBox
        vbox.getChildren().addAll(text, team1ComboBox, team2TextField, dateTimeField, veldComboBox, btnOpslaan, btnterug);

        // Use a StackPane to center the VBox
        StackPane root = new StackPane();
        root.getChildren().add(vbox);

        return root;
    }
}

// UI Elements



