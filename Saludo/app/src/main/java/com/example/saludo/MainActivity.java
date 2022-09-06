package com.example.saludo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Definimos los componentes

    EditText txtNombre;
    Button btnAceptar;
    EditText txtApellido;

    String nombre;
    String apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //se igualan los componentes, se le dice que busque en la vista el id con ese nombre
        txtNombre= findViewById(R.id.txtNombre);
        btnAceptar= findViewById(R.id.btnAceptar);
        txtApellido=findViewById(R.id.txtApellido);


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre=txtNombre.getText().toString();
                //Toast.makeText(getApplicationContext(), "hola"+nombre,Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,
                        "Hola"+nombre, Toast.LENGTH_SHORT).show();

                //Apellido
                apellido=txtApellido.getText().toString();
                Toast.makeText(MainActivity.this, "Apellidos"+apellido, Toast.LENGTH_SHORT).show();
                //para la comunicacion entre activitis
                Intent intent = new Intent(MainActivity.this,activitySaludo.class);

                Bundle bundle= new Bundle();
                bundle.putString("NOMBRE",nombre);

                Bundle bundle1= new Bundle();
                bundle1.putString("APELLIDO",apellido);

                //Añadir la informacion al intent

                intent.putExtras(bundle);
                intent.putExtras(bundle1);

                startActivity(intent);
            }
        });
    }
}