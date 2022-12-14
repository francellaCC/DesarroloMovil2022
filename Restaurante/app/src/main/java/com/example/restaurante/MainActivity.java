package com.example.restaurante;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.restaurante.Modelo.Adapter;
import com.example.restaurante.Modelo.RegistroRestaurante;
import com.example.restaurante.Modelo.Plato;
import com.example.restaurante.Modelo.act_Lista;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtCodigoPlato, txtDescripcion,txtPrecio;
    ImageView imgUser;
    Uri fotoTemp;
    Button btnAgregar;
    Plato plato;
    RegistroRestaurante registroRestaurante = new RegistroRestaurante();
    String mensaje;
    ListView listaE;
    Adapter adapterP;


    private final int Galeria = 1;
    private final int Camara = 2;
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

        listaE = findViewById(R.id.listaE);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtPrecio.getText().toString().trim().isEmpty()|| txtDescripcion.getText().toString().trim().isEmpty() ||
                        txtCodigoPlato.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor llenar todos los campos", Toast.LENGTH_SHORT).show();
                }else{

                    plato= new Plato(txtCodigoPlato.getText().toString().trim(),txtCodigoPlato.getText().toString().trim(),
                            txtPrecio.getText().toString().trim(),fotoTemp);
                    mensaje= registroRestaurante.registrarPlato(plato);
                    Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
                    limpiar();
                    adapterP = new Adapter(getApplicationContext(),registroRestaurante.getListaRestaurante());
                    listaE.setAdapter(adapterP);
                }
            }
        });


        imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Selecciona la imagen del platillo");
                alertDialog.setMessage("Que desea utilizar?");
                alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                alertDialog.setCancelable(false);

                //Al boton positivo se le da la opcion de galeria
                alertDialog.setPositiveButton("Galeria",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.setType("image/*");
                                intent.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(Intent.createChooser(intent,
                                        "Seleccionar Foto"),Galeria);
                            }
                        });

                alertDialog.show();
            }
        });

        listaE.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, act_Lista.class);

                intent.putParcelableArrayListExtra("miLista",registroRestaurante.getListaRestaurante());
                intent.putExtra("posicion",i);
                startActivity(intent);
            }
        });
    }//Fin del oncreate

//  ******************************************

    public void onActivityResult(int rqCode, int resCode,Intent data){
        super.onActivityResult(rqCode,resCode,data);
        if(resCode == RESULT_OK){
            switch (rqCode){
                case Galeria:
                    //A la variable fotoTemp se le asignan los datos que se encuentran en el intent data
                    fotoTemp=data.getData();
                    //Al imageUser se le carga la direccion de la imagen que se guardo en temp
                    imgUser.setImageURI(fotoTemp);
                    Toast.makeText(getApplicationContext(), "Imagen cargada correctamente", Toast.LENGTH_SHORT).show();
                    break;
            }
        }else{
            Toast.makeText(getApplicationContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiar(){
        txtCodigoPlato.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        imgUser.setImageURI(null);
    }
}