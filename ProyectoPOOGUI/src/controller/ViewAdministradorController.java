/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import model.Organizaciones;
import model.Usuario;
import model.Animal;

/**
 * FXML Controller class
 *
 * @author montserrat
 */
public class ViewAdministradorController implements Initializable {

    private static boolean sesion;
    
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
    @FXML
    private TextField tfUsuario;
    @FXML
    private Button btSubmitUser;
    @FXML
    private Button btSubmitAnimal;
    @FXML
    private Button btSubmitOrganizacion;
    @FXML
    private TextField trNewUser;
    @FXML
    private TextField trNewPassword;
    @FXML
    private TextField trNewAnimal;
    @FXML
    private TextField trNewDescripcionAnimal;
    @FXML
    private TextField trNewInformacionAnimal;
    @FXML
    private TextField tfNewOrganizacion;
    @FXML
    private TextField tfNewFecha;
    @FXML
    private TextField tfNewUbicacion;
    @FXML
    private TextField tfNewContacto;
    @FXML
    private TextField tfNewGeneral;
    @FXML
    private Button iniciarSesion;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField MUser;
    @FXML
    private TextField MPassword;
    @FXML
    private ComboBox CBUsers;
    @FXML
    private TextField MAnimals;
    @FXML
    private TextField MDescripcionAnimal;
    @FXML
    private TextField MInformationAnimal;
    @FXML
    private ComboBox CBAnimals;
    @FXML
    private TextField MOrgName;
    @FXML
    private TextField MDateOrg;
    @FXML
    private TextField MUbicationOrg;
    @FXML
    private TextField MContactOrg;
    @FXML
    private TextField MGeneralOrg;
    @FXML
    private ComboBox CBOrganizaciones;
    @FXML
    private Button BTMUser;
    @FXML
    private Button BTMAnimals;
    @FXML
    private Button BTMOrg;
    
    ControladorArchivos controlador = new ControladorArchivos();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
    }    
    
    @FXML
    private void MAnimal(ActionEvent event){
        
    }
    @FXML
    private void MUser(ActionEvent event){
        
    }
    
    @FXML
    private void MOrg (ActionEvent event){
        
    }

    @FXML
    private void goMenu(ActionEvent event) {
        
        loadStage("/view/viewStart.fxml", event);
        sesion = false;
        
    }

    
    /**
     * Metodo para ir a informacion
    *@param ActionEvent event
    */
    @FXML
    private void goInfo(ActionEvent event) {
        
        loadStage("/view/ViewInformation.fxml", event);
        sesion = false;
        
    }
    
    /**
     * Metodo para ir a WhoWeAre
    *@param ActionEvent event
    */
    @FXML
    private void goWhoWeAre(ActionEvent event) {
        
        loadStage("/view/ViewWhoWeAre.fxml", event);
        sesion = false;
        
    }

    /**
     * Metodo para ir a donate
    *@param ActionEvent event
    */
    @FXML
    private void gotDonate(ActionEvent event) {
        
        loadStage("/view/ViewDonate.fxml", event);
        sesion = false;
        
    }

    /**
     * Metodo para ir a inicio administradores
    *@param ActionEvent event
    */
    @FXML
    private void goInicioAdministradores(ActionEvent event) {
        
        loadStage("/view/ViewAdministrador.fxml", event);
        sesion = false;
        
    }
   
    /**
     * Metodo para ir a Organizaciones
    *@param ActionEvent event
    */
    @FXML
    private void goOrg (ActionEvent event){
        
        loadStage("/view/ViewOrganizaciones.fxml", event);
        sesion = false;
        
    }

    /**
     * Metodo para agregar un nuevo usuario
    *@param ActionEvent event
    */
    @FXML
    private void newUser (ActionEvent event) throws IOException{
        
        if(!trNewUser.getText().isEmpty() && !trNewPassword.getText().isEmpty() && sesion == true){

            Usuario nUP = new Usuario(trNewUser.getText(), trNewPassword.getText());
            controlador.agregarUsuario(nUP);
            trNewUser.clear(); 
            trNewPassword.clear();
            
            JOptionPane.showMessageDialog(null, "se ha agregado un nuevo usuario");

        }else{
            
            JOptionPane.showMessageDialog(null, "llene todas las casillas/login");
        }
        
    }

    /**
     * Metodo para agregar un nuevo animal
    *@param ActionEvent event
    */
    @FXML
    private void newAnimal (ActionEvent event){
        
        if(!trNewAnimal.getText().isEmpty() && !trNewDescripcionAnimal.getText().isEmpty() && !trNewInformacionAnimal.getText().isEmpty() && sesion == true){
            
            
            
            Animal nA = new Animal(trNewAnimal.getText(),trNewDescripcionAnimal.getText(),trNewInformacionAnimal.getText());
            controlador.agregarAnimal(nA);
            trNewAnimal.clear();
            trNewDescripcionAnimal.clear();
            trNewInformacionAnimal.clear();
            JOptionPane.showMessageDialog(null, "se ha agregado un nuevo animal");
            
        }else{
            JOptionPane.showMessageDialog(null, "llene todas las casillas/login");
        }
        
    }

    
    /**
     * Metodo para agregar una nueva organizacion
    *@param ActionEvent event
    */
    @FXML
    private void newOrg (ActionEvent event){
        
        if(!tfNewOrganizacion.getText().isEmpty() && !tfNewFecha.getText().isEmpty() && !tfNewUbicacion.getText().isEmpty() && !tfNewContacto.getText().isEmpty() && !tfNewGeneral.getText().isEmpty() && sesion == true ){
            
            
            Organizaciones nOrg = new Organizaciones(tfNewOrganizacion.getText(), tfNewFecha.getText(), tfNewUbicacion.getText(), tfNewContacto.getText(), tfNewGeneral.getText());
            tfNewOrganizacion.clear(); 
            tfNewFecha.clear(); 
            tfNewUbicacion.clear(); 
            tfNewContacto.clear(); 
            tfNewGeneral.clear();
            controlador.agregarOrganizacion(nOrg);
            JOptionPane.showMessageDialog(null, "se ha agregado una nueva organización");
            
        }else{
            JOptionPane.showMessageDialog(null, "llene todas las casillas/login");
        }
        
    }

    /**
     * Metodo para ingresar sesion
    *@param ActionEvent event
    */
    @FXML
    private void login (ActionEvent event){
                
        //Scanner scan = new Scanner(System.in);
        //iniciar sesion
        //parte solo para administradores con usuario y password
        boolean seguir = false;
        boolean seguir2 = false;
        ArrayList<Usuario> usuariosD = leerUsariosDelArchivo();
        
        
        if(tfUsuario.getText().isEmpty() || tfPassword.getText().isEmpty() || (tfUsuario.getText().isEmpty() && tfPassword.getText().isEmpty())){
            
            JOptionPane.showMessageDialog(null, "ingrese todos los datos necesarios");
            
        }else{
        
            //String u = scan.nextLine();

            for (Usuario h:usuariosD){
                if (h.revisarUsuario(tfUsuario.getText()) == 0){
                    seguir = true;
                    
                } else {
                    
                
                }
            }
            if (seguir == true){
                
                for (Usuario k:usuariosD){
                    if (k.revisarUsuarioYPassword(tfUsuario.getText(), tfPassword.getText()) == 0){
                        seguir2 = true;
                        
                        //inicio de sesion
                        sesion = true;
                        JOptionPane.showMessageDialog(null, "inicio de sesion con exito");
                        
                        break;
                    }else{
                                                
                    }
                }
                if(seguir2 == false){
                    JOptionPane.showMessageDialog(null, "verifique sus datos");
                }
            } else{
                JOptionPane.showMessageDialog(null, "verifique sus datos");
            }
        }
        
        
        
    }

    /**
     * Metodo para leer usuarios del archivo en cuestion
    *@return ArrayList Usuario
    */
    private ArrayList<Usuario> leerUsariosDelArchivo(){
        
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        try{
            ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
            File file = new File(classLoader.getResource("containers/registro.txt").getFile());
            Scanner s = new Scanner(file);
            
            while (s.hasNextLine()){
                String linea = s.nextLine();
                String[] items = linea.split("\\|");
                
                String user = items[0];
                String password = items[1];

                Usuario nuevoUsuario = new Usuario(user, password);
                listaUsuarios.add(nuevoUsuario);
            }
            s.close();
        } catch (Exception e){
            
            System.out.println(e);
        }
        System.out.println(listaUsuarios);
        return listaUsuarios;
    }
    
 
    /**
     * Metodo para mostrar la pagina
    *@param String url
    * @param Event event
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
    
}
