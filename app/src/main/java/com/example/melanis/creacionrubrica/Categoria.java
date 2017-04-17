package com.example.melanis.creacionrubrica;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Melanis on 13/04/2017.
 */

public class Categoria extends SugarRecord{
    public String name;
    public String descripcion;
    public  List<Elemento> ElementsArray;
    public Float peso;
    public Rubrica rubrica;

    public List<Elemento> getElementos(){
        return Elemento.find(Elemento.class, "categoria = ?", String.valueOf(this.getId()));
    }
    public Categoria() {

    }


    public Categoria(String name, List<Elemento>ElementsArray) {
        this.name = name;
        //this.descripcion = descripcion;
        this.ElementsArray = ElementsArray;
        //this.peso = peso;
    }
}
