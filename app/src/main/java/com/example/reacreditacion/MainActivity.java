package com.example.reacreditacion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
               switch (position){
                   case 0:
                        setPosition0();
                       break;
                   case 1:
                        setPosition1();
                       break;
                   case 2:
                       setPosition2();
                       break;
                   case 3:
                       setPosition3();
                       break;
                   case 4:
                        setPosition4();
                       break;
                   case 5:
                        setPosition5();
                       break;
                   case 6:
                        setPosition6();
                       break;
                   case 7:
                       setPosition7();
                       break;
                   case 8:
                       setPosition8();
                       break;
                   case 9:
                       setPosition9();
                       break;
                   case 10:
                       setPosition10();
                       break;
                   case 11:
                       setPosition11();
                       break;
               }
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

    public void setPosition0(){
        String titulo = "Categoria 1"; //el titulo
        int codigo = 1; //el identificador
        Intent intent = new Intent(MainActivity.this, Dinamica.class);
        intent.putExtra("Titulo",titulo);
        intent.putExtra("Codigo",codigo);
        startActivity(intent);
    }
    public void setPosition1(){
        String titulo = "Categoria 2"; //el titulo
        int codigo = 2; //el identificador
        Intent intent = new Intent(MainActivity.this, Dinamica.class);
        intent.putExtra("Titulo",titulo);
        intent.putExtra("Codigo",codigo);
        startActivity(intent);
    }
    public void setPosition2(){
        String titulo = "Categoria 3"; //el titulo
        int codigo = 3; //el identificador
        Intent intent = new Intent(MainActivity.this, Dinamica.class);
        intent.putExtra("Titulo",titulo);
        intent.putExtra("Codigo",codigo);
        startActivity(intent);
    }
    public void setPosition3(){
        String titulo = "Categoria 4"; //el titulo
        int codigo = 4; //el identificador
        Intent intent = new Intent(MainActivity.this, Dinamica.class);
        intent.putExtra("Titulo",titulo);
        intent.putExtra("Codigo",codigo);
        startActivity(intent);
    }
    public void setPosition4(){
        String titulo = "Categoria 5"; //el titulo
        int codigo = 5; //el identificador
        Intent intent = new Intent(MainActivity.this, Dinamica.class);
        intent.putExtra("Titulo",titulo);
        intent.putExtra("Codigo",codigo);
        startActivity(intent);
    }
    public void setPosition5(){
        String titulo = "Categoria 6"; //el titulo
        int codigo = 6; //el identificador
        Intent intent = new Intent(MainActivity.this, Dinamica.class);
        intent.putExtra("Titulo",titulo);
        intent.putExtra("Codigo",codigo);
        startActivity(intent);
    }
    public void setPosition6(){
        String titulo = "Categoria 7"; //el titulo
        int codigo = 7; //el identificador
        Intent intent = new Intent(MainActivity.this, Dinamica.class);
        intent.putExtra("Titulo",titulo);
        intent.putExtra("Codigo",codigo);
        startActivity(intent);
    }
    public void setPosition7(){
        String titulo = "Categoria 8"; //el titulo
        int codigo = 8; //el identificador
        Intent intent = new Intent(MainActivity.this, Dinamica.class);
        intent.putExtra("Titulo",titulo);
        intent.putExtra("Codigo",codigo);
        startActivity(intent);
    }
    public void setPosition8(){
        String titulo = "Categoria 9"; //el titulo
        int codigo = 9; //el identificador
        Intent intent = new Intent(MainActivity.this, Dinamica.class);
        intent.putExtra("Titulo",titulo);
        intent.putExtra("Codigo",codigo);
        startActivity(intent);
    }
    public void setPosition9(){
        String titulo = "Categoria 10"; //el titulo
        int codigo = 10; //el identificador
        Intent intent = new Intent(MainActivity.this, Dinamica.class);
        intent.putExtra("Titulo",titulo);
        intent.putExtra("Codigo",codigo);
        startActivity(intent);
    }
    public void setPosition10(){
        String titulo = "Categoria 11"; //el titulo
        int codigo = 11; //el identificador
        Intent intent = new Intent(MainActivity.this, Dinamica.class);
        intent.putExtra("Titulo",titulo);
        intent.putExtra("Codigo",codigo);
        startActivity(intent);
    }
    public void setPosition11(){
        String titulo = "Categoria 12"; //el titulo
        int codigo = 12; //el identificador
        Intent intent = new Intent(MainActivity.this, Dinamica.class);
        intent.putExtra("Titulo",titulo);
        intent.putExtra("Codigo",codigo);
        startActivity(intent);
    }

}
