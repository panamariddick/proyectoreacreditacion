package com.example.reacreditacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Login extends AppCompatActivity {
    EditText txt_Email;
    EditText txt_Contrasena;
    CheckBox checkboxPassword;
    Button btnIniciar;
    //Variable para inicio de sesion Firebase
    private FirebaseAuth mAuth;
    //TAGs para identificar un tipo de funcion
    public static final String TAG = "INICIO DE SESION";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Inicio de sesión");
        //Relacionar los id xml con los del controlador
        txt_Email = findViewById(R.id.txt_email);
        txt_Contrasena = findViewById(R.id.txt_contrasena);
        checkboxPassword = findViewById(R.id.checkboxpassword);
        btnIniciar = findViewById(R.id.btniniciar);
        // Inicializamos el inicio de sesion de Firebase
        mAuth = FirebaseAuth.getInstance();
        //Ejecuta la funcion de verificar usuario logueado
        onStart();
        //Esta funcion manda un aviso al entrar y no estar logueado
        alertaAviso();
        //Esta funcion muestra la contrasena al escuchar que se presiono el checkbox
        checkboxPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    //Oculta la conttrasena
                    txt_Contrasena.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    //Muestra la contrasena
                    txt_Contrasena.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

    }

    public void alertaAviso(){
        try{
            new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                    .setTitleText("Bienvenido!")
                    .setContentText("Antes de iniciar sesion asegurate de que fuiste debidamente registrado por el administrador.")
                    .setCustomImage(R.drawable.info_img)
                    .show();
        }catch (Exception e){
            e.getMessage();
        }
    }
    //Muestra progreso al click boton iniciar
    public void loadingUser(){
        SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Iniciando sesión");
        pDialog.setCancelable(false);
        pDialog.show();
    }
    //Funcion mensaje de error
    public void errorCampoVacio(){
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setContentText("No dejes campos vacios!")
                .show();
    }
    //Funcion mensaje no existe usuario
    public void errorNoExisteUsuario(){
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Error!")
                .setContentText("El usuario no existe")
                .show();
    }
    //Funcion para verificar si el usuario ya se conecto a la aplicacion
     @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

   private void updateUI(FirebaseUser user) {

            if (user != null) {
                irHome();
            } else {

            }
   }

    public void irHome(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void iniciarSesion(){
      String email = txt_Email.getText().toString();
      String password = txt_Contrasena.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            errorNoExisteUsuario();
                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                            limpiarCamposLogin();
                        }

                    }
                });
    }

    public void validarCampos(View view){
        String email = txt_Email.getText().toString();
        String password = txt_Contrasena.getText().toString();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            errorCampoVacio();
        }else{
            //Muestra la ventana de carga
           // loadingUser();
            //Inicia la sesion
            iniciarSesion();
        }
    }

    public void limpiarCamposLogin(){
        txt_Email.setText("");
        txt_Contrasena.setText("");
    }

}
