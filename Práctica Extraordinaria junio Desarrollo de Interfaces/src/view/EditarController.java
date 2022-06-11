package view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Trabajador;

public class EditarController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField cityField;
    //@FXML
    private TextField workShiftField;
    @FXML
    private TextField languagesField;

    private Stage dialogStage;
    private Trabajador trabajador;
    private boolean okClicked = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
        firstNameField.setText(trabajador.getFirstName());
        lastNameField.setText(trabajador.getLastName());
        streetField.setText(trabajador.getStreet());
        cityField.setText(trabajador.getCity());
        //workShiftField.setText(trabajador.getCity());
        languagesField.setText(trabajador.getIdiomas());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            trabajador.setFirstName(firstNameField.getText());
            trabajador.setLastName(lastNameField.getText());
            trabajador.setStreet(streetField.getText());
            trabajador.setCity(cityField.getText());
            trabajador.setIdiomas(languagesField.getText());


            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }
        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }
        if (languagesField.getText() == null || languagesField.getText().length() == 0) {
            errorMessage += "No valid languages!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Campos incorrectos");
            alert.setHeaderText("Corrija los campos incorrectos");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
