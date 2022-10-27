/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practica2fx;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.CRUD_Usuarios;
import modelo.Comprobaciones;
import static modelo.Conexion.getConexion;
import modelo.VariablesLogin;

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
    private Pane panelLogin;
    
    @FXML
    private ImageView imgLog, imgPass,imagenPortada;
    

    //Este boton va a llevarnos a la pantalla de registro
    @FXML
    private void registrarse() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Registro.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();
        //Para cerrar el login
        Stage loginStage = (Stage) this.botonIniciar.getScene().getWindow();
        loginStage.close();
    }

    //Boton de inicio de sesion
    @FXML
    private void inicioSesion() throws IOException {

        //Si alguno de los dos campos esta vacio, te salta un warning de que no pueden estar vacios
        if (txtDni.getText().isEmpty() || txtPass.getText().isEmpty()) {
            Comprobaciones.crearAlertaError("Introduce tus credenciales de acceso");
        } else {
            //Guardamos la contraseña en una variable para comprobar el login
            contra = CRUD_Usuarios.buscarUsuario(con, txtDni.getText());
            //Si no encuentra el dni, la variable contraseña sera null, comprobamos con un if
            if (contra != null) {
                if (contra.equals(txtPass.getText())) {

                    Comprobaciones.crearAlertaInfo("Bienvenido "+VariablesLogin.getNombreUser());

                    //Abrimos la venatana de menu
                    Stage stage = new Stage();

                    Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage(StageStyle.DECORATED);
                    stage.setScene(scene);
                    stage.show();
                    //Para cerrar el login
                    Stage loginStage = (Stage) this.botonIniciar.getScene().getWindow();
                    loginStage.close();

                } else {
                    Comprobaciones.crearAlertaError("Contraseña incorrecta");
                }
                
            }else{
                Comprobaciones.crearAlertaError("Credenciales de acceso incorrectas");
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
