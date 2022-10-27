/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            Comprobaciones.crearAlertaInfo("Vehiculo creado (Insertado en ambas tablas)");

        } catch (SQLException e)
        {
            Comprobaciones.crearAlertaError("Error de conexion");
        }

    }

    //PARA INSERTAR EN LA TABLA COCHE
    private static void insertarCoche(Coche c1) {
        String sqlCoche;
        PreparedStatement ps1;
        Connection con = Conexion.getConexion();

        //Introduce en la tabla coche
        sqlCoche = "insert into coche(Matricula, asientosCalefactables, aire, techoSolar) values(?,?,?,?)";
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
        sqlMoto = "insert into coche(Matricula, asientosCalefactables, aire, techoSolar) values(?,?,?,?)";
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

}
