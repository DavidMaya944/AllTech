package com.example.alltech_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import controller.CtrlUsuario;

public class RegistroActivity extends AppCompatActivity {
    public static EditText txtNombre;
    public static EditText txtApellidos;
    public static EditText txtEmail;
    public static EditText txtDireccion;
    public static EditText txtUsuario;
    public static EditText txtPassword;
    public static EditText txtTelefono;
    Button btnCancelar;
    Button btnConfirmar;
    CtrlUsuario ctrlUser = new CtrlUsuario();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_activity);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtEmail = findViewById(R.id.txtEmail);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtPassword = findViewById(R.id.txtPassword);
        txtTelefono = findViewById(R.id.txtTelefono);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        MainActivity.preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final MediaPlayer sonido = MediaPlayer.create(this, R.raw.boton);



        btnConfirmar.setOnClickListener(v -> {
            MainActivity.mutearSonido(sonido);
            try {
            ctrlUser.registro();
            } catch(Exception e) {
                Toast.makeText(getApplicationContext(), "ERROR: Registro fallido.", Toast.LENGTH_SHORT).show();
            }

        });

        btnCancelar.setOnClickListener(v -> {
            MainActivity.mutearSonido(sonido);
            onBackPressed();
        });



    }
}