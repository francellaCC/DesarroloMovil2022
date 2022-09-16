package com.example.registrooperaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText txtNumero1, txtNumero2, txtResultado;

    Button btnSumar,btnRestar,btnMultiplicar,btnDividir,btnGuardar,btnBorar;
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
        btnGuardar=findViewById(R.id.btnGuardar);
        btnBorar= findViewById(R.id.btnBorar);


        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNumero1.getText().toString().isEmpty() || txtNumero2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Porfavor llenar todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    int n1=Integer.parseInt(txtNumero1.getText().toString().trim());
                    int n2=Integer.parseInt(txtNumero2.getText().toString().trim());
                    int r = n2+n1;
                    txtResultado.setText(" "+r);
                }
            }
        });
       //fin boton sumar

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNumero1.getText().toString().isEmpty() || txtNumero2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Porfavor llenar todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    int n1=Integer.parseInt(txtNumero1.getText().toString().trim());
                    int n2=Integer.parseInt(txtNumero2.getText().toString().trim());
                    int r = n1-n2;
                    txtResultado.setText(" "+r);
                }
            }
        });

        //fin boton restar

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNumero1.getText().toString().isEmpty() || txtNumero2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Porfavor llenar todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    int n1=Integer.parseInt(txtNumero1.getText().toString().trim());
                    int n2=Integer.parseInt(txtNumero2.getText().toString().trim());
                    int r = n1/n2;
                    txtResultado.setText(" "+r);
                }
            }
        });
        //fin boton dividir

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNumero1.getText().toString().isEmpty() || txtNumero2.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Porfavor llenar todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    int n1=Integer.parseInt(txtNumero1.getText().toString().trim());
                    int n2=Integer.parseInt(txtNumero2.getText().toString().trim());
                    int r = n1*n2;
                    txtResultado.setText(" "+r);
                }
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNumero1.getText().toString().isEmpty() || txtNumero2.getText().toString().isEmpty() || txtResultado.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Porfavor llenar todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    int n1=Integer.parseInt(txtNumero1.getText().toString().trim());
                    int n2=Integer.parseInt(txtNumero2.getText().toString().trim());
                    int r = n1*n2;
                    Toast.makeText(MainActivity.this, "Su resultado es"+r, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBorar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNumero1.getText().toString().isEmpty() || txtNumero2.getText().toString().isEmpty() ) {
                    Toast.makeText(getApplicationContext(), "Los campos estan limpios", Toast.LENGTH_SHORT).show();
                }else{
                    txtResultado.setText("");
                    txtNumero1.setText("");
                    txtNumero2.setText("");
                    Toast.makeText(MainActivity.this, "Campos limpiados", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}