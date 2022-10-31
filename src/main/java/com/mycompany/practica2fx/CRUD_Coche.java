/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2fx;

import static com.mycompany.practica2fx.Conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author furu9
 */
public class CRUD_Coche {

    //PARA INSERTAR EN VEHICULO + COCHE/MOTO
    public static void insertarVehiculo(Vehiculo v1) {

        PreparedStatement ps;
        String sqlVehiculo;
        Connection con = Conexion.getConexion();

        try
        {
            //TRANSANCCION
            con.setAutoCommit(false);

            //Introduce en la tabla vehiculo
            sqlVehiculo = "insert into vehiculo(marca, modelo, peso, cilindrada, matricula) values(?,?,?,?,?)";
            ps = con.prepareStatement(sqlVehiculo);
            ps.setString(1, v1.getMarca());
            ps.setString(2, v1.getModelo());
            ps.setInt(3, v1.getPeso());
            ps.setInt(4, v1.getCilindrada());
            ps.setString(5, v1.getMatricula());
            ps.executeUpdate();

            if (v1 instanceof Coche)
            {
                insertarCoche((Coche) v1);
            } else
            {
                insertarMoto((Moto) v1);
            }

            con.commit();
            con.setAutoCommit(true);
            Comprobaciones.crearAlertaInfo("Vehiculo creado");

        } catch (SQLException e)
        {
            Comprobaciones.crearAlertaError("Matricula ya existente en el sistema");
        }

    }

    //PARA INSERTAR EN LA TABLA COCHE
    private static void insertarCoche(Coche c1) {
        String sqlCoche;
        PreparedStatement ps1;
        Connection con = Conexion.getConexion();

        //Introduce en la tabla coche
        sqlCoche = "insert into coche(Matricula, asientosCalefactables,aire, techoSolar) values(?,?,?,?)";
        try
        {
            ps1 = con.prepareStatement(sqlCoche);
            ps1.setString(1, c1.getMatricula());
            ps1.setBoolean(2, c1.isAsientosCalefactables());
            ps1.setBoolean(3, c1.isAire());
            ps1.setBoolean(4, c1.isTechoSolar());
            ps1.executeUpdate();

        } catch (SQLException ex)
        {
            Logger.getLogger(CRUD_Coche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //PARA INSERTAR EN LA TABLA MOTO
    private static void insertarMoto(Moto m1) {
        String sqlMoto;
        PreparedStatement ps1;
        Connection con = Conexion.getConexion();

        //Introduce en la tabla coche
        sqlMoto = "insert into moto(Matricula, mangCalefactables,suspensionRegulable) values(?,?,?)";
        try
        {
            ps1 = con.prepareStatement(sqlMoto);
            ps1.setString(1, m1.getMatricula());
            ps1.setBoolean(2, m1.isMangCalefactables());
            ps1.setBoolean(3, m1.isSuspensionRegulable());

            ps1.executeUpdate();

        } catch (SQLException ex)
        {
            Logger.getLogger(CRUD_Coche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //PARA BORRAR DE AMBAS TABLAS
    public static void borrarVehiculo(String matricula){
        Connection con = getConexion();
        
        String sentenciaSql = "DELETE  from  vehiculo WHERE matricula = ?";
        PreparedStatement sentencia = null;
        String sentenciaSql1 = "DELETE  from  coche WHERE matricula = ?";
        PreparedStatement sentencia1 = null;
        String sentenciaSql2 = "DELETE  from  moto WHERE matricula = ?";
        PreparedStatement sentencia2 = null;

        try {
            con.setAutoCommit(false);
            sentencia = con.prepareStatement(sentenciaSql);
            sentencia.setString(1, matricula);
            sentencia.execute();
            sentencia1 = con.prepareStatement(sentenciaSql1);
            sentencia1.setString(1, matricula);
            sentencia1.execute();
            sentencia2 = con.prepareStatement(sentenciaSql2);
            sentencia2.setString(1, matricula);
            sentencia2.execute();
            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
    }
   
    //PARA LLENAR LA TABLA
    public static ObservableList<Vehiculo> getVehiculos() {
        Connection con;
        con=getConexion();
        ObservableList <Vehiculo> listaTabla;
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
        
        return listaTabla;
    }
    
    //PARA MODIFICAR LA TABLA
    public static void modificarVehiculo(Vehiculo v1) {
        Connection con = getConexion();
        
        try {
            con.setAutoCommit(false);
            String valueMatricula = v1.getMatricula();
            String valueMarca = v1.getMarca();
            String valueModelo = v1.getModelo();
            int valuePeso = v1.getPeso();
            int valueCilindrada =v1.getCilindrada();

            String sentenciaSql = "UPDATE vehiculo SET matricula = ?,marca = ?,modelo = ?,peso = ?,cilindrada = ? "
                    + "WHERE matricula=?";
            PreparedStatement sentencia = null;
            sentencia = con.prepareStatement(sentenciaSql);
            sentencia.setString(1, valueMatricula);
            sentencia.setString(2, valueMarca);
            sentencia.setString(3, valueModelo);
            sentencia.setInt(4, valuePeso);
            sentencia.setInt(5, valueCilindrada);
            sentencia.setString(6, valueMatricula);
            sentencia.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }
}
