package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConvertViewController implements Initializable {

    @FXML
    private Button cToFButton;
    @FXML
    private Button fToCButton;
    @FXML
    private Button cToKButton;
    @FXML
    private Button kToCButton;
    @FXML
    private Button kToFButton;
    @FXML
    private Button fToKButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeCToFButton();
        initializeFToCButton();
        initializeCToKButton();
        initializeKToCButton();
        initializeKToFButton();
        initializeFToKButton();
    }

    private void initializeCToFButton() {
        cToFButton.setOnAction((x) -> {
            createStage("/fxml/cToF-view.fxml");
        });
    }

    private void initializeFToCButton() {
        fToCButton.setOnAction((x) -> {
            createStage("/fxml/fToC-view.fxml");
        });
    }

    private void initializeCToKButton() {
        cToKButton.setOnAction((x) -> {
            createStage("/fxml/cToK-view.fxml");
        });
    }

    private void initializeKToCButton() {
        kToCButton.setOnAction((x) -> {
            createStage("/fxml/kToC-view.fxml");
        });
    }

    private void initializeKToFButton() {
        kToFButton.setOnAction((x) -> {
            createStage("/fxml/kToF-view.fxml");
        });
    }

    private void initializeFToKButton() {
        fToKButton.setOnAction((x) -> {
            createStage("/fxml/fToK-view.fxml");
        });
    }

    private void createStage(String resource){
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(resource));
            stage.setScene(new Scene(root, 500, 300));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException("Can't load this file");
        }
    }
}
