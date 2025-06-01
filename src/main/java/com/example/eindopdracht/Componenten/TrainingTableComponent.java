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

public class TrainingTableComponent {

    private final GridPane table;

    public TrainingTableComponent() {
        table = new GridPane();
        table.setTranslateY(-670);
        table.setTranslateX(285);
        table.setHgap(0);
        table.setVgap(0);
        table.setAlignment(Pos.CENTER);
    }

    public GridPane getTable(Consumer<DatabaseManager.Training> onSelect, Consumer<DatabaseManager.Training> onDelete) {
        updateTable(onSelect, onDelete);
        return table;
    }

    public void updateTable(Consumer<DatabaseManager.Training> onSelect, Consumer<DatabaseManager.Training> onDelete) {
        table.getChildren().clear();

        String[] headers = {"TeamID", "TrainingID", "Datum", "Veld"};
        for (int i = 0; i < headers.length; i++) {
            Label header = new Label(headers[i]);
            header.setMinWidth(187.5);
            header.setMinHeight(35);
            header.getStyleClass().add("MenuItemText");
            header.setAlignment(Pos.CENTER);
            table.add(header, i, 0);
        }

        List<DatabaseManager.Training> trainingen = DatabaseManager.getTrainingen();
        int row = 1;

        for (DatabaseManager.Training training : trainingen) {
            HBox rowBox = createRow(training, onSelect, onDelete);
            table.add(rowBox, 0, row, 6, 1);
            row++;
        }
    }

    private HBox createRow(DatabaseManager.Training training, Consumer<DatabaseManager.Training> onSelect, Consumer<DatabaseManager.Training> onDelete) {
        HBox rowBox = new HBox();
        rowBox.setSpacing(0);
        rowBox.setPadding(new Insets(0));
        rowBox.setAlignment(Pos.CENTER_LEFT);
        rowBox.setStyle("-fx-background-color: transparent;");

        Label teamId = new Label(String.valueOf(training.TeamID));
        Label trainingId = new Label(String.valueOf(training.TrainingID));
        Label datum = new Label(training.TrainingDatumTijd);
        Label veld = new Label(training.Veld);

        teamId.getStyleClass().add("cell-label3");
        trainingId.getStyleClass().add("cell-label3");
        datum.getStyleClass().add("cell-label3");
        veld.getStyleClass().add("cell-label3");

        Button deleteButton = new Button("Delete");
        deleteButton.getStyleClass().add("delete-button");
        deleteButton.setOnAction(e -> onDelete.accept(training));

        rowBox.getChildren().addAll(teamId, trainingId, datum, veld, deleteButton);

        rowBox.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            onSelect.accept(training);
            for (Node node : table.getChildren()) {
                if (node instanceof HBox) {
                    node.setStyle("-fx-background-color: transparent;");
                }
            }
            rowBox.setStyle("-fx-background-color: #b3d9ff;");
        });

        return rowBox;
    }
}
