package sample.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.alert.CountAlerts;
import sample.convert.Convert;
import sample.count.Area;
import sample.countElements.Figures;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AreaViewController implements Initializable {

    @FXML
    private ChoiceBox areaChoiceBox;
    @FXML
    private Label firstParamLabel;
    @FXML
    private Label secondParamLabel;
    @FXML
    private Label thirdParamLabel;
    @FXML
    private Button countButton;
    @FXML
    private Button refreshButton;
    @FXML
    private TextField firstParamTextField;
    @FXML
    private TextField secondParamTextField;
    @FXML
    private TextField thirdParamTextField;
    @FXML
    private Label solutionLabel;

    private Convert convert;
    private CountAlerts countAlerts;
    private Area area;

    public AreaViewController() {
        convert = new Convert();
        countAlerts = new CountAlerts();
        area = new Area();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        areaChoiceBox.setItems(FXCollections.observableArrayList(getFigures()));
        initializeAreaChoiceBox();
        initializeCountButton();
        initializeRefreshButton();

    }

    private void initializeAreaChoiceBox() {
        areaChoiceBox.setOnAction((x) -> {
            changeTemplate();
        });
    }


    private void initializeCountButton() {
        countButton.setOnAction((x) -> {
            count();
        });
    }


    private void initializeRefreshButton() {
        refreshButton.setOnAction((x) -> {
            refresh();
        });
    }


    private void refresh() {

        areaChoiceBox.setValue(null);

        firstParamTextField.clear();
        secondParamTextField.clear();
        thirdParamTextField.clear();

        firstParamTextField.setEditable(true);
        secondParamTextField.setEditable(true);
        thirdParamTextField.setEditable(true);

        firstParamLabel.setText("Parameter a");
        secondParamLabel.setText("Parameter b");
        thirdParamLabel.setText("Height");

        solutionLabel.setText("The area of the figure is                square centimeters");

    }

    private void changeTemplate() {
        if (areaChoiceBox.getSelectionModel().getSelectedItem().toString().equals("TRIANGLE") ||
                areaChoiceBox.getSelectionModel().getSelectedItem().toString().equals("RHOMBOID")) {

            secondParamLabel.setText("-");
            secondParamTextField.setEditable(false);

        } else if (areaChoiceBox.getSelectionModel().getSelectedItem().toString().equals("CIRCLE")) {

            firstParamLabel.setText("Radius");
            secondParamLabel.setText("-");
            thirdParamLabel.setText("-");

            secondParamTextField.setEditable(false);
            thirdParamTextField.setEditable(false);

        } else if (areaChoiceBox.getSelectionModel().getSelectedItem().toString().equals("SQUARE")) {

            firstParamLabel.setText("Parameter a");
            secondParamLabel.setText("-");
            thirdParamLabel.setText("-");

            secondParamTextField.setEditable(false);
            thirdParamTextField.setEditable(false);

        } else if (areaChoiceBox.getSelectionModel().getSelectedItem().toString().equals("TRAPEZIUM")) {

            firstParamLabel.setText("Parameter a");
            secondParamLabel.setText("Parameter b");
            thirdParamLabel.setText("Height");

        } else if (areaChoiceBox.getSelectionModel().getSelectedItem().toString().equals("RHOMB")) {

            firstParamLabel.setText("Diagonal e");
            secondParamLabel.setText("Diagonal f");
            thirdParamLabel.setText("-");

            thirdParamTextField.setEditable(false);

        } else if (areaChoiceBox.getSelectionModel().getSelectedItem().toString().equals("RECTANGLE")) {

            firstParamLabel.setText("Parameter a");
            secondParamLabel.setText("Parameter b");
            thirdParamLabel.setText("-");

            thirdParamTextField.setEditable(false);

        }
    }

    private void count() {
        try {
            if (areaChoiceBox.getSelectionModel().getSelectedItem().toString().equals("CIRCLE")) {
                circleCount();
            } else if (areaChoiceBox.getSelectionModel().getSelectedItem().toString().equals("TRIANGLE")) {
                triangleCount();
            } else if (areaChoiceBox.getSelectionModel().getSelectedItem().toString().equals("RECTANGLE")) {
                rectangleCount();
            } else if (areaChoiceBox.getSelectionModel().getSelectedItem().toString().equals("RHOMBOID")) {
                rhomboidCount();
            } else if (areaChoiceBox.getSelectionModel().getSelectedItem().toString().equals("RHOMB")) {
                rhombCount();
            } else if (areaChoiceBox.getSelectionModel().getSelectedItem().toString().equals("SQUARE")) {
                squareCount();
            } else if (areaChoiceBox.getSelectionModel().getSelectedItem().toString().equals("TRAPEZIUM")) {
                trapeziumCount();
            }
        } catch (NullPointerException ex) {
            countAlerts.createNoFigureAlert();
        }
    }

    private void circleCount() {

        String text = firstParamTextField.getText();

        try {
            double value = Double.parseDouble(text);
            if (value < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = area.circleArea(value);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The area of the figure is " + valueToDisplay + " square centimeters");
            }

        } catch (NumberFormatException ex) {
            if (text.isEmpty()) {
                countAlerts.createEmptyStringAlert();
            } else {
                countAlerts.createWrongFormatAlert();
            }
        }
    }

    private void triangleCount() {

        String text1 = firstParamTextField.getText();
        String text2 = thirdParamTextField.getText();

        try {
            double value1 = Double.parseDouble(text1);
            double value2 = Double.parseDouble(text2);
            if (value1 < 0 || value2 < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = area.triangleArea(value1, value2);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The area of the figure is " + valueToDisplay + " square centimeters");
            }

        } catch (NumberFormatException ex) {
            if (text1.isEmpty() || text2.isEmpty()) {
                countAlerts.createEmptyStringAlert();
            } else {
                countAlerts.createWrongFormatAlert();
            }
        }
    }

    private void rectangleCount() {

        String text1 = firstParamTextField.getText();
        String text2 = secondParamTextField.getText();

        try {
            double value1 = Double.parseDouble(text1);
            double value2 = Double.parseDouble(text2);
            if (value1 < 0 || value2 < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = area.rectangleArea(value1, value2);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The area of the figure is " + valueToDisplay + " square centimeters");
            }

        } catch (NumberFormatException ex) {
            if (text1.isEmpty() || text2.isEmpty()) {
                countAlerts.createEmptyStringAlert();
            } else {
                countAlerts.createWrongFormatAlert();
            }
        }
    }

    private void rhomboidCount() {

        String text1 = firstParamTextField.getText();
        String text2 = thirdParamTextField.getText();

        try {
            double value1 = Double.parseDouble(text1);
            double value2 = Double.parseDouble(text2);
            if (value1 < 0 || value2 < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = area.rhomboidArea(value1, value2);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The area of the figure is " + valueToDisplay + " square centimeters");
            }

        } catch (NumberFormatException ex) {
            if (text1.isEmpty() || text2.isEmpty()) {
                countAlerts.createEmptyStringAlert();
            } else {
                countAlerts.createWrongFormatAlert();
            }
        }
    }

    private void rhombCount() {

        String text1 = firstParamTextField.getText();
        String text2 = secondParamTextField.getText();

        try {
            double value1 = Double.parseDouble(text1);
            double value2 = Double.parseDouble(text2);
            if (value1 < 0 || value2 < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = area.rhombArea(value1, value2);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The area of the figure is " + valueToDisplay + " square centimeters");
            }

        } catch (NumberFormatException ex) {
            if (text1.isEmpty() || text2.isEmpty()) {
                countAlerts.createEmptyStringAlert();
            } else {
                countAlerts.createWrongFormatAlert();
            }
        }
    }

    private void squareCount() {

        String text = firstParamTextField.getText();

        try {
            double value = Double.parseDouble(text);
            if (value < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = area.squareArea(value);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The area of the figure is " + valueToDisplay + " square centimeters");
            }

        } catch (NumberFormatException ex) {
            if (text.isEmpty()) {
                countAlerts.createEmptyStringAlert();
            } else {
                countAlerts.createWrongFormatAlert();
            }
        }
    }

    private void trapeziumCount() {

        String text1 = firstParamTextField.getText();
        String text2 = secondParamTextField.getText();
        String text3 = thirdParamTextField.getText();

        try {
            double value1 = Double.parseDouble(text1);
            double value2 = Double.parseDouble(text2);
            double value3 = Double.parseDouble(text3);
            if (value1 < 0 || value2 < 0 || value3 < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = area.trapeziumArea(value1, value2, value3);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The area of the figure is " + valueToDisplay + " square centimeters");
            }

        } catch (NumberFormatException ex) {
            if (text1.isEmpty() || text2.isEmpty() || text3.isEmpty()) {
                countAlerts.createEmptyStringAlert();
            } else {
                countAlerts.createWrongFormatAlert();
            }
        }
    }

    private List<Figures> getFigures() {
        Figures[] values = Figures.values();
        List<Figures> figures = Arrays.asList(values);
        return figures;
    }
}
