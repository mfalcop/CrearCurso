package com.example.melanis.creacionrubrica;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Melanis on 13/04/2017.
 */

public class StudentListAdapter extends BaseAdapter {
    private Context mycontext;
    public ArrayList<Estudiante> Data;

    public StudentListAdapter(Context context,ArrayList<Estudiante> data ){
        mycontext= context;
        Data=data;
    }
    @Override
    public int getCount() {
        return Data.size();
    }

    @Override
    public Object getItem(int position) {
        return Data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String nombre= Data.get(position).name;
        //long id= Data.get(position).getId();

        if (convertView == null) {
            LayoutInflater T = (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = T.inflate(R.layout.student_delete_row, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.StudentNameTbx);
         FloatingActionButton button = (FloatingActionButton) convertView.findViewById(R.id.FloatingDeleteStudentBtn);

        textView.setText(nombre);
        //button.setTag(id);
  //      button.setFocusable(false);
    //    button.setFocusableInTouchMode(false);
        return convertView;
    }
}





