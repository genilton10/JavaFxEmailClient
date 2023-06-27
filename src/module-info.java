module JavaFxEmailClient {
    requires javafx.fxml;
    requires  javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires activation;
    requires java.mail;
    requires java.desktop;

    //test:
    //requires org.junit.jupiter.api;
    //requires mockito.all;

    exports com.lisboa.controller;
    opens com.lisboa;
    opens com.lisboa.view;
    opens com.lisboa.controller;
    opens com.lisboa.model;
}