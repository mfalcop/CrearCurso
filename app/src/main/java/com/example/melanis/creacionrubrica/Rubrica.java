package com.example.melanis.creacionrubrica;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by Melanis on 13/04/2017.
 */

public class Rubrica extends SugarRecord {
    String name;
    String descripcion;
    ArrayList<Categoria> categoriaArray;
    int niveles;

    public Rubrica() {
    }

    public Rubrica(String name, ArrayList<Categoria> categoriaArray, int niveles) {
        this.name = name;
        this.categoriaArray = categoriaArray;
        this.niveles = niveles;
    }
}

