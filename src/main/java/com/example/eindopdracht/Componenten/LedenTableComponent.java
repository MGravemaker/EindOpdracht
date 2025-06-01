package com.example.eindopdracht.Componenten;

import com.example.eindopdracht.AndereSchermen.DatabaseManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.List;
import java.util.function.Consumer;

public class LedenTableComponent {

    private GridPane ledenTable;

    public LedenTableComponent() {
        ledenTable = new GridPane();
        ledenTable.setTranslateY(-740);
        ledenTable.setTranslateX(190);
        ledenTable.setHgap(0);
        ledenTable.setVgap(0);
        ledenTable.setAlignment(Pos.CENTER);
    }

    public GridPane getTable(Consumer<DatabaseManager.Lid> onSelect, Consumer<DatabaseManager.Lid> onDelete) {
        updateTable(onSelect, onDelete);
        return ledenTable;
    }

    public void updateTable(Consumer<DatabaseManager.Lid> onSelect, Consumer<DatabaseManager.Lid> onDelete) {
        ledenTable.getChildren().clear();

        String[] headers = {"Voornaam", "Achternaam", "Teamnaam", "Rol", "Geboortedatum"};
        for (int col = 0; col < headers.length; col++) {
            Label headerLabel = new Label(headers[col]);
            headerLabel.setMinWidth(150);
            headerLabel.setMinHeight(35);
            headerLabel.getStyleClass().add("MenuItemText");
            headerLabel.setAlignment(Pos.CENTER);
            ledenTable.add(headerLabel, col, 0);
        }

        List<DatabaseManager.Lid> leden = DatabaseManager.getLeden();
        int rowIndex = 1;

        for (DatabaseManager.Lid lid : leden) {
            HBox rowBox = createRow(lid, onSelect, onDelete);
            ledenTable.add(rowBox, 0, rowIndex, 6, 1);
            rowIndex++;
        }
    }

    private HBox createRow(DatabaseManager.Lid lid, Consumer<DatabaseManager.Lid> onSelect, Consumer<DatabaseManager.Lid> onDelete) {
        HBox rowBox = new HBox();
        rowBox.setSpacing(0);
        rowBox.setPadding(new Insets(0));
        rowBox.setAlignment(Pos.CENTER_LEFT);
        rowBox.setStyle("-fx-background-color: transparent;");

        Label voornaamLabel = new Label(lid.voornaam);
        Label achternaamLabel = new Label(lid.achternaam);
        Label teamLabel = new Label(lid.TeamID);
        Label rolLabel = new Label(lid.rol);
        Label geboortedatumLabel = new Label(lid.geboortedatum);

        for (Label label : new Label[]{voornaamLabel, achternaamLabel, teamLabel, rolLabel, geboortedatumLabel}) {
            label.getStyleClass().add("cell-label");
        }

        Button deleteButton = new Button("Delete");
        deleteButton.getStyleClass().add("delete-button");
        deleteButton.setOnAction(e -> onDelete.accept(lid));

        rowBox.getChildren().addAll(voornaamLabel, achternaamLabel, teamLabel, rolLabel, geboortedatumLabel, deleteButton);
        rowBox.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            onSelect.accept(lid);
            for (Node node : ledenTable.getChildren()) {
                if (node instanceof HBox) {
                    node.setStyle("-fx-background-color: transparent;");
                }
            }
            rowBox.setStyle("-fx-background-color: #b3d9ff;");
        });

        return rowBox;
    }
}
