package com.example.reacreditacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dinamica extends AppCompatActivity {
    TextView textView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamica);

        btn = findViewById(R.id.button);

        textView = findViewById(R.id.id);

        String titulo = getIntent().getStringExtra("Titulo");
        setTitle(titulo);
        int codigo = (int) getIntent().getIntExtra("Codigo",0);
        String codigoCat = String.valueOf(codigo);
        textView.setText("Id "+codigoCat);


       btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dinamica.this, Agregar_nueva_actividad.class);
                startActivity(intent);
            }
        });


    }
}
