package com.example.intento;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    ArrayList<Items> list;

    public Adapter(Context context, ArrayList<Items> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Items item =list.get(position);
        holder.Producto.setText(item.getProducto());
        holder.Precio.setText(item.getPrecio());
        holder.Marca.setText(item.getMarca());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Producto,Precio,Marca;

        public MyViewHolder (@NonNull View itemView) {
            super(itemView);
            Producto = itemView.findViewById(R.id.Producto);
            Precio = itemView.findViewById(R.id.Precio);
            Marca = itemView.findViewById(R.id.Marca);

        }
    }

}
