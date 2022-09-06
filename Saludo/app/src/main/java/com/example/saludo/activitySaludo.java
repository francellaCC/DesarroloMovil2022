package com.example.saludo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class activitySaludo extends AppCompatActivity {

    TextView tvSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_saludo);

        tvSaludo =findViewById(R.id.tvSaludo);


        //recuperamos la informacion que se recibe del intent

        Bundle bundle =this.getIntent().getExtras();


        //construimos el mensaje para monstrarlo

        tvSaludo.setText("Hola Señot(a): " +bundle.getString("NOMBRE")+" "+bundle.getString("APELLIDO"));

    }
}