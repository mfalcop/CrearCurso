package com.example.melanis.creacionrubrica.Calificaciones;

import com.example.melanis.creacionrubrica.Evaluacion;
import com.orm.SugarRecord;

import java.util.List;


/**
 * Created by fdjvf on 4/16/2017.
 */

public class PesoRubrica extends SugarRecord {

    Evaluacion evaluacion;

    public PesoRubrica() {

    }

    public List<PesoCategoria> getPesosCategoria() {

        return PesoCategoria.find(PesoCategoria.class, "pesoRubrica = ?", String.valueOf(this.getId()));

    }


}
