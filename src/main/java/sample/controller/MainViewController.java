package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private BorderPane mainViewBorderPane;
    @FXML
    private Button countButton;
    @FXML
    private Button convertButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeCountButton();
        initializeConvertButton();
    }

    private void initializeConvertButton() {
        convertButton.setOnAction((x) -> {
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/convert-view.fxml"));
                stage.setTitle("Convert");
                stage.setScene(new Scene(root, 700, 500));
                stage.show();
            } catch (IOException e) {
               throw new RuntimeException("Can't load this file");
            }
        });
    }

    private void initializeCountButton() {
        countButton.setOnAction((x) -> {
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/count-view.fxml"));
                stage.setTitle("Count");
                stage.setScene(new Scene(root, 700, 500));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException("Can't load this file");
            }

        });
    }
}
