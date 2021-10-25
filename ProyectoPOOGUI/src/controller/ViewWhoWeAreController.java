/*
 * Archivo ViewWhoWeAreController.java
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
/**
 * FXML Controller class:
 * Controlador de ¿Quiénes Somos?
 * @author Joabh
 */
public class ViewWhoWeAreController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button menuButton;
    
    @FXML
    private Button informButton;
    
    @FXML
    private Button whoWeAreButton;
    
    @FXML
    private Button DonateButton;
    
    @FXML
    private ImageView imgSM;
    
    @FXML
    private ImageView imgSM1;
    
    @FXML
    private ImageView imgSM2;
    
    @FXML
    private Button InicioAdministradorButton;
    
    /**
     * Método para ir a la seccion de inicio
     * @param event 
     */
    @FXML
    private void goInicioAdministradores(ActionEvent event){
        loadStage("/view/ViewAdministrador.fxml", event);
    }
    
    @FXML
    private Label Title;
    
    private String text;
    
    /**
     * Método para ir al menú
     * @param event 
     */
    @FXML
    private void goMenu(ActionEvent event){
        
        loadStage("/view/viewStart.fxml", event);
        
    }
    
    /**
     * Método para ir a Información
     * @param event 
     */
    @FXML
    private void goInfo (ActionEvent event){
        
        loadStage("/view/ViewInformation.fxml", event);
        
    }
    
    /**
     * Método para ir a ¿Quiénes somos?
     * @param event 
     */
    @FXML
    private void goWhoWeAre (ActionEvent event){
        
        loadStage("/view/ViewWhoWeAre.fxml", event);
        
    }
    
    /**
     * Método para ir a Donar
     * @param event 
     */
    @FXML
    private void goDonate (ActionEvent event){
        
        loadStage("/view/ViewDonate.fxml", event);
        
    }
    
    /**
     * Metodo para cargar el escenario
     * @param url
     * @param event 
     */
    private void loadStage(String url, Event event){
        
        try{
            
        Object eventSource = event.getSource();
        Node SourceAsNode = (Node) eventSource;
        Scene oldScene = SourceAsNode.getScene();
        Window window = oldScene.getWindow();
        Stage stage = (Stage)window;
        stage.hide();
        
        Parent root = FXMLLoader.load(getClass().getResource(url));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.show();
        
        newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Platform.exit();
                }
            });  
            
        }catch (IOException ex){
            
            JOptionPane.showMessageDialog(null, "error");
            
        }
        
        
    }
    
    /**
     * Método para inicializar
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    Image image2 = new Image(getClass().getResourceAsStream("/images/fb.png"));
    imgSM.setImage(image2);
    
    Image image3 = new Image(getClass().getResourceAsStream("/images/ig.png"));
    imgSM1.setImage(image3);
    
    Image image4 = new Image(getClass().getResourceAsStream("/images/gm.png"));
    imgSM2.setImage(image4);
    
    text = "¡Síguenos en nuestras redes sociales!";
    Title.setText(text);
    }    
    
}
