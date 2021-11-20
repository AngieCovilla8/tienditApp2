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

import com.example.intento.databinding.ActivityRegistroBinding;
import com.google.android.material.snackbar.Snackbar;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Registro extends AppCompatActivity {

    Button registro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro);

        this.registro= findViewById(R.id.button);
        this.registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Registro Completado",Snackbar.LENGTH_LONG).show();
                Intent loging =new  Intent(Registro.this,Login.class);
                startActivity(loging);


            }
        });

    }




}