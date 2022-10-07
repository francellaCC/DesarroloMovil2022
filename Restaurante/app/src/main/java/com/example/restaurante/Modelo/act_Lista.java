package com.example.restaurante.Modelo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurante.MainActivity;
import com.example.restaurante.R;

import java.util.ArrayList;

public class act_Lista extends AppCompatActivity {
    EditText txtCodigoPlato, txtDescripcion,txtPrecio;
    Button btnModificar,btnBorrar,btnRegresar;
    Plato plato;
    RegistroRestaurante registroRestaurante = new RegistroRestaurante();
    String mensaje;

   ArrayList<Plato> listaPlatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lty_actions);

        //text
        txtPrecio=findViewById(R.id.txtPrecio);
        txtDescripcion=findViewById(R.id.txtDescripcion);
        txtCodigoPlato=findViewById(R.id.txtCodigoPlato);

        //botones
        btnModificar=findViewById(R.id.btnModificar);
        btnBorrar=findViewById(R.id.btnBorrar);
        btnRegresar=findViewById(R.id.btnRegresar);

        listaPlatos =getIntent().getParcelableArrayListExtra("miLista");
        Integer posicion= getIntent().getIntExtra("posicion",-1);

        plato= listaPlatos.get(posicion);

        txtCodigoPlato.setText(plato.getCodigoPLato());
        txtDescripcion.setText(plato.getDescripcion());
        txtPrecio.setText(plato.getPrecio());





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
                    limpiar();
                    listaPlatos.add(plato);
                    Toast.makeText(act_Lista.this, "Datos modificados", Toast.LENGTH_SHORT).show();
            }}
        });



        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCodigoPlato.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),
                            "Por favor ingrese el codigo del plato",
                            Toast.LENGTH_SHORT).show();
                }else {
                    int posicion = registroRestaurante.getPosicon(txtCodigoPlato.getText().toString());
                    mensaje = registroRestaurante.eliminarProducto(posicion);
                    Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
                    limpiar();
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(act_Lista.this, "Volviendo a la Pantalla Principal", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(act_Lista.this, MainActivity.class);
                //intent.putExtra("lista",listaPlatos);
                startActivity(intent);
            }
        });

    }
    public void limpiar(){
        txtCodigoPlato.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
    }
}