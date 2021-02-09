package com.example.alltech_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import controller.CtrlUsuario;
import logic.LogicaUsuario;
import model.Usuario;

public class ActivityAjustes extends AppCompatActivity {
    CtrlUsuario ctrlUser = new CtrlUsuario();
    public static Context contextAjuste;
    public static EditText txtAjNombre;
    public static EditText txtAjApellidos;
    public static EditText txtAjEmail;
    public static EditText txtAjPassword;
    public static EditText txtAjDireccion;
    public static EditText txtAjUsuario;
    public static EditText txtAjPhone;
    Button btnDelete;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        txtAjEmail = findViewById(R.id.txtAjEmail);
        txtAjPassword = findViewById(R.id.txtAjPassword);
        txtAjNombre = findViewById(R.id.txtAjNombre);
        txtAjApellidos = findViewById(R.id.txtAjApellidos);
        txtAjDireccion = findViewById(R.id.txtAjDireccion);
        txtAjUsuario = findViewById(R.id.txtAjUsuario);
        txtAjPhone = findViewById(R.id.txtAjPhone);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);

        final MediaPlayer sonido = MediaPlayer.create(this, R.raw.boton);

        for(Usuario u : LogicaUsuario.lUsuario){
            txtAjEmail.setText(u.getEMAIL());
            txtAjPassword.setText(u.getPASSWORD());
            txtAjNombre.setText(u.getNOMBRE());
            txtAjApellidos.setText(u.getAPELLIDOS());
            txtAjDireccion.setText(u.getDIRECCION());
            txtAjUsuario.setText(u.getUSUARIO());
            txtAjPhone.setText(u.getTELEFONO());
        }

        btnDelete.setOnClickListener(v -> {
            MainActivity.mutearSonido(sonido);
            ctrlUser.delete_user();
        });

        btnUpdate.setOnClickListener(v -> {
            MainActivity.mutearSonido(sonido);
            ctrlUser.update_user();
            onBackPressed();
        });
    }



}