package com.example.reacreditacion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Variable para inicio de sesion Firebase
    private FirebaseAuth mAuth;
    private ListView listViewCat;
    private Adaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inicializamos el inicio de sesion de Firebase
        mAuth = FirebaseAuth.getInstance();
        //ListCategorias
        listViewCat = findViewById(R.id.listviewcat);
        adaptador = new Adaptador(this, GetArrayItems());
        listViewCat.setAdapter(adaptador);
       listViewCat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Log.d("Posicion: ",""+position);
           }
       });
    }

    private ArrayList<Categorias> GetArrayItems(){
        ArrayList<Categorias> listItems = new ArrayList<>();
        listItems.add(new Categorias(R.drawable.uno,"Categoria 1","Relación con el Entorno"));
        listItems.add(new Categorias(R.drawable.dos,"Categoria 2","Diseño Curricular"));
        listItems.add(new Categorias(R.drawable.tres,"Categoria 3","Proceso Enseñanza Aprendizaje"));
        listItems.add(new Categorias(R.drawable.cuatro,"Categoria 4","Investigación y Desarrollo Tecnológico"));
        listItems.add(new Categorias(R.drawable.cinco,"Categoria 5","Extensión y Vinculación del Programa"));
        listItems.add(new Categorias(R.drawable.seis,"Categoria 6","Administración del Talento Humano"));
        listItems.add(new Categorias(R.drawable.siete,"Categoria 7","Requisitos de los Estudiantes del Programa"));
        listItems.add(new Categorias(R.drawable.ocho,"Categoria 8","Servicios Estudiantiles"));
        listItems.add(new Categorias(R.drawable.nueve,"Categoria 9","Gestión Académica"));
        listItems.add(new Categorias(R.drawable.diez,"Categoria 10","Infraestructura del Programa"));
        listItems.add(new Categorias(R.drawable.once,"Categoria 11","Recursos de Apoyo al Programa"));
        listItems.add(new Categorias(R.drawable.doce,"Categoria 12","Graduados"));

        return listItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    //Al seleccionar una opcion esta toma su ID para hacer lo debido
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.salir:
                cerrarSesion();
                break;
            case R.id.acercade:
                //irAcercaDe();
                break;
        }
        return true;
    }

    public void cerrarSesion(){
        //Cierra la sesion
        FirebaseAuth.getInstance().signOut();
        finish();
        //Lo envia al login
        irLogin();

    }

    public void irLogin(){
        Intent intent = new Intent(this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
