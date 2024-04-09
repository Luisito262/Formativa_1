package com.example.formativa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Temperatura extends AppCompatActivity {

    Spinner Temperaturas;

    EditText IngresarTemp, resultado3;

    Button Calcular;

    Toolbar Formativa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
        Temperaturas = findViewById(R.id.spinnerUnits);
        IngresarTemp = (EditText) findViewById(R.id.edcelsius);
        resultado3 = (EditText) findViewById(R.id.edresultado3);
        Calcular = (Button) findViewById(R.id.btncalcular3);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temperature_units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Temperaturas.setAdapter(adapter);

        Formativa = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(Formativa);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String celsiusString = IngresarTemp.getText().toString().trim();
                    if (!TextUtils.isEmpty(celsiusString)) {
                        double celsius = Double.parseDouble(celsiusString);
                        double resultado;
                        String unit = Temperaturas.getSelectedItem().toString();
                        switch (unit) {
                            case "Fahrenheit":
                                resultado = celsius * 9 / 5 + 32;
                                break;
                            case "Kelvin":
                                resultado = celsius + 273.15;
                                break;
                            case "Rankine":
                                resultado = (celsius + 273.15) * 9 / 5;
                                break;
                            default:
                                resultado = celsius;
                        }
                        resultado3.setText("La Temperatura es " + resultado);
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








