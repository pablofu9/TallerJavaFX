/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2fx;

/**
 *
 * @author furu9
 */
public class Usuarios {

    private String nombre;
    private String apellido;
    private String dni;
    private String password;

    //CONSTRUCTOR AL QUE HAY QUE INTRODUCIRLE PARAMETROS
    public Usuarios(String nombre, String apellido, String dni, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.password=password;
    }

    //CONSTRUCTOR VACIO
    public Usuarios() {

    }

    //GETTERS Y SETTERS 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 

}
