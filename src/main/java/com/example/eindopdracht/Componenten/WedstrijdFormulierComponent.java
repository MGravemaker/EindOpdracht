package com.example.eindopdracht.Componenten;

import com.example.eindopdracht.AndereSchermen.DatabaseManager;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.function.Consumer;

public class WedstrijdFormulierComponent {

    private final TextField teamIdField = new TextField();
    private final TextField tegenstanderField = new TextField();
    private final TextField wedstrijdIdField = new TextField();
    private final TextField datumField = new TextField();
    private final TextField veldField = new TextField();

    private final Button opslaanKnop = new Button("Opslaan");
    private final Button verwijderKnop = new Button("Verwijderen");

    private DatabaseManager.Wedstrijd geselecteerdWedstrijd;

    public GridPane getForm(Consumer<DatabaseManager.Wedstrijd> onSave, Consumer<DatabaseManager.Wedstrijd> onDelete) {
        GridPane pane = new GridPane();
        pane.setVgap(30);
        pane.setId("pane");
        pane.setMinWidth(380);
        pane.setMinHeight(450);
        pane.setAlignment(Pos.CENTER_LEFT);

        configure(teamIdField, "Team ID");
        configure(tegenstanderField, "Tegenstander");
        configure(wedstrijdIdField, "Wedstrijd ID");
        configure(datumField, "Datum");
        configure(veldField, "Veld");

        opslaanKnop.setMinWidth(250);
        verwijderKnop.setMinWidth(250);
        GridPane.setHalignment(opslaanKnop, HPos.CENTER);
        GridPane.setHalignment(verwijderKnop, HPos.CENTER);

        opslaanKnop.setOnAction(e -> {
            if (geselecteerdWedstrijd != null) {
                vulWedstrijdIn(geselecteerdWedstrijd);
                onSave.accept(geselecteerdWedstrijd);
            }
        });

        verwijderKnop.setOnAction(e -> {
            if (geselecteerdWedstrijd != null) {
                onDelete.accept(geselecteerdWedstrijd);
            }
        });

        pane.add(teamIdField, 0, 0);
        pane.add(tegenstanderField, 0, 1);
        pane.add(wedstrijdIdField, 0, 2);
        pane.add(datumField, 0, 3);
        pane.add(veldField, 0, 4);
        pane.add(verwijderKnop, 0, 5);
        pane.add(opslaanKnop, 0, 6);

        return pane;
    }

    private void configure(TextField field, String prompt) {
        field.setPromptText(prompt);
        field.setMaxWidth(150);
        GridPane.setHalignment(field, HPos.CENTER);
    }

    public void vulFormulierMetWedstrijd(DatabaseManager.Wedstrijd wedstrijd) {
        geselecteerdWedstrijd = wedstrijd;
        teamIdField.setText(String.valueOf(wedstrijd.TeamID));
        tegenstanderField.setText(wedstrijd.Team2Naam);
        wedstrijdIdField.setText(String.valueOf(wedstrijd.WedstrijdID));
        datumField.setText(wedstrijd.WedstrijdDatumTijd);
        veldField.setText(wedstrijd.Veld);
    }

    private void vulWedstrijdIn(DatabaseManager.Wedstrijd wedstrijd) {
        wedstrijd.TeamID = Integer.parseInt(teamIdField.getText());
        wedstrijd.Team2Naam = tegenstanderField.getText();
        wedstrijd.WedstrijdID = Integer.parseInt(wedstrijdIdField.getText());
        wedstrijd.WedstrijdDatumTijd = datumField.getText();
        wedstrijd.Veld = veldField.getText();
    }
}
