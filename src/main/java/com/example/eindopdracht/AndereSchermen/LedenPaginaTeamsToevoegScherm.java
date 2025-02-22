package com.example.eindopdracht.AndereSchermen;

import com.example.eindopdracht.Hoofdschermen.LedenPaginaTeams;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class LedenPaginaTeamsToevoegScherm extends Application {
    private Stage stage5;

    public static void main(String[] args) {
        launch(args);
    }

    public LedenPaginaTeamsToevoegScherm(Stage stage5) {
        this.stage5 = stage5;
    }

    public LedenPaginaTeamsToevoegScherm() {
        // JavaFX will call this constructor when launching the app
    }

    @Override
    public void start(Stage stage) {

        this.stage5 = stage;
        // Create the root node for the scene
        Parent root = getRoot5();

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
    public Parent getRoot5() {
        StackPane root = new StackPane(); // StackPane to keep everything centered
        VBox vbox = new VBox(25); // VBox to organize elements vertically with spacing
        vbox.setAlignment(Pos.CENTER); // Center the VBox itself

        Button btnterug = new Button();
        btnterug.setMinWidth(50);
        btnterug.setMinHeight(50);
        btnterug.setTranslateY(-50);
        btnterug.setTranslateX(-350);
        btnterug.setOnAction(e -> {
            LedenPaginaTeams ledenPage = new LedenPaginaTeams(stage5);
            // Instead of directly setting the scene, use the getRoot() to get the layout
            Scene ledenScene = new Scene(ledenPage.getRoot(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage5.setScene(ledenScene);  // Set the new scene

            ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });



        // UI Elements
        Text text = new Text("Team Toevoegen");
        text.setId("text1");
        text.setTranslateY(-50);

        TextField tf1 = new TextField();
        tf1.setPromptText("Teamnaam:"); // Placeholder text
        tf1.setId("gebruikersnaam");
        tf1.setMaxWidth(600);
        tf1.setMaxHeight(300);
        tf1.setMinHeight(50);

        ListView<String> spelersListView = new ListView<>();
        spelersListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // Allow multiple selection

        // Get player names from database and populate ListView
        List<String> spelers = DatabaseManager.getLidnamen();
        ObservableList<String> observableSpelers = FXCollections.observableArrayList(spelers);
        spelersListView.setItems(observableSpelers);

        // Set max size
        spelersListView.setMaxHeight(300);
        spelersListView.setMaxWidth(600);


        ComboBox<String> trainerComboBox = new ComboBox<>();
        trainerComboBox.getItems().add("Geen trainer"); // Default option

        List<String> trainerNames = DatabaseManager.getTrainerNames();
        trainerComboBox.getItems().addAll(trainerNames);


        trainerComboBox.setValue("Geen trainer");


        ComboBox<String> activiteitComboBox = new ComboBox<>();
        activiteitComboBox.getItems().addAll("Actief", "Nonactief");
        activiteitComboBox.setValue("Actief"); // Default value
        activiteitComboBox.setMinWidth(600);
        activiteitComboBox.setMinHeight(50);
        GridPane.setHalignment(activiteitComboBox, HPos.CENTER);




        Button btnopslaan = new Button("Opslaan");;
        GridPane.setHalignment(btnopslaan, Pos.CENTER.getHpos());
        btnopslaan.setMaxWidth(600);
        btnopslaan.setMaxHeight(300);
        btnopslaan.setMinHeight(50);
        btnopslaan.setOnAction(e -> {
            String teamNaam = tf1.getText();
            String activiteit = activiteitComboBox.getValue();

            // Get selected trainer
            String selectedTrainer = trainerComboBox.getValue();

            // Convert trainer name to LidID
            Integer trainerLidId = selectedTrainer.equals("Geen trainer") ? null : DatabaseManager.getLidIdByName(selectedTrainer);

            // Insert into database
            boolean success = DatabaseManager.insertTeam(teamNaam, activiteit, trainerLidId);

            if (success) {
                System.out.println("Team succesvol toegevoegd!");

                // Reload the page or navigate back to the team overzicht
                LedenPaginaTeams teamsPage = new LedenPaginaTeams(stage5);
                Scene teamsScene = new Scene(teamsPage.getRoot(), 1280, 720);
                stage5.setScene(teamsScene);
                teamsScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
            } else {
                System.out.println("Fout bij toevoegen team!");
            }
        });







        // Add elements to VBox
       // vbox.getChildren().addAll(text, gebruikersnaam, wachtwoord, inlog);
        vbox.getChildren().addAll(btnterug, text, tf1,spelersListView ,trainerComboBox,activiteitComboBox, btnopslaan);

        // Add VBox to StackPane
        root.getChildren().add(vbox);

        // Create scene and set stage
        return root;



    }
}
