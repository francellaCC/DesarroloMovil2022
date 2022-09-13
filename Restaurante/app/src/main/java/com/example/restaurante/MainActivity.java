package com.example.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.restaurante.Modelo.RegistroRestaurante;
import com.example.restaurante.Modelo.Restaurante;

public class MainActivity extends AppCompatActivity {

    EditText txtCodigoPlato, txtDescripcion,txtPrecio;
    ImageView imgUser;
    Button btnAgregar;
    Restaurante restaurante;
    RegistroRestaurante registroRestaurante;
    String mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //text
        txtPrecio=findViewById(R.id.txtPrecio);
        txtDescripcion=findViewById(R.id.txtDescripcion);
        txtCodigoPlato=findViewById(R.id.txtCodigoPlato);

        //imagen
        imgUser=findViewById(R.id.imgUser);

        //botones
        btnAgregar=findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtPrecio.getText().toString().trim().isEmpty()|| txtDescripcion.getText().toString().trim().isEmpty() ||
                        txtCodigoPlato.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor llenar todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    restaurante= new Restaurante(txtCodigoPlato.getText().toString().trim(),txtCodigoPlato.getText().toString().trim(),txtPrecio.getText().toString().trim());
                    mensaje= registroRestaurante.registrarPlato(restaurante);
                    Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}