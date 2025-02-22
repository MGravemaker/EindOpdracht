package com.example.eindopdracht.Hoofdschermen;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LedenPaginaTeams extends Application {
    private Stage stage;


    public static void main(String[] args) {

        launch(args);
    }
    public LedenPaginaTeams(Stage stage) {
        this.stage = stage;

    }

    public LedenPaginaTeams() {
        // JavaFX will call this constructor when launching the app
    }

    @Override
    public void start(Stage stage) {

        this.stage = stage;

        // Create the root node for the scene
        Parent root = getRoot();

        // Create the scene
        Scene scene = new Scene(root, 1280, 720);

        // Set the scene for the stage (now using the correct 'stage' variable)
        stage.setScene(scene);
        stage.setTitle("LedenPaginaTeams");

        // Add the CSS stylesheet to the scene
        scene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());

        // Disable resizing
        stage.setResizable(false);

        // Show the stage
        stage.show();
    }

    public Parent getRoot() {
        // Create buttons for the HBox
        Button btn1 = new Button("Ledenbeheer");
        btn1.setMinWidth(190);
        btn1.getStyleClass().add("Knoppen");
        btn1.setOnAction(e -> {
            LedenPaginaTeams ledenPage2 = new LedenPaginaTeams(stage);
            // Instead of directly setting the scene, use the getRoot() to get the layout
            Scene veldenScene = new Scene(ledenPage2.getRoot(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage.setScene(veldenScene);  // Set the new scene

            veldenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });



        Button btn2 = new Button("Veldenbeheer");
        btn2.setMinWidth(190);
        btn2.getStyleClass().add("Knoppen");
       btn2.setOnAction(e -> {
       VeldenPaginaWedstrijden veldenPage = new VeldenPaginaWedstrijden(stage);
            // Instead of directly setting the scene, use the getRoot() to get the layout
         Scene veldenScene = new Scene(veldenPage.getRoot3(), 1280, 720);  // Getting the root from LedenPaginaTeams
          stage.setScene(veldenScene);  // Set the new scene

           veldenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });

        Button btn3 = new Button("Teams");
        btn3.setMinWidth(450);
        btn3.getStyleClass().add("Knoppen");
        btn3.setTranslateY(-190);

        Button btn4 = new Button("Leden");
        btn4.setMinWidth(450);
        btn4.getStyleClass().add("Knoppen");
        btn4.setTranslateY(-190);
        btn4.setOnAction(e -> {
                    LedenPaginaLeden ledenPage = new LedenPaginaLeden(stage);
                    // Instead of directly setting the scene, use the getRoot() to get the layout
                    Scene ledenScene = new Scene(ledenPage.getRoot2(), 1280, 720);  // Getting the root from LedenPaginaTeams
                    stage.setScene(ledenScene);  // Set the new scene

                    ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });

        // Left side TextField and Buttons
        TextField Linkstf1 = new TextField("Team naam:");
        Linkstf1.setTranslateX(10);
        Linkstf1.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, HPos.CENTER);

        Button btnlinks2 = new Button("Spelers lijst aanpassen");
        btnlinks2.setMinWidth(300);
        GridPane.setHalignment(btnlinks2, HPos.CENTER);

        Button btnlinks3 = new Button("Trainers lijst aanpassen");
        btnlinks3.setMinWidth(300);
        GridPane.setHalignment(btnlinks3, HPos.CENTER);

        Button btnlinks4 = new Button("Team activiteit: actief");
        btnlinks4.setMinWidth(300);
        GridPane.setHalignment(btnlinks4, HPos.CENTER);

        Button btnlinks5 = new Button("Dit team verwijderen");
        btnlinks5.setMinWidth(300);
        GridPane.setHalignment(btnlinks5, HPos.CENTER);

        Button btnlinks6 = new Button("Opslaan");
        btnlinks6.setMinWidth(250);
        GridPane.setHalignment(btnlinks6, HPos.CENTER);

        // Left panel GridPane Layout
        GridPane pane = new GridPane();
        pane.setVgap(25);
        pane.setId("pane");
        pane.setMinWidth(380);
        pane.setMinHeight(430);

        pane.add(btn1, 0, 0);
        pane.add(btn2, 1, 0);
        pane.add(Linkstf1, 0, 1);
        GridPane.setColumnSpan(Linkstf1, 2);
        pane.add(btnlinks2, 0, 2);
        GridPane.setColumnSpan(btnlinks2, 2);
        pane.add(btnlinks3, 0, 3);
        GridPane.setColumnSpan(btnlinks3, 2);
        pane.add(btnlinks4, 0, 4);
        GridPane.setColumnSpan(btnlinks4, 2);
        pane.add(btnlinks5, 0, 5);
        GridPane.setColumnSpan(btnlinks5, 2);
        pane.add(btnlinks6, 0, 6);
        GridPane.setColumnSpan(btnlinks6, 2);

        // HBox to hold the left pane and btn3, btn4
        HBox hbox = new HBox();  // Add spacing between elements
        hbox.setAlignment(Pos.CENTER);  // Center alignment for buttons and grid
        hbox.getChildren().addAll(pane, btn3, btn4);


        // Right panel GridPane Layout
        GridPane pane2 = new GridPane();
        pane2.setVgap(25);
        pane2.setId("pane2");
        pane2.setMaxWidth(381.5);
        pane2.setMinHeight(290);

        Button btnlinks8 = new Button("Team toevoegen");
        btnlinks8.setTranslateY(25);
        btnlinks8.setMinWidth(300);
        GridPane.setHalignment(btnlinks8, HPos.CENTER);

        Button btnlinks9 = new Button("Team(s) verwijderen");
        btnlinks9.setTranslateY(25);
        btnlinks9.setMinWidth(300);
        GridPane.setHalignment(btnlinks9, HPos.CENTER);

        Button btnlinks10 = new Button("Volledige scherm");
        btnlinks10.setTranslateY(25);
        btnlinks10.setMinWidth(300);
        GridPane.setHalignment(btnlinks10, HPos.CENTER);

        Button btnlinks11 = new Button("Opslaan");
        btnlinks11.setTranslateY(25);
        btnlinks11.setMinWidth(250);
        GridPane.setHalignment(btnlinks11, HPos.CENTER);

        // Column Constraints for the right GridPane
        ColumnConstraints col = new ColumnConstraints();
        col.setHalignment(HPos.CENTER);
        col.setPrefWidth(380);
        pane2.getColumnConstraints().add(col);

        // Add buttons to the right panel GridPane
        pane2.add(btnlinks10, 0, 0);
        GridPane.setColumnSpan(btnlinks10, 2);
        pane2.add(btnlinks8, 0, 1);
        GridPane.setColumnSpan(btnlinks8, 2);
        pane2.add(btnlinks9, 0, 2);
        GridPane.setColumnSpan(btnlinks9, 2);
        pane2.add(btnlinks11, 0, 3);
        GridPane.setColumnSpan(btnlinks11, 2);

    HBox hbox3 = new HBox();

        Label txt1 = new Label("1");
        txt1.setMinWidth(187.5);
        txt1.getStyleClass().add("MenuItemText");
        txt1.setMinHeight(25);
        txt1.setAlignment(Pos.CENTER);

        Label txt2 = new Label("2");
        txt2.setMinWidth(187.5);
        txt2.getStyleClass().add("MenuItemText");
        txt2.setMinHeight(25);
        txt2.setAlignment(Pos.CENTER);

        Label txt3 = new Label("3");
        txt3.setMinWidth(187.5);
        txt3.getStyleClass().add("MenuItemText");
        txt3.setMinHeight(25);
        txt3.setAlignment(Pos.CENTER);

        Label txt4 = new Label("4");
        txt4.setMinWidth(187.5);
        txt4.getStyleClass().add("MenuItemText");
        txt4.setMinHeight(25);
        txt4.setAlignment(Pos.CENTER);





        Pane pane3 = new Pane();
    Button btnmenu = new Button("Refresh");
    btnmenu.setMinHeight(20);
    btnmenu.setMinWidth(150);

    pane3.getChildren().addAll(btnmenu);
    pane3.setMinWidth(150);
    pane3.setMinHeight(20);

    hbox3.setTranslateY(-670);
    hbox3.setTranslateX(380);
    hbox3.setMinHeight(50);
    hbox3.getChildren().addAll(txt1, txt2, txt3, txt4, pane3);




        // Top-right HBox with buttons for interacting with team data
        HBox hbox2 = new HBox();
        Button btnitem1 = new Button("Team naam");
        btnitem1.setMinWidth(187.5);
        btnitem1.setMinHeight(35);
        Button btnitem2 = new Button("Aantal spelers");
        btnitem2.setMinWidth(187.5);
        btnitem2.setMinHeight(35);
        Button btnitem3 = new Button("Trainer");
        btnitem3.setMinWidth(187.5);
        btnitem3.setMinHeight(35);
        Button btnitem4 = new Button("Activiteit");
        btnitem4.setMinWidth(187.5);
        btnitem4.setMinHeight(35);
        Button btnmenuknop = new Button("Reset");
        btnmenuknop.setMinHeight(35);
        btnmenuknop.setMinWidth(150);



        hbox2.setTranslateY(-670);
        hbox2.setTranslateX(380);
        hbox2.getChildren().addAll(btnitem1, btnitem2, btnitem3, btnitem4, btnmenuknop);

        // Main VBox layout that contains the full scene structure
        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox, pane2, hbox2, hbox3);



        return vbox;
    }
}
