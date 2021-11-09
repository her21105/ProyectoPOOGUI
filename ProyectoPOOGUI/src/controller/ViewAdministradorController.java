/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import model.Usuario;

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
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goMenu(ActionEvent event) {
        
        loadStage("/view/viewStart.fxml", event);
        sesion = false;
        
    }

    @FXML
    private void goInfo(ActionEvent event) {
        
        loadStage("/view/ViewInformation.fxml", event);
        sesion = false;
        
    }

    @FXML
    private void goWhoWeAre(ActionEvent event) {
        
        loadStage("/view/ViewWhoWeAre.fxml", event);
        sesion = false;
        
    }

    @FXML
    private void gotDonate(ActionEvent event) {
        
        loadStage("/view/ViewDonate.fxml", event);
        sesion = false;
        
    }

    @FXML
    private void goInicioAdministradores(ActionEvent event) {
        
        loadStage("/view/ViewAdministrador.fxml", event);
        sesion = false;
        
    }
    
    @FXML
    private void goOrg (ActionEvent event){
        
        loadStage("/view/ViewOrganizaciones.fxml", event);
        sesion = false;
        
    }
    
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
                    break;
                } else {
                }
            }
            if (seguir){
                
                for (Usuario k:usuariosD){
                    if (k.revisarUsuarioYPassword(tfUsuario.getText(), tfPassword.getText()) == 0){
                        seguir2 = true;
                        
                        //inicio de sesion
                        sesion = true;
                        JOptionPane.showMessageDialog(null, "inicio de sesion con exito");
                        
                        break;
                    }
                }
            } else{
                JOptionPane.showMessageDialog(null, "usuario no encontrado");
            }
        }
        
        
        
    }
    
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
            
        }
        
        return listaUsuarios;
    }
    
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
