package com.example.eindopdracht.Hoofdschermen;

import com.example.eindopdracht.AndereSchermen.DatabaseManager;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class LedenPaginaLeden extends Application {
    private DatabaseManager.Lid selectedLid;
    private Stage stage2;

    public static void main(String[] args) {
        launch(args);
    }

    public LedenPaginaLeden(Stage stage2) {
        this.stage2 = stage2;

    }

    public LedenPaginaLeden() {

    }

    public static void setLabels(String voornaam, String achternaam, String teamnaam, String rol, String geboortedatum) {
    }

    public void start(Stage stage) {

        this.stage2 = stage;
        // Create the root node for the scene
        Parent root = getRoot2();

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

    public Parent getRoot2() {
        Button btn1 = new Button("Ledenbeheer");
        btn1.setMinWidth(190);
        btn1.getStyleClass().add("Knoppen");
        //  btn1.setOnAction(se);

        Button btn2 = new Button("Veldenbeheer");
        btn2.setMinWidth(190);
        btn2.getStyleClass().add("Knoppen");
        btn2.setOnAction(e -> {
            VeldenPaginaWedstrijden veldenPage = new VeldenPaginaWedstrijden(stage2);
            // Instead of directly setting the scene, use the getRoot() to get the layout
            Scene veldenScene = new Scene(veldenPage.getRoot3(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage2.setScene(veldenScene);  // Set the new scene

            veldenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });

        Button btn3 = new Button("Teams");
        btn3.setMinWidth(450);
        btn3.getStyleClass().add("Knoppen");
        btn3.setOnAction(e -> {
            LedenPaginaTeams ledenPage = new LedenPaginaTeams(stage2);
            // Instead of directly setting the scene, use the getRoot() to get the layout
            Scene ledenScene = new Scene(ledenPage.getRoot(), 1280, 720);  // Getting the root from LedenPaginaTeams
            stage2.setScene(ledenScene);  // Set the new scene

            ledenScene.getStylesheets().add(getClass().getResource("/stylesheets/LedenTeams.css").toExternalForm());
        });

        Button btn4 = new Button("Leden");
        btn4.setMinWidth(450);
        btn4.getStyleClass().add("Knoppen");


        TextField Linkstf1 = new TextField("Voornaam:");
        Linkstf1.setTranslateX(10);
        Linkstf1.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf2 = new TextField("Achternaam:");
        Linkstf2.setTranslateX(10);
        Linkstf2.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf3 = new TextField("Email:");
        Linkstf3.setTranslateX(30);
        Linkstf3.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf4 = new TextField("Telefoonnummer:");
        Linkstf4.setTranslateX(10);
        Linkstf4.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf5 = new TextField("Geboortedatum:");
        Linkstf5.setTranslateX(30);
        Linkstf5.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf6 = new TextField("Geslacht:");
        Linkstf6.setTranslateX(10);
        Linkstf6.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf7 = new TextField("Team:");
        Linkstf7.setTranslateX(30);
        Linkstf7.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        TextField Linkstf8 = new TextField("Rol:");
        Linkstf8.setTranslateX(10);
        Linkstf8.setMaxWidth(150);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        Button btnlinks1 = new Button("Dit lid verwijderen");
        btnlinks1.setTranslateX(65);
        btnlinks1.setMaxWidth(250);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());

        Button btnlinks2 = new Button("Opslaan");
        btnlinks2.setTranslateX(65);
        btnlinks2.setMaxWidth(250);
        GridPane.setHalignment(Linkstf1, Pos.CENTER.getHpos());




        GridPane pane = new GridPane();

        pane.setVgap(25);

        pane.setId("pane");
        pane.setMinWidth(380);
        pane.setMinHeight(430);

        pane.add(btn1, 0, 0);
        pane.add(btn2, 1, 0);

        pane.add(Linkstf1, 0, 1);
        //  GridPane.setColumnSpan(Linkstf1, 2);

        pane.add(Linkstf2, 1, 1);
        // GridPane.setColumnSpan(btnlinks2, 2);

        pane.add(Linkstf3, 0, 2);
        // GridPane.setColumnSpan(btnlinks3, 2);

        pane.add(Linkstf4, 1, 2);
        // GridPane.setColumnSpan(btnlinks4, 2);

        pane.add(Linkstf5, 0, 3);

        pane.add(Linkstf6, 1, 3);

        pane.add(Linkstf7, 0, 4);

        pane.add(Linkstf8, 1, 4);

        pane.add(btnlinks1, 0, 5);
        GridPane.setColumnSpan(btnlinks1, 2);

        pane.add(btnlinks2, 0, 6);
        GridPane.setColumnSpan(btnlinks2, 2);


        btn1.setLayoutX(0);
        btn1.setLayoutY(0);

        btn2.setLayoutX(190);
        btn2.setLayoutY(0);


        //  pane.getChildren().addAll(btn1, btn2);


        HBox hbox = new HBox();
        hbox.getChildren().addAll(pane, btn3, btn4);

        GridPane pane2 = new GridPane();
        pane2.setVgap(25);
        pane2.setId("pane2");
        pane2.setMaxWidth(381.5);
        //  pane2.setPrefWidth(380);
        pane2.setMinHeight(290);

        // Button btnlinks7 = new Button("Team(s) activiteit aanpassen");
        //btnlinks7.setTranslateY(25);
        // btnlinks7.setMinWidth(300);
        //GridPane.setHalignment(btnlinks7, Pos.CENTER.getHpos());

        Button btnlinks8 = new Button("Lid toevoegen");
        btnlinks8.setTranslateY(25);
        btnlinks8.setMinWidth(300);
        GridPane.setHalignment(btnlinks8, Pos.CENTER.getHpos());


        Button btnlinks9 = new Button("Lid verwijderen");
        btnlinks9.setTranslateY(25);
        btnlinks9.setMinWidth(300);
        GridPane.setHalignment(btnlinks9, Pos.CENTER.getHpos());

        Button btnlinks10 = new Button("Volledige scherm");
        btnlinks10.setTranslateY(25);
        btnlinks10.setMinWidth(300);
        GridPane.setHalignment(btnlinks10, Pos.CENTER.getHpos());

        Button btnlinks11 = new Button("Opslaan");
        btnlinks11.setTranslateY(25);
        btnlinks11.setMinWidth(250);
        GridPane.setHalignment(btnlinks11, Pos.CENTER.getHpos());


        ColumnConstraints col = new ColumnConstraints();
        col.setHalignment(HPos.CENTER);
        col.setPrefWidth(380);
        pane2.getColumnConstraints().add(col);


        pane2.add(btnlinks10, 0, 0);
        GridPane.setColumnSpan(btnlinks10, 2);

        pane2.add(btnlinks8, 0, 1);
        GridPane.setColumnSpan(btnlinks8, 2);

        pane2.add(btnlinks9, 0, 2);
        GridPane.setColumnSpan(btnlinks9, 2);

        pane2.add(btnlinks11, 0, 3);
        GridPane.setColumnSpan(btnlinks11, 2);

        //   pane2.add(btnlinks11, 0, 4);
        //   GridPane.setColumnSpan(btnlinks11, 2);

         /*
        Button btnitem1 = new Button("Voornaam");
        btnitem1.setMinWidth(150);
        Button btnitem2 = new Button("Achternaam");
        btnitem2.setMinWidth(150);
        Button btnitem3 = new Button("Team");
        btnitem3.setMinWidth(150);
        Button btnitem4 = new Button("Rol");
        btnitem4.setMinWidth(150);
        Button btnitem5 = new Button("Geboortedatum");
        btnitem5.setMinWidth(150);
*/



        HBox hbox3 = new HBox();
        GridPane ledenTable = new GridPane();
        ledenTable.setTranslateY(-670);
        ledenTable.setTranslateX(190);
        ledenTable.setHgap(0);
        ledenTable.setVgap(0);
        ledenTable.setAlignment(Pos.CENTER);






        // ✅ Headers
        String[] headers = {"Voornaam", "Achternaam", "Teamnaam", "Rol", "Geboortedatum"};
        for (int col2 = 0; col2 < headers.length; col2++) {
            Label headerLabel = new Label(headers[col2]);
            headerLabel.setMinWidth(150);
            headerLabel.setMinHeight(35);
            headerLabel.getStyleClass().add("MenuItemText");
            headerLabel.setAlignment(Pos.CENTER);
            ledenTable.add(headerLabel, col2, 0);
        }


        // ✅ Haal leden op en voeg ze toe als rijen
        List<DatabaseManager.Lid> leden = DatabaseManager.getLeden();
        int row = 1;

        for (DatabaseManager.Lid lid : leden) {
            HBox rowBox = new HBox();
            rowBox.setSpacing(0);
            rowBox.setPadding(new Insets(0));
            rowBox.setAlignment(Pos.CENTER_LEFT);
            rowBox.setStyle("-fx-background-color: transparent;");

            // ✅ Labels met CSS-styling
            Label voornaamLabel = new Label(lid.voornaam);
            Label achternaamLabel = new Label(lid.achternaam);
            Label teamLabel = new Label(lid.TeamID);
            Label rolLabel = new Label(lid.rol);
            Label geboortedatumLabel = new Label(lid.geboortedatum);

            voornaamLabel.getStyleClass().add("cell-label");
            achternaamLabel.getStyleClass().add("cell-label");
            teamLabel.getStyleClass().add("cell-label");
            rolLabel.getStyleClass().add("cell-label");
            geboortedatumLabel.getStyleClass().add("cell-label");

            // ✅ Selecteer een rij bij klikken
            rowBox.setOnMouseClicked(event -> {
                selectedLid = lid; // Bewaar het geselecteerde lid

                Linkstf1.setText(lid.voornaam);
                Linkstf2.setText(lid.achternaam);
                Linkstf3.setText(lid.email);
                Linkstf4.setText(lid.telefoonnummer);
                Linkstf5.setText(lid.geboortedatum);
                Linkstf6.setText(lid.geslacht);
                Linkstf7.setText(lid.TeamID);
                Linkstf8.setText(lid.rol);

                // ✅ Deselecteer andere rijen
                for (Node node : ledenTable.getChildren()) {
                    if (node instanceof HBox) {
                        node.setStyle("-fx-background-color: transparent;");
                    }
                }

                // ✅ Highlight geselecteerde rij
                rowBox.setStyle("-fx-background-color: #b3d9ff;");
            });

            // ✅ Verwijderknop
            Button deleteButton = new Button("Delete");
            deleteButton.getStyleClass().add("delete-button");
            deleteButton.setOnAction(event -> {
                if (DatabaseManager.deleteLid(lid.LidID)) {  // Use lid.LidID instead of selectedLid!
                    System.out.println("Lid succesvol verwijderd!");

                    // ✅ Remove the row from the UI
                    ledenTable.getChildren().remove(rowBox);  // Remove this row from the table
                } else {
                    System.out.println("Fout bij verwijderen van lid.");
                }
            });



            rowBox.getChildren().addAll(voornaamLabel, achternaamLabel, teamLabel, rolLabel, geboortedatumLabel, deleteButton);
            ledenTable.add(rowBox, 0, row, 6, 1);
            row++;
        }
        Button btnmenu = new Button("Refresh");
        btnmenu.setMinHeight(35);
        btnmenu.setMinWidth(150);
        btnmenu.setTranslateY(-760);
        btnmenu.setTranslateX(1130);
       btnmenu.setOnAction(event -> {

           ledenTable.getChildren().clear();

           String[] columnHeaders = {"Voornaam", "Achternaam", "Teamnaam", "Rol", "Geboortedatum"};
           for (int col2 = 0; col2 < columnHeaders.length; col2++) {
               Label columnHeaderLabel = new Label(columnHeaders[col2]);
               columnHeaderLabel.setMinWidth(150);
               columnHeaderLabel.setMinHeight(35);
               columnHeaderLabel.getStyleClass().add("MenuItemText");
               columnHeaderLabel.setAlignment(Pos.CENTER);
               ledenTable.add(columnHeaderLabel, col2, 0);
           }

// Haal data op en voeg ze toe als rijen (Load the data)
           List<DatabaseManager.Lid> teamMembers = DatabaseManager.getLeden();
           int rowIndex = 1;

           for (DatabaseManager.Lid member : teamMembers) {
               HBox rowContainer = new HBox();
               rowContainer.setSpacing(0);
               rowContainer.setPadding(new Insets(0));
               rowContainer.setAlignment(Pos.CENTER_LEFT);
               rowContainer.setStyle("-fx-background-color: transparent;");

               // Labels met CSS-styling
               Label firstNameLabel = new Label(member.voornaam);
               Label lastNameLabel = new Label(member.achternaam);
               Label teamLabel = new Label(member.TeamID);
               Label roleLabel = new Label(member.rol);
               Label birthDateLabel = new Label(member.geboortedatum);

               firstNameLabel.getStyleClass().add("cell-label");
               lastNameLabel.getStyleClass().add("cell-label");
               teamLabel.getStyleClass().add("cell-label");
               roleLabel.getStyleClass().add("cell-label");
               birthDateLabel.getStyleClass().add("cell-label");

               // Selecteer een rij bij klikken
               rowContainer.setOnMouseClicked(event2 -> {
                   selectedLid = member; // Bewaar het geselecteerde lid

                   Linkstf1.setText(member.voornaam);
                   Linkstf2.setText(member.achternaam);
                   Linkstf3.setText(member.email);
                   Linkstf4.setText(member.telefoonnummer);
                   Linkstf5.setText(member.geboortedatum);
                   Linkstf6.setText(member.geslacht);
                   Linkstf7.setText(member.TeamID);
                   Linkstf8.setText(member.rol);

                   // Deselecteer andere rijen
                   for (Node node : ledenTable.getChildren()) {
                       if (node instanceof HBox) {
                           node.setStyle("-fx-background-color: transparent;");
                       }
                   }

                   // Highlight geselecteerde rij
                   rowContainer.setStyle("-fx-background-color: #b3d9ff;");
               });

               // Verwijderknop
               Button deleteButton = new Button("Delete");
               deleteButton.getStyleClass().add("delete-button");
               deleteButton.setOnAction(event2 -> {
                   if (DatabaseManager.deleteLid(member.LidID)) {
                       System.out.println("Lid succesvol verwijderd!");

                       // Remove the row from the UI
                       ledenTable.getChildren().remove(rowContainer); // Remove this row from the table
                   } else {
                       System.out.println("Fout bij verwijderen van lid.");
                   }
               });

               rowContainer.getChildren().addAll(firstNameLabel, lastNameLabel, teamLabel, roleLabel, birthDateLabel, deleteButton);
               ledenTable.add(rowContainer, 0, rowIndex, 6, 1);
               rowIndex++;
           }
       });


        // ✅ Opslaan-knop voor updates
        Button saveButton = new Button("Opslaan");
        saveButton.setOnAction(event -> {
            if (selectedLid != null) {
                selectedLid.voornaam = Linkstf1.getText();
                selectedLid.achternaam = Linkstf2.getText();
                selectedLid.email = Linkstf3.getText();
                selectedLid.telefoonnummer = Linkstf4.getText();
                selectedLid.geboortedatum = Linkstf5.getText();
                selectedLid.geslacht = Linkstf6.getText();
                selectedLid.TeamID = Linkstf7.getText();
                selectedLid.rol = Linkstf8.getText();

                boolean success = DatabaseManager.updateLid(selectedLid);
                if (success) {
                    System.out.println("Lid succesvol bijgewerkt!");
                } else {
                    System.out.println("Fout bij updaten van lid.");
                }
            }
        });
        btnlinks1.setOnAction(event -> {
            if (selectedLid != null) {
                boolean success = DatabaseManager.deleteLid(selectedLid.LidID); // Pass the ID instead
                if (success) {
                    System.out.println("Lid succesvol verwijderd!");

                    // ✅ Remove row from UI
                    ledenTable.getChildren().removeIf(node -> {
                        if (node instanceof HBox) {
                            HBox row2 = (HBox) node;
                            Label firstLabel = (Label) row2.getChildren().get(0); // Assuming first label is first name
                            return firstLabel.getText().equals(selectedLid.voornaam);
                        }
                        return false;
                    });

                    selectedLid = null; // Reset selection
                } else {
                    System.out.println("Fout bij verwijderen van lid.");
                }
            } else {
                System.out.println("Geen lid geselecteerd om te verwijderen.");
            }
        });




// ✅ Save changes when btnlinks2 is clicked
        btnlinks2.setOnAction(event -> {
            if (selectedLid != null) {
                selectedLid.voornaam = Linkstf1.getText();
                selectedLid.achternaam = Linkstf2.getText();
                selectedLid.email = Linkstf3.getText();
                selectedLid.telefoonnummer = Linkstf4.getText();
                selectedLid.geboortedatum = Linkstf5.getText();
                selectedLid.geslacht = Linkstf6.getText();
                selectedLid.TeamID = Linkstf7.getText();
                selectedLid.rol = Linkstf8.getText();

                boolean success = DatabaseManager.updateLid(selectedLid);
                if (success) {
                    System.out.println("Lid succesvol bijgewerkt!");
                } else {
                    System.out.println("Fout bij updaten van lid.");
                }
            } else {
                System.out.println("Geen lid geselecteerd om op te slaan.");
            }
        });

        VBox vbox = new VBox();
       // vbox.getChildren().addAll(ledenTable, saveButton);
        vbox.getChildren().addAll(hbox, pane2, ledenTable, saveButton, btnmenu); // Nu wordt het getoond!
        return vbox;
    }
}