package com.example.melanis.creacionrubrica;


import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.StringDef;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreacionEvaluacionActivity extends AppCompatActivity {
    public List<Rubrica> RubricList;
    Spinner spinner;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_evaluacion);

        Rubrica.deleteAll(Rubrica.class);
        Categoria.deleteAll(Categoria.class);
        Elemento.deleteAll(Elemento.class);


        ArrayList<String> RubricListName = new ArrayList<>();
        ArrayList<Categoria> cats  = new ArrayList<>();
        spinner= (Spinner) findViewById(R.id.spinnerRubricas);
        expListView = (ExpandableListView) findViewById(R.id.exprubrica);
        ed = (EditText) findViewById(R.id.editText);
        crearRubricas();

        RubricList= Rubrica.listAll(Rubrica.class);
        RubricListName.add("Selecciona una rubrica");
        RubricListName.addAll(getAllNamesRub((ArrayList<Rubrica>) RubricList));

       // ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, RubricListName);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, RubricListName) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent)
            {
                View v = null;
                // If this is the initial dummy entry, make it hidden
                if (position == 0) {
                    TextView tv = new TextView(getContext());
                    tv.setHeight(0);
                    tv.setVisibility(View.GONE);
                    v = tv;
                }
                else {
                    // Pass convertView as null to prevent reuse of special case views
                    v = super.getDropDownView(position, null, parent);
                }
                // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                parent.setVerticalScrollBarEnabled(false);
                return v;
            }
        };
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    Toast.makeText(parent.getContext(), (String) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                    inflateExpandable(parent, position);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void inflateExpandable(AdapterView<?> parent,int position) {
        String nameRubrica = parent.getItemAtPosition(position).toString();
        listDataChild= new HashMap<String, List<String>>();
        List<Rubrica> RubricaSelected;
        RubricaSelected= Rubrica.find(Rubrica.class, "name = ?", nameRubrica);
        List<Categoria> categ = RubricaSelected.get(0).getCategorias();
        List<Elemento> elems ;
        ArrayList<String> elemnames;

        listDataHeader=getAllNamesCat(categ);
        for (int i=0;i<listDataHeader.size();i++){
            elems = categ.get(i).getElementos();
            elemnames=getAllNamesEl(elems);
            listDataChild.put(listDataHeader.get(i),elemnames);
        }
        listAdapter= new ExpandableListAdapter(this,listDataHeader,listDataChild);
        expListView.setAdapter(listAdapter);


    }

    private ArrayList<String>getAllNamesCat(List<Categoria> cats){
        ArrayList<String>names = new ArrayList<>();
        for(int i=0; i<cats.size(); i++){
            names.add(i,cats.get(i).name);
        }

        return names;
    }
    private ArrayList<String>getAllNamesEl(List<Elemento> cats){
        ArrayList<String>names = new ArrayList<>();
        for(int i=0; i<cats.size(); i++){
            names.add(i,cats.get(i).name);
        }

        return names;
    }
    private ArrayList<String>getAllNamesRub(List<Rubrica> cats){
        ArrayList<String>names = new ArrayList<>();
        for(int i=0; i<cats.size(); i++){
            names.add(i,cats.get(i).name);
        }

        return names;
    }
    public void crearRubricas() {


        Rubrica rub = new Rubrica();
        rub.name= "Rubrica1";
        rub.save();

        Categoria cat = new Categoria();
        cat.rubrica= rub;
        cat.name="Categoria1";
        cat.save();
        Categoria cat2 = new Categoria();
        cat2.rubrica= rub;
        cat2.name="Categoria2";
        cat2.save();

        for (int i=1;i<5;i++){
            Elemento elem = new Elemento();
            elem.name = "Elemento"+i;
            elem.categoria=cat;
            elem.save();
            Elemento elem2 = new Elemento();
            elem2.name = "Elemento"+i;
            elem2.categoria=cat2;
            elem2.save();
        }

        List<Rubrica> rubricas = Rubrica.listAll(Rubrica.class);
        List<Categoria>  tem1= rub.getCategorias();
        List<Elemento>  tem2= cat.getElementos();

        /*rub = new Rubrica();
        rub.name="Rubrica2";
        rub.categoriaArray=  Categoria.listAll(Categoria.class);
        rub.save();*/

    }


    private void hideKeyboard(View view){
       // View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }
}
