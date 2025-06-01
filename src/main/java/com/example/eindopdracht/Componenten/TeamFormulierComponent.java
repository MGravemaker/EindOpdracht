package com.example.eindopdracht.Componenten;

import com.example.eindopdracht.AndereSchermen.DatabaseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.List;
import java.util.function.Consumer;

public class TeamFormulierComponent {

    private final TextField teamNaamField = new TextField();
    private final ComboBox<String> activiteitBox = new ComboBox<>();
    private final ListView<String> spelersList = new ListView<>();

    private final Button opslaanKnop = new Button("Opslaan");
    private final Button verwijderKnop = new Button("Verwijderen");

    private DatabaseManager.Team geselecteerdTeam;

    public GridPane getForm(Consumer<DatabaseManager.Team> onSave, Consumer<DatabaseManager.Team> onDelete) {
        GridPane pane = new GridPane();
        pane.setVgap(15);
        pane.setId("pane");
        pane.setMinWidth(380);
        pane.setMinHeight(450);
        pane.setAlignment(Pos.CENTER_LEFT);

        teamNaamField.setPromptText("Team naam");
        teamNaamField.setMaxWidth(150);
        GridPane.setHalignment(teamNaamField, HPos.CENTER);

        activiteitBox.getItems().addAll("ACTIEF", "NONACTIEF");
        activiteitBox.setValue("ACTIEF");
        activiteitBox.setMinWidth(250);
        activiteitBox.setMinHeight(50);
        GridPane.setHalignment(activiteitBox, HPos.CENTER);

        spelersList.setMaxHeight(100);
        spelersList.setMaxWidth(250);
        spelersList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        List<String> spelers = DatabaseManager.getLidnamen();
        ObservableList<String> observableSpelers = FXCollections.observableArrayList(spelers);
        spelersList.setItems(observableSpelers);

        opslaanKnop.setMinWidth(250);
        verwijderKnop.setMinWidth(250);
        GridPane.setHalignment(opslaanKnop, HPos.CENTER);
        GridPane.setHalignment(verwijderKnop, HPos.CENTER);

        opslaanKnop.setOnAction(e -> {
            if (geselecteerdTeam != null) {
                vulTeamIn(geselecteerdTeam);
                onSave.accept(geselecteerdTeam);
            }
        });

        verwijderKnop.setOnAction(e -> {
            if (geselecteerdTeam != null) {
                onDelete.accept(geselecteerdTeam);
            }
        });

        pane.add(teamNaamField, 0, 0, 2, 1);
        pane.add(spelersList, 0, 1, 2, 1);
        pane.add(activiteitBox, 0, 2, 2, 1);
        pane.add(verwijderKnop, 0, 3, 2, 1);
        pane.add(opslaanKnop, 0, 4, 2, 1);

        return pane;
    }

    public void vulFormulierMetTeam(DatabaseManager.Team team) {
        geselecteerdTeam = team;
        teamNaamField.setText(team.teamNaam);
        activiteitBox.setValue(team.activiteit.name());
        // Eventueel hier ook spelers selecteren als je die info hebt
    }

    private void vulTeamIn(DatabaseManager.Team team) {
        team.teamNaam = teamNaamField.getText();
        team.activiteit = DatabaseManager.Activiteit.valueOf(activiteitBox.getValue());
        // Eventueel team.spelers = spelersList.getSelectionModel().getSelectedItems()
    }
}
