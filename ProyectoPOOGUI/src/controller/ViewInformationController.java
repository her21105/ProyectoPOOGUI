/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Desktop;
import static java.awt.SystemColor.window;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import model.Animal;
import javafx.util.StringConverter;


/**
 * FXML Controller class
 *
 * @author Joabh
 */
public class ViewInformationController implements Initializable {

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
    private ComboBox<String> AnimalList;
    
    @FXML
    private Label ShowInfo;
    
    @FXML
    private ImageView imgAnimals;
    
    private int select;
    
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
    private void InfoAnimals(ActionEvent e){
        
      /*  select = AnimalList.getSelectionModel().getSelectedIndex();
        
        Animal animal = leerAnimalesDelArchivo().get(select);
        String string = "nombres: "+animal.getNombre()+"\n"
                + "descripción: "+animal.getDescripcion()+"\n"
                + "información: "+animal.getInformacion();
        
        ShowInfo.setText(string); */
        
        
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
        
        ArrayList<Animal> aux = new ArrayList<Animal>();
        ArrayList<String> aux2 = new ArrayList<String>();
        aux.addAll(leerAnimalesDelArchivo());
        for(int i = 0; i<aux.size(); i++    ){
            
            
            aux2.add(i+" "+aux.get(i).getNombre());
            
        }
        AnimalList.getItems().addAll(aux2); //ingresar datos
        /*AnimalList.setConverter(new StringConverter<Animal>() { //metodo abstracto
            @Override
            public String toString(Animal object) { //solo mostrar nombre
                return object.getNombre();
            }

            @Override
            public Animal fromString(String string) {
                return null;
            }
        }); */
        
        
        AnimalList.setOnAction((event2)->{
    
        //System.out.println(AnimalList.getSelectionModel().getSelectedIndex());
        select = AnimalList.getSelectionModel().getSelectedIndex();
        
        Animal animal = leerAnimalesDelArchivo().get(select);
        String string = "nombres: "+animal.getNombre()+"\n"
                + "descripción: "+animal.getDescripcion()+"\n"
                + "información: "+animal.getInformacion();
        
        ShowInfo.setText(string);
        
        Image image1 = new Image(getClass().getResourceAsStream("/images/"+animal.getNombre()+".png"));
        imgAnimals.setImage(image1);
        
        
        
    
    });
        
        
    }


private ArrayList<Animal> leerAnimalesDelArchivo(){//devuelve el arraylist de Animales
    
    ArrayList<Animal> listaAnimales = new ArrayList<Animal>();
    try{
        
        
        ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
        File file = new File(classLoader.getResource("containers/animalesFile.txt").getFile());
        Scanner s = new Scanner(file);
        
        
        while (s.hasNextLine()){
            
            String linea = s.nextLine();
            String[] items = linea.split("\\|");

            String nombre = items[0];
            String descripcion = items[1];
            String informacion = items[2]; 
            
            Animal nuevoAnimal = new Animal(nombre, descripcion, informacion);
            listaAnimales.add(nuevoAnimal);
            
        }
         s.close();
        
    } catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "error al ingresar a la base de datos");
        
    }
        return listaAnimales;
    
    
}    


    
}
