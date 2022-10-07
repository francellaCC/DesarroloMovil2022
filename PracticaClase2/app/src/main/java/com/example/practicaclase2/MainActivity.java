package com.example.practicaclase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnRegistro,btnInformeRegistro,btnGraficosVenta,btnGraficosIngresos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnGraficosIngresos = findViewById(R.id.btnGraficosIngresos);
        btnGraficosVenta = findViewById(R.id.btnGraficosVenta);
        btnInformeRegistro = findViewById(R.id.btnInformeRegistro);
        btnRegistro = findViewById(R.id.btnRegistro);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),act_Registro.class);
                startActivity(intent);
            }
        });
    }
}