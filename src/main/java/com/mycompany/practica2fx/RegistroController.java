/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practica2fx;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.CRUD_Usuarios;
import modelo.Usuarios;

/**
 * FXML Controller class
 *
 * @author furu9
 */
public class RegistroController implements Initializable {

    Connection con;
    
    @FXML
    private TextField registroDni, registroNombre, registroApellido, registroPass;
    
    @FXML
    private Button btnRegistro, btnVolver;
    
    @FXML //Boton para volver a la pantalla de login
    private void volver() throws IOException{
        App.setRoot("Login");
    }
    
    @FXML
    private void registrarUser(){
       
        Usuarios user1 = new Usuarios(registroNombre.getText(), registroApellido.getText(), registroDni.getText(), registroPass.getText());
        CRUD_Usuarios.insertarUsuario(con, user1);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
