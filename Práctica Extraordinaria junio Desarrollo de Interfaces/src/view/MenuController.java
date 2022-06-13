package view;

import java.io.IOException;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Trabajador;

public class MenuController {

    private BorderPane rootLayout;

    private Main mainApp;

	private ObservableList<Trabajador> trabajadorData = FXCollections.observableArrayList();

    private TableView<Trabajador> trabajadorTable;

    @FXML
    private void initialize() {
		trabajadorData.add(new Trabajador("Antonio", "García"));
		trabajadorData.add(new Trabajador("María Carmen", "Rodríguez"));
		trabajadorData.add(new Trabajador("María", "González"));
		trabajadorData.add(new Trabajador("Manuel", "Fernández"));
		trabajadorData.add(new Trabajador("José", "López"));
		trabajadorData.add(new Trabajador("Francisco", "Martínez"));
		trabajadorData.add(new Trabajador("Carmen", "Sánchez"));
		trabajadorData.add(new Trabajador("David", "Pérez"));
    }

    @FXML
    void abrirDatos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuController.class.getResource("pantallaDatos.fxml"));
            AnchorPane abrir = (AnchorPane) loader.load();

            rootLayout.setCenter(abrir);

            TrabajadorOverviewController controller = loader.getController();
            controller.setTrabajadorTable(trabajadorData);
            controller.setMain(mainApp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public boolean abrirEditar(Trabajador trabajador) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuController.class.getResource("pantallaEditar.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editar Trabajador");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            EditarController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setTrabajador(trabajador);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    void abrirTutorial(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuController.class.getResource("pantallaTutorial.fxml"));
            AnchorPane abrir = (AnchorPane) loader.load();

            rootLayout.setCenter(abrir);

            TutorialController controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void cerrarPantalla(ActionEvent event) {
        try {
            rootLayout.setCenter(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TableView<Trabajador> getTrabajadorTable() {
        return trabajadorTable;
    }

    public void setTrabajadorTable(TableView<Trabajador> trabajadorTable) {
        this.trabajadorTable = trabajadorTable;
    }

	public ObservableList<Trabajador> getTrabajadorData() {
		return trabajadorData;
	}

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public void setRootLayout(BorderPane rootLayout) {
        this.rootLayout = rootLayout;
    }

    public void setMain(Main mainApp) {
        this.mainApp = mainApp;
    }

}