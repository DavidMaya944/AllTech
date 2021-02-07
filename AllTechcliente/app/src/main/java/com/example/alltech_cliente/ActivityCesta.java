package com.example.alltech_cliente;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import logic.AdapterCesta;

public class ActivityCesta extends AppCompatActivity {

    public static RecyclerView rView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cesta);
        rView = findViewById(R.id.listaProdPrincipal);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rView.setLayoutManager(llm);
        logic.AdapterCesta adapterCesta = new AdapterCesta(this);
        rView.setAdapter(adapterCesta);
        adapterCesta.refresh();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onPause();
    }
}