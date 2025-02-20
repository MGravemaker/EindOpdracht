module com.example.eindopdracht {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.desktop;

    opens com.example.eindopdracht to javafx.fxml;
    exports com.example.eindopdracht;
    exports com.example.eindopdracht.Hoofdschermen;
    opens com.example.eindopdracht.Hoofdschermen to javafx.fxml;
    exports com.example.eindopdracht.AndereSchermen;
    opens com.example.eindopdracht.AndereSchermen to javafx.fxml;
}