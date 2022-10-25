/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author furu9
 */
public class Moto extends Vehiculo {

    boolean mangCalefactables;
    boolean suspensionRegulable;

    //CONSTRUCTORES
    public Moto(boolean mangCalefactables, boolean suspensionRegulable, String marca, String modelo, int peso, int cilindrada, String matricula) {
        super(marca, modelo, peso, cilindrada, matricula);
        this.mangCalefactables = mangCalefactables;
        this.suspensionRegulable = suspensionRegulable;
    }

    public Moto(boolean mangCalefactables, boolean suspensionRegulable) {
        this.mangCalefactables = mangCalefactables;
        this.suspensionRegulable = suspensionRegulable;
    }

    public Moto() {

    }
    //GETTERS AND SETTERS
    public boolean isMangCalefactables() {
        return mangCalefactables;
    }

    public void setMangCalefactables(boolean mangCalefactables) {
        this.mangCalefactables = mangCalefactables;
    }

    public boolean isSuspensionRegulable() {
        return suspensionRegulable;
    }

    public void setSuspensionRegulable(boolean suspensionRegulable) {
        this.suspensionRegulable = suspensionRegulable;
    }

}
