/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practica2fx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.VariablesLogin;

/**
 * FXML Controller class
 *
 * @author furu9
 */
public class NuevoVehiculoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtMatricula, txtMarca, txtModelo, txtPeso, txtCilindrada;

    @FXML
    private Label lblUser;

    @FXML
    private Button volverMenu;

    @FXML
    private Pane panelMoto, panelCoche,panelUserNuevoVehiculo;

    @FXML
    private ComboBox cmbTipo;
    
    @FXML
    private MenuButton menuUserNuevoVehiculo;
    
    @FXML
    private MenuItem verPerfilNuevo, salirPerfilNuevo;

    /*
    @FXML
    private CheckBox checkManguitos, checkSuspension, checkAsientos, checkAsientos, checkAire;
     */
    //OnClick del boton para volver atras
    @FXML
    private void volverMenuOnClick() throws IOException {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();
        //Para cerrar el login
        Stage loginStage = (Stage) this.volverMenu.getScene().getWindow();
        loginStage.close();
    }

    //Metodo para que te enseñe el panel de oche o moto segun corresponda
    //Es un metodo del comboBox
    @FXML
    private void cambioTipo() {
        if (cmbTipo.getValue().toString().equals("Coche"))
        {
            panelCoche.setVisible(true);
            panelMoto.setVisible(false);
        } else if (cmbTipo.getValue().equals("Moto"))
        {
            panelCoche.setVisible(false);
            panelMoto.setVisible(true);
        } else
        {
            panelCoche.setVisible(false);
            panelMoto.setVisible(false);
        }
    }

    @FXML  
    private void menuUserNuevoVehiculoExit() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();

        Stage loginStage = (Stage) this.menuUserNuevoVehiculo.getScene().getWindow();
        loginStage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       menuUserNuevoVehiculo.setText(VariablesLogin.getNombreUser());
        cmbTipo.getItems().add("Coche");
        cmbTipo.getItems().add("Moto");

    }
}
