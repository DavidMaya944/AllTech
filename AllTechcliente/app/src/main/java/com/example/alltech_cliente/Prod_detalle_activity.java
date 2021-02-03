package com.example.alltech_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import logic.LogicaProducto;
import model.Producto;

public class Prod_detalle_activity extends AppCompatActivity {
    public static EditText txtNombreDetalle;
    public static EditText txtPrecioDetalle;
    public static TextView txtDescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prod_detalle_activity);
        txtNombreDetalle = findViewById(R.id.txtNombreDetalle);
        txtPrecioDetalle = findViewById(R.id.txtPrecioDetalle);
        txtDescrip = findViewById(R.id.txtDescripcionDetalle);


        for(Producto p : LogicaProducto.lProducto){
            txtNombreDetalle.setText(p.getNOMBRE());
            txtPrecioDetalle.setText(p.getPVP() + " €");
            txtDescrip.setText(p.getCOMENTARIOS());
        }
    }
}