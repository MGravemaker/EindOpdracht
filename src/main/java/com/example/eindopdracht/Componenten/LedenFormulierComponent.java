package com.example.eindopdracht.Componenten;

import com.example.eindopdracht.AndereSchermen.DatabaseManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.function.Consumer;

public class LedenFormulierComponent {

    private final TextField voornaamField = new TextField();
    private final TextField achternaamField = new TextField();
    private final TextField emailField = new TextField();
    private final TextField telefoonField = new TextField();
    private final TextField geboortedatumField = new TextField();
    private final TextField geslachtField = new TextField();
    private final TextField teamField = new TextField();
    private final TextField rolField = new TextField();
    private final Button opslaanKnop = new Button("Opslaan");
    private final Button verwijderKnop = new Button("Verwijderen");

    private DatabaseManager.Lid geselecteerdLid;

    public GridPane getForm(Consumer<DatabaseManager.Lid> onSave, Consumer<DatabaseManager.Lid> onDelete) {
        GridPane pane = new GridPane();
        pane.setVgap(15);
        pane.setAlignment(Pos.CENTER_LEFT);

        configureField(voornaamField, "Voornaam");
        configureField(achternaamField, "Achternaam");
        configureField(emailField, "Email");
        configureField(telefoonField, "Telefoonnummer");
        configureField(geboortedatumField, "Geboortedatum");
        configureField(geslachtField, "Geslacht");
        configureField(teamField, "Team");
        configureField(rolField, "Rol");

        pane.add(voornaamField, 0, 0);
        pane.add(achternaamField, 1, 0);
        pane.add(emailField, 0, 1);
        pane.add(telefoonField, 1, 1);
        pane.add(geboortedatumField, 0, 2);
        pane.add(geslachtField, 1, 2);
        pane.add(teamField, 0, 3);
        pane.add(rolField, 1, 3);
        pane.add(opslaanKnop, 0, 4);
        pane.add(verwijderKnop, 1, 4);

        opslaanKnop.setOnAction(e -> {
            if (geselecteerdLid != null) {
                vulLidIn(geselecteerdLid);
                onSave.accept(geselecteerdLid);
            }
        });

        verwijderKnop.setOnAction(e -> {
            if (geselecteerdLid != null) {
                onDelete.accept(geselecteerdLid);
            }
        });

        return pane;
    }

    private void configureField(TextField field, String prompt) {
        field.setPromptText(prompt);
        field.setMaxWidth(150);
    }

    public void vulFormulierMetLid(DatabaseManager.Lid lid) {
        geselecteerdLid = lid;
        voornaamField.setText(lid.voornaam);
        achternaamField.setText(lid.achternaam);
        emailField.setText(lid.email);
        telefoonField.setText(lid.telefoonnummer);
        geboortedatumField.setText(lid.geboortedatum);
        geslachtField.setText(lid.geslacht);
        teamField.setText(lid.TeamID);
        rolField.setText(lid.rol);
    }

    private void vulLidIn(DatabaseManager.Lid lid) {
        lid.voornaam = voornaamField.getText();
        lid.achternaam = achternaamField.getText();
        lid.email = emailField.getText();
        lid.telefoonnummer = telefoonField.getText();
        lid.geboortedatum = geboortedatumField.getText();
        lid.geslacht = geslachtField.getText();
        lid.TeamID = teamField.getText();
        lid.rol = rolField.getText();
    }
}
