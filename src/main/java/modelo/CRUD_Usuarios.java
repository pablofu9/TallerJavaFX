/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Pablo
 */
public class CRUD_Usuarios {

    public static void insertarUsuario(Connection con, Usuarios user) {

        PreparedStatement ps;
        String sql;

        try {

            sql = "insert into usuario(nombre, apellido, dni,password) values(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getDni());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Usuario Insertado");
            alert.showAndWait();

        } catch (SQLException e) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("No se ha podido insertar el usuario");
            alert.showAndWait();
        }

    }

    public static void buscarUsuario(Connection conexion, String dni) {

        PreparedStatement ps;
        ResultSet rs;
        boolean encontrado = false;
        Usuarios u = new Usuarios();
        try {
            String SQL = "SELECT * FROM usuario WHERE dni = ? ;";
            ps = (PreparedStatement) conexion.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, dni);
            rs = ps.executeQuery();

            while (rs.next()) {
                encontrado = true;
                /*
                u.setPass(rs.getString("pass"));
                u.setDescuentos(rs.getDouble("descuentos"));
                u.setPremium(rs.getBoolean("premium"));
                 */

            }
            if (encontrado) {
                String contra=u.getPassword();
               
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Info");
                alert.setContentText("Usuario encontrado");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Info");
                alert.setContentText("Usuario no encontrado");
                alert.showAndWait();

            }
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.toString());

        }

    }
}
