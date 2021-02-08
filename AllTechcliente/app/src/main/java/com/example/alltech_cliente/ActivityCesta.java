package com.example.alltech_cliente;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import controller.CtrlProducto;
import logic.Adapter;
import logic.AdapterCesta;
import model.Producto;

public class ActivityCesta extends AppCompatActivity {
    public static RecyclerView rViewCesta;
    List<Producto> lCesta;
    Button btnComprar;
    CtrlProducto ctrlProd = new CtrlProducto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cesta);
        btnComprar = findViewById(R.id.btnComprar);
        lCesta = Adapter.lCesta;
        rViewCesta = findViewById(R.id.rvCesta);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rViewCesta.setLayoutManager(llm);
        logic.AdapterCesta adapterCesta = new AdapterCesta(this);
        rViewCesta.setAdapter(adapterCesta);
        adapterCesta.refresh();

        final MediaPlayer sonido = MediaPlayer.create(this, R.raw.boton);

        MainActivity.preferences = PreferenceManager.getDefaultSharedPreferences(this);

        btnComprar.setOnClickListener(v -> {
            MainActivity.mutearSonido(sonido);
            ctrlProd.insert_compra();
            Toast.makeText(this, "La compra se ha realizado con exito", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onPause();
    }
}