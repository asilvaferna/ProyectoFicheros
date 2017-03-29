/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoficheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author asilvafernandez
 */
public class Fichero {

    private static final String NG = "alumnos.txt";
    private static final String NA = "aprobado.txt";
    private static final String NS = "suspenso.txt";
    private static File fichero = null;
    private static FileOutputStream fos = null;
    private static ObjectOutputStream oos = null;
    private static FileInputStream fis = null;
    private static ObjectInputStream ois = null;
    private static ArrayList<Alumno> aprobados = new ArrayList<>();

    public static void addAlumnoFichero(int nAlumnos) {
        try {
            fichero = new File(NG);
            fos = new FileOutputStream(fichero);
            oos = new ObjectOutputStream(fos);
            // for loop to create and add every alumno on the alumnos.dat file
            for (int i = 0; i < nAlumnos; i++) {
                String nombre = JOptionPane.showInputDialog("Introduce un nombre: ");
                int nota = Integer.parseInt(JOptionPane.showInputDialog("Introduce una nota: "));
                oos.writeObject(new Alumno(nombre, nota));
            }

        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public static void addAoSFichero() throws IOException {
        try {
            fichero = new File(NG);
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);
            // inifinite while loop to check every object Alumno
            while (true) {
                // we read every object Alumno and store it on a variable called alumno
                Alumno alumno = (Alumno) ois.readObject();
                // If conditional to distinguish the students by the positive/negative grade
                if (alumno.getNota() < 5) {
                    fichero = new File(NS);
                    fos = new FileOutputStream(fichero);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(alumno);
                } else {
                    fichero = new File(NA);
                    fos = new FileOutputStream(fichero);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(alumno);
                    aprobados.add(alumno); // we add each student that has a positive grade to the ArrayList
                }
            }

        } catch (FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException e) {
            System.out.println("");
        } finally {
            ois.close();
        }
    }
    
    
    
    public static void mostrarArrayList(){
        for (Alumno aprobado: aprobados){
            System.out.println(aprobado.getNombre() + "-->" + aprobado.getNota());
        }
    }

}
