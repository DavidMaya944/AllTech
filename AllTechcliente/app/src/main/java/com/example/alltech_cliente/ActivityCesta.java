package com.example.alltech_cliente;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import logic.Adapter;
import logic.AdapterCesta;
import model.Producto;

public class ActivityCesta extends AppCompatActivity {
    public static RecyclerView rViewCesta;
    List<Producto> lCesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cesta);
        lCesta = Adapter.lCesta;
        rViewCesta = findViewById(R.id.rvCesta);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rViewCesta.setLayoutManager(llm);
        logic.AdapterCesta adapterCesta = new AdapterCesta(this);
        rViewCesta.setAdapter(adapterCesta);
        adapterCesta.refresh();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onPause();
    }
}