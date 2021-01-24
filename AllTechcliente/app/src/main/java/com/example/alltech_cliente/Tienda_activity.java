package com.example.alltech_cliente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import controller.CtrlProducto;
import logic.Adapter;

public class Tienda_activity extends AppCompatActivity {

    private CtrlProducto ctrlProd = new CtrlProducto();
    public static Context contextTienda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tienda_activity);
        ctrlProd.getProductos();
        onResume();
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuBuilder mb = (MenuBuilder) menu;
        mb.setGroupDividerEnabled(true);
        mb.setOptionalIconsVisible(true);
        mb.findItem(R.id.itemAjustes).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String sMensaje = "";

        switch (item.getItemId()){
            case R.id.itemAjustes:
                sMensaje = "Ajustes";
                break;
            case R.id.itemCerrarSesion:
                sMensaje = "Cerrar Sesion";
                break;
            case R.id.itemCesta:
                sMensaje = "Opción tres";
                break;

        }

        Toast.makeText(this, sMensaje, Toast.LENGTH_SHORT).show();

        return true;
    }

    protected void onResume(){
        super.onResume();
        ctrlProd.getProductos();
        RecyclerView rView = findViewById(R.id.listaProdPrincipal);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rView.setLayoutManager(llm);
        logic.Adapter adapter = new Adapter(this);
        rView.setAdapter(adapter);
        adapter.refresh();
    }
}