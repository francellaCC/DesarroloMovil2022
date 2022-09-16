package com.example.restaurante.Modelo;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Restaurante implements Parcelable {

    private String codigoPLato;
    private String descripcion;
    private String precio;

    private Uri imgUser;

    public Restaurante(String codigoPLato, String descripcion, String precio,Uri imgUser) {
        this.codigoPLato = codigoPLato;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imgUser=imgUser;
    }
    public Restaurante(){
        codigoPLato = "";
        descripcion = "";
        precio = "";
        imgUser=null;
    }

    protected Restaurante(Parcel in) {
        codigoPLato = in.readString();
        descripcion = in.readString();
        precio = in.readString();
        imgUser = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Restaurante> CREATOR = new Creator<Restaurante>() {
        @Override
        public Restaurante createFromParcel(Parcel in) {
            return new Restaurante(in);
        }

        @Override
        public Restaurante[] newArray(int size) {
            return new Restaurante[size];
        }
    };

    public String getCodigoPLato() {
        return codigoPLato;
    }

    public void setCodigoPLato(String codigoPLato) {
        this.codigoPLato = codigoPLato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Uri getImgUser() {
        return imgUser;
    }

    public void setImgUser(Uri imgUser) {
        this.imgUser = imgUser;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "codigoPLato='" + codigoPLato + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio='" + precio + '\'' +
                ", imgUser=" + imgUser +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(codigoPLato);
        parcel.writeString(descripcion);
        parcel.writeString(precio);
        parcel.writeParcelable(imgUser, i);
    }
}
