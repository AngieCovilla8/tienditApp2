package com.example.intento;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class Productos extends AppCompatActivity {



    public Productos() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_nav_productos);

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

            default:
                return false;
        }
    }
}