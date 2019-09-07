package com.example.movilesguia03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import  static com.example.movilesguia03.MainActivity.listaNombre;

public class verLista extends AppCompatActivity {
    private ListView lstNombres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_lista);

        this.lstNombres=findViewById(R.id.lstNombres);

        this.lstNombres.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaNombre));
    }
}
