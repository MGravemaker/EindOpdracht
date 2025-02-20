package com.example.eindopdracht.AndereSchermen;

import com.example.eindopdracht.Hoofdschermen.LedenPaginaLeden;
import com.example.eindopdracht.Hoofdschermen.VeldenPaginaTrainingen;
import javafx.application.Application;
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

        // UI Elements
        Text text = new Text("Training Toevoegen");
        text.setId("text1");
        text.setTranslateY(-135);

        TextField tf1 = new TextField("Team:");
        tf1.setMinWidth(150);
        tf1.setMinHeight(40);
        GridPane.setHalignment(tf1, Pos.CENTER.getHpos());

        TextField tf2 = new TextField("Datum");
        tf2.setMinWidth(150);
        tf2.setMinHeight(40);
        GridPane.setHalignment(tf2, Pos.CENTER.getHpos());

        TextField tf3 = new TextField("Tijd:");
        tf3.setMinWidth(300);
        tf3.setMinHeight(40);
        GridPane.setHalignment(tf3, Pos.CENTER.getHpos());

        TextField tf4 = new TextField("Veld:");
        tf4.setMinWidth(300);
        tf4.setMinHeight(40);
        GridPane.setHalignment(tf4, Pos.CENTER.getHpos());





        Button btnopslaan = new Button("Opslaan");;
        GridPane.setHalignment(btnopslaan, Pos.CENTER.getHpos());
        btnopslaan.setMaxWidth(600);
        btnopslaan.setMaxHeight(300);
        btnopslaan.setMinHeight(50);
        btnopslaan.setTranslateY(85);
        btnopslaan.setOnAction(e -> {
            VeldenPaginaTrainingen VeldenPage = new VeldenPaginaTrainingen(stage8);
            // Instead of directly setting the scene, use the getRoot() to get the layout
            Scene ledenScene = new Scene(VeldenPage.getRoot4(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage8.setScene(ledenScene);  // Set the new scene

            ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
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



        vbox.getChildren().addAll(btnterug, text, pane, btnopslaan);

        // Add VBox to StackPane
        root.getChildren().add(vbox);

        // Create scene  and set stage
        return root;



    }
}

