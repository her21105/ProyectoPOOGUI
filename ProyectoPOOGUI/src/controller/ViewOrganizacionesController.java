/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

import model.Organizaciones;

/**
 * FXML Controller class
 *
 * @author Joabh
 */
public class ViewOrganizacionesController implements Initializable {

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
    private FlowPane AnimalBox;
    
    @FXML
    private ComboBox<String> OrganizationList;
    
    @FXML
    private Label ShowInfo;
    
    @FXML
    private Button InicioAdministradorButton;
    
    @FXML
    private Button BTTOrganization;
    
    @FXML
    private void goInicioAdministradoresgo(ActionEvent event){
        loadStage("/view/ViewAdministrador.fxml", event);
    }
    
    @FXML
    private void goMenu(ActionEvent event){
        
        loadStage("/view/viewStart.fxml", event);
        
    }
    
    @FXML
    private void goInfo (ActionEvent event){
        
        loadStage("/view/ViewInformation.fxml", event);
        
    }
    
    @FXML
    private void goWhoWeAre (ActionEvent event){
        
        loadStage("/view/ViewWhoWeAre.fxml", event);
        
    }
    
    @FXML
    private void goDonate (ActionEvent event){
        
        loadStage("/view/ViewDonate.fxml", event);
        
    }
    
    @FXML
    private void goOrg (ActionEvent event){
        
        loadStage("/view/ViewOrganizaciones.fxml", event);
        
    }

    @FXML
    private void InfoOrganization (ActionEvent event){
        
        
        
    }
    
    private void loadStage(String url, Event event){//abre otras pestañas y cierra la actual
        
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<Organizaciones> aux = new ArrayList<Organizaciones>();
        ArrayList<String> aux2 = new ArrayList<String>();
        aux.addAll(leerOrganizacionesDelArchivo());
        for(int i = 0; i<aux.size(); i++    ){
            
            
            aux2.add(i+" "+aux.get(i).getNombre());
            
        }
        OrganizationList.getItems().addAll(aux2);
        
        OrganizationList.setOnAction((event2)->{
    
        //System.out.println(AnimalList.getSelectionModel().getSelectedIndex());
        select = OrganizationList.getSelectionModel().getSelectedIndex();
        
        Organizaciones organizaciones = leerOrganizacionesDelArchivo().get(select);
        String string = "nombres: "+organizaciones.getNombre()+"\n"
                + "descripción: "+organizaciones.getDescripcion()+"\n"
                + "información: "+organizaciones.getInformacion();
        
        ShowInfo.setText(string);

    
    });
    }    
    
    private ArrayList<Organizaciones> leerOrganizacionesDelArchivo(){
        ArrayList<Organizaciones> listaOrganizaciones = new ArrayList<Organizaciones>();
        try{
            
            ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
            File file = new File(classLoader.getResource("containers/organizacionesFile.txt").getFile());
            Scanner s = new Scanner(file);
            
            while (s.hasNextLine()){
                String linea = s.nextLine();
                String[] items = linea.split("\\|");
                
                String nombre = items[0];
                String annioDeCreacion = items[1];
                String lugar= items[2];
                String informacionDeContacto= items[3];
                String informacion= items[4];

                Organizaciones nuevaOrganizaciones = new Organizaciones(nombre, annioDeCreacion, lugar, informacionDeContacto, informacion);
                listaOrganizaciones.add(nuevaOrganizaciones);
            }
            s.close();
        } catch (Exception e){
            
        }
        return listaOrganizaciones;
        
    }
}
