package com.example.alltech_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import logic.Adapter;
import logic.LogicaProducto;
import model.Producto;

public class Prod_detalle_activity extends AppCompatActivity {
    private LogicaProducto logProd = new LogicaProducto();
    public static EditText txtNombreDetalle;
    public static EditText txtPrecioDetalle;
    public static TextView txtDescrip;
    public static ImageView imgProdDet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prod_detalle_activity);
        txtNombreDetalle = findViewById(R.id.txtNombreDetalle);
        txtPrecioDetalle = findViewById(R.id.txtPrecioDetalle);
        txtDescrip = findViewById(R.id.txtDescripcionDetalle);
        imgProdDet = findViewById(R.id.imgProdDet);


        for(Producto p : LogicaProducto.lProducto){
            Glide
                    .with(getApplicationContext())
                    .load(Adapter.DOMINIO + "/imgProd/" + p.getCODIGO() + ".jpg")
                    .into(imgProdDet);
            txtNombreDetalle.setText(p.getNOMBRE());
            txtPrecioDetalle.setText(p.getPVP() + " €");
            txtDescrip.setText(p.getCOMENTARIOS());
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        logProd.getProductosBack();
    }
}