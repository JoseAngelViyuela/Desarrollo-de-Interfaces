package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TutorialController {

    @FXML
    private Label tutorialDatos;
    @FXML
    private Label tutorialAgnadir;
    @FXML
    private Label tutorialEditar;
    @FXML
    private Label tutorialEliminar;

    @FXML
    private void initialize() {
    	tutorialDatos.setText("En la pantalla de Datos se encuentra la tabla con el nombre de los trabajadores los cuales podemos ojear con un click para ver el resto de datos");
    	tutorialAgnadir.setText("Podemos añadir datos en el botón de añadir e introduciendo los valores que consideremos y pulsar el botón de confirmación");
    	tutorialEditar.setText("Para editar un trabajador tendremos que seleccionarlo con un click y cambiar los valores que consideremos");
    	tutorialEliminar.setText("Para eliminar el dato de un trabajador hay que seleccionarlo con un click, pero hay que tener cuidado porque perderemos los datos");
    }
}
