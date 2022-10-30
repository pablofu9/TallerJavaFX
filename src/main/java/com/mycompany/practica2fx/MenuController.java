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

    ObservableList<Vehiculo> listaTabla;

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

    Connection con;

    //METODO PARA LLENAR LA TABLA CON UN OBLIST
    public ObservableList<Vehiculo> getVehiculos() {
        con = getConexion();
        listaTabla = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * from vehiculo");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaTabla.add(new Vehiculo(rs.getString("marca"), rs.getString("modelo"),
                        rs.getInt("peso"), rs.getInt("cilindrada"), rs.getString("matricula")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tablaVehiculos.setItems(listaTabla);
        return listaTabla;
    }

    
    //METODO DEL BOTON PARA REFRESCAR LA TABLA
    public void refrescarTabla() {
        tablaVehiculos.setItems(getVehiculos());
    }

    //METODO PARA BORRAR LOS VEHICULOS DE LA TABLA
    public void borrarVehiculos() {
        con = getConexion();
        getSelected();
        tablaVehiculos.getItems().removeAll(tablaVehiculos.getSelectionModel().getSelectedItem());
        String sentenciaSql = "DELETE  from  vehiculo WHERE matricula = ?";
        PreparedStatement sentencia = null;

        try {
            sentencia = con.prepareStatement(sentenciaSql);
            sentencia.setString(1, txtMatricula.getText());
            sentencia.execute();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        //BORRAR FROM COCHE
        String sentenciaSql1 = "DELETE  from  coche WHERE matricula = ?";
        PreparedStatement sentencia1 = null;
        try {
            sentencia1 = con.prepareStatement(sentenciaSql1);
            sentencia1.setString(1, txtMatricula.getText());
            sentencia1.execute();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        //BORRAR FROM MOTO
        String sentenciaSql2 = "DELETE  from  moto WHERE matricula = ?";
        PreparedStatement sentencia2 = null;

        try {
            sentencia2 = con.prepareStatement(sentenciaSql2);
            sentencia2.setString(1, txtMatricula.getText());
            sentencia2.execute();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

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

    //PARA MODIFICAR LA TABLA  (FALTA MODIFICAR EN LA TABLE COCHE / MOTO)
    public void btnModificarOnClick() {
        con = getConexion();

        try {
            String valueMatricula = txtMatricula.getText();
            String valueMarca = txtMarca.getText();
            String valueModelo = txtModelo.getText();
            int valuePeso = Integer.parseInt(txtPeso.getText());
            int valueCilindrada = Integer.parseInt(txtCilindrada.getText());

            String sentenciaSql = "UPDATE vehiculo SET matricula = '" + valueMatricula + "',marca = '" + valueMarca + "',modelo = '" + valueModelo + "',peso = '" + valuePeso + "',cilindrada = '" + valueCilindrada + "' "
                    + "WHERE matricula='" + valueMatricula + "'";
            PreparedStatement sentencia = null;
            sentencia = con.prepareStatement(sentenciaSql);
            sentencia.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        con = getConexion();
        menuUser.setText(VariablesLogin.getNombreUser());

        cMarca.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("marca"));
        cModelo.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("modelo"));
        cPeso.setCellValueFactory(new PropertyValueFactory<Vehiculo, Integer>("peso"));
        cCilindrada.setCellValueFactory(new PropertyValueFactory<Vehiculo, Integer>("cilindrada"));
        cMatricula.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("matricula"));

        //LLENAMOS LA TABLA A TRAVES DEL METODO
        getVehiculos();
    }

}
