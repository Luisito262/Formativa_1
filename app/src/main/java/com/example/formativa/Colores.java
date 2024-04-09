package com.example.formativa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Colores extends AppCompatActivity {

    androidx.constraintlayout.widget.ConstraintLayout Fondo;

    Button CambiarColor;

    Toolbar Formativa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores);
        Fondo = (androidx.constraintlayout.widget.ConstraintLayout) findViewById(R.id.Fondo);
        CambiarColor = (Button) findViewById(R.id.btnCambioColor);

        Formativa = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(Formativa);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        CambiarFondo();

        CambiarColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CambiarFondo();

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

    private void CambiarFondo() {

        Random ran = new Random();
        int color = Color.argb(255, ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));

        // Establecer el color de fondo del layout
        Fondo.setBackgroundColor(color);
    }
}
