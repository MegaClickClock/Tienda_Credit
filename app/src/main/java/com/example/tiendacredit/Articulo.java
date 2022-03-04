package com.example.tiendacredit;

import java.text.DecimalFormat;

public class Articulo {
    private int codigo;
    private String nombreArticulo;
    private String precio;

    public Articulo(){};

    public Articulo(int codigo, String nombreArticulo, float precio) {
        this.codigo = codigo;
        this.nombreArticulo = nombreArticulo;
        this.precio = String.format("%.02f", precio);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getnombreArticulo() {
        return nombreArticulo;
    }

    public void setnombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = String.format("%.02f", precio);
    }
}
