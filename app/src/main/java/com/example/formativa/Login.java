package com.example.formativa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText usuario, password;
    Button ingresar, cancelar;

    CheckBox terminoYcondiciones;

    ProgressBar barritaDeProgreso;

    Toolbar Formativa;


    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText) findViewById(R.id.edtusuario);
        password = (EditText) findViewById(R.id.edtpassword);
        ingresar = (Button) findViewById(R.id.btningresar);
        cancelar = (Button) findViewById(R.id.btncancelar);
        terminoYcondiciones = (CheckBox) findViewById(R.id.chaceptoterminos);
        barritaDeProgreso = (ProgressBar) findViewById(R.id.progressBar);
        Formativa = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(Formativa);


        // Asignar un Listener al checkbox de términos y condiciones
        terminoYcondiciones.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Si los términos están aceptados, desactivar el drawableRight
                terminoYcondiciones.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                // Habilitar el botón de ingresar
                ingresar.setEnabled(true);
            } else {
                // Si los términos no están aceptados, activar el drawableRight
                terminoYcondiciones.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.baseline_report_24, 0);
                // Deshabilitar el botón de ingresar
                ingresar.setEnabled(false);
                Toast.makeText(Login.this, "Por favor, acepta los términos y condiciones", Toast.LENGTH_SHORT).show();
            }
        });


// Asignar un Listener al botón de ingresar
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Mostrar ProgressBar
                barritaDeProgreso.setVisibility(View.VISIBLE);

                // Simular verificación de credenciales durante 2 segundos
                new Handler().postDelayed(() -> {
                    // Ocultar ProgressBar después de la verificación
                    barritaDeProgreso.setVisibility(View.INVISIBLE);

                    // Verificar las credenciales
                    if (usuario.getText().toString().equalsIgnoreCase("admin") &&
                            password.getText().toString().equalsIgnoreCase("12345")) {
                        // Credenciales válidas, iniciar sesión
                        Intent i = new Intent(getApplicationContext(), HomePrincipal.class);
                        startActivity(i);
                    } else {
                        // Credenciales inválidas, mostrar mensaje de error
                        Toast.makeText(getApplicationContext(), "Credenciales inválidas", Toast.LENGTH_LONG).show();
                    }
                }, 2000); // Tiempo de simulación de verificación de credenciales
            }
        });


        password = findViewById(R.id.edtpassword);


        password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_visibility_off_24, 0);


        password.setTransformationMethod(PasswordTransformationMethod.getInstance());

        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int right = 2;
                if (password.getCompoundDrawables()[right] != null && event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= password.getRight() - password.getCompoundDrawables()[right].getBounds().width()) {
                        togglePasswordVisibility();
                        return true; // Indicar que hemos manejado completamente el evento
                    }
                }
                return false;
            }


            private void togglePasswordVisibility() {
                int selection = password.getSelectionEnd();
                if (password.getTransformationMethod() instanceof PasswordTransformationMethod) {
                    // Si la contraseña está oculta, mostrarla
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_visibility_24, 0);
                } else {
                    // Si la contraseña está visible, ocultarla
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_visibility_off_24, 0);
                }
                password.setSelection(selection);
            }
        });


        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setText("");
                password.setText("");
            }
        });
    }
}