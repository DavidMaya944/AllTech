package com.example.alltech_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import controller.CtrlUsuario;
import logic.LogicaProducto;
import logic.LogicaUsuario;
import model.Usuario;

public class ActivityAjustes extends AppCompatActivity {
    CtrlUsuario ctrlUser = new CtrlUsuario();
    public static Context contextAjuste;
    EditText txtAjNombre;
    EditText txtAjApellidos;
    public static EditText txtAjEmail;
    EditText txtAjPassword;
    EditText txtAjDireccion;
    EditText txtAjUsuario;
    EditText txtAjPhone;
    Button btnDelete;

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

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
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

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(preferences.getBoolean("vol",true)){
                    sonido.start();
                }else{
                    sonido.stop();
                }
                ctrlUser.delete_user();
            }
        });
    }



}