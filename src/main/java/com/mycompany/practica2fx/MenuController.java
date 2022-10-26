/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practica2fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Label lblUser;

    @FXML
    private ImageView imgIcono;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUser.setText( VariablesLogin.getNombreUser());
        imgIcono.setVisible(true);
       
    }

}
