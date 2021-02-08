package com.example.alltech_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;

import logic.LogicaProducto;
import logic.LogicaUsuario;

public class MainActivity extends AppCompatActivity {
    public static Context mainContext;
    public static SharedPreferences preferences;
    Button btnRegistro;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogicaProducto logProd = new LogicaProducto();
        mainContext = getApplicationContext();
        final MediaPlayer sonido = MediaPlayer.create(this, R.raw.boton);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);


        btnRegistro = findViewById(R.id.btnRegistro);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            MainActivity.mutearSonido(sonido);
            if(preferences.getString("email", "").equals("*") && preferences.getString("pass","").equals("*")){
                LogicaUsuario.isLogged = false;
                Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(login);
            } else {
                LogicaUsuario.isLogged = true;
                logProd.getProductos();
            }
        });

        btnRegistro.setOnClickListener(v -> {
            MainActivity.mutearSonido(sonido);
            Intent registro = new Intent(getApplicationContext(), RegistroActivity.class);
            startActivity(registro);
        });
    }
    public static void mutearSonido(MediaPlayer sonido) {
        if(MainActivity.preferences.getBoolean("vol",true)){
            sonido.start();
        }else{
            sonido.stop();
        }
    }
}