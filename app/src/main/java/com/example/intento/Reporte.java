package com.example.intento;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class Reporte extends AppCompatActivity {





    public Reporte() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_nav_reporte);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_drawer,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_proveedor:
                Intent intent = new Intent(this, Proveedor.class);
                startActivity(intent);
                return true;

            case R.id.nav_reporte:
                Intent intent2 = new Intent(this, Reporte.class);
                startActivity(intent2);
                return true;

            case R.id.nav_productos:
                Intent intent1 = new Intent(this, Productos.class);
                startActivity(intent1);
                return true;

            case R.id.nav_home:
                Intent intent3 = new Intent(this, Home.class);
                startActivity(intent3);
                return true;

            default:
                return false;
        }
    }
}