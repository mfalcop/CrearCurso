package com.example.melanis.creacionrubrica;

import com.orm.SugarRecord;

/**
 * Created by Melanis on 13/04/2017.
 */

public class InfoNivel extends SugarRecord {
    String descripcion;
    int nivel;

    public InfoNivel(String descripcion, int nivel) {
        this.descripcion = descripcion;
        this.nivel = nivel;
    }

    public InfoNivel() {

    }
}
