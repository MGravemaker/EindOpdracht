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

public class WedstrijdTableComponent {

    private final GridPane table;

    public WedstrijdTableComponent() {
        table = new GridPane();
        table.setTranslateY(-670);
        table.setTranslateX(340);
        table.setHgap(0);
        table.setVgap(0);
        table.setAlignment(Pos.CENTER);
    }

    public GridPane getTable(Consumer<DatabaseManager.Wedstrijd> onSelect, Consumer<DatabaseManager.Wedstrijd> onDelete) {
        updateTable(onSelect, onDelete);
        return table;
    }

    public void updateTable(Consumer<DatabaseManager.Wedstrijd> onSelect, Consumer<DatabaseManager.Wedstrijd> onDelete) {
        table.getChildren().clear();

        String[] headers = {"TeamID", "Tegenstander", "WedstrijdID", "Datum", "Veld"};
        for (int i = 0; i < headers.length; i++) {
            Label label = new Label(headers[i]);
            label.setMinWidth(150);
            label.setMinHeight(35);
            label.getStyleClass().add("MenuItemText");
            label.setAlignment(Pos.CENTER);
            table.add(label, i, 0);
        }

        List<DatabaseManager.Wedstrijd> wedstrijden = DatabaseManager.getWedstrijden();
        int rowIndex = 1;

        for (DatabaseManager.Wedstrijd wedstrijd : wedstrijden) {
            HBox row = createRow(wedstrijd, onSelect, onDelete);
            table.add(row, 0, rowIndex, 6, 1);
            rowIndex++;
        }
    }

    private HBox createRow(DatabaseManager.Wedstrijd wedstrijd, Consumer<DatabaseManager.Wedstrijd> onSelect, Consumer<DatabaseManager.Wedstrijd> onDelete) {
        HBox rowBox = new HBox();
        rowBox.setSpacing(0);
        rowBox.setPadding(new Insets(0));
        rowBox.setAlignment(Pos.CENTER_LEFT);
        rowBox.setStyle("-fx-background-color: transparent;");

        Label label1 = new Label(String.valueOf(wedstrijd.TeamID));
        Label label2 = new Label(wedstrijd.Team2Naam);
        Label label3 = new Label(String.valueOf(wedstrijd.WedstrijdID));
        Label label4 = new Label(wedstrijd.WedstrijdDatumTijd);
        Label label5 = new Label(wedstrijd.Veld);

        for (Label label : new Label[]{label1, label2, label3, label4, label5}) {
            label.getStyleClass().add("cell-label");
        }

        Button deleteButton = new Button("Delete");
        deleteButton.getStyleClass().add("delete-button");
        deleteButton.setOnAction(e -> onDelete.accept(wedstrijd));

        rowBox.getChildren().addAll(label1, label2, label3, label4, label5, deleteButton);

        rowBox.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            onSelect.accept(wedstrijd);
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
