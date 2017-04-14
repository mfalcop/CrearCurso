package com.example.melanis.creacionrubrica;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by Melanis on 13/04/2017.
 */

public class Estudiante extends SugarRecord {

    public String name;
    public Boolean state;
    public ArrayList<Evaluacion> Evaluaciones;

    public Estudiante() {

    }


    public Estudiante(String name, Boolean state, ArrayList<Evaluacion> evaluaciones) {
        this.name = name;
        this.state = state;
        this.Evaluaciones = evaluaciones;
    }
}
