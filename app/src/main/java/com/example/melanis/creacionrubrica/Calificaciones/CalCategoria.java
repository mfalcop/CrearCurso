package com.example.melanis.creacionrubrica.Calificaciones;

import com.example.melanis.creacionrubrica.Calificacion;
import com.orm.SugarRecord;

import java.util.List;


/**
 * Created by fdjvf on 4/16/2017.
 */

public class CalCategoria extends SugarRecord {

    Calificacion calificacion;
    float pesoCategoria;

    public CalCategoria() {

    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public float getNotaFinal() {  //Nota de la categoria con respecto a la rubrica
        return getNota() * pesoCategoria;
    }


    public float getPesoCategoria() {
        return pesoCategoria;
    }

    public void setPesoCategoria(float value) {
        pesoCategoria = value;
    }

    public float getNota() {//Nota de la categoria con sus elementos
        float Suma = 0;
        List<CalElemento> temp = CalElemento.find(CalElemento.class, "calCategoria = ?", String.valueOf(getId()));
        for (CalElemento element : temp) {
            Suma = Suma + element.getNotaFinal();
        }
        return Suma;
    }


}
