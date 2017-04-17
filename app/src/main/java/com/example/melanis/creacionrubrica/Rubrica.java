package com.example.melanis.creacionrubrica;

import android.widget.ListView;

import com.orm.SugarRecord;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Melanis on 13/04/2017.
 */

public class Rubrica extends SugarRecord {

    //public static ObservableArrayList<Object> list = new ObservableArrayList<>();
    //final static private boolean t = list.addAll(Rubrica.listAll(Rubrica.class));
    public String name;
    String descripcion;
    public List<Categoria> categoriaArray;
    int niveles;

    public List<Categoria> getCategorias(){
        return Categoria.find(Categoria.class, "rubrica = ?", String.valueOf(this.getId()));
    }

    public Rubrica() {
    }

    public Rubrica(String name, List<Categoria> categoriaArray, int niveles) {
        this.name = name;
        this.categoriaArray = categoriaArray;
        this.niveles = niveles;
    }
}

