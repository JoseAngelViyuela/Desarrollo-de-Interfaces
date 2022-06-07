package view;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.Trabajador;

public class MenuController {

    private BorderPane rootLayout;

    private Main mainApp;

    private TableView<Trabajador> trabajadorTable;

    @FXML
    private void initialize() {
    }

    @FXML
    void abrirDatos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuController.class.getResource("pantallaDatos.fxml"));
            AnchorPane abrir = (AnchorPane) loader.load();

            rootLayout.setCenter(abrir);

            TrabajadorOverviewController controller = loader.getController();
            controller.setTrabajadorTable(trabajadorTable);;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirTutorial(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuController.class.getResource("pantallaTutorial.fxml"));
            AnchorPane abrir = (AnchorPane) loader.load();

            rootLayout.setCenter(abrir);
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

    public void setMain(Main mainApp) {
        this.mainApp = mainApp;

        trabajadorTable.setItems(mainApp.getTrabajadorData());
    }


    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public void setRootLayout(BorderPane rootLayout) {
        this.rootLayout = rootLayout;
    }

}