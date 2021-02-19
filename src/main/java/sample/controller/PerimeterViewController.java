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
import sample.count.Perimeter;
import sample.countElements.Figures;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class PerimeterViewController implements Initializable {

    @FXML
    private ChoiceBox perimeterChoiceBox;
    @FXML
    private Label firstParamLabel;
    @FXML
    private Label secondParamLabel;
    @FXML
    private Label thirdParamLabel;
    @FXML
    private Label fourthParamLabel;
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
    private TextField fourthParamTextField;
    @FXML
    private Label solutionLabel;

    private Convert convert;
    private CountAlerts countAlerts;
    private Perimeter perimeter;

    public PerimeterViewController() {
        convert = new Convert();
        countAlerts = new CountAlerts();
        perimeter = new Perimeter();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        perimeterChoiceBox.setItems(FXCollections.observableArrayList(getFigures()));
        initializePerimeterChoiceBox();
        initializeCountButton();
        initializeRefreshButton();
    }

    private void initializePerimeterChoiceBox() {
        perimeterChoiceBox.setOnAction((x) -> {
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

        perimeterChoiceBox.setValue(null);

        firstParamTextField.clear();
        secondParamTextField.clear();
        thirdParamTextField.clear();
        fourthParamTextField.clear();

        firstParamTextField.setEditable(true);
        secondParamTextField.setEditable(true);
        thirdParamTextField.setEditable(true);
        fourthParamTextField.setEditable(true);

        firstParamLabel.setText("Parameter a");
        secondParamLabel.setText("Parameter b");
        thirdParamLabel.setText("Parameter c");
        fourthParamLabel.setText("Parameter d");

        solutionLabel.setText("The perimeter of the figure is                centimeters");

    }

    private void changeTemplate() {
        if (perimeterChoiceBox.getSelectionModel().getSelectedItem().toString().equals("SQUARE") ||
                perimeterChoiceBox.getSelectionModel().getSelectedItem().toString().equals("RHOMB")) {

            firstParamLabel.setText("Parameter a");
            secondParamLabel.setText("-");
            thirdParamLabel.setText("-");
            fourthParamLabel.setText("-");

            secondParamTextField.setEditable(false);
            thirdParamTextField.setEditable(false);
            fourthParamTextField.setEditable(false);

        } else if (perimeterChoiceBox.getSelectionModel().getSelectedItem().toString().equals("CIRCLE")) {

            firstParamLabel.setText("Radius");
            secondParamLabel.setText("-");
            thirdParamLabel.setText("-");
            fourthParamLabel.setText("-");

            secondParamTextField.setEditable(false);
            thirdParamTextField.setEditable(false);
            fourthParamTextField.setEditable(false);

        } else if (perimeterChoiceBox.getSelectionModel().getSelectedItem().toString().equals("RECTANGLE") ||
                perimeterChoiceBox.getSelectionModel().getSelectedItem().toString().equals("RHOMBOID")) {

            firstParamLabel.setText("Parameter a");
            secondParamLabel.setText("Parameter b");
            thirdParamLabel.setText("-");
            fourthParamLabel.setText("-");

            thirdParamTextField.setEditable(false);
            fourthParamTextField.setEditable(false);

        } else if (perimeterChoiceBox.getSelectionModel().getSelectedItem().toString().equals("TRAPEZIUM")) {

            firstParamLabel.setText("Parameter a");
            secondParamLabel.setText("Parameter b");
            thirdParamLabel.setText("Parameter c");
            fourthParamLabel.setText("Parameter d");

        } else if (perimeterChoiceBox.getSelectionModel().getSelectedItem().toString().equals("TRIANGLE")) {

            firstParamLabel.setText("Parameter a");
            secondParamLabel.setText("Parameter b");
            thirdParamLabel.setText("Parameter c");
            fourthParamLabel.setText("-");

            fourthParamTextField.setEditable(false);

        }
    }

    private void count() {
        try {
            if (perimeterChoiceBox.getSelectionModel().getSelectedItem().toString().equals("CIRCLE")) {
                circleCount();
            } else if (perimeterChoiceBox.getSelectionModel().getSelectedItem().toString().equals("TRIANGLE")) {
                triangleCount();
            } else if (perimeterChoiceBox.getSelectionModel().getSelectedItem().toString().equals("RECTANGLE")) {
                rectangleCount();
            } else if (perimeterChoiceBox.getSelectionModel().getSelectedItem().toString().equals("RHOMBOID")) {
                rhomboidCount();
            } else if (perimeterChoiceBox.getSelectionModel().getSelectedItem().toString().equals("RHOMB")) {
                rhombCount();
            } else if (perimeterChoiceBox.getSelectionModel().getSelectedItem().toString().equals("SQUARE")) {
                squareCount();
            } else if (perimeterChoiceBox.getSelectionModel().getSelectedItem().toString().equals("TRAPEZIUM")) {
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
                double solution = perimeter.circlePerimeter(value);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The perimeter of the figure is " + valueToDisplay + " centimeters");
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
        String text2 = secondParamTextField.getText();
        String text3 = thirdParamTextField.getText();

        try {
            double value1 = Double.parseDouble(text1);
            double value2 = Double.parseDouble(text2);
            double value3 = Double.parseDouble(text3);
            if (value1 < 0 || value2 < 0 || value3 < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = perimeter.trianglePerimeter(value1, value2, value3);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The perimeter of the figure is " + valueToDisplay + " centimeters");
            }
        } catch (NumberFormatException ex) {
            if (text1.isEmpty() || text2.isEmpty() || text3.isEmpty()) {
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
                double solution = perimeter.rectanglePerimeter(value1, value2);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The perimeter of the figure is " + valueToDisplay + " centimeters");
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
        String text2 = secondParamTextField.getText();

        try {
            double value1 = Double.parseDouble(text1);
            double value2 = Double.parseDouble(text2);
            if (value1 < 0 || value2 < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = perimeter.rhomboidPerimeter(value1, value2);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The perimeter of the figure is " + valueToDisplay + " centimeters");
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

        String text = firstParamTextField.getText();

        try {
            double value = Double.parseDouble(text);
            if (value < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = perimeter.rhombPerimeter(value);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The perimeter of the figure is " + valueToDisplay + " centimeters");
            }
        } catch (NumberFormatException ex) {
            if (text.isEmpty()) {
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
                double solution = perimeter.squarePerimeter(value);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The perimeter of the figure is " + valueToDisplay + " centimeters");
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
        String text4 = fourthParamTextField.getText();

        try {
            double value1 = Double.parseDouble(text1);
            double value2 = Double.parseDouble(text2);
            double value3 = Double.parseDouble(text3);
            double value4 = Double.parseDouble(text4);
            if (value1 < 0 || value2 < 0 || value3 < 0 || value4 < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = perimeter.trapeziumPerimeter(value1, value2, value3, value4);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The perimeter of the figure is " + valueToDisplay + " centimeters");
            }
        } catch (NumberFormatException ex) {
            if (text1.isEmpty() || text2.isEmpty() || text3.isEmpty() || text4.isEmpty()) {
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
