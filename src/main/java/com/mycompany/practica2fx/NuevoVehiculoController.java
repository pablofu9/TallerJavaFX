/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practica2fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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
    
    /*
    @FXML
    private CheckBox checkManguitos, checkSuspension, checkAsientos, checkAsientos, checkAire;
    */
    @FXML
    private Pane panelMoto, panelCoche;

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
