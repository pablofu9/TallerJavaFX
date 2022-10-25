/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author furu9
 */
public class Coche extends Vehiculo {
    
    boolean asientosCalefactables;
    boolean aire;
    boolean techoSolar;

    //CONSTRUCTORES

    public Coche(boolean asientosCalefactables, boolean aire, boolean techoSolar, String marca, String modelo, int peso, int cilindrada, String matricula) {
        super(marca, modelo, peso, cilindrada, matricula);
        this.asientosCalefactables = asientosCalefactables;
        this.aire = aire;
        this.techoSolar = techoSolar;
    }
   

    public Coche(boolean asientosCalefactables, boolean aire, boolean techoSolar) {
        this.asientosCalefactables = asientosCalefactables;
        this.aire = aire;
        this.techoSolar = techoSolar;
    }
    
    public Coche(){
        
    }

    //GETTERS AND SETTERS

    public boolean isAsientosCalefactables() {
        return asientosCalefactables;
    }

    public void setAsientosCalefactables(boolean asientosCalefactables) {
        this.asientosCalefactables = asientosCalefactables;
    }

    public boolean isAire() {
        return aire;
    }

    public void setAire(boolean aire) {
        this.aire = aire;
    }

    public boolean isTechoSolar() {
        return techoSolar;
    }

    public void setTechoSolar(boolean techoSolar) {
        this.techoSolar = techoSolar;
    }
    
    
}