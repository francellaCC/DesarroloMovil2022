package com.example.registro.Modelo;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Estudiante implements Parcelable {
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

    protected Estudiante(Parcel in) {
        nombre = in.readString();
        carnte = in.readString();
        carrera = in.readString();
        telefono = in.readInt();
        imgUser = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Estudiante> CREATOR = new Creator<Estudiante>() {
        @Override
        public Estudiante createFromParcel(Parcel in) {
            return new Estudiante(in);
        }

        @Override
        public Estudiante[] newArray(int size) {
            return new Estudiante[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(carnte);
        parcel.writeString(carrera);
        parcel.writeInt(telefono);
        parcel.writeParcelable(imgUser,i);
    }
}
