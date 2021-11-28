package com.example.intento;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;

import com.example.intento.databinding.ActivityBienvenidaBinding;
import com.google.firebase.auth.FirebaseAuth;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Bienvenida extends AppCompatActivity {

    Button login, registro;

    private FirebaseAuth Autenticador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        this.login= findViewById(R.id.login_boton);
        this.registro=findViewById(R.id.registro_boton);
        this.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(Bienvenida.this,Login.class);
                startActivity(intent);


            }
        });

        this.registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(Bienvenida.this,Registro.class);
                startActivity(intent);
            }
        });
        Autenticador = FirebaseAuth.getInstance();
    }





}