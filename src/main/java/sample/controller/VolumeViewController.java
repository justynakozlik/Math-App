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
import sample.count.Volume;
import sample.countElements.Solids;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class VolumeViewController implements Initializable {

    @FXML
    private ChoiceBox volumeChoiceBox;
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
    private Volume volume;

    public VolumeViewController() {
        convert = new Convert();
        countAlerts = new CountAlerts();
        volume = new Volume();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        volumeChoiceBox.setItems(FXCollections.observableArrayList(getSolids()));
        initializeVolumeChoiceBox();
        initializeCountButton();
        initializeRefreshButton();
    }

    private void initializeVolumeChoiceBox() {
        volumeChoiceBox.setOnAction((x) -> {
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

        volumeChoiceBox.setValue(null);

        firstParamTextField.clear();
        secondParamTextField.clear();
        thirdParamTextField.clear();

        firstParamTextField.setEditable(true);
        secondParamTextField.setEditable(true);
        thirdParamTextField.setEditable(true);

        firstParamLabel.setText("Parameter a");
        secondParamLabel.setText("Parameter b");
        thirdParamLabel.setText("Parameter c");

        solutionLabel.setText("The volume of the solid is                cubic centimeters");
    }

    private void changeTemplate() {

        if (volumeChoiceBox.getSelectionModel().getSelectedItem().toString().equals("CYLINDER") ||
                volumeChoiceBox.getSelectionModel().getSelectedItem().toString().equals("CONE")) {

            firstParamLabel.setText("Radius");
            secondParamLabel.setText("Height");
            thirdParamLabel.setText("-");

            thirdParamTextField.setEditable(false);

        } else if (volumeChoiceBox.getSelectionModel().getSelectedItem().toString().equals("SPHERE")) {

            firstParamLabel.setText("Radius");
            secondParamLabel.setText("-");
            thirdParamLabel.setText("-");

            secondParamTextField.setEditable(false);
            thirdParamTextField.setEditable(false);

        } else if (volumeChoiceBox.getSelectionModel().getSelectedItem().toString().equals("CUBE")) {

            firstParamLabel.setText("Parameter a");
            secondParamLabel.setText("-");
            thirdParamLabel.setText("-");

            secondParamTextField.setEditable(false);
            thirdParamTextField.setEditable(false);

        } else if (volumeChoiceBox.getSelectionModel().getSelectedItem().toString().equals("CUBOID")) {

            firstParamLabel.setText("Parameter a");
            secondParamLabel.setText("Parameter b");
            thirdParamLabel.setText("Parameter c");

        }
    }

    private void count() {
        try {
            if (volumeChoiceBox.getSelectionModel().getSelectedItem().toString().equals("CUBE")) {
                cubeCount();
            } else if (volumeChoiceBox.getSelectionModel().getSelectedItem().toString().equals("CUBOID")) {
                cuboidCount();
            } else if (volumeChoiceBox.getSelectionModel().getSelectedItem().toString().equals("SPHERE")) {
                sphereCount();
            } else if (volumeChoiceBox.getSelectionModel().getSelectedItem().toString().equals("CYLINDER")) {
                cylinderCount();
            } else if (volumeChoiceBox.getSelectionModel().getSelectedItem().toString().equals("CONE")) {
                coneCount();
            }
        } catch (NullPointerException ex) {
            countAlerts.createNoSolidAlert();
        }
    }

    private void cubeCount() {

        String text = firstParamTextField.getText();

        try {
            double value = Double.parseDouble(text);
            if (value < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = volume.cubeVolume(value);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The volume of the solid is " + valueToDisplay + " cubic centimeters");
            }
        } catch (NumberFormatException ex) {
            if (text.isEmpty()) {
                countAlerts.createEmptyStringAlert();
            } else {
                countAlerts.createWrongFormatAlert();
            }
        }
    }

    private void cuboidCount() {

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
                double solution = volume.cuboidVolume(value1, value2, value3);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The volume of the solid is " + valueToDisplay + " cubic centimeters");
            }
        } catch (NumberFormatException ex) {
            if (text1.isEmpty() || text2.isEmpty() || text3.isEmpty()) {
                countAlerts.createEmptyStringAlert();
            } else {
                countAlerts.createWrongFormatAlert();
            }
        }
    }

    private void sphereCount() {

        String text = firstParamTextField.getText();

        try {
            double value = Double.parseDouble(text);
            if (value < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = volume.sphereVolume(value);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The volume of the solid is " + valueToDisplay + " cubic centimeters");
            }
        } catch (NumberFormatException ex) {
            if (text.isEmpty()) {
                countAlerts.createEmptyStringAlert();
            } else {
                countAlerts.createWrongFormatAlert();
            }
        }
    }

    private void cylinderCount() {

        String text1 = firstParamTextField.getText();
        String text2 = secondParamTextField.getText();

        try {
            double value1 = Double.parseDouble(text1);
            double value2 = Double.parseDouble(text2);
            if (value1 < 0 || value2 < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = volume.cylinderVolume(value1, value2);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The volume of the solid is " + valueToDisplay + " cubic centimeters");
            }
        } catch (NumberFormatException ex) {
            if (text1.isEmpty() || text2.isEmpty()) {
                countAlerts.createEmptyStringAlert();
            } else {
                countAlerts.createWrongFormatAlert();
            }
        }
    }

    private void coneCount() {

        String text1 = firstParamTextField.getText();
        String text2 = secondParamTextField.getText();

        try {
            double value1 = Double.parseDouble(text1);
            double value2 = Double.parseDouble(text2);
            if (value1 < 0 || value2 < 0) {
                countAlerts.createNegativeNumberAlert();
            } else {
                double solution = volume.coneVolume(value1, value2);
                String valueToDisplay = convert.customFormat("###.###", solution);
                solutionLabel.setText("The volume of the solid is " + valueToDisplay + " cubic centimeters");
            }
        } catch (NumberFormatException ex) {
            if (text1.isEmpty() || text2.isEmpty()) {
                countAlerts.createEmptyStringAlert();
            } else {
                countAlerts.createWrongFormatAlert();
            }
        }
    }

    private List<Solids> getSolids() {
        Solids[] values = Solids.values();
        List<Solids> solids = Arrays.asList(values);
        return solids;
    }
}
