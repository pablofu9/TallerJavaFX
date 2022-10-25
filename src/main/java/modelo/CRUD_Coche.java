/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author furu9
 */
public class CRUD_Coche {

    public static void insertarVehiculo(Connection con, Vehiculo v1) {

        PreparedStatement ps;
        PreparedStatement ps1;
        String sql, sql1;

        try
        {

            //Introduce en la tabla vehiculo
            sql = "insert into vehiculo(marca, modelo, peso, cilindrada, matricula) values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, v1.getMarca());
            ps.setString(2, v1.getModelo());
            ps.setInt(3, v1.getPeso());
            ps.setInt(4, v1.getCilindrada());
            ps.setString(5, v1.getMatricula());
            ps.executeUpdate();

            //Introduce en la tabla coche
            sql1 = "insert into coche(asientosCalefactables, aire, techoSolar) values(?,?,?,?,?)";
            ps1 = con.prepareStatement(sql1);

            ps1.setString(1, v1.getMatricula());

            Comprobaciones.crearAlertaInfo("Vehiculo creado (Insertado en ambas tablas)");
        } catch (SQLException e)
        {
            //JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }

    }
}
