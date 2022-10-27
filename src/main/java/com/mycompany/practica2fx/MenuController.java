/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practica2fx;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.Comprobaciones;
import modelo.VariablesLogin;

/**
 * FXML Controller class
 *
 * @author furu9
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnAlta, btnModificar, btnEliminar;

    @FXML
    private TableView tablaVehiculos;
    @FXML
    private TableColumn cMatricula, cMarca, cModelo, cPeso, cCilindrada, cTipo;

    @FXML
    private MenuButton menuUser;

    @FXML
    private MenuItem verPerfil, salirPerfil;
    
    //PARA AÑADIR UN NUEVO VEHICULO
    @FXML
    private void altaVehiculo() throws IOException {
        //Creamos el stage para que vaya al siguiente frame
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("nuevoVehiculo.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();
        //Cerramos la ventana actual
        Stage loginStage = (Stage) this.btnAlta.getScene().getWindow();
        loginStage.close();
    }
    
    //PARA CERRAR SESION
    @FXML
    private void menuExit() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();

        Stage loginStage = (Stage) this.menuUser.getScene().getWindow();
        loginStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        menuUser.setText(VariablesLogin.getNombreUser());
    }

}
