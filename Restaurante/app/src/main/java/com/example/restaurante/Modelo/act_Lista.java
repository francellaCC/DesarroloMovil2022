package com.example.restaurante.Modelo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurante.R;

import java.util.ArrayList;

public class act_Lista extends AppCompatActivity {
    EditText txtCodigoPlato, txtDescripcion,txtPrecio;
    ImageView imgUser;
    Uri fotoTemp;
    Button btnModificar,btnBorrar;
    Restaurante plato;
    RegistroRestaurante registroRestaurante = new RegistroRestaurante();
    String mensaje;
    ArrayAdapter adapter;
    Adapter adapterP;
   ArrayList<Restaurante> listaPlatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lty_actions);
         nose();
        //text
        txtPrecio=findViewById(R.id.txtPrecio);
        txtDescripcion=findViewById(R.id.txtDescripcion);
        txtCodigoPlato=findViewById(R.id.txtCodigoPlato);

        //imagen
        imgUser=findViewById(R.id.imgUser);

        //botones
        btnModificar=findViewById(R.id.btnModificar);
        btnBorrar=findViewById(R.id.btnBorrar);

        listaPlatos =getIntent().getParcelableArrayListExtra("miLista");
        Integer posicion= getIntent().getIntExtra("posicion",-1);

        plato= listaPlatos.get(posicion);

        txtCodigoPlato.setText(plato.getCodigoPLato());

    }

    public void  nose(){
        if(getIntent().getExtras()!=null) {


            Toast.makeText(getApplicationContext(), "si hay datos", Toast.LENGTH_SHORT).show();
        }
    }
}