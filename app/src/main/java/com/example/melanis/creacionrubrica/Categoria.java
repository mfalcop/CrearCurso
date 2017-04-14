package com.example.melanis.creacionrubrica;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by Melanis on 13/04/2017.
 */

public class Categoria extends SugarRecord {
    String name;
    String descripcion;
    ArrayList<Elemento> elementoArray;
    Float peso;

    public Categoria() {

    }

    public Categoria(String name, String descripcion, ArrayList<Elemento> elementoArray, Float peso) {
        this.name = name;
        this.descripcion = descripcion;
        this.elementoArray = elementoArray;
        this.peso = peso;
    }
}
