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
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import static javafx.beans.binding.Bindings.select;
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
    @FXML
    private Label lblInfo;
    
    private int select;
    
    ControladorArchivos controlador = new ControladorArchivos();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //combobox de animales
        CBanimales();
        
        //combobox organizaciones
        CBOrgs();
      
        //combobox de usuarios
        CBUsuarios();
        
    }
    
    /**
     * Metodo para agregar un nuevo animal
     */
    private void CBanimales(){
        
        ArrayList<Animal> aux = new ArrayList<Animal>();
        ArrayList<String> aux2 = new ArrayList<String>();
        aux.addAll(leerAnimalesDelArchivo());
        for(int i = 0; i<aux.size(); i++    ){
            
            aux2.add(i+" "+aux.get(i).getNombre());
            
        }
        
        if(sesion == true){
            
            CBAnimals.getItems().addAll(aux2); //ingresar datos
            
        }
        
 
        CBAnimals.setOnAction((event2)->{
    
        select = CBAnimals.getSelectionModel().getSelectedIndex();
        
        Animal animal = leerAnimalesDelArchivo().get(select);
        String string = "nombres: "+animal.getNombre()+"\n"
                + "descripción: "+animal.getDescripcion()+"\n"
                + "información: "+animal.getInformacion();
        
        if(sesion == true){
            lblInfo.setText(string);
        }else{
            
            lblInfo.setText("inicie sesión para desbloquear esta caracteristica");
        }
        
        
    });
        
    }
    
    private void CBOrgs(){
        ArrayList<Organizaciones> aux = new ArrayList<Organizaciones>();
        ArrayList<String> aux2 = new ArrayList<String>();
        aux.addAll(leerOrganizacionesDelArchivo());
        for(int i = 0; i<aux.size(); i++    ){
            
            
            aux2.add(i+" "+aux.get(i).getNombre());
            
        }
        
        if(sesion == true){
            CBOrganizaciones.getItems().addAll(aux2);
        }
        
        
        CBOrganizaciones.setOnAction((event2)->{
    
        //System.out.println(AnimalList.getSelectionModel().getSelectedIndex());
        select = CBOrganizaciones.getSelectionModel().getSelectedIndex();
        
        Organizaciones organizaciones = leerOrganizacionesDelArchivo().get(select);
        String string = "nombre: "+organizaciones.getNombre()+"\n"
                + "año de creación : "+organizaciones.getAnnioDeCreacion()+"\n"
                + "información: "+organizaciones.getInformacion()+"\n"
                + "lugar: "+organizaciones.getLugar()+"\n"
                + "contacto: "+organizaciones.getInformacionDeContacto();
        
        if(sesion == true){
            lblInfo.setText(string);
        }else{
            
            lblInfo.setText("inicie sesión para desbloquear esta caracteristica");
        }
    
    });
    }
    
    private void CBUsuarios(){
        
        ArrayList<Usuario> aux = new ArrayList<Usuario>();
        ArrayList<String> aux2 = new ArrayList<String>();
        aux.addAll(leerUsariosDelArchivo());
        for(int i = 0; i<aux.size(); i++    ){
            
            
            aux2.add(i+" "+aux.get(i).getUser());
            
        }
        
        
        if(sesion == true){
             CBUsers.getItems().addAll(aux2);
        }
       
        
        
        
        CBUsers.setOnAction((event2)->{
    
        //System.out.println(AnimalList.getSelectionModel().getSelectedIndex());
        select = CBUsers.getSelectionModel().getSelectedIndex();
        
        Usuario usuario = leerUsariosDelArchivo().get(select);
        String string = "nombre: "+usuario.getUser()+"\n"
                + "contraseña : "+usuario.getPassword();
                
        
        if(sesion == true){
            lblInfo.setText(string);
        }else{
            
            lblInfo.setText("inicie sesión para desbloquear esta caracteristica");
        }
    
    });
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
    
    @FXML
    private void MUser(ActionEvent event) throws IOException{
        
        if(!MUser.getText().isEmpty() && !MPassword.getText().isEmpty() && sesion == true){
            try{
            String user = MUser.getText();
            String password = MPassword.getText();
            
            int Select = select;
 
            controlador.ModUsers(user, password, Select);
            
                
                goInicioAdministradores(event);
            
            
        }catch(Exception e){
            
            System.out.println(e);
            }
        }else{
            
            JOptionPane.showMessageDialog(null, "inicie sesión o verifique que todas las casillas estan llenas");
        }
        
        
        
    }
    
    @FXML
    private void MAnimal (ActionEvent event) throws IOException{
        
        if(!MAnimals.getText().isEmpty() && !MDescripcionAnimal.getText().isEmpty() && !MInformationAnimal.getText().isEmpty() && sesion == true){
            try{
            String nombre = MAnimals.getText();
            String description = MDescripcionAnimal.getText();
            String information = MInformationAnimal.getText();

            controlador.ModAnimales(nombre, description, information, select);
            
            goInicioAdministradores(event);
            
        }catch(Exception e){
            
            System.out.println(e);
        }
        
            
        }else{
                
            JOptionPane.showMessageDialog(null, "inicie sesión o verifique que todas las casillas estan llenas");
        }
        
        
    }
    
    @FXML
    private void MOrg (ActionEvent event){
        
        if(!MOrgName.getText().isEmpty() && !MDateOrg.getText().isEmpty() && !MUbicationOrg.getText().isEmpty() && !MContactOrg.getText().isEmpty() && !MGeneralOrg.getText().isEmpty() && sesion == true){
            
            try{
            String nombre = MOrgName.getText();
            String anno = MDateOrg.getText();
            String lugar = MUbicationOrg.getText();
            String informacionC = MContactOrg.getText();
            String inform = MGeneralOrg.getText();
            
            controlador.ModOrgs(nombre, anno, lugar, informacionC, inform, select);
            
            goInicioAdministradores(event);
            
            }catch(Exception e){

                System.out.println(e);

            }
        }else{
            
            JOptionPane.showMessageDialog(null, "inicie sesión o verifique que todas las casillas estan llenas");
            
        }
        
            
            
        
    }

    @FXML
    private void goMenu(ActionEvent event) {
        
        sesion = false;
        loadStage("/view/viewStart.fxml", event);
        
        
    }

    
    /**
     * Metodo para ir a informacion
    *@param ActionEvent event
    */
    @FXML
    private void goInfo(ActionEvent event) {
        
        sesion = false;
        loadStage("/view/ViewInformation.fxml", event);
        
        
    }
    
    /**
     * Metodo para ir a WhoWeAre
    *@param ActionEvent event
    */
    @FXML
    private void goWhoWeAre(ActionEvent event) {
        
        sesion = false;
        loadStage("/view/ViewWhoWeAre.fxml", event);
        
        
    }

    /**
     * Metodo para ir a donate
    *@param ActionEvent event
    */
    @FXML
    private void gotDonate(ActionEvent event) {
        
        sesion = false;
        loadStage("/view/ViewDonate.fxml", event);
        
        
    }

    /**
     * Metodo para ir a inicio administradores
    *@param ActionEvent event
    */
    @FXML
    private void goInicioAdministradores(ActionEvent event) {
        
        sesion = false;
        loadStage("/view/ViewAdministrador.fxml", event);
        
        
    }
   
    /**
     * Metodo para ir a Organizaciones
    *@param ActionEvent event
    */
    @FXML
    private void goOrg (ActionEvent event){
        
        sesion = false;
        loadStage("/view/ViewOrganizaciones.fxml", event);
        
        
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
                        
                        //combobox
                        CBanimales();
                        CBOrgs();
                        CBUsuarios();
                        
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
