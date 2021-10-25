/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Desktop;
import static java.awt.SystemColor.window;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Joabh
 */
public class viewStartController implements Initializable {
    
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
    private Button InicioAdministradorButton;
    
    /**
     * Método para ir a inicio de administradores
     * @param event 
     */
    @FXML
    private void goInicioAdministradores(ActionEvent event){
        loadStage("/view/ViewAdministrador.fxml", event);
    }
    
    /**
     * Método para ir al menú
     * @param event 
     */
    @FXML
    private void goMenu(ActionEvent event){
        
        loadStage("/view/viewStart.fxml", event);
        
    }
    
    /**
     * Método para ir a información
     * @param event 
     */
    @FXML
    private void goInfo (ActionEvent event){
        
        loadStage("/view/ViewInformation.fxml", event);
        
    }
    
    /**
     * Método para ir a quiénes somos
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
     * Método para cargar el escenario
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
            
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "error");
            
        }
        
        
    }
    
    
    
    
    
    /**
     * Método para inizializar
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
