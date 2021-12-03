package com.example.intento;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import com.example.intento.databinding.ActivityMainBinding;
import com.example.intento.databinding.ActivityRegistroBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Inventario extends AppCompatActivity {

    Button añadir;
    String Producto,Precio,Marca;
    FirebaseDatabase db;
    DatabaseReference reference;
    private EditText RProducto,RMarca,RPrecio;
    private ActivityRegistroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);

        this.añadir= findViewById(R.id.button33);
        this.RProducto = findViewById(R.id.RegProducto);
        this.RPrecio = findViewById(R.id.RegPrecio) ;
        this.RMarca = findViewById(R.id.RegMarca);
        this.añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Producto =  RProducto.getText().toString();
                Precio = RPrecio.getText().toString();
                Marca = RMarca.getText().toString();

                if(!Producto.isEmpty() && !Precio.isEmpty() && !Marca.isEmpty()){

                    Items items = new Items(Producto,Precio,Marca);
                    db = FirebaseDatabase.getInstance();
                    reference= db.getReference("Items");
                    reference.child(Producto).setValue(items).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            RProducto.setText("");
                            RPrecio.setText("");
                            RMarca.setText("");

                        }
                    });

                }
            }
        });
    }

}