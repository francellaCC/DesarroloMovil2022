package com.example.restaurante.Modelo;

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

    public ArrayList<Restaurante> getListaRestaurante() {
        return listaRestaurante;
    }
}
