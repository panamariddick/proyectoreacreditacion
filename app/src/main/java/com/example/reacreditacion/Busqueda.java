package com.example.reacreditacion;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Busqueda extends AppCompatActivity {
    String initVariableAqui = null;
    public ImageButton img_btn_fecha_inicial, img_btn_fecha_final, img_btn_buscar, img_btn_agregar;
    public EditText et_fecha_inicial, et_fecha_final;
    private int dia, mes, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
        setTitle("Categoría" + initVariableAqui);
        et_fecha_inicial = findViewById(R.id.et_desde_fecha);
        et_fecha_final = findViewById(R.id.et_hasta_fecha);

        //imageButton

        img_btn_fecha_final = findViewById(R.id.img_btn_hasta);
        img_btn_fecha_inicial = findViewById(R.id.img_btn_De);
        //todo img_btn_buscar = findViewById(R.id.img_btn_buscar);
        img_btn_agregar = findViewById(R.id.img_btn_agregar_nueva_categoria);


        Calendar calendario =Calendar.getInstance();
        final int year = calendario.get(Calendar.YEAR);
        final int month = calendario.get(Calendar.MONTH);
        final int day = calendario.get(Calendar.DAY_OF_MONTH);


        img_btn_fecha_inicial.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DatePickerDialog dp = new DatePickerDialog(
                        Busqueda.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date  = day+"/"+month+"/"+year;
                        et_fecha_inicial.setText(date);
                    }
                },year,month,day);
                dp.show();
            }
        });


        img_btn_fecha_final.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DatePickerDialog dp = new DatePickerDialog(
                        Busqueda.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date2  = day+"/"+month+"/"+year;
                        et_fecha_final.setText(date2);
                    }
                },year,month,day);
                dp.show();

            }
        });




        img_btn_buscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            }
        });

    }
//metodo para encontrar la actividad
    //TODO
    private void  buscar(){

    }

    }

