package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.alert.ConvertAlerts;
import sample.convert.Convert;

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

    private Convert convert;
    private ConvertAlerts convertAlerts;

    public CToFViewController(){
        convert = new Convert();
        convertAlerts = new ConvertAlerts();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeExitButton();
        initializeConvertButton();
        initializeRefreshButton();
    }

    private void initializeRefreshButton() {
        refreshButton.setOnAction((x) -> {
            refresh();
        });
    }

    private void initializeConvertButton() {
        convertButton.setOnAction((x) -> {
            convert();
        });
    }

    private void initializeExitButton() {
        exitButton.setOnAction((x) -> {
            getStage().close();
        });
    }

    private void convert() {

        String text = textField.getText();

        try {

            double value = Double.parseDouble(text);

            double solution = convert.cToFConvert(value);

            String valueToDisplay = convert.customFormat("###.###", solution);

            solutionLabel.setText(text + " ℃ = " + valueToDisplay + " ℉");

        } catch (NumberFormatException ex) {

            if (text.isEmpty()) {
                convertAlerts.createEmptyStringAlert();
            } else {
                convertAlerts.createWrongFormatAlert();
            }
        }
    }

    private void refresh() {
        textField.clear();
        solutionLabel.setText("℃ =       ℉");
    }

    private Stage getStage(){
        return (Stage) cToFBorderPane.getScene().getWindow();
    }
}
