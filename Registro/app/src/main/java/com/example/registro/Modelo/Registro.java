package com.example.registro.Modelo;

import java.util.ArrayList;

public class Registro {
    ArrayList<Estudiante> listaEstudiantes;

    public Registro(){
        listaEstudiantes = new ArrayList<>();
    }

    public String aregarEstudiante(Estudiante estudiante){
        if(estudiante !=null){
            if(listaEstudiantes.contains(estudiante)){
                return "El estudiante ya se encuentra registrado";
            }else{
                listaEstudiantes.add(estudiante);
                return "el estudiante se agrego correctamente";
            }
        }

        return "Error";
    }

    public int getPosicon(String carnet){
        for (int i=0; i<listaEstudiantes.size(); i++){
            if (listaEstudiantes.get(i).getCarnte().equalsIgnoreCase(carnet)){
                return i;
            }
        }

        return -1;
    }

    public String modificarEstudiante(Estudiante estudiante){
        int indice = getPosicon(estudiante.getCarnte());
        if(estudiante!=null && indice !=-1){
         // listaEstudiantes.get(indice).setNombre(estudiante.getNombre());
           // listaEstudiantes.get(indice).setCarnte(estudiante.getCarnte());
            //listaEstudiantes.get(indice).setCarrera(estudiante.getCarrera());
           // listaEstudiantes.get(indice).setTelefono(estudiante.getTelefono());
            listaEstudiantes.set(indice,estudiante);

            return "estudiante modificado";
        }
        return "error al estudiante modificado";
    }


    public String eliminarEstudiante(int posicion){
        if (posicion != -1){
            listaEstudiantes.remove(posicion);
            return "Estudiante eliminado";
        }

        return "Error";
    }

    public Estudiante devolverEstudiante(int posicion){
        if(posicion !=-1){
            return listaEstudiantes.get(posicion);
        }else{
            return null;
        }
    }

    public ArrayList<Estudiante> devolverLista(){
        return listaEstudiantes;
    }

}
