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

import java.util.Objects;

public class Fisica extends AppCompatActivity {

    EditText Masa, Tiempo,resultado2;

    Button Calcular2;

    Toolbar Formativa;

    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica);
        Masa = (EditText) findViewById(R.id.edmasa);
        Tiempo = (EditText) findViewById(R.id.edtiempo);
        Calcular2 = (Button) findViewById(R.id.btncalcular2);
        resultado2 = (EditText) findViewById(R.id.edresultado2);

        Formativa = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(Formativa);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Calcular2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double masa = Double.parseDouble(Masa.getText().toString());
                    double aceleracion = Double.parseDouble(Tiempo.getText().toString());

                    double fuerza = masa * aceleracion;
                    resultado2.setText("Fuerza aplicada es: " + fuerza);
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

