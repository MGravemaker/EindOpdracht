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
        scene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/stylesheets/inlogpagina.css").toExternalForm());

        // Disable resizing
        stage.setResizable(false);

        // Show the stage
        stage.show();


    }
    public Parent getRoot5() {
        StackPane root = new StackPane();
        VBox vbox = new VBox(25);
        vbox.setAlignment(Pos.CENTER);

        Button btnterug = new Button();
        btnterug.setText("⬅");
        btnterug.setId("TerugKnop");
        btnterug.setMinWidth(50);
        btnterug.setMinHeight(50);
        btnterug.setTranslateY(50);

        btnterug.setTranslateX(-350);
        btnterug.setOnAction(e -> {
            LedenPaginaTeams ledenPage = new LedenPaginaTeams(stage5);
            Scene ledenScene = new Scene(ledenPage.getRoot(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage5.setScene(ledenScene);
            ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
        });


        Text text = new Text("Team Toevoegen");
        text.setId("text1");
        text.setTranslateY(-15);

        TextField tf1 = new TextField();
        tf1.setPromptText("Teamnaam:");
        tf1.setId("gebruikersnaam");
        tf1.setMaxWidth(600);
        tf1.setMaxHeight(300);
        tf1.setMinHeight(50);

        ListView<String> spelersListView = new ListView<>();
        spelersListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // Allow multiple selection

        List<String> spelers = DatabaseManager.getLidnamen();
        ObservableList<String> observableSpelers = FXCollections.observableArrayList(spelers);
        spelersListView.setItems(observableSpelers);

        spelersListView.setMaxHeight(300);
        spelersListView.setMaxWidth(600);


        ComboBox<String> trainerComboBox = new ComboBox<>();
        trainerComboBox.getItems().add("Geen trainer");

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

            String selectedTrainer = trainerComboBox.getValue();

            Integer trainerLidId = selectedTrainer.equals("Geen trainer") ? null : DatabaseManager.getLidIdByName(selectedTrainer);

            boolean success = DatabaseManager.insertTeam(teamNaam, activiteit, trainerLidId);

            if (success) {
                System.out.println("Team succesvol toegevoegd!");

                LedenPaginaTeams teamsPage = new LedenPaginaTeams(stage5);
                Scene teamsScene = new Scene(teamsPage.getRoot(), 1280, 720);
                stage5.setScene(teamsScene);
                teamsScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
            } else {
                System.out.println("Fout bij toevoegen team!");
            }
        });

        vbox.getChildren().addAll(btnterug, text, tf1,spelersListView ,trainerComboBox,activiteitComboBox, btnopslaan);
        vbox.setTranslateY(-35);

        root.getChildren().add(vbox);

        return root;

    }
}
