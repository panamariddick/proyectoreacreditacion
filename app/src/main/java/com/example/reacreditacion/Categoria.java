package com.example.reacreditacion;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Categoria extends AppCompatActivity implements View.OnClickListener {
    String initVariableAqui = null;
    public ImageButton img_btn_fecha_inicial, img_btn_fecha_final, img_btn_buscar, img_btn_agregar;
    public EditText et_fecha_inicial, et_fecha_final;
    private int dia, mes, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        setTitle("Categoría" + initVariableAqui);
        et_fecha_inicial = findViewById(R.id.et_desde_fecha);
        et_fecha_final = findViewById(R.id.et_hasta_fecha);

        //imageButton

        img_btn_fecha_final = findViewById(R.id.img_btn_hasta);
        img_btn_fecha_inicial = findViewById(R.id.img_btn_De);
        // img_btn_buscar = findViewById(R.id.img_btn_buscar);
        img_btn_agregar = findViewById(R.id.img_btn_agregar_nueva_categoria);

        //onClick Listener - cuando doy click al boton
        img_btn_fecha_inicial.setOnClickListener(this);
        img_btn_fecha_final.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v == img_btn_fecha_inicial) {
            final Calendar calendario = Calendar.getInstance();
            dia = calendario.get(Calendar.DAY_OF_MONTH);
            mes = calendario.get(Calendar.MONTH);
            ano = calendario.get(Calendar.YEAR);
           /* DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){

                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    et_fecha_inicial.setText(dayOfMonth+"/"+"/"+month+"/"+year);
                }
            });*/

            //problema con el api

            if (v == img_btn_fecha_final) {
                final Calendar cl = Calendar.getInstance();
                dia = cl.get(Calendar.DAY_OF_MONTH);
                mes = cl.get(Calendar.MONTH);
                ano = cl.get(Calendar.YEAR);
            }
        }


    }
}
