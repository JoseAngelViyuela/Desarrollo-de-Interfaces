package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import application.Main;
import model.Trabajador;
import util.DateUtil;

public class TrabajadorOverviewController {

	@FXML
	private TableView<Trabajador> trabajadorTable;
    @FXML
    private TableColumn<Trabajador, String> firstNameColumn;
    @FXML
    private TableColumn<Trabajador, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    private Main mainApp;

    public TrabajadorOverviewController() {
    }

    @FXML
    private void initialize() {
    	// Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().lastNameProperty());

        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        trabajadorTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    public void setMain(Main mainApp) {
        this.mainApp = mainApp;

        trabajadorTable.setItems(mainApp.getTrabajadorData());
    }

    public void setTrabajadorTable(TableView<Trabajador> trabajadorTable) {
        this.trabajadorTable = trabajadorTable;
    }

    private void showPersonDetails(Trabajador trabajador) {
        if (trabajador != null) {
            firstNameLabel.setText(trabajador.getFirstName());
            lastNameLabel.setText(trabajador.getLastName());
            streetLabel.setText(trabajador.getStreet());
            postalCodeLabel.setText(Integer.toString(trabajador.getPostalCode()));
            cityLabel.setText(trabajador.getCity());
            birthdayLabel.setText(DateUtil.format(trabajador.getBirthday()));
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        }
    }


}