/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author montserrat
 */
public class ViewAdministradorController implements Initializable {

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
    }

    @FXML
    private void goInfo(ActionEvent event) {
    }

    @FXML
    private void goWhoWeAre(ActionEvent event) {
    }

    @FXML
    private void gotDonate(ActionEvent event) {
    }

    @FXML
    private void goInicioAdministradores(ActionEvent event) {
    }
    
}
