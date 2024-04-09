package com.example.formativa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePrincipal extends AppCompatActivity {

    Button matematica, fisica, texto, salir;

    Toolbar Formativa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_principal);
        matematica = (Button) findViewById(R.id.btnmatematica);
        fisica = (Button) findViewById(R.id.btnfisica);
        texto = (Button) findViewById(R.id.btntexto);
        salir = (Button) findViewById(R.id.btnsalir);
        Formativa = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(Formativa);

        matematica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomePrincipal.this, Matematicas.class);
                startActivity(a);
            }
        });


        fisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(HomePrincipal.this, Fisica.class);
                startActivity(b);
            }
        });

        texto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(HomePrincipal.this, Texto.class);
                startActivity(c);
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(HomePrincipal.this, Login.class);
                startActivity(d);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_casita,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_item_temperatura) {
            Intent e = new Intent(this, Temperatura.class);
            startActivity(e);
            return true;
        }
        int itemid1 = item.getItemId();
        if (itemid1 == R.id.action_color){
            Intent f = new Intent (this,Colores.class);
            startActivity(f);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

}