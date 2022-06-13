package view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import application.Main;
import model.Trabajador;

public class TrabajadorOverviewController {

    private Main mainApp;

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
    private Label cityLabel;
    @FXML
    private Label workShiftLabel;
    @FXML
    private Label languagesLabel;

    public TrabajadorOverviewController() {
    }

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().lastNameProperty());

        showPersonDetails(null);

        trabajadorTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    public void setTrabajadorTable(ObservableList<Trabajador> trabajadorData) {
        this.trabajadorTable.setItems(trabajadorData);;

    }

    private void showPersonDetails(Trabajador trabajador) {
        if (trabajador != null) {
            firstNameLabel.setText(trabajador.getFirstName());
            lastNameLabel.setText(trabajador.getLastName());
            streetLabel.setText(trabajador.getStreet());
            cityLabel.setText(trabajador.getCity());
            workShiftLabel.setText(trabajador.getTurno());
            languagesLabel.setText(trabajador.getIdiomas());
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            cityLabel.setText("");
            workShiftLabel.setText("");
            languagesLabel.setText("");
        }
    }

    @FXML
    private void handleDeleteTrabajador() {
        int selectedIndex = trabajadorTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            trabajadorTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Sin selección");
            alert.setHeaderText("No hay trabajador seleccionado");
            alert.setContentText("Por favor selecciona un trabajador de la tabla.");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewTrabajador() {
        Trabajador tempTrabajador = new Trabajador();
        boolean okClicked = mainApp.getMenuController().abrirEditar(tempTrabajador);
        if (okClicked) {
            mainApp.getMenuController().getTrabajadorData().add(tempTrabajador);
        }
    }

    @FXML
    private void handleEditTrabajador() {
        Trabajador selectedTrabajador = trabajadorTable.getSelectionModel().getSelectedItem();
        if (selectedTrabajador != null) {
            boolean okClicked = mainApp.getMenuController().abrirEditar(selectedTrabajador);
            if (okClicked) {
                showPersonDetails(selectedTrabajador);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Sin selección");
            alert.setHeaderText("No hay trabajador seleccionado");
            alert.setContentText("Por favor selecciona un trabajador de la tabla.");

            alert.showAndWait();
        }
    }

    public void setMain(Main mainApp) {
        this.mainApp = mainApp;
    }

}