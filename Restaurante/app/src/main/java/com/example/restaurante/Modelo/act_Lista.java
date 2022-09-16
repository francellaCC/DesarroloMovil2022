package com.example.restaurante.Modelo;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurante.R;

import java.util.ArrayList;

public class act_Lista extends AppCompatActivity {
    EditText txtCodigoPlato, txtDescripcion,txtPrecio;
    ImageView imgUser;
    Uri fotoTemp;
    Button btnModificar,btnBorrar;
    Restaurante restaurante;
    RegistroRestaurante registroRestaurante = new RegistroRestaurante();
    String mensaje;
    ArrayAdapter adapter;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_lista);

        //text
        txtPrecio=findViewById(R.id.txtPrecio);
        txtDescripcion=findViewById(R.id.txtDescripcion);
        txtCodigoPlato=findViewById(R.id.txtCodigoPlato);

        //imagen
        imgUser=findViewById(R.id.imgUser);

        //botones
        btnModificar=findViewById(R.id.btnModificar);
        btnBorrar=findViewById(R.id.btnBorrar);


        bundle = getIntent().getExtras();
        restaurante = (Restaurante) bundle.getParcelable("plato");
        txtCodigoPlato.setText(restaurante.getCodigoPLato());
    }
}