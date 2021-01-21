package com.example.alltech_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import controller.CtrlUsuario;

public class RegistroActivity extends AppCompatActivity {
    public static EditText txtNombre;
    public static EditText txtApellidos;
    public static EditText txtEmail;
    public static EditText txtDireccion;
    public static EditText txtUsuario;
    public static EditText txtPassword;
    public static EditText txtTelefono;
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

        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctrlUser.registro();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}