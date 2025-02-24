package com.example.eindopdracht.Hoofdschermen;

import com.example.eindopdracht.AndereSchermen.DatabaseManager;
import com.example.eindopdracht.AndereSchermen.VeldenPaginaTrainingenToevoegScherm;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;


public class VeldenPaginaTrainingen extends Application {
    private DatabaseManager.Training selectedTraining;
    private Stage stage4;

    public VeldenPaginaTrainingen(Stage stage4) {
        this.stage4 = stage4;
    }

    public VeldenPaginaTrainingen() {
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        this.stage4 = stage;
        Parent root = getRoot4();

        Scene scene = new Scene(root, 1280, 720);

        stage.setScene(scene);
        stage.setTitle("LedenPaginaTeams");

        scene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());

        stage.setResizable(false);

        stage.show();
    }
    public Parent getRoot4() {

        Button btn1 = new Button("Ledenbeheer");
        btn1.setMinWidth(190);
        btn1.getStyleClass().add("Knoppen");
        btn1.setOnAction(e -> {
            LedenPaginaTeams ledenPage2 = new LedenPaginaTeams(stage4);
            Scene veldenScene = new Scene(ledenPage2.getRoot(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage4.setScene(veldenScene);

            veldenScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
        });

        Button btn2 = new Button("Veldenbeheer");
        btn2.getStyleClass().add("HuidigKnop");
        btn2.setMinWidth(190);
        btn2.getStyleClass().add("Knoppen");

        Button btn3 = new Button("Wedstrijden");
        btn3.setMinWidth(450);
        btn3.getStyleClass().add("Knoppen");
        btn3.setOnAction(e -> {
            VeldenPaginaWedstrijden veldenPage2 = new VeldenPaginaWedstrijden(stage4);
            Scene veldenScene = new Scene(veldenPage2.getRoot3(), 1280, 720);
            stage4.setScene(veldenScene);

            veldenScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
        });

        Button btn4 = new Button("Trainingen");
        btn4.getStyleClass().add("HuidigKnop");
        btn4.setMinWidth(450);
        btn4.getStyleClass().add("Knoppen");


        TextField Linkstf1 = new TextField();
        Linkstf1.setPromptText("TeamID:");
        Linkstf1.setTranslateX(10);
        Linkstf1.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf2 = new TextField();
        Linkstf2.setPromptText("TrainingID");
        Linkstf2.setTranslateX(10);
        Linkstf2.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf3 = new TextField();
        Linkstf3.setPromptText("Datum:");
        Linkstf3.setTranslateX(30);
        Linkstf3.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf4 = new TextField("");
        Linkstf4.setPromptText("Veld:");
        Linkstf4.setTranslateX(10);
        Linkstf4.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        Button btnlinks1 = new Button("Dit training verwijderen");
        btnlinks1.setTranslateX(0);
        btnlinks1.setMaxWidth(250);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        Button btnlinks2 = new Button("Opslaan");
        btnlinks2.setTranslateX(65);
        btnlinks2.setMaxWidth(250);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());


        GridPane pane = new GridPane();

        pane.setVgap(50);

        pane.setId("pane");
        pane.setMinWidth(380);
        pane.setMinHeight(450);

        pane.add(btn1, 0, 0);
        pane.add(btn2, 1, 0);

        pane.add(Linkstf1, 0, 1);

        pane.add(Linkstf2, 1, 1);

        pane.add(Linkstf3, 0, 2);

        pane.add(Linkstf4, 1, 2);

        pane.add(btnlinks1, 0, 3);
        GridPane.setColumnSpan(btnlinks1, 2);

        pane.add(btnlinks2, 0, 4);
        GridPane.setColumnSpan(btnlinks2, 2);


        btn1.setLayoutX(0);
        btn1.setLayoutY(0);

        btn2.setLayoutX(190);
        btn2.setLayoutY(0);


        HBox hbox = new HBox();
        hbox.getChildren().addAll(pane, btn3, btn4);

        GridPane pane2 = new GridPane();
        pane2.setVgap(25);
        pane2.setId("pane2");
        pane2.setMaxWidth(381.5);

        pane2.setMinHeight(270);

        Button btnlinks8 = new Button("Training toevoegen");
        btnlinks8.setId("ToevoegKnop");
        btnlinks8.setMinWidth(300);
        btnlinks8.setMinHeight(50);
        btnlinks8.setTranslateY(100);
        btnlinks8.setMinWidth(300);
        GridPane.setHalignment(btnlinks8, Pos.CENTER.getHpos());
        btnlinks8.setOnAction(e -> {
            VeldenPaginaTrainingenToevoegScherm ToevoegScherm = new VeldenPaginaTrainingenToevoegScherm(stage4);
            Scene ToevoegScene = new Scene(ToevoegScherm.getRoot8(), 800, 600);  // Getting the root from LedenPaginaTeams
            stage4.setScene(ToevoegScene);

            ToevoegScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
            ToevoegScene.getStylesheets().add(getClass().getResource("/stylesheets/inlogpagina.css").toExternalForm());

        });


        Button btnlinks10 = new Button("Volledige scherm");
        btnlinks10.setTranslateY(25);
        btnlinks10.setMinWidth(300);
        GridPane.setHalignment(btnlinks10, Pos.CENTER.getHpos());




        ColumnConstraints col = new ColumnConstraints();
        col.setHalignment(HPos.CENTER);
        col.setPrefWidth(380);
        pane2.getColumnConstraints().add(col);


        pane2.add(btnlinks8, 0, 0);
        GridPane.setColumnSpan(btnlinks10, 8);


        HBox hbox3 = new HBox();
        GridPane TrainingTable = new GridPane();
        TrainingTable.setTranslateY(-670);
        TrainingTable.setTranslateX(285);
        TrainingTable.setHgap(0);
        TrainingTable.setVgap(0);
        TrainingTable.setAlignment(Pos.CENTER);


// ✅ Headers
        String[] headers = {"TeamID", "TrainingID", "Datum", "Veld"};
        for (int col2 = 0; col2 < headers.length; col2++) {
            Label headerLabel = new Label(headers[col2]);
            headerLabel.setMinWidth(187.5);
            headerLabel.setMinHeight(35);
            headerLabel.getStyleClass().add("MenuItemText");
            headerLabel.setAlignment(Pos.CENTER);
            TrainingTable.add(headerLabel, col2, 0);

            if (col2 == 3) {
                headerLabel.setTranslateX(-340);
            }
        }


//  Haal trainingen op en voeg ze toe
        List<DatabaseManager.Training> trainingen = DatabaseManager.getTrainingen();
        int row = 1;

        for (DatabaseManager.Training training : trainingen) {
            HBox rowBox = new HBox();
            rowBox.setSpacing(0);
            rowBox.setPadding(new Insets(0));
            rowBox.setAlignment(Pos.CENTER_LEFT);
            rowBox.setStyle("-fx-background-color: transparent;");

            Label TeamIDLabel = new Label(String.valueOf(training.TeamID));  // Converts int to String
            Label TrainingIDLabel = new Label(String.valueOf(training.TrainingID));  // Converts int to String
            Label Datum = new Label(String.valueOf(training.TrainingDatumTijd));  // If Datum is a Date, format it properly
            Label Veld = new Label(training.Veld);  // Assuming Veld is already a String


            TeamIDLabel.getStyleClass().add("cell-label3");
            TrainingIDLabel.getStyleClass().add("cell-label3");
            Datum.getStyleClass().add("cell-label3");
            Veld.getStyleClass().add("cell-label3");

            rowBox.setOnMouseClicked(event -> {
                selectedTraining = training;
                Linkstf1.setText(String.valueOf(training.TeamID));
                Linkstf2.setText(String.valueOf(training.TrainingID));
                Linkstf3.setText(String.valueOf(training.TrainingDatumTijd));
                Linkstf4.setText(training.Veld);

                for (Node node : TrainingTable.getChildren()) {
                    if (node instanceof HBox) {
                        node.setStyle("-fx-background-color: transparent;");
                    }
                }
                rowBox.setStyle("-fx-background-color: #b3d9ff;");
            });

            Button deleteButton = new Button("Delete");
            deleteButton.getStyleClass().add("delete-button");
            deleteButton.setOnAction(event -> {
                if (DatabaseManager.deleteTraining(training.TrainingID)) {
                    System.out.println("Training succesvol verwijderd!");
                    TrainingTable.getChildren().remove(rowBox);
                } else {
                    System.out.println("Fout bij verwijderen van training.");
                }
            });

            rowBox.getChildren().addAll(TeamIDLabel, TrainingIDLabel, Datum, Veld, deleteButton);
            TrainingTable.add(rowBox, 0, row, 3, 1);
            row++;

            btnlinks1.setMinWidth(250);
            GridPane.setHalignment(btnlinks1, HPos.CENTER);
            btnlinks1.setOnAction(e -> {
                if (DatabaseManager.deleteTraining(training.TrainingID)) {
                    System.out.println("Training succesvol verwijderd!");
                    TrainingTable.getChildren().remove(rowBox);
                } else {
                    System.out.println("Fout bij verwijderen van training.");
                }
            });
        }
        btnlinks2.setOnAction(event -> {
            if (selectedTraining != null) {
                selectedTraining.TeamID = Integer.parseInt(Linkstf1.getText());
                selectedTraining.TrainingID = Integer.parseInt(Linkstf2.getText());
                selectedTraining.TrainingDatumTijd = Linkstf3.getText();
                selectedTraining.Veld = Linkstf4.getText();

                boolean success = DatabaseManager.updateTraining(selectedTraining);
                if (success) {
                    System.out.println("Lid succesvol bijgewerkt!");
                } else {
                    System.out.println("Fout bij updaten van Training.");
                }
            } else {
                System.out.println("Geen Training geselecteerd om op te slaan.");
            }
        });

        Button btnmenu = new Button("Refresh");
        btnmenu.setMinHeight(35);
        btnmenu.setMinWidth(152);
        btnmenu.setTranslateY(-735);
        btnmenu.setTranslateX(1130);
        btnmenu.setOnAction(event -> {
            TrainingTable.getChildren().clear();

                    String[] headers2 = {"TeamID", "TrainingID", "Datum", "Veld"};
                    for (int col2 = 0; col2 < headers2.length; col2++) {
                        Label headerLabel2 = new Label(headers2[col2]);
                        headerLabel2.setMinWidth(187.5);
                        headerLabel2.setMinHeight(35);
                        headerLabel2.getStyleClass().add("MenuItemText");
                        headerLabel2.setAlignment(Pos.CENTER);
                        TrainingTable.add(headerLabel2, col2, 0);


                        if (col2 == 3) {
                            headerLabel2.setTranslateX(-340);
                        }
                    }

//  Haal trainingen op en voeg ze toe
                    List<DatabaseManager.Training> trainingen2 = DatabaseManager.getTrainingen();
                    int row2 = 1;

                    for (DatabaseManager.Training training : trainingen2) {
                        HBox rowBox = new HBox();
                        rowBox.setPadding(new Insets(0));
                        rowBox.setAlignment(Pos.CENTER_LEFT);
                        rowBox.setStyle("-fx-background-color: transparent;");

                        Label TeamIDLabel = new Label(String.valueOf(training.TeamID));
                        Label TrainingIDLabel = new Label(String.valueOf(training.TrainingID));
                        Label Datum = new Label(String.valueOf(training.TrainingDatumTijd));
                        Label Veld = new Label(training.Veld);


                        TeamIDLabel.getStyleClass().add("cell-label3");
                        TrainingIDLabel.getStyleClass().add("cell-label3");
                        Datum.getStyleClass().add("cell-label3");
                        Veld.getStyleClass().add("cell-label3");

                        rowBox.setOnMouseClicked(event2 -> {
                            selectedTraining = training;
                            Linkstf1.setText(String.valueOf(training.TeamID));
                            Linkstf2.setText(String.valueOf(training.TrainingID));
                            Linkstf3.setText(String.valueOf(training.TrainingDatumTijd));
                            Linkstf4.setText(training.Veld);

                            for (Node node : TrainingTable.getChildren()) {
                                if (node instanceof HBox) {
                                    node.setStyle("-fx-background-color: transparent;");
                                }
                            }
                            rowBox.setStyle("-fx-background-color: #b3d9ff;");
                        });

                        Button deleteButton = new Button("Delete");
                        deleteButton.getStyleClass().add("delete-button");
                        deleteButton.setOnAction(event2 -> {
                            if (DatabaseManager.deleteTraining(training.TrainingID)) {
                                System.out.println("Training succesvol verwijderd!");
                                TrainingTable.getChildren().remove(rowBox);
                            } else {
                                System.out.println("Fout bij verwijderen van training.");
                            }
                        });

                        rowBox.getChildren().addAll(TeamIDLabel, TrainingIDLabel, Datum, Veld, deleteButton);
                        TrainingTable.add(rowBox, 0, row2, 3, 1);
                        row2++;
                    }


        });
                    VBox vbox = new VBox();
                    vbox.getChildren().addAll(hbox, pane2, TrainingTable, btnmenu);


        return vbox;

    }
}

