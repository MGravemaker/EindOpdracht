package com.example.eindopdracht.Hoofdschermen;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SchermNavigator {

    public static void openLedenPagina(Stage stage) {
        LedenPaginaTeams ledenPage = new LedenPaginaTeams(stage);
        Scene ledenScene = new Scene(ledenPage.getRoot(), 1280, 720);
        ledenScene.getStylesheets().add(SchermNavigator.class.getResource("/stylesheets/algemeen.css").toExternalForm());
        stage.setScene(ledenScene);
    }
}
