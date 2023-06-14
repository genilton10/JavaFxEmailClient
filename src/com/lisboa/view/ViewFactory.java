package com.lisboa.view;

import com.lisboa.EmailManager;
import com.lisboa.controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
public class ViewFactory {
    private EmailManager emailManager;
    private ArrayList<Stage> activeStages;
    private boolean mainViewInitialized = false;
    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
        activeStages = new ArrayList<Stage>();
    }
    public boolean isMainViewInitialized(){
        return mainViewInitialized;
    }
    //View options handling
    private ColorTheme colorTheme =ColorTheme.DARK;
    private FontSize fontSize = FontSize.MEDIUM;
    public ColorTheme getColorTheme() {
        return colorTheme;
    }
    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }
    public FontSize getFontSize() {
        return fontSize;
    }
    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }
    public void showLoginWindow() {
        System.out.println("show login window called");
        BaseController controller = new LoginWindowController(emailManager, this, "LoginWindow.fxml");
        initializeState(controller);
    }
    public void showMainWindow() {
        System.out.println("main window called");
        BaseController controller = new MainWindowController(emailManager, this, "MainWindow.fxml");
        initializeState(controller);
        mainViewInitialized = true;
    }
    public void  showOptionsWindow(){
        System.out.println("Options window called!");
        BaseController Controller = new OptionsWindowController(emailManager, this, "OptionsWindow.fxml");
        initializeState(Controller);
    }
    public void  showComposeMessageWindow(){
        System.out.println("ComposeMessage window called!");
        BaseController Controller = new ComposeMessageController(emailManager, this, "ComposeMessageWindow.fxml");
        initializeState(Controller);
    }
    private void initializeState(BaseController baseController) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);
    }
    public void closeStage(Stage stageToClose){
        stageToClose.close();
        activeStages.remove(stageToClose);
    }
    public void updateStyles() {
        for(Stage stage: activeStages){
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());
            scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(fontSize)).toExternalForm());
        }
    }
}
