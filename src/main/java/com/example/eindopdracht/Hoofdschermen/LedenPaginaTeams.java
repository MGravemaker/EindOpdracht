package com.example.eindopdracht.Hoofdschermen;

import com.example.eindopdracht.AndereSchermen.DatabaseManager;
import com.example.eindopdracht.AndereSchermen.LedenPaginaTeamsToevoegScherm;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class LedenPaginaTeams extends Application {
    private static DatabaseManager.Team selectedTeam;
    private Stage stage;


    public static void main(String[] args) {

        launch(args);
    }

    public LedenPaginaTeams(Stage stage) {
        this.stage = stage;

    }

    public LedenPaginaTeams() {

    }

    @Override
    public void start(Stage stage) {

        this.stage = stage;

        Parent root = getRoot();


        Scene scene = new Scene(root, 1280, 720);

        stage.setScene(scene);
        stage.setTitle("LedenPaginaTeams");


        scene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());

        stage.setResizable(false);

        stage.show();
    }

    public Parent getRoot() {

        Button btn1 = new Button("Ledenbeheer");
        btn1.setMinWidth(190);
        btn1.getStyleClass().add("Knoppen");
        btn1.getStyleClass().add("HuidigKnop");
        btn1.setOnAction(e -> {
            LedenPaginaTeams ledenPage2 = new LedenPaginaTeams(stage);
            Scene veldenScene = new Scene(ledenPage2.getRoot(), 1280, 720);
            stage.setScene(veldenScene);

            veldenScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
        });

        Button btn2 = new Button("Veldenbeheer");
        btn2.setMinWidth(190);
        btn2.getStyleClass().add("Knoppen");
        btn2.setOnAction(e -> {
            VeldenPaginaWedstrijden veldenPage = new VeldenPaginaWedstrijden(stage);
            Scene veldenScene = new Scene(veldenPage.getRoot3(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage.setScene(veldenScene);  // Set the new scene

            veldenScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
        });

        Button btn3 = new Button("Teams");
        btn3.getStyleClass().add("HuidigKnop");
        btn3.setMinWidth(450);
        btn3.getStyleClass().add("Knoppen");
        btn3.setTranslateY(-190);

        Button btn4 = new Button("Leden");
        btn4.setMinWidth(450);
        btn4.getStyleClass().add("Knoppen");
        btn4.setTranslateY(-190);
        btn4.setOnAction(e -> {
            LedenPaginaLeden ledenPage = new LedenPaginaLeden(stage);
            Scene ledenScene = new Scene(ledenPage.getRoot2(), 1280, 720);
            stage.setScene(ledenScene);

            ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
        });

        TextField Linkstf1 = new TextField();
        Linkstf1.setPromptText("Team naam:");
        Linkstf1.setTranslateX(10);
        Linkstf1.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, HPos.CENTER);

        ListView<String> spelersListView = new ListView<>();
        spelersListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // Allow multiple selection


        List<String> spelers = DatabaseManager.getLidnamen();
        ObservableList<String> observableSpelers = FXCollections.observableArrayList(spelers);
        spelersListView.setItems(observableSpelers);


        spelersListView.setMaxHeight(100);
        spelersListView.setMaxWidth(250);
        GridPane.setHalignment(spelersListView, HPos.CENTER);


        ComboBox<String> activiteitComboBox = new ComboBox<>();
        activiteitComboBox.getItems().addAll("ACTIEF", "NONACTIEF");
        activiteitComboBox.setValue("ACTIEF"); // Default value
        activiteitComboBox.setMinWidth(250);
        activiteitComboBox.setMinHeight(50);
        GridPane.setHalignment(activiteitComboBox, HPos.CENTER);

        Button btnlinks5 = new Button("Dit team verwijderen");
        btnlinks5.setMinWidth(250);
        GridPane.setHalignment(btnlinks5, HPos.CENTER);


        Button btnlinks6 = new Button("Opslaan");
        btnlinks6.setMinWidth(250);
        GridPane.setHalignment(btnlinks6, HPos.CENTER);
        btnlinks6.setOnAction(e -> {});


        GridPane pane = new GridPane();
        pane.setVgap(20);
        pane.setId("pane");
        pane.setMinWidth(380);
        pane.setMinHeight(430);

        pane.add(btn1, 0, 0);
        pane.add(btn2, 1, 0);
        pane.add(Linkstf1, 0, 1);
        GridPane.setColumnSpan(Linkstf1, 2);
        pane.add(spelersListView, 0, 2);
        GridPane.setColumnSpan(spelersListView, 2);
        pane.add(activiteitComboBox, 0, 3);
        GridPane.setColumnSpan(activiteitComboBox, 2);
        pane.add(btnlinks5, 0, 4);
        GridPane.setColumnSpan(btnlinks5, 2);
        pane.add(btnlinks6, 0, 5);
        GridPane.setColumnSpan(btnlinks6, 2);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(pane, btn3, btn4);


        GridPane pane2 = new GridPane();
        pane2.setVgap(25);
        pane2.setId("pane2");
        pane2.setMaxWidth(381.5);
        pane2.setMinHeight(290);

        Button btnlinks8 = new Button("Team toevoegen");
        btnlinks8.setId("ToevoegKnop");
        btnlinks8.setTranslateY(110);
        btnlinks8.setMinWidth(300);
        btnlinks8.setMinHeight(50);
        GridPane.setHalignment(btnlinks8, HPos.CENTER);
        btnlinks8.setOnAction(e -> {
            LedenPaginaTeamsToevoegScherm ToevoegScherm = new LedenPaginaTeamsToevoegScherm(stage);

            Scene ToevoegScene = new Scene(ToevoegScherm.getRoot5(), 800, 600);
            stage.setScene(ToevoegScene);

            ToevoegScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
            ToevoegScene.getStylesheets().add(getClass().getResource("/stylesheets/inlogpagina.css").toExternalForm());

        });


        ColumnConstraints col = new ColumnConstraints();
        col.setHalignment(HPos.CENTER);
        col.setPrefWidth(380);
        pane2.getColumnConstraints().add(col);

        pane2.add(btnlinks8, 0, 0);
        GridPane.setColumnSpan(btnlinks8, 2);

        HBox hbox3 = new HBox();
        GridPane teamsTable = new GridPane();
        teamsTable.setTranslateY(-670);
        teamsTable.setTranslateX(190);
        teamsTable.setHgap(0);
        teamsTable.setVgap(0);
        teamsTable.setAlignment(Pos.CENTER);


        //  Headers
        String[] headers = {"Teamnaam", "Activiteit"};
        for (int col2 = 0; col2 < headers.length; col2++) {
            Label headerLabel = new Label(headers[col2]);
            headerLabel.setMinWidth(375);
            headerLabel.setMinHeight(35);
            headerLabel.getStyleClass().add("MenuItemText");
            headerLabel.setAlignment(Pos.CENTER);
            teamsTable.add(headerLabel, col2, 0);
        }

        // Haal teams op en voeg ze toe
        List<DatabaseManager.Team> teams = DatabaseManager.getTeams();
        int row = 1;

        for (DatabaseManager.Team team : teams) {
            HBox rowBox = new HBox();
            rowBox.setSpacing(0);
            rowBox.setPadding(new Insets(0));
            rowBox.setAlignment(Pos.CENTER_LEFT);
            rowBox.setStyle("-fx-background-color: transparent;");

            Label teamNaamLabel = new Label(team.teamNaam);
            Label activiteitLabel = new Label(team.activiteit.name());


            teamNaamLabel.getStyleClass().add("cell-label2");
            activiteitLabel.getStyleClass().add("cell-label2");

            rowBox.setOnMouseClicked(event -> {
                selectedTeam = team;
                Linkstf1.setText(team.teamNaam);
                activiteitComboBox.setValue(team.activiteit.name());

                for (Node node : teamsTable.getChildren()) {
                    if (node instanceof HBox) {
                        node.setStyle("-fx-background-color: transparent;");
                    }
                }
                rowBox.setStyle("-fx-background-color: #b3d9ff;");
            });

            Button deleteButton = new Button("Delete");
            deleteButton.getStyleClass().add("delete-button");
            deleteButton.setOnAction(event -> {
                if (DatabaseManager.deleteTeam(team.teamID)) {
                    System.out.println("Team succesvol verwijderd!");
                    teamsTable.getChildren().remove(rowBox);
                } else {
                    System.out.println("Fout bij verwijderen van team.");
                }
            });

            rowBox.getChildren().addAll(teamNaamLabel, activiteitLabel, deleteButton);
            teamsTable.add(rowBox, 0, row, 3, 1);
            row++;

            btnlinks5.setMinWidth(250);
            GridPane.setHalignment(btnlinks5, HPos.CENTER);
            btnlinks5.setOnAction(e -> {
                if (DatabaseManager.deleteTeam(team.teamID)) {
                    System.out.println("Team succesvol verwijderd!");
                    teamsTable.getChildren().remove(rowBox);
                } else {
                    System.out.println("Fout bij verwijderen van team.");
                }
            });
        }

        Button btnmenu = new Button("Refresh");
        btnmenu.setMinHeight(35);
        btnmenu.setMinWidth(150);
        btnmenu.setTranslateY(-795);
        btnmenu.setTranslateX(1130);
        btnmenu.setOnAction(event -> {

            teamsTable.getChildren().clear();

            String[] headers2 = {"Teamnaam", "Activiteit"};
            for (int col2 = 0; col2 < headers2.length; col2++) {
                Label headerLabel = new Label(headers2[col2]);
                headerLabel.setMinWidth(375);
                headerLabel.setMinHeight(35);
                headerLabel.getStyleClass().add("MenuItemText");
                headerLabel.setAlignment(Pos.CENTER);
                teamsTable.add(headerLabel, col2, 0);
            }

            //  Haal teams op en voeg ze toe
            List<DatabaseManager.Team> teams2 = DatabaseManager.getTeams();
            int row2 = 1;

            for (DatabaseManager.Team team : teams2) {
                HBox rowBox = new HBox();
                rowBox.setSpacing(0);
                rowBox.setPadding(new Insets(0));
                rowBox.setAlignment(Pos.CENTER_LEFT);
                rowBox.setStyle("-fx-background-color: transparent;");

                Label teamNaamLabel = new Label(team.teamNaam);
                Label activiteitLabel = new Label(team.activiteit.name());


                teamNaamLabel.getStyleClass().add("cell-label2");
                activiteitLabel.getStyleClass().add("cell-label2");

                rowBox.setOnMouseClicked(event2 -> {
                    selectedTeam = team;
                    Linkstf1.setText(team.teamNaam);
                    activiteitComboBox.setValue(team.activiteit.name());

                    for (Node node : teamsTable.getChildren()) {
                        if (node instanceof HBox) {
                            node.setStyle("-fx-background-color: transparent;");
                        }
                    }
                    rowBox.setStyle("-fx-background-color: #b3d9ff;");
                });

                Button deleteButton = new Button("Delete");
                deleteButton.getStyleClass().add("delete-button");
                deleteButton.setOnAction(event2 -> {
                    if (DatabaseManager.deleteTeam(team.teamID)) {
                        System.out.println("Team succesvol verwijderd!");
                        teamsTable.getChildren().remove(rowBox);
                    } else {
                        System.out.println("Fout bij verwijderen van team.");
                    }
                });

                rowBox.getChildren().addAll(teamNaamLabel, activiteitLabel, deleteButton);
                teamsTable.add(rowBox, 0, row2, 3, 1);
                row2++;
            }
        });


        btnlinks6.setOnAction(event -> {
            if (selectedTeam != null) {
                selectedTeam.teamNaam = Linkstf1.getText();
                selectedTeam.activiteit = DatabaseManager.Activiteit.valueOf(activiteitComboBox.getValue());
                boolean success = DatabaseManager.updateTeam(selectedTeam);
                if (success) {
                    System.out.println("Team succesvol bijgewerkt!");

                    // Refresh de teamsTable
                    teamsTable.getChildren().clear();

                    String[] headers2 = {"Teamnaam", "Activiteit"};
                    for (int col2 = 0; col2 < headers2.length; col2++) {
                        Label headerLabel = new Label(headers2[col2]);
                        headerLabel.setMinWidth(375);
                        headerLabel.setMinHeight(35);
                        headerLabel.getStyleClass().add("MenuItemText");
                        headerLabel.setAlignment(Pos.CENTER);
                        teamsTable.add(headerLabel, col2, 0);
                    }

                    List<DatabaseManager.Team> teams2 = DatabaseManager.getTeams();
                    int row2 = 1;

                    for (DatabaseManager.Team team : teams2) {
                        HBox rowBox = new HBox();
                        rowBox.setSpacing(0);
                        rowBox.setPadding(new Insets(0));
                        rowBox.setAlignment(Pos.CENTER_LEFT);
                        rowBox.setStyle("-fx-background-color: transparent;");

                        Label teamNaamLabel = new Label(team.teamNaam);
                        Label activiteitLabel = new Label(team.activiteit.name());

                        teamNaamLabel.getStyleClass().add("cell-label2");
                        activiteitLabel.getStyleClass().add("cell-label2");

                        rowBox.setOnMouseClicked(event2 -> {
                            selectedTeam = team;
                            Linkstf1.setText(team.teamNaam);
                            activiteitComboBox.setValue(team.activiteit.name());

                            for (Node node : teamsTable.getChildren()) {
                                if (node instanceof HBox) {
                                    node.setStyle("-fx-background-color: transparent;");
                                }
                            }
                            rowBox.setStyle("-fx-background-color: #b3d9ff;");
                        });

                        teamsTable.add(rowBox, 0, row2, 2, 1);
                        row2++;
                    }
                } else {
                    System.out.println("Fout bij updaten van team.");
                }
            } else {
                System.out.println("Geen team geselecteerd om op te slaan.");
            }
        });


        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox, pane2, hbox3,teamsTable);
        return vbox;
    }
}