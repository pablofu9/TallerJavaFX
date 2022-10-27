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
import modelo.CRUD_Coche;
import modelo.Comprobaciones;
import modelo.Conexion;
import static modelo.Conexion.getConexion;
import modelo.VariablesLogin;
import modelo.Vehiculo;

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
    private TableView<Vehiculo> tablaVehiculos;
    @FXML
    private TableColumn<Vehiculo, String> cMatricula;
    @FXML
    private TableColumn<Vehiculo, String> cMarca;
    @FXML
    private TableColumn<Vehiculo, String> cModelo;
    @FXML
    private TableColumn<Vehiculo, String> cPeso;
    @FXML
    private TableColumn<Vehiculo, String> cCilindrada;

    @FXML
    private MenuButton menuUser;

    @FXML
    private MenuItem verPerfil, salirPerfil;
    
    ObservableList<Vehiculo> oblist = FXCollections.observableArrayList();

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
        

        Connection con = getConexion();
        menuUser.setText(VariablesLogin.getNombreUser());

        cMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        cModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        cPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        cCilindrada.setCellValueFactory(new PropertyValueFactory<>("cilindrada"));
        cMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));

        try
        {

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM vehiculo");
            while (rs.next())
            {
                /*oblist.add(new Vehiculo(rs.getString("marca"), rs.getString("modelo"),
                        rs.getInt("peso"), rs.getInt("cilindrada"), rs.getString("matricula")));
                tablaVehiculos.setItems(oblist);
*/
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
