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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelo.CRUD_Usuarios;
import static modelo.Conexion.getConexion;

/**
 * FXML Controller class
 *
 * @author furu9
 */
public class LoginController implements Initializable {

    Connection con = getConexion();
    /**
     * Initializes the controller class.
     */
    String contra;
    @FXML
    private Button botonIniciar, botonRegistro;

    @FXML
    private TextField txtDni;

    @FXML
    private PasswordField txtPass;

    @FXML
    private Label lblDNI, lblPass;

    @FXML
    private void registrarse() throws IOException {
        App.setRoot("Registro");
    }

    //Boton de inicio de sesion
    @FXML
    private void inicioSesion() {

        //Si alguno de los dos campos esta vacio, te salta un warning de que no pueden estar vacios
        if (txtDni.getText().isEmpty() || txtPass.getText().isEmpty())
        {
            Alert alertEmpty = new Alert(Alert.AlertType.WARNING);
            alertEmpty.setHeaderText(null);
            alertEmpty.setTitle("Info");
            alertEmpty.setContentText("Introduce tus credenciales de acceso");
            alertEmpty.showAndWait();
        } else
        {
            //Guardamos la contraseña en una variable para comprobar el login
            contra = CRUD_Usuarios.buscarUsuario(con, txtDni.getText());
            //Si no encuentra el dni, la variable contraseña sera null, comprobamos con un if
            if (contra != null)
            {
                if (contra.equals(txtPass.getText()))
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Info");
                    alert.setContentText("Login correcto");
                    alert.showAndWait();
                } else
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText(null);
                    alert.setTitle("Info");
                    alert.setContentText("Contraseña incorrecta");
                    alert.showAndWait();
                }
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
