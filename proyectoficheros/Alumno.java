/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoficheros;

import java.io.Serializable;

/**
 *
 * @author asilvafernandez
 */
public class Alumno implements Serializable, Comparable<Alumno> {

    private String nombre;
    private int nota;

    public Alumno(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public int compareTo(Alumno o) {
        String a = String.valueOf(this.getNombre());
        String b = String.valueOf(o.getNombre());
        return a.compareTo(b);
    }

}
