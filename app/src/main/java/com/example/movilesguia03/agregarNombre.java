package com.example.movilesguia03;


import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.movilesguia03.MainActivity.listaNombre;

public class agregarNombre extends AppCompatActivity {
    private EditText edtNombre;
    ProgressBar pgbCargar;
    private int mProgressStatus=0;
    private Handler mHandler=new Handler();
    TextView txtPorcentaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_nombre);
        edtNombre=findViewById(R.id.edtNombre);
        pgbCargar=findViewById(R.id.pgbCargar);
        txtPorcentaje=findViewById(R.id.txtPorcentaje);
    }

    public void clickGuardar(View v){
        if(edtNombre.getText().toString().isEmpty()){
            Toast.makeText(this,"Llene todos los campos",Toast.LENGTH_LONG).show();
        }else {
            this.setProgressValue();
        }
    }

    private void GuardarDatos(){
        listaNombre.add(edtNombre.getText().toString());
        finish();
    }

    private void setProgressValue(){
        pgbCargar.setVisibility(View.VISIBLE);
        txtPorcentaje.setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus<100){
                    mProgressStatus+=5;
                    android.os.SystemClock.sleep(500);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            txtPorcentaje.setText(mProgressStatus+" %");
                            pgbCargar.setProgress(mProgressStatus);
                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        GuardarDatos();
                    }
                });
            }
        }).start();
    }
}
