/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.practica2fx;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static com.mycompany.practica2fx.Conexion.getConexion;
import javafx.scene.control.TextField;

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
    private Button btnAlta, btnModificar, btnEliminar, botonRefrescar;

    @FXML
    private TableView<Vehiculo> tablaVehiculos;
    @FXML
    private TableColumn<Vehiculo, String> cMatricula;
    @FXML
    private TableColumn<Vehiculo, String> cMarca;
    @FXML
    private TableColumn<Vehiculo, String> cModelo;
    @FXML
    private TableColumn<Vehiculo, Integer> cPeso;
    @FXML
    private TableColumn<Vehiculo, Integer> cCilindrada;


    @FXML
    private MenuButton menuUser;

    @FXML
    private MenuItem verPerfil, salirPerfil;

    @FXML
    private TextField txtMatricula, txtMarca, txtModelo, txtPeso, txtCilindrada;
    
    

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
    
    //METODO DEL BOTON PARA REFRESCAR LA TABLA
    public void refrescarTabla() {
       tablaVehiculos.setItems(CRUD_Coche.getVehiculos());
    }

    //METODO PARA BORRAR LOS VEHICULOS DE LA TABLA
    public void borrarVehiculos(){
        
        getSelected();
        tablaVehiculos.getItems().removeAll(tablaVehiculos.getSelectionModel().getSelectedItem());
        CRUD_Coche.borrarVehiculo(txtMatricula.getText());
        

        

    }

    //VEMOS QUE ITEM DE LA TABLA ESTA SELECCIONADO AL PULSAR EN UN ITEM DE LA TABLA
    public void getSelected() {
        int index = tablaVehiculos.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        txtMatricula.setText(cMatricula.getCellData(index).toString());
        txtMarca.setText(cMarca.getCellData(index).toString());
        txtModelo.setText(cModelo.getCellData(index).toString());
        txtPeso.setText(cPeso.getCellData(index).toString());
        txtCilindrada.setText(cCilindrada.getCellData(index).toString());

    }

    //PARA MODIFICAR LA TABLA
    public void btnModificarOnClick() {
        
        Vehiculo v1 = new Vehiculo(txtMarca.getText(), txtModelo.getText(),Integer.parseInt(txtPeso.getText()), Integer.parseInt(txtCilindrada.getText()),txtMatricula.getText());
        CRUD_Coche.modificarVehiculo(v1);
        refrescarTabla();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        menuUser.setText(VariablesLogin.getNombreUser());

        cMarca.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("marca"));
        cModelo.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("modelo"));
        cPeso.setCellValueFactory(new PropertyValueFactory<Vehiculo, Integer>("peso"));
        cCilindrada.setCellValueFactory(new PropertyValueFactory<Vehiculo, Integer>("cilindrada"));
        cMatricula.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("matricula"));
        
        //LLENAR LA TABLA CUANDO SE INICIE LA VISTA
        tablaVehiculos.setItems(CRUD_Coche.getVehiculos());
        
        
    }

}
