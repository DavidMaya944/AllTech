package com.example.alltech_cliente;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import logic.Adapter;
import logic.LogicaUsuario;

public class Tienda_activity extends AppCompatActivity {
    LogicaUsuario logUser = new LogicaUsuario();
    public static Context contextTienda;
    public static RecyclerView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tienda_activity);
        contextTienda = getApplicationContext();
        rView = findViewById(R.id.listaProdPrincipal);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rView.setLayoutManager(llm);
        logic.Adapter adapter = new Adapter(this);
        rView.setAdapter(adapter);
        adapter.refresh();
        onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final MediaPlayer sonido = MediaPlayer.create(this, R.raw.boton);

        if(preferences.getBoolean("vol",true)){
            sonido.start();
        }else{
            sonido.stop();
        }
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuBuilder mb = (MenuBuilder) menu;
        mb.setGroupDividerEnabled(true);
        mb.setOptionalIconsVisible(true);
        mb.findItem(R.id.itemAjustes).setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemPreferencias:
                Intent pref = new Intent(this, ActivityPreferencias.class);
                startActivity(pref);
                break;
            case R.id.itemAjustes:
                logUser.getUserEmail();
                break;
            case R.id.itemCerrarSesion:
                Intent logOut = new Intent(this, LoginActivity.class);
                startActivity(logOut);
                break;

        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        rView = findViewById(R.id.listaProdPrincipal);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rView.setLayoutManager(llm);
        logic.Adapter adapter = new Adapter(this);
        rView.setAdapter(adapter);
        adapter.refresh();
    }
}