package com.example.melanis.creacionrubrica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.orm.SugarContext;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Evaluacion> eval = new ArrayList<Evaluacion>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void crearCurso(View view) {

        Intent i = new Intent(this,CrearCursoActivity.class);
        startActivity(i);

    }

    public void crearRubrica(View view) {

    }
}
