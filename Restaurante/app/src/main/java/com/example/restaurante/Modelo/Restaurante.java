package com.example.restaurante.Modelo;

public class Restaurante {

    private String CodigoPLato;
    private String Descripcion;
    private String Precio;

    public Restaurante(String codigoPLato, String descripcion, String precio) {
        CodigoPLato = codigoPLato;
        Descripcion = descripcion;
        Precio = precio;
    }
    public Restaurante(){
        CodigoPLato = "";
        Descripcion = "";
        Precio = "";
    }

    public String getCodigoPLato() {
        return CodigoPLato;
    }

    public void setCodigoPLato(String codigoPLato) {
        CodigoPLato = codigoPLato;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "CodigoPLato='" + CodigoPLato + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", Precio='" + Precio + '\'' +
                '}';
    }
}
