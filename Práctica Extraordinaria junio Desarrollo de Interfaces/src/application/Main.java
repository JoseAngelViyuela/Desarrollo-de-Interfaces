package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Trabajador;
import view.MenuController;

public class Main extends Application {

    private Stage primaryStage;
	private BorderPane rootLayout;
	private MenuController menuController;

	public Main() {
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el dise�o del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Pasamos al controlador de menu el objeto con el BorderPane principal
			menuController = loader.getController();
			menuController.setRootLayout(rootLayout);
			menuController.setMain(this);

			// Mostramos la escena del BorderPane de la variable rootLayot
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Practica Final");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public MenuController getMenuController() {
		return menuController;
	}

}