package com.example.registro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityManagerCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
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

import com.example.registro.Modelo.Adapter;
import com.example.registro.Modelo.Estudiante;
import com.example.registro.Modelo.Registro;
import com.example.registro.Modelo.act_Lista;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class act_Registro extends AppCompatActivity {

    public static final  String chanelId="Notificacion";
    public static final  int notificationID=0;


    EditText txtNombre, txtCarnet,txtCarrera,textTelefono;
    Button btnAgregar, btnModificar,btnEliminar,btnBuscar,btnLlamar;
    ImageView imgUser;
    Uri fotoTemp;

    Adapter adapterP;
    private final int Galeria=1;
    private final int Camara=2;
    Estudiante estudiante;

    Registro registro = new Registro();
    String mensaje;
    ArrayAdapter adapter;

    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_registro);

        txtNombre = findViewById(R.id.txtNombre);
        txtCarnet = findViewById(R.id.txtCarnet);
        txtCarrera = findViewById(R.id.txtCarrera);
        textTelefono = findViewById(R.id.txtTelefono);


        btnAgregar = findViewById(R.id.btnAgregar);
        btnModificar = findViewById(R.id.btnModificar);
        btnBuscar = findViewById(R.id.button4);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnLlamar= findViewById(R.id.btnLlamar);

        lista = findViewById(R.id.lista);

        imgUser = findViewById(R.id.imageView);


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNombre.getText().toString().isEmpty() || txtCarnet.getText().toString().isEmpty() ||
                        txtCarrera.getText().toString().isEmpty() || textTelefono.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Porfavor llenar todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    int telefono = Integer.parseInt(textTelefono.getText().toString().trim());
                    estudiante = new Estudiante(txtNombre.getText().toString().trim(),
                            txtCarnet.getText().toString().trim(),
                            txtCarrera.getText().toString().trim(), telefono,fotoTemp);
                    mensaje=registro.aregarEstudiante(estudiante);
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    limpiar();
                    //adapter = new ArrayAdapter(act_Registro.this, android.R.layout.simple_list_item_1,registro.devolverLista());

                    adapterP = new Adapter(getApplicationContext(),registro.devolverLista());
                    lista.setAdapter(adapterP);
                }
            }
        });


        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCarnet.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Por Favor ingrese el carnet",Toast.LENGTH_SHORT).show();
                }else{

                 /*   int posicion = registro.getPosicon(txtCarnet.getText().toString().trim());
                    estudiante=registro.devolverEstudiante(posicion);
                    if(estudiante!=null){
                        txtNombre.setText(estudiante.getNombre());
                        txtCarnet.setText(estudiante.getCarnte());
                        txtCarrera.setText(estudiante.getCarrera());
                        textTelefono.setText(""+estudiante.getTelefono());
                    }else{
                        Toast.makeText(act_Registro.this, "El estudiante no se encuentra", Toast.LENGTH_SHORT).show();
                    }
                    */
                    createNotification();
                  Intent i = new Intent(act_Registro.this, act_Lista.class);
                  i.putParcelableArrayListExtra("miLista",registro.devolverLista());
                  startActivity(i);
                }
            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCarnet.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Por Favor Ingrese el carnet",Toast.LENGTH_SHORT).show();

                } else {
                    int telefono = Integer.parseInt(textTelefono.getText().toString().trim());
                    estudiante = new Estudiante(txtNombre.getText().toString().trim(),
                            txtCarnet.getText().toString().trim(),
                            txtCarrera.getText().toString().trim(), telefono,fotoTemp);
                   mensaje= registro.aregarEstudiante(estudiante);
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    limpiar();
                }
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtCarnet.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Por Favor Ingrese el carnet",Toast.LENGTH_SHORT).show();

                } else {
                    int posicion = registro.getPosicon(txtCarnet.getText().toString().trim());
                    mensaje= registro.eliminarEstudiante(posicion);
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                    limpiar();
                }
            }
        });


        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textTelefono.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Por Favor Ingrese el telefono",Toast.LENGTH_SHORT).show();

                }else{
                    String numero = textTelefono.getText().toString();
                    Intent intentLlamar = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+numero));
                    startActivity(intentLlamar);
                }
            }
        });

        imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(act_Registro.this);
                alertDialog.setTitle("Seleccion de la imagen de usuario");
                alertDialog.setMessage("Que desea utilizar?");
                alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                alertDialog.setCancelable(false);

                alertDialog.setPositiveButton("Galeria", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(intent,"Seleccionar Foto"),Galeria);
                    }
                });

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
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                estudiante=registro.devolverEstudiante(i);
                txtNombre.setText(estudiante.getNombre());
                txtCarnet.setText(estudiante.getCarnte());
                txtCarrera.setText(estudiante.getCarrera());
                textTelefono.setText(""+estudiante.getTelefono());
                imgUser.setImageURI(estudiante.getImgUser());

            }
        });

    }

    //recibe 3 parametros
    //el codigo de la solicitud que se envio por medio del starActivityForResult
    //Un codigo de resultado (Result_OK si la accion se realiza correctamente o Result canceled si el usuario cancelo la operacion)
    //Un intent con la informacion
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

    //-------------------------------------------------------------------------------------------------------------------------------------------
    //metodo para notificicacion en versiones anteriores a la 26

    public void createNotification(){
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(getApplicationContext(),chanelId);
        builder.setSmallIcon(R.drawable.ic_lista);
        builder.setContentTitle("Lista Estudiantes");
        builder.setContentText("Se abrió una ventana con lista");
        builder.setColor(Color.RED);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setLights(Color.MAGENTA, 1000, 10000);
        builder.setVibrate(new long[]{1000,1000,1000,1000,1000});
        builder.setDefaults(Notification.DEFAULT_SOUND);

        NotificationManagerCompat notificationManagerCompat =
                NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(notificationID, builder.build());
    }
//-------------------------------------------------------------------------

    //para versiones posteriores a 26
    public void createdNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //verifica si la version es mayor a 26
            CharSequence name = "Notificacion";
            NotificationChannel notificationChannel = new NotificationChannel(chanelId, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }

    }


    //-------------------------------------------------------------------------------------------------------------------------------------------

    public void limpiar(){
        txtNombre.setText("");
        txtCarnet.setText("");
        txtCarrera.setText("");
        textTelefono.setText("");
        imgUser.setImageURI(null);
    }




}