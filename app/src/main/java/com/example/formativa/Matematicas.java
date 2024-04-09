package com.example.formativa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Matematicas extends AppCompatActivity {
        Button Calcular1;

        EditText numero1, numero2,resultado1;

        Toolbar Formativa;

        @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_matematicas);
            numero1 = (EditText) findViewById(R.id.ednum1);
            numero2 = (EditText) findViewById(R.id.ednum2);
            Calcular1 = (Button) findViewById(R.id.btncalcular1);
            resultado1 = (EditText) findViewById(R.id.edresultado1);

            Formativa = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(Formativa);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);



            Calcular1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        double x1 = Double.parseDouble(numero1.getText().toString());
                        double y1 = Double.parseDouble(numero2.getText().toString());
                        double x2 = 0;
                        double y2 = 0;

                        // Calculamos la distancia
                        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

                        // Mostrar la distancia
                        resultado1.setText("La distancia entre los puntos es: " + distancia);
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Los Valores Agregados no son validos", Toast.LENGTH_LONG).show();

                    }
                    }


            });




        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    }
