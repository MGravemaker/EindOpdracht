package com.example.eindopdracht.AndereSchermen;

import com.example.eindopdracht.Hoofdschermen.LedenPaginaLeden;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class LedenPaginaLedenToevoegScherm extends Application {
    private Stage stage6;

    public static void main(String[] args) {
        launch(args);
    }

    public LedenPaginaLedenToevoegScherm(Stage stage6) {
        this.stage6 = stage6;
    }

    public LedenPaginaLedenToevoegScherm() {
        // JavaFX will call this constructor when launching the app
    }

    @Override
    public void start(Stage stage) {

        this.stage6 = stage;
        // Create the root node for the scene
        Parent root = getRoot6();

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
    public Parent getRoot6() {
        StackPane root = new StackPane(); // StackPane to keep everything centered
        VBox vbox = new VBox(25); // VBox to organize elements vertically with spacing
        vbox.setAlignment(Pos.CENTER); // Center the VBox itself

        Button btnterug = new Button();
        btnterug.setMinWidth(50);
        btnterug.setMinHeight(50);
        btnterug.setTranslateY(-70);
        btnterug.setTranslateX(-350);
        btnterug.setOnAction(e -> {
            LedenPaginaLeden ledenPage = new LedenPaginaLeden(stage6);
            // Instead of directly setting the scene, use the getRoot() to get the layout
            Scene ledenScene = new Scene(ledenPage.getRoot2(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage6.setScene(ledenScene);  // Set the new scene

            ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });

        // UI Elements
        Text text = new Text("Lid toevoegen");
        text.setId("text1");
        text.setTranslateY(-70);

        TextField tf1 = new TextField("Voornaam:");
        tf1.setMinWidth(150);
        tf1.setMinHeight(40);
        GridPane.setHalignment(tf1, Pos.CENTER.getHpos());

        TextField tf2 = new TextField("Achternaam:");
        tf2.setMinWidth(150);
        tf2.setMinHeight(40);
        GridPane.setHalignment(tf2, Pos.CENTER.getHpos());

        TextField tf3 = new TextField("Email:");
        tf3.setMinWidth(150);
        tf3.setMinHeight(40);
        GridPane.setHalignment(tf3, Pos.CENTER.getHpos());

        TextField tf4 = new TextField("Telefoonnummer:");
        tf4.setMinWidth(150);
        tf4.setMinHeight(40);
        GridPane.setHalignment(tf4, Pos.CENTER.getHpos());

        TextField tf5 = new TextField("Geboortedatum:");
        tf5.setMinWidth(150);
        tf5.setMinHeight(40);
        GridPane.setHalignment(tf5, Pos.CENTER.getHpos());

        TextField tf6 = new TextField("Geslacht:");
        tf6.setMinWidth(150);
        tf6.setMinHeight(40);
        GridPane.setHalignment(tf6, Pos.CENTER.getHpos());

        ComboBox<String> TeamNaam = new ComboBox<>();
        TeamNaam.setMaxWidth(600);
        TeamNaam.setMinHeight(50);
        GridPane.setHalignment(TeamNaam, HPos.CENTER);


        List<String> teams = DatabaseManager.getTeamNames();

        TeamNaam.getItems().add("Geen team");

        if (!teams.isEmpty()) {
            TeamNaam.getItems().addAll(teams);
            TeamNaam.setValue(teams.get(0));
        } else {
            TeamNaam.setPromptText("Geen teams gevonden");
        }


        TeamNaam.setOnAction(event -> {
            if ("Geen team".equals(TeamNaam.getValue())) {
                TeamNaam.setValue(null);
            }
        });
            TextField tf8 = new TextField("Rol:");
            tf8.setMinHeight(40);
            tf8.setMinWidth(300);
            GridPane.setHalignment(tf8, Pos.CENTER.getHpos());


            Button btnopslaan = new Button("Opslaan");
            ;
            GridPane.setHalignment(btnopslaan, Pos.CENTER.getHpos());
            btnopslaan.setMaxWidth(600);
            btnopslaan.setMaxHeight(300);
            btnopslaan.setMinHeight(50);
            btnopslaan.setTranslateY(20);
            btnopslaan.setOnAction(e -> {
                String voornaam = tf1.getText();
                String achternaam = tf2.getText();
                String email = tf3.getText();
                String telefoonnummer = tf4.getText();
                String geboortedatum = tf5.getText();
                String geslacht = tf6.getText();
                String team = TeamNaam.getValue();
                String rol = tf8.getText();

                // Insert into database
                boolean success = DatabaseManager.insertLid(voornaam, achternaam, email, telefoonnummer, geboortedatum, geslacht, team, rol);

                if (success) {
                    System.out.println("Lid succesvol toegevoegd!");

                    LedenPaginaLeden ledenPage = new LedenPaginaLeden(stage6);
                    // Instead of directly setting the scene, use the getRoot() to get the layout
                    Scene ledenScene = new Scene(ledenPage.getRoot2(), 1280, 720);  // Getting the root from LedenPaginaTeams
                    stage6.setScene(ledenScene);  // Set the new scene

                    ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
                } else {
                    System.out.println("Fout bij toevoegen lid!");
                }

            });

            GridPane pane = new GridPane();
            pane.setTranslateY(-25);
            pane.setAlignment(Pos.CENTER);
            pane.setVgap(25);
            pane.setHgap(25);
            pane.setId("pane1");
            // pane.setMaxWidth(381.5);
            //  pane2.setPrefWidth(380);
            //
            pane.add(tf1, 0, 0);
            pane.add(tf2, 1, 0);
            pane.add(tf3, 0, 1);
            pane.add(tf4, 1, 1);
            pane.add(tf5, 0, 2);
            pane.add(tf6, 1, 2);
            pane.add(TeamNaam, 0, 3);
            pane.add(tf8, 1, 3);


            // Add elements to VBox
            // vbox.getChildren().addAll(text, gebruikersnaam, wachtwoord, inlog);
            //vbox.getChildren().addAll(btnterug, text, gebruikersnaam,btn1,btn2,btn3, btnopslaan);
            vbox.getChildren().addAll(btnterug, text, pane, btnopslaan);

            // Add VBox to StackPane
            root.getChildren().add(vbox);

            // Create scene  and set stage
            return root;


        }
    }
