package com.example.reacreditacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Dinamica extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamica);

        textView = findViewById(R.id.id);

        String titulo = getIntent().getStringExtra("Titulo");
        setTitle(titulo);
        int codigo = (int) getIntent().getIntExtra("Codigo",0);
        String codigoCat = String.valueOf(codigo);
        textView.setText("Id "+codigoCat);
    }
}
