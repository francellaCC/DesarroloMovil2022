package com.example.restaurante.Modelo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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
    Button btnModificar,btnBorrar,btnRegresar;
    Restaurante plato;
    Restaurante platoTemp;
    RegistroRestaurante registroRestaurante = new RegistroRestaurante();
    String mensaje;
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


        //botones
        btnModificar=findViewById(R.id.btnModificar);
        btnBorrar=findViewById(R.id.btnBorrar);
        btnRegresar=findViewById(R.id.btnRegresar);
//
        listaPlatos =getIntent().getParcelableArrayListExtra("miLista");
        Integer posicion= getIntent().getIntExtra("posicion",-1);

        plato= listaPlatos.get(posicion);

        txtCodigoPlato.setText(plato.getCodigoPLato());
        txtDescripcion.setText(plato.getDescripcion());
        txtPrecio.setText(plato.getPrecio());
       // imgUser.setImageURI(plato.getImgUser());




        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCodigoPlato.getText().toString().isEmpty()
                        || txtDescripcion.getText().toString().isEmpty()
                        || txtPrecio.getText().toString().isEmpty()
                ){
                    Toast.makeText(getApplicationContext(),
                            "Porfavor llenar todos los espacios",
                            Toast.LENGTH_SHORT).show();
                }else{
                    plato.setPrecio(txtPrecio.getText().toString().trim());
                    plato.setDescripcion(txtDescripcion.getText().toString().trim());
                    plato.setCodigoPLato(txtCodigoPlato.getText().toString().trim());
                    mensaje = registroRestaurante.modificarProducto(plato);

                    Toast.makeText(getApplicationContext(),mensaje,
                            Toast.LENGTH_SHORT).show();
                    System.out.println(plato);
            }}
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }


    public void  nose(){
        if(getIntent().getExtras()!=null) {


            Toast.makeText(getApplicationContext(), "si hay datos", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiar(){
        txtCodigoPlato.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
    }
}