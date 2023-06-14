package com.lisboa;

import com.lisboa.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;
public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory = new ViewFactory(new EmailManager());
//        viewFactory.showMainWindow();
        viewFactory.showLoginWindow();
//        viewFactory.updateStyles();
    }
}
