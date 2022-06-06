package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MenuController {

    private BorderPane rootLayout;

    @FXML
    private void initialize() {
    }

    @FXML
    void abrirDatos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuController.class.getResource("/view/pantallaDatos.fxml"));
            AnchorPane abrir = (AnchorPane) loader.load();

            rootLayout.setCenter(abrir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirMantenimiento(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuController.class.getResource("/view/pantallaMantenimiento.fxml"));
            AnchorPane abrir = (AnchorPane) loader.load();

            rootLayout.setCenter(abrir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirTutorial(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuController.class.getResource("/view/pantallaTutorial.fxml"));
            AnchorPane abrir = (AnchorPane) loader.load();

            rootLayout.setCenter(abrir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public void setRootLayout(BorderPane rootLayout) {
        this.rootLayout = rootLayout;
    }

}
