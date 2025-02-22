package com.example.eindopdracht.Hoofdschermen;

import com.example.eindopdracht.AndereSchermen.LedenPaginaLedenToevoegScherm;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LedenPaginaLeden extends Application {
    private Stage stage2;

    public static void main(String[] args) {
        launch(args);
    }

    public LedenPaginaLeden(Stage stage2) {
        this.stage2 = stage2;
    }

    public LedenPaginaLeden() {
        // JavaFX will call this constructor when launching the app
    }

    public void start(Stage stage) {

        this.stage2 = stage;
        // Create the root node for the scene
        Parent root = getRoot2();

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

    public Parent getRoot2() {
        Button btn1 = new Button("Ledenbeheer");
        btn1.setMinWidth(190);
        btn1.getStyleClass().add("Knoppen");
        //  btn1.setOnAction(se);

        Button btn2 = new Button("Veldenbeheer");
        btn2.setMinWidth(190);
        btn2.getStyleClass().add("Knoppen");
        btn2.setOnAction(e -> {
            VeldenPaginaWedstrijden veldenPage = new VeldenPaginaWedstrijden(stage2);
            // Instead of directly setting the scene, use the getRoot() to get the layout
            Scene veldenScene = new Scene(veldenPage.getRoot3(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage2.setScene(veldenScene);  // Set the new scene

            veldenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });

        Button btn3 = new Button("Teams");
        btn3.setMinWidth(450);
        btn3.getStyleClass().add("Knoppen");
        btn3.setOnAction(e -> {
            LedenPaginaTeams ledenPage = new LedenPaginaTeams(stage2);
            // Instead of directly setting the scene, use the getRoot() to get the layout
            Scene ledenScene = new Scene(ledenPage.getRoot(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage2.setScene(ledenScene);  // Set the new scene

            ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });

        Button btn4 = new Button("Leden");
        btn4.setMinWidth(450);
        btn4.getStyleClass().add("Knoppen");


        TextField Linkstf1 = new TextField("Voornaam:");
        Linkstf1.setTranslateX(10);
        Linkstf1.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf2 = new TextField("Achternaam:");
        Linkstf2.setTranslateX(10);
        Linkstf2.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf3 = new TextField("Email:");
        Linkstf3.setTranslateX(30);
        Linkstf3.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf4 = new TextField("Telefoonnummer:");
        Linkstf4.setTranslateX(10);
        Linkstf4.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf5 = new TextField("Geboortedatum:");
        Linkstf5.setTranslateX(30);
        Linkstf5.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf6 = new TextField("Geslacht:");
        Linkstf6.setTranslateX(10);
        Linkstf6.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf7 = new TextField("Team:");
        Linkstf7.setTranslateX(30);
        Linkstf7.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf8 = new TextField("Rol:");
        Linkstf8.setTranslateX(10);
        Linkstf8.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        Button btnlinks1 = new Button("Dit lid verwijderen");
        btnlinks1.setTranslateX(65);
        btnlinks1.setMaxWidth(250);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        Button btnlinks2 = new Button("Opslaan");
        btnlinks2.setTranslateX(65);
        btnlinks2.setMaxWidth(250);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());


        GridPane pane = new GridPane();

        pane.setVgap(25);

        pane.setId("pane");
        pane.setMinWidth(380);
        pane.setMinHeight(430);

        pane.add(btn1, 0, 0);
        pane.add(btn2, 1, 0);

        pane.add(Linkstf1, 0, 1);
        //  GridPane.setColumnSpan(Linkstf1, 2);

        pane.add(Linkstf2, 1, 1);
        // GridPane.setColumnSpan(btnlinks2, 2);

        pane.add(Linkstf3, 0, 2);
        // GridPane.setColumnSpan(btnlinks3, 2);

        pane.add(Linkstf4, 1, 2);
        // GridPane.setColumnSpan(btnlinks4, 2);

        pane.add(Linkstf5, 0, 3);

        pane.add(Linkstf6, 1, 3);

        pane.add(Linkstf7, 0, 4);

        pane.add(Linkstf8, 1, 4);

        pane.add(btnlinks1, 0, 5);
        GridPane.setColumnSpan(btnlinks1, 2);

        pane.add(btnlinks2, 0, 6);
        GridPane.setColumnSpan(btnlinks2, 2);


        btn1.setLayoutX(0);
        btn1.setLayoutY(0);

        btn2.setLayoutX(190);
        btn2.setLayoutY(0);


        //  pane.getChildren().addAll(btn1, btn2);


        HBox hbox = new HBox();
        hbox.getChildren().addAll(pane, btn3, btn4);

        GridPane pane2 = new GridPane();
        pane2.setVgap(25);
        pane2.setId("pane2");
        pane2.setMaxWidth(381.5);
        //  pane2.setPrefWidth(380);
        pane2.setMinHeight(290);

        // Button btnlinks7 = new Button("Team(s) activiteit aanpassen");
        //btnlinks7.setTranslateY(25);
        // btnlinks7.setMinWidth(300);
        //GridPane.setHalignment(btnlinks7, Pos.CENTER.getHpos());

        Button btnlinks8 = new Button("Lid toevoegen");
        btnlinks8.setTranslateY(25);
        btnlinks8.setMinWidth(300);
        GridPane.setHalignment(btnlinks8, Pos.CENTER.getHpos());


        Button btnlinks9 = new Button("Lid verwijderen");
        btnlinks9.setTranslateY(25);
        btnlinks9.setMinWidth(300);
        GridPane.setHalignment(btnlinks9, Pos.CENTER.getHpos());

        Button btnlinks10 = new Button("Volledige scherm");
        btnlinks10.setTranslateY(25);
        btnlinks10.setMinWidth(300);
        GridPane.setHalignment(btnlinks10, Pos.CENTER.getHpos());

        Button btnlinks11 = new Button("Opslaan");
        btnlinks11.setTranslateY(25);
        btnlinks11.setMinWidth(250);
        GridPane.setHalignment(btnlinks11, Pos.CENTER.getHpos());


        ColumnConstraints col = new ColumnConstraints();
        col.setHalignment(HPos.CENTER);
        col.setPrefWidth(380);
        pane2.getColumnConstraints().add(col);


        pane2.add(btnlinks10, 0, 0);
        GridPane.setColumnSpan(btnlinks10, 2);

        pane2.add(btnlinks8, 0, 1);
        GridPane.setColumnSpan(btnlinks8, 2);

        pane2.add(btnlinks9, 0, 2);
        GridPane.setColumnSpan(btnlinks9, 2);

        pane2.add(btnlinks11, 0, 3);
        GridPane.setColumnSpan(btnlinks11, 2);

        //   pane2.add(btnlinks11, 0, 4);
        //   GridPane.setColumnSpan(btnlinks11, 2);

        HBox hbox2 = new HBox();
        Button btnitem1 = new Button("Voornaam");
        btnitem1.setMinWidth(150);
        Button btnitem2 = new Button("Achternaam");
        btnitem2.setMinWidth(150);
        Button btnitem3 = new Button("Team");
        btnitem3.setMinWidth(150);
        Button btnitem4 = new Button("Rol");
        btnitem4.setMinWidth(150);
        Button btnitem5 = new Button("Geboortedatum");
        btnitem5.setMinWidth(150);



        Button btnmenuknop = new Button("Reset");
        btnmenuknop.setMinWidth(150);

        hbox2.setTranslateY(-670);
        hbox2.setTranslateX(380);

        hbox2.getChildren().addAll(btnitem1, btnitem2, btnitem3, btnitem4, btnitem5, btnmenuknop);

        HBox hbox3 = new HBox();

        Label txt1 = new Label("1");
        txt1.setMinWidth(150);
        txt1.getStyleClass().add("MenuItemText");
        txt1.setMinHeight(25);
        txt1.setAlignment(Pos.CENTER);

        Label txt2 = new Label("2");
        txt2.setMinWidth(150);
        txt2.getStyleClass().add("MenuItemText");
        txt2.setMinHeight(25);
        txt2.setAlignment(Pos.CENTER);

        Label txt3 = new Label("3");
        txt3.setMinWidth(150);
        txt3.getStyleClass().add("MenuItemText");
        txt3.setMinHeight(25);
        txt3.setAlignment(Pos.CENTER);

        Label txt4 = new Label("4");
        txt4.setMinWidth(150);
        txt4.getStyleClass().add("MenuItemText");
        txt4.setMinHeight(25);
        txt4.setAlignment(Pos.CENTER);

        Label txt5 = new Label("5");
        txt5.setMinWidth(150);
        txt5.getStyleClass().add("MenuItemText");
        txt5.setMinHeight(25);
        txt5.setAlignment(Pos.CENTER);




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
        hbox3.getChildren().addAll(txt1, txt2, txt3, txt4, txt5, pane3);


        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox, pane2, hbox2, hbox3);


        // Create a scene and set it on the stage
        return vbox;
    }
}

