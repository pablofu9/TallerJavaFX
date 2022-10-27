/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javafx.scene.control.Alert;

/**
 *
 * @author Pablo
 */
public class Comprobaciones {

    //Comprobamos formato de deni
    public static boolean dniCorrecto(String dni) {

        if (dni.length() == 9 && dni.substring(0, 7).matches("[0-9]*") && Character.isLetter(dni.charAt(8))) {
            return true;
        } else {
            return false;

        }
    }

    //Para crear alertas sin repetir el codigo
    public static void crearAlertaError(String textoAlerta) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(textoAlerta);
        alert.showAndWait();
    }

    public static void crearAlertaInfo(String textoAlerta) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información");
        alert.setContentText(textoAlerta);
        alert.showAndWait();
    }
    
    public static boolean matriculaCorrecta(String matricula){
        if(matricula.length()==7 && matricula.substring(0,3).matches("[0-9]*") && matricula.substring(4,6).matches("[A-Z]*")){
            return true;
        }else{
            return false;
        }
    }
}
