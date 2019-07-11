package com.example.reacreditacion;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Busqueda extends AppCompatActivity {
    String initVariableAqui = null;
    public Button buscar, agregar;
    public TextView tv_fecha_inicial, tv_fecha_final;
    DatabaseReference databaseReference;
    String date = null, date2 = null;

    //databaseReference = FirebaseDatabase.getInstance().getReference("FechaActividad");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
        setTitle("Categoría" + initVariableAqui);
        tv_fecha_inicial = findViewById(R.id.tv_desde_fecha);
        tv_fecha_final = findViewById(R.id.tv_hasta_fecha);
        buscar = findViewById(R.id.btn_buscar);
        agregar = findViewById(R.id.btn_agregar);
        //Declaracion para variables de calendario
        Calendar calendario = Calendar.getInstance();
        final int year = calendario.get(Calendar.YEAR);
        final int month = calendario.get(Calendar.MONTH);
        final int day = calendario.get(Calendar.DAY_OF_MONTH);


        //Boton buscar
        buscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    buscar();
                    databaseReference= FirebaseDatabase.getInstance().getReference();
                    databaseReference.child("FechaActividad");
                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            if (snapshot.getValue() == null) {
                                noExisteLaActividad();
                            }
                            else{
                                //todo agregar la clase      Intent mostrarActividades = new Intent(Busqueda.this,ClasePorDefinir.class);
                                //myIntent.putExtra("", null);
                                //todo agregar la clase     Busqueda.this.startActivity(mostrarActividades);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }catch (Exception e){
                }
            }
        });


        tv_fecha_inicial.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DatePickerDialog dp = new DatePickerDialog(
                        Busqueda.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        date  = day+"/"+month+"/"+year;
                        tv_fecha_inicial.setText(date);
                    }
                },year,month,day);
                dp.show();
            }
        });


        tv_fecha_final.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DatePickerDialog dp = new DatePickerDialog(
                        Busqueda.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        date2  = day+"/"+month+"/"+year;
                        tv_fecha_final.setText(date2);
                    }
                },year,month,day);
                dp.show();

            }
        });


    }

    private void  buscar(){
        databaseReference.orderByChild("FechaActividad").startAt(date).endAt(date2);
    }

//Metodos de alertas

    public void noExisteLaActividad() {
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Advertencia")
                .setContentText("No se han encontrado actividades dentro de ese rango")
                .setCancelText("Cancelar")
                .setConfirmText("Crear nueva actividad?")
                .showCancelButton(true)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        cargarNuevaActividad();
                    }
                })
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        cancelar();
                    }
                })
                .show();
    }

    public void cargarNuevaActividad() {
        SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Cargando");
        pDialog.setCancelable(false);
        pDialog.show();
        Intent myIntent = new Intent(Busqueda.this, Agregar_nueva_actividad.class);
        Busqueda.this.startActivity(myIntent);
    }

    public void cancelar() {
        new SweetAlertDialog(this)
                .setTitleText("Intente otra fecha")
                .show();
    }

    }

