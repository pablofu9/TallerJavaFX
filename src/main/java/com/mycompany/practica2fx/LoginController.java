/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practica2fx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author furu9
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button botonIniciar, botonRegistro;
    
    @FXML
    private TextField txtDni;
    
    @FXML
    private PasswordField txtPass;
    
    @FXML
    private Label lblDNI, lblPass;
    
    @FXML
    private void registrarse() throws IOException{
        App.setRoot("Registro");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
