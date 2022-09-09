package com.example.registro.Modelo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.registro.R;

import java.util.ArrayList;

public class act_Lista extends AppCompatActivity {

    ListView listaE;
    ArrayList<Estudiante> lista;
    Adapter adapterP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_lista);

        listaE= findViewById(R.id.listaE);

        lista=getIntent().getParcelableArrayListExtra("miLista");
        adapterP = new Adapter(getApplicationContext(),lista);
        listaE.setAdapter(adapterP);
    }
}