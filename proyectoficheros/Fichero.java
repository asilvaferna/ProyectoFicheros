/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoficheros;

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

    private static final String NG = "alumnos.dat";
    private static final String NA = "aprobado.dat";
    private static final String NS = "suspenso.dat";
    private static File fichero;
    private static FileOutputStream fos;
    private static ObjectOutputStream oos;
    private static FileInputStream fis;
    private static ObjectInputStream ois;
    private static ArrayList<Alumno> aprobados;

    private static void addAlumnoFichero(int nAlumnos) {
        try {
            fichero = new File(NG);
            fos = new FileOutputStream(fichero);
            oos = new ObjectOutputStream(fos);

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

    private static void addAprobadosFichero() throws IOException {
        try {
            fichero = new File(NG);
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);
            aprobados = new ArrayList<>();

            while (true) {
                Alumno alumno = (Alumno) ois.readObject();
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
                }
            }

        } catch (FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ois.close();
        }
    }

}
