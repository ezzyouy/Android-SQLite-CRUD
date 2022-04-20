package com.example.dblite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv= findViewById(R.id.listView);
        DBconnexion cx= new DBconnexion(this);
        ArrayList<String> list= cx.getAll();
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
    }

    public void Enregister(View view){
        TextView nom= findViewById(R.id.editTextTextPersonName2);
        ListView lv= findViewById(R.id.listView);
        DBconnexion cx=     new DBconnexion(this);
        cx.insertAdmin(nom.getText().toString());
        ArrayList<String> array= cx.getAll();
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        lv.setAdapter(adapter);
        nom.setText("");
    }
    public void update(View view){
        TextView nom= findViewById(R.id.editTextTextPersonName2);
        EditText id=findViewById(R.id.editTextTextPersonName);
        ListView lv= findViewById(R.id.listView);
        DBconnexion cx=     new DBconnexion(this);
        cx.update(nom.getText().toString(),Integer.parseInt(id.getText().toString())) ;
        ArrayList<String> array= cx.getAll();
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, array);
        lv.setAdapter(adapter);
        nom.setText("");
        id.setText("");
    }
    public void supprimer(View view){
        EditText id=findViewById(R.id.editTextTextPersonName);
        ListView lv= findViewById(R.id.listView);
        DBconnexion cx=     new DBconnexion(this);
        cx.deleteRow(Integer.parseInt(id.getText().toString()));
        ArrayList<String> array= cx.getAll();
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, array);
        lv.setAdapter(adapter);
        id.setText("");
    }
}