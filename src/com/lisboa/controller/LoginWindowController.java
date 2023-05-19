package com.lisboa.controller;

        import com.lisboa.EmailManager;
        import com.lisboa.controller.services.LoginService;
        import com.lisboa.model.EmailAccount;
        import com.lisboa.view.ViewFactory;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Label;
        import javafx.scene.control.PasswordField;
        import javafx.scene.control.TextField;
        import javafx.stage.Stage;

        import java.net.URL;
        import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {

    @FXML
    private TextField emailAddressField;

    @FXML
    private Label errorLabel;

    @FXML
    private PasswordField passwordField;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction() {
        System.out.println("loginButtonAction!");
        if(fieldsAreValid()){
            EmailAccount emailAccount = new EmailAccount(emailAddressField.getText(), passwordField.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            loginService.start();
            loginService.setOnSucceeded(event -> {

                EmailLoginResult emailLoginResult = loginService.getValue();
                switch (emailLoginResult){
                    case SUCCESS:
                        System.out.println("login succesfull!!"+ emailAccount);
                        viewFactory.showMainWindow();
                        Stage stage = (Stage) errorLabel.getScene().getWindow();
                        viewFactory.closeStage(stage);
                        return;
                    case FAILED_BY_CREDENTIALS:
                        errorLabel.setText("invalid credentials!");
                        return;
                    case FAILED_BY_UNEXPECTED_ERROR:
                        errorLabel.setText("unexpected error!");
                        return;
                    default:
                        return;
                }
            });
        }
    }

    private boolean fieldsAreValid() {

        if(emailAddressField.getText().isEmpty()){
            errorLabel.setText("Please fill email");
            return false;
        }
        if(passwordField.getText().isEmpty()){
            errorLabel.setText("Please fill email");
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailAddressField.setText("glemailtest2023@gmail.com");
        passwordField.setText("dE!!6eNR");
    }
}

