/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practica2fx;

import static com.mycompany.practica2fx.Conexion.getConexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
    private Button volverMenu, agregarCoche;

    @FXML
    private Pane panelMoto, panelCoche, panelUserNuevoVehiculo;

    @FXML
    private ComboBox cmbTipo;

    @FXML
    private MenuButton menuUserNuevoVehiculo;

    @FXML
    private MenuItem verPerfilNuevo, salirPerfilNuevo;

    @FXML
    private CheckBox checkManguitos, checkSuspension, checkAsientos, checkTecho, checkAire;

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
    private void agregarCocheOnClick() {
        String marca = txtMarca.getText();
        String modelo = txtModelo.getText();
        int peso = Integer.parseInt(txtPeso.getText());
        int cilindrada = Integer.parseInt(txtCilindrada.getText());
        String matricula = txtMatricula.getText();
        if (Comprobaciones.matriculaCorrecta(matricula))
        {
            int sel = cmbTipo.getSelectionModel().getSelectedIndex();

            switch (sel)
            {
                case 0:
                    CRUD_Coche.insertarVehiculo(new Coche(
                            checkAsientos.isSelected(),
                            checkAire.isSelected(),
                            checkTecho.isSelected(),
                            marca, modelo, peso, cilindrada, matricula));
                    break;
                case 1:
                    CRUD_Coche.insertarVehiculo(new Moto(
                            checkManguitos.isSelected(),
                            checkSuspension.isSelected(),
                            marca, modelo, peso, cilindrada, matricula));
                    
                    break;
                default:
                    Comprobaciones.crearAlertaError("Debe seleccionar el tipo de vehículo");
                    break;
            }
        }else{
            Comprobaciones.crearAlertaError("El formato de matricula no es correcto");
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
        Connection con=getConexion();
        menuUserNuevoVehiculo.setText(VariablesLogin.getNombreUser());
        cmbTipo.getItems().add("Coche");
        cmbTipo.getItems().add("Moto");
        

    }
}
