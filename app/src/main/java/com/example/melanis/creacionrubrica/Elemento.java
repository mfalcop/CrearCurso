package com.example.melanis.creacionrubrica;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Melanis on 13/04/2017.
 */

public class Elemento extends SugarRecord {
   public  String name;
    Float peso;
    String descripcion;
   public  ArrayList<InfoNivel> niveldescripcion;

    Categoria categoria;

    public Elemento() {
    }

    public List<InfoNivel> getInfoNivel(){
        return InfoNivel.find(InfoNivel.class,"elemento = ?",String.valueOf(this.getId()));
    }

    public Elemento(String name, Float peso, String descripcion, ArrayList<InfoNivel> niveldescripcion, Categoria categoria) {
        this.name = name;
        this.peso = peso;
        this.descripcion = descripcion;
        this.niveldescripcion = niveldescripcion;
        this.categoria = categoria;
    }


}
