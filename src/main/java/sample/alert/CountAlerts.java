package sample.alert;

import javafx.scene.control.Alert;

public class CountAlerts {

    public void createNegativeNumberAlert(){
        alertPattern("Information", "Negative number", "Value cannot be negative number.");
    }

    public void createQuadraticEquationWrongAValueAlert(){
        alertPattern("Information", "Wrong \"a\" parameter value","Parameter \"a\" cannot be equal zero +\nEnter a different value to count.");
    }

    public void createEmptyStringAlert(){
        alertPattern("Information", "Empty text field", "Enter data to count.");
    }

    public void createWrongFormatAlert(){
        alertPattern("Information", "Wrong format",
                "Enter an integer or a floating point number." + "\nFor example: 14 or 25.5");
    }

    private void alertPattern(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
