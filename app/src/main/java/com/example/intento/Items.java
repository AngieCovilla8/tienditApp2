package com.example.intento;

public class Items {
    String Producto,Precio,Marca;

    public Items() {
    }

    public Items(String producto, String precio, String marca) {
        Producto = producto;
        Precio = precio;
        Marca = marca;
    }

    public String getProducto() {
        return Producto;
    }

    public String getPrecio() {
        return Precio;
    }

    public String getMarca() {
        return Marca;
    }

    public void setProducto(String producto) {
        Producto = producto;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }
}
