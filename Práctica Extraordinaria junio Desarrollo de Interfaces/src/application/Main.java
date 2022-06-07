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

	private ObservableList<Trabajador> trabajadorData = FXCollections.observableArrayList();

	public Main() {
		trabajadorData.add(new Trabajador("Antonio", "García"));
		trabajadorData.add(new Trabajador("María Carmen", "Rodríguez"));
		trabajadorData.add(new Trabajador("María", "González"));
		trabajadorData.add(new Trabajador("Manuel", "Fernández"));
		trabajadorData.add(new Trabajador("José", "López"));
		trabajadorData.add(new Trabajador("Francisco", "Martínez"));
		trabajadorData.add(new Trabajador("Carmen", "Sánchez"));
		trabajadorData.add(new Trabajador("David", "Pérez"));
	}

	public ObservableList<Trabajador> getTrabajadorData() {
		return trabajadorData;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Pasamos al controlador de menu el objeto con el BorderPane principal
			MenuController menuController = loader.getController();
			menuController.setRootLayout(rootLayout);

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

}