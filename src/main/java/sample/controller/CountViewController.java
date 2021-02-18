package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CountViewController implements Initializable {

    @FXML
    private Button areaButton;
    @FXML
    private Button perimeterButton;
    @FXML
    private Button volumeButton;
    @FXML
    private Button quadraticEquationButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeAreaButton();
        initializePerimeterButton();
        initializeVolumeButton();
        initializeQuadraticEquationButton();
    }

    private void initializeAreaButton() {
        areaButton.setOnAction((x) -> {
            createStage("/fxml/area-view.fxml", "Area");
        });
    }

    private void initializePerimeterButton() {
        perimeterButton.setOnAction((x) -> {
            createStage("/fxml/perimeter-view.fxml", "Perimeter");
        });
    }

    private void initializeVolumeButton() {
        volumeButton.setOnAction((x) -> {
            createStage("/fxml/volume-view.fxml", "Volume");
        });
    }

    private void initializeQuadraticEquationButton() {
        quadraticEquationButton.setOnAction((x) -> {
            createStage("/fxml/quadraticEquation-view.fxml", "Quadratic equation");
        });
    }

    private void createStage(String resource, String title){
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(resource));
            stage.setScene(new Scene(root, 700, 500));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException("Can't load this file");
        }
    }
}
