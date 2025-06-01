package com.example.eindopdracht.Componenten;

import com.example.eindopdracht.AndereSchermen.DatabaseManager;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.function.Consumer;

public class TrainingFormulierComponent {

    private final TextField teamIdField = new TextField();
    private final TextField trainingIdField = new TextField();
    private final TextField datumField = new TextField();
    private final TextField veldField = new TextField();

    private final Button opslaanKnop = new Button("Opslaan");
    private final Button verwijderKnop = new Button("Verwijderen");

    private DatabaseManager.Training geselecteerdeTraining;

    public GridPane getForm(Consumer<DatabaseManager.Training> onSave, Consumer<DatabaseManager.Training> onDelete) {
        GridPane pane = new GridPane();
        pane.setVgap(30);
        pane.setId("pane");
        pane.setMinWidth(380);
        pane.setMinHeight(450);
        pane.setAlignment(Pos.CENTER_LEFT);

        configure(teamIdField, "TeamID");
        configure(trainingIdField, "TrainingID");
        configure(datumField, "Datum");
        configure(veldField, "Veld");

        opslaanKnop.setMinWidth(250);
        verwijderKnop.setMinWidth(250);
        GridPane.setHalignment(opslaanKnop, HPos.CENTER);
        GridPane.setHalignment(verwijderKnop, HPos.CENTER);

        opslaanKnop.setOnAction(e -> {
            if (geselecteerdeTraining != null) {
                vulTrainingIn(geselecteerdeTraining);
                onSave.accept(geselecteerdeTraining);
            }
        });

        verwijderKnop.setOnAction(e -> {
            if (geselecteerdeTraining != null) {
                onDelete.accept(geselecteerdeTraining);
            }
        });

        pane.add(teamIdField, 0, 0);
        pane.add(trainingIdField, 0, 1);
        pane.add(datumField, 0, 2);
        pane.add(veldField, 0, 3);
        pane.add(verwijderKnop, 0, 4);
        pane.add(opslaanKnop, 0, 5);

        return pane;
    }

    private void configure(TextField field, String prompt) {
        field.setPromptText(prompt);
        field.setMaxWidth(150);
        GridPane.setHalignment(field, HPos.CENTER);
    }

    public void vulFormulierMetTraining(DatabaseManager.Training training) {
        geselecteerdeTraining = training;
        teamIdField.setText(String.valueOf(training.TeamID));
        trainingIdField.setText(String.valueOf(training.TrainingID));
        datumField.setText(training.TrainingDatumTijd);
        veldField.setText(training.Veld);
    }

    private void vulTrainingIn(DatabaseManager.Training training) {
        training.TeamID = Integer.parseInt(teamIdField.getText());
        training.TrainingID = Integer.parseInt(trainingIdField.getText());
        training.TrainingDatumTijd = datumField.getText();
        training.Veld = veldField.getText();
    }
}
