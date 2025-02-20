package com.example.eindopdracht.AndereSchermen;

import com.example.eindopdracht.Hoofdschermen.LedenPaginaTeams;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

        TextField gebruikersnaam = new TextField();
        gebruikersnaam.setPromptText("Teamnaam:"); // Placeholder text
        gebruikersnaam.setId("gebruikersnaam");
        gebruikersnaam.setMaxWidth(600);
        gebruikersnaam.setMaxHeight(300);
        gebruikersnaam.setMinHeight(50);

        Button btn1 = new Button("Spelers lijst aanpassen");
        btn1.setMinWidth(300);
        GridPane.setHalignment(btn1, HPos.CENTER);
        btn1.setMaxWidth(600);
        btn1.setMaxHeight(300);
        btn1.setMinHeight(50);

        Button btn2 = new Button("Trainers lijst aanpassen");
        GridPane.setHalignment(btn2, HPos.CENTER);
        btn2.setMaxWidth(600);
        btn2.setMaxHeight(300);
        btn2.setMinHeight(50);

        Button btn3 = new Button("Team activiteit: actief");

        GridPane.setHalignment(btn3, HPos.CENTER);
        btn3.setMaxWidth(600);
        btn3.setMaxHeight(300);
        btn3.setMinHeight(50);

        Button btnopslaan = new Button("Opslaan");;
        GridPane.setHalignment(btnopslaan, Pos.CENTER.getHpos());
        btnopslaan.setMaxWidth(600);
        btnopslaan.setMaxHeight(300);
        btnopslaan.setMinHeight(50);
        btnopslaan.setOnAction(e -> {
            LedenPaginaTeams ledenPage = new LedenPaginaTeams(stage5);
            // Instead of directly setting the scene, use the getRoot() to get the layout
            Scene ledenScene = new Scene(ledenPage.getRoot(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage5.setScene(ledenScene);  // Set the new scene

            ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });







        // Add elements to VBox
       // vbox.getChildren().addAll(text, gebruikersnaam, wachtwoord, inlog);
        vbox.getChildren().addAll(btnterug, text, gebruikersnaam,btn1,btn2,btn3, btnopslaan);

        // Add VBox to StackPane
        root.getChildren().add(vbox);

        // Create scene and set stage
        return root;



    }
}
