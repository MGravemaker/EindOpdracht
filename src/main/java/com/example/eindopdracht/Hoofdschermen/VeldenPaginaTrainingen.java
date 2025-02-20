package com.example.eindopdracht.Hoofdschermen;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VeldenPaginaTrainingen extends Application {
    private Stage stage4;

    public VeldenPaginaTrainingen(Stage stage4) {
        this.stage4 = stage4;
    }

    public VeldenPaginaTrainingen() {
        // JavaFX will call this constructor when launching the app
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        this.stage4 = stage;
        // Create the root node for the scene
        Parent root = getRoot4();

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
    public Parent getRoot4() {

        Button btn1 = new Button("Ledenbeheer");
        btn1.setMinWidth(190);
        btn1.getStyleClass().add("Knoppen");
        btn1.setOnAction(e -> {
            LedenPaginaTeams ledenPage2 = new LedenPaginaTeams(stage4);
            // Instead of directly setting the scene, use the getRoot() to get the layout
            Scene veldenScene = new Scene(ledenPage2.getRoot(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage4.setScene(veldenScene);  // Set the new scene

            veldenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });

        Button btn2 = new Button("Veldenbeheer");
        btn2.setMinWidth(190);
        btn2.getStyleClass().add("Knoppen");

        Button btn3 = new Button("Wedstrijden");
        btn3.setMinWidth(450);
        btn3.getStyleClass().add("Knoppen");
        btn3.setOnAction(e -> {
            VeldenPaginaWedstrijden veldenPage2 = new VeldenPaginaWedstrijden(stage4);
            // Instead of directly setting the scene, use the getRoot() to get the layout
            Scene veldenScene = new Scene(veldenPage2.getRoot3(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage4.setScene(veldenScene);  // Set the new scene

            veldenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });

        Button btn4 = new Button("Trainingen");
        btn4.setMinWidth(450);
        btn4.getStyleClass().add("Knoppen");




        TextField Linkstf1 = new TextField("Team:");
        Linkstf1.setTranslateX(10);
        Linkstf1.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf2 = new TextField("Datum:");
        Linkstf2.setTranslateX(10);
        Linkstf2.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf3 = new TextField("Tijd:");
        Linkstf3.setTranslateX(30);
        Linkstf3.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf4 = new TextField("Veld:");
        Linkstf4.setTranslateX(10);
        Linkstf4.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        Button btnlinks1 = new Button("Dit training verwijderen");
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
        pane.setMinHeight(355);

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


        pane.add(btnlinks1, 0, 3);
        GridPane.setColumnSpan(btnlinks1, 2);

        pane.add(btnlinks2, 0, 4);
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
        pane2.setMinHeight(365);

        Button btnlinks7 = new Button("Schema printen");
        btnlinks7.setTranslateY(25);
        btnlinks7.setMinWidth(300);
        GridPane.setHalignment(btnlinks7, Pos.CENTER.getHpos());

        Button btnlinks8 = new Button("Training toevoegen");
        btnlinks8.setTranslateY(25);
        btnlinks8.setMinWidth(300);
        GridPane.setHalignment(btnlinks8, Pos.CENTER.getHpos());

        Button btnlinks9 = new Button("Training verwijderen");
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

        pane2.add(btnlinks7, 0, 1);
        GridPane.setColumnSpan(btnlinks7, 2);

        pane2.add(btnlinks8, 0, 2);
        GridPane.setColumnSpan(btnlinks8, 2);

        pane2.add(btnlinks9, 0, 3);
        GridPane.setColumnSpan(btnlinks9, 2);

        pane2.add(btnlinks11, 0, 4);
        GridPane.setColumnSpan(btnlinks11, 2);

        HBox hbox2 = new HBox();
        Button btnitem1 = new Button("Team");
        btnitem1.setMinWidth(180);
        Button btnitem2 = new Button("Datum");
        btnitem2.setMinWidth(180);
        Button btnitem3 = new Button("Tijd");
        btnitem3.setMinWidth(180);
        Button btnitem4 = new Button("Veld");
        btnitem4.setMinWidth(180);


        Button btnmenuknop = new Button("Reset");
        btnmenuknop.setMinWidth(180);

        hbox2.setTranslateY(-670);
        hbox2.setTranslateX(380);

        hbox2.getChildren().addAll(btnitem1, btnitem2, btnitem3, btnitem4, btnmenuknop);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox, pane2,hbox2);


        // Create a scene and set it on the stage
        return vbox;

    }
}

