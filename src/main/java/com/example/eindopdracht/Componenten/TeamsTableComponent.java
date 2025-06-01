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

public class TeamsTableComponent {

    private final GridPane table;

    public TeamsTableComponent() {
        table = new GridPane();
        table.setTranslateY(-670);
        table.setTranslateX(190);
        table.setHgap(0);
        table.setVgap(0);
        table.setAlignment(Pos.CENTER);
    }

    public GridPane getTable(Consumer<DatabaseManager.Team> onSelect, Consumer<DatabaseManager.Team> onDelete) {
        updateTable(onSelect, onDelete);
        return table;
    }

    public void updateTable(Consumer<DatabaseManager.Team> onSelect, Consumer<DatabaseManager.Team> onDelete) {
        table.getChildren().clear();

        String[] headers = {"Teamnaam", "Activiteit"};
        for (int col = 0; col < headers.length; col++) {
            Label header = new Label(headers[col]);
            header.setMinWidth(375);
            header.setMinHeight(35);
            header.getStyleClass().add("MenuItemText");
            header.setAlignment(Pos.CENTER);
            table.add(header, col, 0);
        }

        List<DatabaseManager.Team> teams = DatabaseManager.getTeams();
        int rowIndex = 1;

        for (DatabaseManager.Team team : teams) {
            HBox row = createRow(team, onSelect, onDelete);
            table.add(row, 0, rowIndex, 3, 1);
            rowIndex++;
        }
    }

    private HBox createRow(DatabaseManager.Team team, Consumer<DatabaseManager.Team> onSelect, Consumer<DatabaseManager.Team> onDelete) {
        HBox row = new HBox();
        row.setSpacing(0);
        row.setPadding(new Insets(0));
        row.setAlignment(Pos.CENTER_LEFT);
        row.setStyle("-fx-background-color: transparent;");

        Label nameLabel = new Label(team.teamNaam);
        Label activiteitLabel = new Label(team.activiteit.name());

        nameLabel.getStyleClass().add("cell-label2");
        activiteitLabel.getStyleClass().add("cell-label2");

        Button deleteButton = new Button("Delete");
        deleteButton.getStyleClass().add("delete-button");
        deleteButton.setOnAction(e -> onDelete.accept(team));

        row.getChildren().addAll(nameLabel, activiteitLabel, deleteButton);

        row.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            onSelect.accept(team);
            for (Node node : table.getChildren()) {
                if (node instanceof HBox) {
                    node.setStyle("-fx-background-color: transparent;");
                }
            }
            row.setStyle("-fx-background-color: #b3d9ff;");
        });

        return row;
    }
}
