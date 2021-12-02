package com.example.intento;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.intento.databinding.ActivityRegistroBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Registro extends AppCompatActivity {

    Button registro;
    private FirebaseAuth Autenticador;
    private EditText correo,contrasena;
    private ActivityRegistroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_registro);

        this.registro= findViewById(R.id.button);
        this.correo=findViewById(R.id.editTextTextEmailAddress);
        this.contrasena=findViewById(R.id.editTextTextPassword);
        this.registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = correo.getText().toString();
                String contra = contrasena.getText().toString();
                if (usuario.isEmpty() || contra.isEmpty()) {
                    Snackbar.make(v, R.string.ContrseñaInvalida, Snackbar.LENGTH_LONG).show();
                }
                else{
                Autenticador.createUserWithEmailAndPassword(usuario, contra)
                        .addOnCompleteListener(Registro.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = Autenticador.getCurrentUser();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Registro.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    Snackbar.make(v,"Error",Snackbar.LENGTH_LONG).show();
                                }
                            }
                        });
                Intent loging =new  Intent(Registro.this,Login.class);
                startActivity(loging);
                Snackbar.make(v, "REGISTRO COMPLETO", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                }


            }
        });
        Autenticador = FirebaseAuth.getInstance();

    }




}