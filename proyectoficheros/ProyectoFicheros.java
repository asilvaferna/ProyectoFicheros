/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoficheros;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author asilvafernandez
 */
public class ProyectoFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        int opt = Integer.parseInt(JOptionPane.showInputDialog("MENU:\n1. Crear alumnos\n2. Ordenar por aprobado\n3. Visualizar ArrayList\n4. Salir"));
        while (opt>0 && opt<4){
            switch (opt){
                case 1: // Create the alumnos.dat file
                    int nAlumnos = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de alumnos que desesas insertar"));
                    Fichero.addAlumnoFichero(nAlumnos);
                    break;
                case 2: // Splits the alumnos.dat file in two different files aprobados.dat/suspensos.dat
                    Fichero.addAoSFichero();
                    break;
                case 3: // Show the aprobados ArrayList
                    Fichero.mostrarArrayList();
                    break;
                    
            }
            opt = Integer.parseInt(JOptionPane.showInputDialog("MENU:\n1. Crear alumnos\n2. Ordenar por aprobado\n3. Visualizar ArrayList\n4. Salir"));
        }
        
    }
    
}
