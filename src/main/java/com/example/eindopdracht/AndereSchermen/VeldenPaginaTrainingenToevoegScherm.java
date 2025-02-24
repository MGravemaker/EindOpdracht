package com.example.eindopdracht.AndereSchermen;

import com.example.eindopdracht.Hoofdschermen.LedenPaginaLeden;
import com.example.eindopdracht.Hoofdschermen.VeldenPaginaTrainingen;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class VeldenPaginaTrainingenToevoegScherm extends Application {
    private Stage stage8;

    public static void main(String[] args) {
        launch(args);
    }

    public VeldenPaginaTrainingenToevoegScherm(Stage stage8) {
        this.stage8 = stage8;
    }

    public VeldenPaginaTrainingenToevoegScherm() {

    }

    @Override
    public void start(Stage stage) {

        this.stage8 = stage;

        Parent root = getRoot8();

        Scene scene = new Scene(root, 800, 600);


        stage.setScene(scene);
        stage.setTitle("LedenPaginaTeamsToevoegScherm");

        scene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/stylesheets/inlogpagina.css").toExternalForm());

        stage.setResizable(false);

        stage.show();

    }
    public Parent getRoot8() {
        StackPane root = new StackPane();
        VBox vbox = new VBox(25);
        vbox.setAlignment(Pos.CENTER);

        Button btnterug = new Button();
        btnterug.setText("⬅");
        btnterug.setId("TerugKnop");
        btnterug.setMinWidth(50);
        btnterug.setMinHeight(50);
        btnterug.setTranslateY(-70);
        btnterug.setTranslateX(-350);
        btnterug.setOnAction(e -> {
            LedenPaginaLeden ledenPage = new LedenPaginaLeden(stage8);
            Scene ledenScene = new Scene(ledenPage.getRoot2(), 1280, 720);
            stage8.setScene(ledenScene);

            ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());
        });


            Text text = new Text("Training Toevoegen");
            text.setId("text1");
            text.setTranslateY(-135);

            ComboBox<String> TeamNaam = new ComboBox<>();
            TeamNaam.setMaxWidth(600);
            TeamNaam.setMinHeight(40);
            GridPane.setHalignment(TeamNaam, HPos.CENTER);

            List<String> teams = DatabaseManager.getTeamNames();


            if (!teams.isEmpty()) {
                TeamNaam.getItems().addAll(teams);
                TeamNaam.setValue(teams.get(0));
            } else {
                TeamNaam.setPromptText("Geen teams gevonden");
            }


            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            TextField dateTimeField = new TextField();
            dateTimeField.setPromptText("Kies datum en tijd (yyyy-MM-dd HH:mm)");
            dateTimeField.setMaxWidth(600);
            dateTimeField.setMinHeight(40);
            GridPane.setHalignment(dateTimeField, HPos.CENTER);


            ComboBox<Integer> veldComboBox = new ComboBox<>();
            for (int i = 1; i <= 8; i++) {
                veldComboBox.getItems().add(i);
            }
            veldComboBox.setPromptText("Kies een veld (1-8)");
            veldComboBox.setMinWidth(600);
            veldComboBox.setMinHeight(40);
            GridPane.setHalignment(veldComboBox, HPos.CENTER);


            Button btnOpslaan = new Button("Opslaan");
            GridPane.setHalignment(btnOpslaan, Pos.CENTER.getHpos());
            btnOpslaan.setMaxWidth(600);
            btnOpslaan.setMaxHeight(300);
            btnOpslaan.setMinHeight(50);
            btnOpslaan.setTranslateY(85);
            btnOpslaan.setOnAction(e -> {
                String selectedTeam = TeamNaam.getValue();
                String dateTimeInput = dateTimeField.getText();
                Integer selectedVeld = veldComboBox.getValue();

                if (selectedTeam == null || dateTimeInput.isEmpty() || selectedVeld == null) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Vul alle velden in!");
                    alert.showAndWait();
                    return;
                }

                try {
                    LocalDateTime selectedDateTime = LocalDateTime.parse(dateTimeInput, formatter);

                    int teamId = DatabaseManager.getTeamIdByName(selectedTeam);

                    boolean success = DatabaseManager.insertTraining(teamId, selectedDateTime, selectedVeld);

                    if (success) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Training succesvol toegevoegd!");
                        alert.showAndWait();

                        VeldenPaginaTrainingen VeldenPage = new VeldenPaginaTrainingen(stage8);
                        Scene ledenScene = new Scene(VeldenPage.getRoot4(), 1280, 720);
                        stage8.setScene(ledenScene);
                        ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/algemeen.css").toExternalForm());

                        System.out.println("Training toegevoegd");
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Fout bij opslaan van training!");
                        alert.showAndWait();
                    }
                } catch (Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Ongeldig invoer");
                    alert.showAndWait();
                }
            });


        GridPane pane = new GridPane();
        pane.setTranslateY(-25);
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(25);
        pane.setHgap(25);
        pane.setId("pane1");


        pane.add(TeamNaam, 0, 0);
        GridPane.setColumnSpan(TeamNaam, 2);
        pane.add(dateTimeField, 0, 1);
        GridPane.setColumnSpan(dateTimeField, 2);
        pane.add(veldComboBox, 0, 2);
        GridPane.setColumnSpan(veldComboBox, 2);



        vbox.getChildren().addAll(btnterug, text, pane, btnOpslaan);

        root.getChildren().add(vbox);

        return root;

    }
}

