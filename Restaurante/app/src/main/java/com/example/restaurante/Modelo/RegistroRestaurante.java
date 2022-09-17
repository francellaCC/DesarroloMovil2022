package com.example.restaurante.Modelo;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class RegistroRestaurante {

 ArrayList<Restaurante> listaRestaurante;

 public RegistroRestaurante(){
   listaRestaurante = new ArrayList<>();
 }

 public String registrarPlato(Restaurante restaurante){
      if(restaurante!= null){
           if(listaRestaurante.contains(restaurante)){
                 return "El plato ya esta registrado";
           }else{
             listaRestaurante.add(restaurante);
             return "Se registro correctamente";
           }
      }
      return "error";
 }

    public int getPosicon(String codigoPlato){
        for (int i=0; i<listaRestaurante.size(); i++){
            if (listaRestaurante.get(i).getCodigoPLato().equalsIgnoreCase(codigoPlato)){
                return i;
            }
        }

        return -1;
    }

    public Restaurante devolverPlato(int posicion){
        if(posicion !=-1){
            return listaRestaurante.get(posicion);
        }else{
            return null;
        }
    }

    public void setListaRestaurante(ArrayList<Restaurante> listaRestaurante) {
        this.listaRestaurante = listaRestaurante;
    }

    public String modificarProducto(Restaurante restaurante){
        int index = getPosicon(restaurante.getCodigoPLato());
        if(restaurante!= null && index != -1){
            listaRestaurante.set(index, restaurante);
            return " El producto ha sido modificado correctamente";
        }
        return "error al meter el producto";
    }
    public ArrayList<Restaurante> getListaRestaurante() {
        return listaRestaurante;
    }
}
