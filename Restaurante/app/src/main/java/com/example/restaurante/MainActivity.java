package com.example.restaurante;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.restaurante.Modelo.RegistroRestaurante;
import com.example.restaurante.Modelo.Restaurante;
import com.example.restaurante.Modelo.act_Lista;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText txtCodigoPlato, txtDescripcion,txtPrecio;
    ImageView imgUser;
    Uri fotoTemp;
    Button btnAgregar;
    Restaurante restaurante;
    RegistroRestaurante registroRestaurante = new RegistroRestaurante();
    String mensaje;
    ListView listaE;
    ArrayAdapter adapter;


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
                    restaurante= new Restaurante(txtCodigoPlato.getText().toString().trim(),txtCodigoPlato.getText().toString().trim(),txtPrecio.getText().toString().trim(),fotoTemp);
                    mensaje= registroRestaurante.registrarPlato(restaurante);
                    Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
                    limpiar();
                    adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,registroRestaurante.getListaRestaurante());
                    listaE.setAdapter(adapter);
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
                //Al boton negativo se le da la opcion de Camara
                alertDialog.setNegativeButton("Camara", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent,Camara);
                    }
                });
                alertDialog.show();
            }
        });

        listaE.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                restaurante=registroRestaurante.devolverPlato(i);
//                txtCodigoPlato.setText(restaurante.getCodigoPLato());
//                txtDescripcion.setText(restaurante.getDescripcion());
//                txtPrecio.setText(restaurante.getPrecio());
//                imgUser.setImageURI(restaurante.getImgUser());

                Intent intent = new Intent(MainActivity.this, act_Lista.class);

                Bundle bundle = new Bundle();
                bundle.putParcelable("plato",restaurante);
                intent.putExtras(bundle);
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

            case Camara:
                if(data !=null){
                    Bitmap thumbail =(Bitmap)data.getExtras().get("data");
                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    thumbail.compress(Bitmap.CompressFormat.JPEG,90, bytes);
                    File destination = new File(Environment.getExternalStorageDirectory(),System.currentTimeMillis()+".jpg");
                    FileOutputStream fo;
                    try{
                        destination.createNewFile();
                        fo= new FileOutputStream(destination);
                        fo.close();

                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                    imgUser.setImageBitmap(thumbail);
                    fotoTemp = data.getData();
                    Toast.makeText(getApplicationContext(), "Imagen correctamente cragada", Toast.LENGTH_SHORT).show();
                }
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
    }
}