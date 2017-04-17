package com.example.melanis.creacionrubrica;

import com.example.melanis.creacionrubrica.Calificaciones.CalCategoria;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Melanis on 13/04/2017.
 */

public class Evaluacion  extends SugarRecord{
    Rubrica rubric;
    Float nota;
    ArrayList<CalCategoria> calCategoriaArray;
    Curso curso;
    Estudiante estudiante;

    List<CalCategoria> getCalCategorias(){
        return CalCategoria.find(CalCategoria.class, "evaluacion = ?", String.valueOf(this.getId()));
    }
    //creacion de calcategoria FALTA
    public Evaluacion() {
    }

    public Evaluacion(Rubrica rubric) {
        this.rubric = rubric;

    }
}
