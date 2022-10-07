package com.example.restaurante.Modelo;

import java.util.ArrayList;

public class RegistroRestaurante {

 ArrayList<Plato> listaPlato;

 public RegistroRestaurante(){
   listaPlato = new ArrayList<>();
 }

 public String registrarPlato(Plato restaurante){
      if(restaurante!= null){
           if(listaPlato.contains(restaurante)){
                 return "El plato ya esta registrado";
           }else{
             listaPlato.add(restaurante);
             return "Se registro correctamente";
           }
      }
      return "error";
 }

    public int getPosicon(String codigoPlato){
        for (int i=0; i<listaPlato.size(); i++){
            if (listaPlato.get(i).getCodigoPLato().equalsIgnoreCase(codigoPlato)){
                return i;
            }
        }

        return -1;
    }

    public Plato devolverPlato(int posicion){
        if(posicion !=-1){
            return listaPlato.get(posicion);
        }else{
            return null;
        }
    }

    public void setListaRestaurante(ArrayList<Plato> listaRestaurante) {
        this.listaPlato = listaRestaurante;
    }

    public String modificarProducto(Plato plato){
        int index = getPosicon(plato.getCodigoPLato());
        if(plato!= null && index != -1){
            listaPlato.set(index, plato);
            return " El producto ha sido modificado correctamente";
        }
        return "error al meter el producto";
    }
    //------------------------------------------------------------------------------------------------------
    public String eliminarProducto(int posicion){
        if(posicion != -1){
            listaPlato.remove(posicion);
            return "Platillo eliminado correctamente";
        }
        return "Error al eliminar";
    }//Fin del metodo eliminar
    //------------------------------------------------------------------------------------------------------
    public ArrayList<Plato> getListaRestaurante() {
        return listaPlato;
    }
}
