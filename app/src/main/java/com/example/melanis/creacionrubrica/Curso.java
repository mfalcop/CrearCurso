package com.example.melanis.creacionrubrica;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by Melanis on 13/04/2017.
 */

public class Curso extends SugarRecord {

    String name;
    String descripcion;
    ArrayList<Estudiante> estudiantes;
    ArrayList<Evaluacion> evaluaciones;

    public Curso() {
    }
    public Curso(String name, String descripcion, ArrayList<Estudiante> estudiantes, ArrayList<Evaluacion> evaluaciones) {
        this.name = name;
        this.descripcion = descripcion;
        this.estudiantes = estudiantes;
        this.evaluaciones = evaluaciones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
