package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.alert.CountAlerts;
import sample.count.QuadraticEquation;

import java.net.URL;
import java.util.ResourceBundle;

public class QuadraticEquationViewController implements Initializable {

    @FXML
    private TextField firstParamTextField;
    @FXML
    private TextField secondParamTextField;
    @FXML
    private TextField thirdParamTextField;
    @FXML
    private Button countButton;
    @FXML
    private Button refreshButton;
    @FXML
    private Label solutionLabel;

    private CountAlerts countAlerts;
    private QuadraticEquation quadraticEquation;

    public QuadraticEquationViewController(){
        countAlerts = new CountAlerts();
        quadraticEquation = new QuadraticEquation();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeCountButton();
        initializeRefreshButton();
    }

    private void initializeRefreshButton() {
        refreshButton.setOnAction((x) -> {
            refresh();
        });
    }

    private void initializeCountButton() {
        countButton.setOnAction((x) -> {
            count();
        });
    }

    private void refresh() {

        firstParamTextField.clear();
        secondParamTextField.clear();
        thirdParamTextField.clear();

        solutionLabel.setText("The equation has ... ");
    }

    private void count() {

        String text1 = firstParamTextField.getText();
        String text2 = secondParamTextField.getText();
        String text3 = thirdParamTextField.getText();

        try {
            double value1 = Double.parseDouble(text1);
            double value2 = Double.parseDouble(text2);
            double value3 = Double.parseDouble(text3);
            if (value1 == 0) {
                countAlerts.createQuadraticEquationWrongAValueAlert();
            } else {
                solutionLabel.setText(quadraticEquation.quadraticEquation(value1, value2, value3));
            }
        } catch (NumberFormatException ex) {
            if (text1.isEmpty() || text2.isEmpty() || text3.isEmpty()) {
                countAlerts.createEmptyStringAlert();
            } else {
                countAlerts.createWrongFormatAlert();
            }
        }
    }
}
