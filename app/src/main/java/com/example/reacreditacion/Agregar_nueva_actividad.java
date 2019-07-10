package com.example.reacreditacion;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Agregar_nueva_actividad extends AppCompatActivity {
    public EditText et_nombre_input, et_tipo_input;
public ImageButton img_btn_guardar;
public RadioGroup radioGroup;
public RadioButton radioButton;
    public TextView tv_select_fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_agregar_nueva_actividad);
        tv_select_fecha = findViewById(R.id.tv_fecha);
        et_tipo_input = findViewById(R.id.et_tipo);
        img_btn_guardar = findViewById(R.id.img_btn_guardar);
        radioGroup = findViewById(R.id.radioGroup1);

        Calendar calendario =Calendar.getInstance();
        final int year = calendario.get(Calendar.YEAR);
        final int month = calendario.get(Calendar.MONTH);
        final int day = calendario.get(Calendar.DAY_OF_MONTH);
        tv_select_fecha.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DatePickerDialog dp = new DatePickerDialog(
                        Agregar_nueva_actividad.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date  = day+"/"+month+"/"+year;
                        tv_select_fecha.setText(date);
                    }
                },year,month,day);
                dp.show();
            }
        });
//Guardar datos de los editText en firebase
       img_btn_guardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                agregarActividad();
            }
        });
    }

    public void agregarActividad(){
        //Setea el id del radio button
        int radioID = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioID);
        //Introduce los valores a la base de datos
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("Actividades");


        String  nombre_actividad= et_nombre_input.getText().toString();
        String fecha_actividad = tv_select_fecha.getText().toString();
        String tipo_actividad = et_tipo_input.getText().toString();
        String dirigido = radioButton.getText().toString();

        //Verifica que no esten los campos vacios
        if(!TextUtils.isEmpty(nombre_actividad)&& !TextUtils.isEmpty(fecha_actividad)
        &&!TextUtils.isEmpty(tipo_actividad)&&!TextUtils.isEmpty(dirigido)){
        String id = databaseReference.push().getKey();
            NombreActividades NuevaActividad = new NombreActividades(nombre_actividad, fecha_actividad, tipo_actividad, dirigido);
            databaseReference.child(id).setValue(NuevaActividad);
            et_nombre_input.setText("");
            tv_select_fecha.setText("");
            et_tipo_input.setText("");
            radioGroup.clearCheck();
            Toast.makeText(this, "Actividad creada exitosamente", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Por favor , introduzca los datos necesarios", Toast.LENGTH_SHORT).show();
        }


    }


}
