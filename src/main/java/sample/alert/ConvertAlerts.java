package sample.alert;

import javafx.scene.control.Alert;

public class ConvertAlerts {

    public void createEmptyStringAlert(){
        alertPattern("Information", "Empty text field", "Enter data to convert.");
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
