package com.example.registro.Modelo;

import android.net.Uri;

public class Estudiante {
    public String nombre;
    public String carnte;
    public String carrera;
    public int telefono;

    private Uri imgUser;

    public Estudiante(String nombre, String carnte, String carrera, int telefono, Uri imgUser) {
        this.nombre = nombre;
        this.carnte = carnte;
        this.carrera = carrera;
        this.telefono = telefono;
        this.imgUser=imgUser;
    }

    public Estudiante() {
        this.nombre = "";
        this.carnte = "";
        this.carrera = "";
        this.telefono = 0;
        this.imgUser=null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnte() {
        return carnte;
    }

    public void setCarnte(String carnte) {
        this.carnte = carnte;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Uri getImgUser() {
        return imgUser;
    }

    public void setImgUser(Uri imgUser) {
        this.imgUser = imgUser;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", carnte='" + carnte + '\'' +
                ", carrera='" + carrera + '\'' +
                ", telefono=" + telefono +
                ", imgUser=" + imgUser +
                '}';
    }
}
