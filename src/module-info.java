module JavaFxEmailClient {
    requires javafx.fxml;
    requires  javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires activation;
    requires java.mail;

    opens com.lisboa;
    opens com.lisboa.view;
    opens com.lisboa.controller;
}