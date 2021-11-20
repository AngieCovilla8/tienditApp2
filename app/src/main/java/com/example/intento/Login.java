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

import com.example.intento.databinding.ActivityLoginBinding;
import com.example.intento.ui.gallery.GalleryFragment;
import com.example.intento.ui.home.HomeFragment;
import com.example.intento.ui.home.HomeViewModel;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Login extends AppCompatActivity {

    Button login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       setContentView(R.layout.activity_login);

        this.login= findViewById(R.id.button2);
        this.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home=new  Intent(Login.this,MainActivity.class);
                startActivity(home);

            }
        });


    }


}