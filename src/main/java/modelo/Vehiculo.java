/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author furu9
 */
public class Vehiculo {
    String marca;
    String modelo;
    int peso;
    int cilindrada;
    String matricula;

    //CONSTRUCTORES
    public Vehiculo(String marca, String modelo, int peso,  int cilindrada, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
        this.cilindrada = cilindrada;
        this.matricula=matricula;
    }

    public Vehiculo() {
    }
    
    //GETTERS Y SETTERS

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

   

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
    
    
}
