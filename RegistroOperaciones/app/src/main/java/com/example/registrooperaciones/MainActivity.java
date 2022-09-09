package com.example.registrooperaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView txtNumero1, txtNumero2, txtResultado;

    Button btnSumar,btnRestar,btnMultiplicar,btnDividir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //texto
        txtNumero1= findViewById(R.id.txtNumero1);
        txtNumero2=findViewById(R.id.txtNumero2);
        txtResultado=findViewById(R.id.txtResultado);


        //botones

        btnSumar=findViewById(R.id.btnSuma);
        btnDividir =findViewById(R.id.btnDivision);
        btnMultiplicar=findViewById(R.id.btnMultiplicar);
        btnRestar=findViewById(R.id.btnRestar);


        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNumero1.getText().toString().isEmpty() || txtNumero2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Porfavor llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}