package com.example.alltech_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import logic.Adapter;
import logic.LogicaProducto;

public class Prod_detalle_activity extends AppCompatActivity {
    public static EditText txtNombreDetalle;
    public static EditText txtPrecioDetalle;
    public static TextView txtDescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prod_detalle_activity);
        txtDescrip = findViewById(R.id.txtDescripcionDetalle);
        txtNombreDetalle = findViewById(R.id.txtNombreDetalle);
        txtPrecioDetalle = findViewById(R.id.txtPrecioDetalle);

        Prod_detalle_activity.txtNombreDetalle.setText(LogicaProducto.lProducto.get(Adapter.iPos).getNOMBRE());
        Prod_detalle_activity.txtPrecioDetalle.setText(LogicaProducto.lProducto.get(Adapter.iPos).getPVP() + " €");
        Prod_detalle_activity.txtDescrip.setText(LogicaProducto.lProducto.get(Adapter.iPos).getCOMENTARIOS());
    }
}