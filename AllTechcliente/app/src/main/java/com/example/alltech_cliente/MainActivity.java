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

import logic.LogicaProducto;
import logic.LogicaUsuario;

public class MainActivity extends AppCompatActivity {
    public static Context mainContext;
    Button btnRegistro;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogicaProducto logProd = new LogicaProducto();
        mainContext = getApplicationContext();
        final MediaPlayer sonido = MediaPlayer.create(this, R.raw.boton);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);


        btnRegistro = findViewById(R.id.btnRegistro);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(preferences.getBoolean("vol",true)){
                    sonido.start();
                }else{
                    sonido.stop();
                }
                if(preferences.getString("email", "").equals("*") && preferences.getString("pass","").equals("*")){
                    LogicaUsuario.isLogged = false;
                    Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(login);
                } else {
                    LogicaUsuario.isLogged = true;
                    logProd.getProductos();
                }
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(preferences.getBoolean("vol",true)){
                    sonido.start();
                }else{
                    sonido.stop();
                }
                Intent registro = new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(registro);
            }
        });

    }
}