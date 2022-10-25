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
 * @author Pablo
 */
public class CRUD_Usuarios {

    public static void insertarUsuario(Connection con, Usuarios user) {

        PreparedStatement ps;
        String sql;

        try
        {

            sql = "insert into usuario(nombre, apellido, dni,password) values(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getDni());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Se han insertado los datos");
        } catch (SQLException e)
        {
            //JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }

    }
}
