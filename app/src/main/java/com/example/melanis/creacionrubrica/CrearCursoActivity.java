package com.example.melanis.creacionrubrica;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

public class CrearCursoActivity extends AppCompatActivity {

    public EditText nombrecur;
    public EditText nombreest;
    public ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
    public ListView myListView;
    public StudentListAdapter myAdapter;
    ArrayList<Evaluacion> eval = new ArrayList<Evaluacion>();
    Estudiante est;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_curso);


        nombrecur = (EditText) findViewById(R.id.nombrecursoEt);
        nombreest = (EditText) findViewById(R.id.nombreestudianteEt);
        myListView= (ListView) findViewById(R.id.StudentListView);

        myAdapter = new StudentListAdapter(this,listaEstudiantes);
        myListView.setAdapter(myAdapter);


    }

    public void crearCurso(View view) {

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }

    public void addStudent(View view) {

        String nameest=nombreest.getText().toString();
        Boolean stat = true;
        if(nameest.isEmpty()){
            Toast.makeText(this, "BUENAAAAAAAAAAS", Toast.LENGTH_SHORT).show();
        }else{

            est = new Estudiante(nameest,stat,eval);
            est.save();
           // Toast.makeText(this,Estudiante.findById(Estudiante.class,1).name, Toast.LENGTH_SHORT).show();
            listaEstudiantes= (ArrayList<Estudiante>) Estudiante.listAll(Estudiante.class);
            //Log.d("ID",newest.getId().toString());
            //listaEstudiantes = new ArrayList<Estudiante>(Estudiante.listAll(Estudiante.class));
            myAdapter.Data = listaEstudiantes;
            myListView.setAdapter(myAdapter);


        }
        //Inflate ListView with student list and update student in db and arraylist
        //*Validate if ed is empty
        //String name= nombreestudiante.getText().toString();
        //if(!name.isEmpty()){
      //      Boolean state= true;
    //        Estudiante nes = new Estudiante(name,state,eval);
  //          nes.save();
            //Adding to arraylist
//            estudiantes = new ArrayList<Estudiante>(Estudiante.listAll(Estudiante.class));

            //Pasarlo al adapter
            //rowHandler.Data= estudiantes;
          //  estudianteslv.setAdapter(rowHandler);
        //}

    }
}
