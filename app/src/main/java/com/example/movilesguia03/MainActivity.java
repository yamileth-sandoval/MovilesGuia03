package com.example.movilesguia03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<String> listaNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaNombre=new ArrayList<>();
    }
    //para mostrar el activity de mis datos
    public void clickMisDatos(View v){
        Intent misDatos=new Intent(this,misDatos.class);
        startActivity(misDatos);
    }
    //para mostrar el activity que permite ingresar el nombre
    public void  clickAgregarNombre(View v){
        Intent terceraActivity = new Intent(this, agregarNombre.class);
        startActivity(terceraActivity);
    }
    //para mostrar la activity que mostrara la lista de nombres
    public void clickVerLista(View v){
        if(listaNombre==null || listaNombre.size()==0){
            Toast.makeText(this,
                    "No hay datos que mostrar",
                    Toast.LENGTH_LONG).show();
        }else {
            Intent verLista = new Intent(this, verLista.class);
            startActivity(verLista);
        }
    }
}
