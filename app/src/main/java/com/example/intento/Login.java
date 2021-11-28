package com.example.intento;


import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;

import com.example.intento.databinding.ActivityLoginBinding;
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
public class Login extends AppCompatActivity {

    Button login;
    private ActivityLoginBinding binding;
    private FirebaseAuth Autentificador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       setContentView(R.layout.activity_login);

        this.login= findViewById(R.id.button2);
        this.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = binding.correologin.getText().toString();
                String contraseña = binding.passlogin.getText().toString();
                Autentificador.signInWithEmailAndPassword(usuario, contraseña)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "SignWithEmail:success");
                                    FirebaseUser user = Autentificador.getCurrentUser();
                                    Intent home=new  Intent(Login.this, Reporte.class);
                                    startActivity(home);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "SignWithEmail:failure", task.getException());
                                    Toast.makeText(Login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    Snackbar.make(v,"Error",Snackbar.LENGTH_LONG).show();
                                }
                            }
                        });

            }

        });
        Autentificador=FirebaseAuth.getInstance();

    }


}