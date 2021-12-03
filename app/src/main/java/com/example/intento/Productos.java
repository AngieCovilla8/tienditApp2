package com.example.intento;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Productos extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    Adapter myAdapter;
    ArrayList<Items> list;



    public Productos() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_nav_productos);
        recyclerView = findViewById(R.id.List);
        database = FirebaseDatabase.getInstance().getReference("Items");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdapter = new Adapter(this,list);
        recyclerView.setAdapter(myAdapter);
        
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Items item =dataSnapshot.getValue(Items.class);
                    list.add(item);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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

            case R.id.nav_inventario:
                Intent intent3 = new Intent(this, Inventario.class);
                startActivity(intent3);
                return true;

            default:
                return false;
        }
    }
}