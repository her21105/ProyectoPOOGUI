/*
 * Clase Principal de la Interfaz Gráfica
 */
package proyectopoogui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Joabh
 */
public class ProyectoPOOGUI extends Application {
    
    /**
     * Método para comenzar
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/viewStart.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método para inicializar todo
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
