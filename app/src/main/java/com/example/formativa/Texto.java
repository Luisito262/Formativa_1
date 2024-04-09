package com.example.formativa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;

public class Texto extends AppCompatActivity {

    EditText Texto;

    Button Aumentar, Disminuye;

    CheckBox Cursiva, Negrita;

    Toolbar Formativa;

    float FontSize = 16.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);
        Texto = (EditText) findViewById(R.id.edtexto);
        Aumentar = (Button) findViewById(R.id.btntamaño);
        Disminuye = (Button) findViewById(R.id.btndisminuir);
        Cursiva = (CheckBox) findViewById(R.id.chcursiva);
        Negrita = (CheckBox) findViewById(R.id.chnegrita);
        Formativa = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(Formativa);
        setSupportActionBar(Formativa);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Aumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FontSize += 1.0f;
                Texto.setTextSize(FontSize);

            }
        });
        Disminuye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FontSize -= 1.0f;
                Texto.setTextSize(FontSize);

            }
        });
        Cursiva.setOnCheckedChangeListener((buttonView, isChecked) -> Estiloletra());
        Negrita.setOnCheckedChangeListener((buttonView, isChecked) -> Estiloletra());
    }

    public void Estiloletra(){
        String text = Texto.getText().toString();
        SpannableStringBuilder spannable = new SpannableStringBuilder(text);

        if (Negrita.isChecked()) {
            StyleSpan boldSpan = new StyleSpan(android.graphics.Typeface.BOLD);
            spannable.setSpan(boldSpan, 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        }

        if (Cursiva.isChecked()) {
            StyleSpan italicSpan = new StyleSpan(android.graphics.Typeface.ITALIC);
            spannable.setSpan(italicSpan, 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        }
        Texto.setText(spannable);

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