package com.example.eindopdracht.Hoofdschermen;

import com.example.eindopdracht.AndereSchermen.DatabaseManager;
import com.example.eindopdracht.AndereSchermen.VeldenPaginaWedstrijdenToevoegScherm;
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

public class VeldenPaginaWedstrijden extends Application {
    private DatabaseManager.Wedstrijd selectedWedstrijd;
    private Stage stage3;


    public static void main(String[] args) {
        launch(args);
    }

    public VeldenPaginaWedstrijden(Stage stage3) {
        this.stage3 = stage3;
    }

    public VeldenPaginaWedstrijden() {

    }

    @Override
    public void start(Stage stage) {

        this.stage3 = stage;

        Parent root = getRoot3();

        Scene scene = new Scene(root, 1280, 720);

        stage.setScene(scene);
        stage.setTitle("LedenPaginaTeams");

        scene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());

        stage.setResizable(false);

        stage.show();
    }


    public Parent getRoot3() {


        Button btn1 = new Button("Ledenbeheer");
        btn1.setMinWidth(190);
        btn1.getStyleClass().add("Knoppen");
        btn1.setOnAction(e -> {
            LedenPaginaTeams ledenPage = new LedenPaginaTeams(stage3);
            Scene ledenScene = new Scene(ledenPage.getRoot(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage3.setScene(ledenScene);

            ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
        });

        Button btn2 = new Button("Veldenbeheer");
        btn2.getStyleClass().add("HuidigKnop");
        btn2.setMinWidth(190);
        btn2.getStyleClass().add("Knoppen");

        Button btn3 = new Button("Wedstrijden");
        btn3.getStyleClass().add("HuidigKnop");
        btn3.setMinWidth(450);
        btn3.getStyleClass().add("Knoppen");

        Button btn4 = new Button("Trainingen");
        btn4.setMinWidth(450);
        btn4.getStyleClass().add("Knoppen");

        btn4.setOnAction(e -> {
            VeldenPaginaTrainingen veldenPage = new VeldenPaginaTrainingen(stage3);
            Scene veldenScene = new Scene(veldenPage.getRoot4(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage3.setScene(veldenScene);

            veldenScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
        });


        TextField Linkstf1 = new TextField();
        Linkstf1.setPromptText("Team id");
        Linkstf1.setTranslateX(10);
        Linkstf1.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf2 = new TextField();
        Linkstf2.setPromptText("Tegenstander");
        Linkstf2.setTranslateX(10);
        Linkstf2.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf3 = new TextField();
        Linkstf3.setPromptText("WedstrijdID:");
        Linkstf3.setTranslateX(30);
        Linkstf3.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf4 = new TextField();
        Linkstf4.setPromptText("Datum:");
        Linkstf4.setTranslateX(10);
        Linkstf4.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf5 = new TextField();
        Linkstf5.setPromptText("Veld");
        Linkstf5.setTranslateX(110);
        Linkstf5.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        Button btnlinks1 = new Button("Dit wedstrijd verwijderen");
        btnlinks1.setTranslateX(0);
        btnlinks1.setMaxWidth(250);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        Button btnlinks2 = new Button("Opslaan");
        btnlinks2.setTranslateX(65);
        btnlinks2.setMaxWidth(250);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());


        GridPane pane = new GridPane();

        pane.setVgap(45);

        pane.setId("pane");
        pane.setMinWidth(380);
        pane.setMinHeight(500);

        pane.add(btn1, 0, 0);
        pane.add(btn2, 1, 0);

        pane.add(Linkstf1, 0, 1);

        pane.add(Linkstf2, 1, 1);

        pane.add(Linkstf3, 0, 2);

        pane.add(Linkstf4, 1, 2);

        pane.add(Linkstf5, 0, 3);
        GridPane.setColumnSpan(Linkstf5, 2);


        pane.add(btnlinks1, 0, 4);
        GridPane.setColumnSpan(btnlinks1, 2);

        pane.add(btnlinks2, 0, 5);
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
        //  pane2.setPrefWidth(380);
        pane2.setMinHeight(220);



        Button btnlinks8 = new Button("Wedstrijd toevoegen");
        btnlinks8.setId("ToevoegKnop");
        btnlinks8.setMinWidth(300);
        btnlinks8.setMinHeight(50);
        btnlinks8.setTranslateY(75);
        btnlinks8.setMinWidth(300);


        GridPane.setHalignment(btnlinks8, Pos.CENTER.getHpos());
        btnlinks8.setOnAction(e -> {
            VeldenPaginaWedstrijdenToevoegScherm ToevoegScherm = new VeldenPaginaWedstrijdenToevoegScherm(stage3);
            Scene ToevoegScene = new Scene(ToevoegScherm.getRoot7(), 800, 600);  // Getting the root from LedenPaginaTeams
            stage3.setScene(ToevoegScene);

            ToevoegScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
            ToevoegScene.getStylesheets().add(getClass().getResource("/stylesheets/inlogpagina.css").toExternalForm());

        });



        ColumnConstraints col = new ColumnConstraints();
        col.setHalignment(HPos.CENTER);
        col.setPrefWidth(380);
        pane2.getColumnConstraints().add(col);


        pane2.add(btnlinks8, 0, 0);
        GridPane.setColumnSpan(btnlinks8, 2);


        GridPane Wedstrijdtable = new GridPane();
        Wedstrijdtable.setTranslateY(-670);
        Wedstrijdtable.setTranslateX(340);
        Wedstrijdtable.setHgap(0);
        Wedstrijdtable.setVgap(0);
        Wedstrijdtable.setAlignment(Pos.CENTER);


//  Headers
        String[] headers = {"TeamID", "Tegenstander", "WedstrijdID", "Datum", "Veld"};
        VBox vbox = null;
        for (int col2 = 0; col2 < headers.length; col2++) {
            Label headerLabel = new Label(headers[col2]);
            headerLabel.setMinWidth(150);
            headerLabel.setMinHeight(35);
            headerLabel.getStyleClass().add("MenuItemText");
            headerLabel.setAlignment(Pos.CENTER);
            Wedstrijdtable.add(headerLabel, col2, 0);

              if (col2 == 3) {
                 headerLabel.setTranslateX(-450);
             }
              else if (col2 == 4) {
                  headerLabel.setTranslateX(-450);
              }
              }


//  Haal Wedstrijden op en voeg ze toe
            List<DatabaseManager.Wedstrijd> wedstrijden = DatabaseManager.getWedstrijden();
            int row = 1;

            for (DatabaseManager.Wedstrijd wedstrijd : wedstrijden) {
                HBox rowBox = new HBox();
                rowBox.setSpacing(0);
                rowBox.setPadding(new Insets(0));
                rowBox.setAlignment(Pos.CENTER_LEFT);
                rowBox.setStyle("-fx-background-color: transparent;");

                Label TeamIDLabel = new Label(String.valueOf(wedstrijd.TeamID));
                Label Team2Label = new Label(String.valueOf(wedstrijd.Team2Naam));
                Label WedstrijdIDLabel = new Label(String.valueOf(wedstrijd.WedstrijdID));
                Label Datum = new Label(String.valueOf(wedstrijd.WedstrijdDatumTijd));
                Label Veld = new Label(wedstrijd.Veld);


                TeamIDLabel.getStyleClass().add("cell-label");
                Team2Label.getStyleClass().add("cell-label");
                WedstrijdIDLabel.getStyleClass().add("cell-label");
                Datum.getStyleClass().add("cell-label");
                Veld.getStyleClass().add("cell-label");


                rowBox.setOnMouseClicked(event -> {
                    selectedWedstrijd = wedstrijd;
                    Linkstf1.setText(String.valueOf(wedstrijd.TeamID));
                    Linkstf2.setText(String.valueOf(wedstrijd.Team2Naam));
                    Linkstf3.setText(String.valueOf(wedstrijd.WedstrijdID));
                    Linkstf4.setText(String.valueOf(wedstrijd.WedstrijdDatumTijd));
                    Linkstf5.setText(String.valueOf(wedstrijd.Veld));


                    for (Node node : Wedstrijdtable.getChildren()) {
                        if (node instanceof HBox) {
                            node.setStyle("-fx-background-color: transparent;");
                        }
                    }
                    rowBox.setStyle("-fx-background-color: #b3d9ff;");
                });

                Button deleteButton = new Button("Delete");
                deleteButton.getStyleClass().add("delete-button");
                deleteButton.setOnAction(event -> {
                    if (DatabaseManager.deleteTraining(wedstrijd.WedstrijdID)) {
                        System.out.println("Wedstrijd succesvol verwijderd!");
                        Wedstrijdtable.getChildren().remove(rowBox);
                    } else {
                        System.out.println("Fout bij verwijderen van wedstrijd.");
                    }
                });


                rowBox.getChildren().addAll(TeamIDLabel, Team2Label, WedstrijdIDLabel, Datum, Veld, deleteButton);
                Wedstrijdtable.add(rowBox, 0, row, 3, 1);
                row++;

                btnlinks1.setMinWidth(250);
                GridPane.setHalignment(btnlinks1, HPos.CENTER);
                btnlinks1.setOnAction(e -> {
                    if (DatabaseManager.deleteWedstrijd(wedstrijd.WedstrijdID)) {
                        System.out.println("Wedstrijd succesvol verwijderd!");
                        Wedstrijdtable.getChildren().remove(rowBox);
                    } else {
                        System.out.println("Fout bij verwijderen van Wedstrijd.");
                    }
                });
            }

            btnlinks2.setOnAction(event -> {
                if (selectedWedstrijd != null) {
                }

                selectedWedstrijd.TeamID = Integer.parseInt(Linkstf1.getText());
                selectedWedstrijd.Team2Naam = Linkstf2.getText();
                selectedWedstrijd.WedstrijdID = Integer.parseInt(Linkstf3.getText());
                selectedWedstrijd.WedstrijdDatumTijd = Linkstf4.getText();
                selectedWedstrijd.Veld = Linkstf5.getText();


                boolean success = DatabaseManager.updateWedstrijd(selectedWedstrijd);
                if (success) {
                    System.out.println("Wedstrijd succesvol bijgewerkt!");
                } else {
                    System.out.println("Fout bij updaten van de Wedstrijd.");
                }
            });


            Button btnmenu = new Button("Refresh");
            btnmenu.setMinHeight(35);
            btnmenu.setMinWidth(152);
            btnmenu.setTranslateY(-735);
            btnmenu.setTranslateX(1130);
            btnmenu.setOnAction(event2 -> {

                Wedstrijdtable.getChildren().clear();

                String[] headers2 = {"TeamID", "Tegenstander", "WedstrijdID", "Datum", "Veld"};
                for (int col3 = 0; col3 < headers.length; col3++) {
                    Label headerLabel2 = new Label(headers2[col3]);
                    headerLabel2.setMinWidth(150);
                    headerLabel2.setMinHeight(35);
                    headerLabel2.getStyleClass().add("MenuItemText");
                    headerLabel2.setAlignment(Pos.CENTER);
                    Wedstrijdtable.add(headerLabel2, col3, 0);


//  Haal wedstrijden op en voeg ze toe
                    List<DatabaseManager.Wedstrijd> wedstrijden2 = DatabaseManager.getWedstrijden();
                    int row2 = 1;

                    for (DatabaseManager.Wedstrijd wedstrijd : wedstrijden2) {
                        HBox rowBox = new HBox();
                        rowBox.setSpacing(0);
                        rowBox.setPadding(new Insets(0));
                        rowBox.setAlignment(Pos.CENTER_LEFT);
                        rowBox.setStyle("-fx-background-color: transparent;");

                        Label TeamIDLabel = new Label(String.valueOf(wedstrijd.TeamID));  // Converts int to String
                        Label Team2Label = new Label(String.valueOf(wedstrijd.Team2Naam));  // Converts int to String
                        Label WedstrijdIDLabel = new Label(String.valueOf(wedstrijd.WedstrijdID));
                        Label Datum = new Label(String.valueOf(wedstrijd.WedstrijdDatumTijd));  // If Datum is a Date, format it properly
                        Label Veld = new Label(wedstrijd.Veld);  // Assuming Veld is already a String


                        TeamIDLabel.getStyleClass().add("cell-label");
                        Team2Label.getStyleClass().add("cell-label");
                        WedstrijdIDLabel.getStyleClass().add("cell-label");
                        Datum.getStyleClass().add("cell-label");
                        Veld.getStyleClass().add("cell-label");


                        rowBox.setOnMouseClicked(event3 -> {
                            selectedWedstrijd = wedstrijd;
                            Linkstf1.setText(String.valueOf(wedstrijd.TeamID));
                            Linkstf2.setText(String.valueOf(wedstrijd.Team2Naam));
                            Linkstf3.setText(String.valueOf(wedstrijd.WedstrijdID));
                            Linkstf4.setText(String.valueOf(wedstrijd.WedstrijdDatumTijd));
                            Linkstf5.setText(String.valueOf(wedstrijd.Veld));


                            for (Node node : Wedstrijdtable.getChildren()) {
                                if (node instanceof HBox) {
                                    node.setStyle("-fx-background-color: transparent;");
                                }
                            }
                            rowBox.setStyle("-fx-background-color: #b3d9ff;");
                        });

                        Button deleteButton = new Button("Delete");
                        deleteButton.getStyleClass().add("delete-button");
                        deleteButton.setOnAction(event3 -> {
                            if (DatabaseManager.deleteWedstrijd(wedstrijd.WedstrijdID)) {
                                System.out.println("Wedstrijd succesvol verwijderd!");
                                Wedstrijdtable.getChildren().remove(rowBox);
                            } else {
                                System.out.println("Fout bij verwijderen van Wedstrijd.");
                            }
                        });


                        rowBox.getChildren().addAll(TeamIDLabel, Team2Label, WedstrijdIDLabel, Datum, Veld, deleteButton);
                        Wedstrijdtable.add(rowBox, 0, row2, 3, 1);
                        row2++;
                    }

                }
            });
            vbox = new VBox();
            vbox.getChildren().addAll(hbox, pane2, Wedstrijdtable, btnmenu);

        return vbox;
    }
}
