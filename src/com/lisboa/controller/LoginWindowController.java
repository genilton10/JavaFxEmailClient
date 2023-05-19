package com.lisboa.controller;

        import com.lisboa.EmailManager;
        import com.lisboa.view.ViewFactory;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.control.PasswordField;
        import javafx.scene.control.TextField;
        import javafx.stage.Stage;

public class LoginWindowController extends BaseController {

    @FXML
    private TextField emailAddressField;

    @FXML
    private Label errorLabelAction;

    @FXML
    private PasswordField passwordField;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction(ActionEvent event) {
        System.out.println("loginButtonAction!");
        viewFactory.showMainWindow();
        Stage stage = (Stage) errorLabelAction.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

}

