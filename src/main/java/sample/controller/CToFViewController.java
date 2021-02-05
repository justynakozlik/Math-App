package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CToFViewController implements Initializable {

    @FXML
    private Button exitButton;
    @FXML
    private TextField textField;
    @FXML
    private Button convertButton;
    @FXML
    private Label solutionLabel;
    @FXML
    private Button refreshButton;
    @FXML
    private BorderPane cToFBorderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeExitButton();
        initializeConvertButton();
        initializeRefreshButton();
    }

    private void initializeRefreshButton() {
    }

    private void initializeConvertButton() {
    }

    private void initializeExitButton() {
        exitButton.setOnAction((x) -> {
            getStage().close();
        });
    }

    private Stage getStage(){
        return (Stage) cToFBorderPane.getScene().getWindow();
    }
}
