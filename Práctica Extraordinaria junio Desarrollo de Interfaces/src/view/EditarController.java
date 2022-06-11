package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Trabajador;

public class EditarController {

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label cityLabel;
    //@FXML
    private Label workShiftLabel;
    @FXML
    private Label languagesLabel;

    private Stage dialogStage;
    private Trabajador trabajador;
    private boolean okClicked = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
        firstNameLabel.setText(trabajador.getFirstName());
        lastNameLabel.setText(trabajador.getLastName());
        streetLabel.setText(trabajador.getStreet());
        cityLabel.setText(trabajador.getCity());
        workShiftLabel.setText("Mañanas");
        languagesLabel.setText(trabajador.getIdiomas());
    }

    public boolean isOkClicked() {
        return okClicked;
    }
}
