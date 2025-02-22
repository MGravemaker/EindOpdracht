package com.example.eindopdracht.AndereSchermen;

import com.example.eindopdracht.Hoofdschermen.LedenPaginaLeden;
import com.example.eindopdracht.Hoofdschermen.VeldenPaginaTrainingen;
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

public class VeldenPaginaTrainingenToevoegScherm extends Application {
    private Stage stage8;

    public static void main(String[] args) {
        launch(args);
    }

    public VeldenPaginaTrainingenToevoegScherm(Stage stage8) {
        this.stage8 = stage8;
    }

    public VeldenPaginaTrainingenToevoegScherm() {
        // JavaFX will call this constructor when launching the app
    }

    @Override
    public void start(Stage stage) {

        this.stage8 = stage;
        // Create the root node for the scene
        Parent root = getRoot8();

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
    public Parent getRoot8() {
        StackPane root = new StackPane(); // StackPane to keep everything centered
        VBox vbox = new VBox(25); // VBox to organize elements vertically with spacing
        vbox.setAlignment(Pos.CENTER); // Center the VBox itself

        Button btnterug = new Button();
        btnterug.setMinWidth(50);
        btnterug.setMinHeight(50);
        btnterug.setTranslateY(-135);
        btnterug.setTranslateX(-350);
        btnterug.setOnAction(e -> {
            LedenPaginaLeden ledenPage = new LedenPaginaLeden(stage8);
            // Instead of directly setting the scene, use the getRoot() to get the layout
            Scene ledenScene = new Scene(ledenPage.getRoot2(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage8.setScene(ledenScene);  // Set the new scene

            ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });


            Text text = new Text("Training Toevoegen");
            text.setId("text1");
            text.setTranslateY(-135);

            ComboBox<String> TeamNaam = new ComboBox<>();
            TeamNaam.setMaxWidth(600);
            TeamNaam.setMinHeight(40);
            GridPane.setHalignment(TeamNaam, HPos.CENTER);

            List<String> teams = DatabaseManager.getTeamNames();


            if (!teams.isEmpty()) {
                TeamNaam.getItems().addAll(teams);
                TeamNaam.setValue(teams.get(0));
            } else {
                TeamNaam.setPromptText("Geen teams gevonden");
            }

            // DateTime Picker for selecting training date and time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            TextField dateTimeField = new TextField();
            dateTimeField.setPromptText("Kies datum en tijd (yyyy-MM-dd HH:mm)");
            dateTimeField.setMaxWidth(600);
            dateTimeField.setMinHeight(40);
            GridPane.setHalignment(dateTimeField, HPos.CENTER);

            // ComboBox for selecting field (Veld 1 - 8)
            ComboBox<Integer> veldComboBox = new ComboBox<>();
            for (int i = 1; i <= 8; i++) {
                veldComboBox.getItems().add(i);
            }
            veldComboBox.setPromptText("Kies een veld (1-8)");
            veldComboBox.setMaxWidth(600);
            veldComboBox.setMinHeight(40);
            GridPane.setHalignment(veldComboBox, HPos.CENTER);



            // Save Button
            Button btnOpslaan = new Button("Opslaan");
            GridPane.setHalignment(btnOpslaan, Pos.CENTER.getHpos());
            btnOpslaan.setMaxWidth(600);
            btnOpslaan.setMaxHeight(300);
            btnOpslaan.setMinHeight(50);
            btnOpslaan.setTranslateY(85);
            btnOpslaan.setOnAction(e -> {
                String selectedTeam = TeamNaam.getValue();
                String dateTimeInput = dateTimeField.getText();
                Integer selectedVeld = veldComboBox.getValue();

                if (selectedTeam == null || dateTimeInput.isEmpty() || selectedVeld == null) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Vul alle velden in!");
                    alert.showAndWait();
                    return;
                }

                try {
                    // Convert date-time string to LocalDateTime
                    LocalDateTime selectedDateTime = LocalDateTime.parse(dateTimeInput, formatter);

                    // Get the TeamID based on the selected team name
                    int teamId = DatabaseManager.getTeamIdByName(selectedTeam);

                    // Save data to database without the activiteit value
                    boolean success = DatabaseManager.insertTraining(teamId, selectedDateTime, selectedVeld);

                    if (success) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Training succesvol toegevoegd!");
                        alert.showAndWait();

                        VeldenPaginaTrainingen VeldenPage = new VeldenPaginaTrainingen(stage8);
                        Scene ledenScene = new Scene(VeldenPage.getRoot4(), 1280, 720);
                        stage8.setScene(ledenScene);
                        ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());

                        System.out.println("Training toegevoegd");
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Fout bij opslaan van training!");
                        alert.showAndWait();
                    }
                } catch (Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Ongeldig invoer");
                    alert.showAndWait();
                }
            });


        // UI Elements

        GridPane pane = new GridPane();
        pane.setTranslateY(-25);
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(25);
        pane.setHgap(25);
        pane.setId("pane1");
        // pane.setMaxWidth(381.5);
        //  pane2.setPrefWidth(380);
        //
        pane.add(TeamNaam, 0, 0);
        pane.add(dateTimeField, 1, 0);
        pane.add(veldComboBox, 0, 1);



        vbox.getChildren().addAll(btnterug, text, pane, btnOpslaan);

        // Add VBox to StackPane
        root.getChildren().add(vbox);

        // Create scene  and set stage
        return root;



    }
}

