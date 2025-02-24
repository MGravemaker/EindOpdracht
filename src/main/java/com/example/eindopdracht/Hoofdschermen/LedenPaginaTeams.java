package com.example.eindopdracht.Hoofdschermen;

import com.example.eindopdracht.AndereSchermen.DatabaseManager;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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

        ListView<String> spelersListView = new ListView<>();
        spelersListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // Allow multiple selection

        // Get player names from database and populate ListView
        List<String> spelers = DatabaseManager.getLidnamen();
        ObservableList<String> observableSpelers = FXCollections.observableArrayList(spelers);
        spelersListView.setItems(observableSpelers);

        // Set max size
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

        // Left panel GridPane Layout
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
        GridPane teamsTable = new GridPane();
        teamsTable.setTranslateY(-670);
        teamsTable.setTranslateX(190);
        teamsTable.setHgap(0);
        teamsTable.setVgap(0);
        teamsTable.setAlignment(Pos.CENTER);


        // ✅ Headers
        String[] headers = {"Teamnaam", "Activiteit"};
        for (int col2 = 0; col2 < headers.length; col2++) {
            Label headerLabel = new Label(headers[col2]);
            headerLabel.setMinWidth(375);
            headerLabel.setMinHeight(35);
            headerLabel.getStyleClass().add("MenuItemText");
            headerLabel.setAlignment(Pos.CENTER);
            teamsTable.add(headerLabel, col2, 0);
        }

        // ✅ Haal teams op en voeg ze toe
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
        btnmenu.setTranslateY(-825);
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

            // ✅ Haal teams op en voeg ze toe
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
                } else {
                    System.out.println("Fout bij updaten van team.");
                }
            }
        });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox, pane2, hbox3,teamsTable, btnmenu);
        return vbox;
    }
}