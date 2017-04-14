package com.example.melanis.creacionrubrica;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by Melanis on 13/04/2017.
 */

public class Evaluacion  extends SugarRecord{
    Rubrica rubric;
    Float nota;


    ArrayList<CalCategoria> calCategoriaArray;

    //creacion de calcategoria FALTA
    public Evaluacion() {
    }

    public Evaluacion(Rubrica rubric) {
        this.rubric = rubric;

    }
}
