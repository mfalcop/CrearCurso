package com.example.melanis.creacionrubrica;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by Melanis on 13/04/2017.
 */

public class CalCategoria extends SugarRecord {

    Float notaCategoria;
    Categoria categoria;
    ArrayList<CalElemento> calElementoArray;

    public CalCategoria() {
    }

    public CalCategoria(Float nota, Categoria categoria, ArrayList<CalElemento> calElementoArray) {
        this.notaCategoria = nota;
        this.categoria = categoria;
        this.calElementoArray = calElementoArray;
    }
}
