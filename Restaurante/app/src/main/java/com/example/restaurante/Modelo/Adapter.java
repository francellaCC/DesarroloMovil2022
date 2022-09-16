package com.example.restaurante.Modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restaurante.Modelo.RegistroRestaurante;

import com.example.restaurante.R;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    Context context;
    ArrayList<Restaurante> lista;

    public Adapter(Context context, ArrayList<Restaurante> lista) {
        this.context = context;
        this.lista = lista;
    }//Fin del constructor

    //Devuelve el tamaño de la lista
    @Override
    public int getCount() {
        return lista.size();
    }

    //Devuelve un objeto en una posición
    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    //Retorna una posicion
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater layoutInflater = (LayoutInflater)
                    context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item,null);
        }
        TextView lbCodigoPlato = view.findViewById(R.id.lbCodigoPlato);
        TextView lbDescripcion = view.findViewById(R.id.lbDescripcion);
        TextView lbPrecio = view.findViewById(R.id.lbPrecio);

        ImageView imgUs = view.findViewById(R.id.imgUs);

        lbCodigoPlato.setText(lista.get(i).getCodigoPLato());
        lbDescripcion.setText(lista.get(i).getDescripcion());
        lbPrecio.setText(lista.get(i).getPrecio());
        imgUs.setImageURI(lista.get(i).getImgUser());
        return view;
    }
}//Fin de la clase Adapter





