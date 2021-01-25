package com.example.alltech_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Prod_detalle_activity extends AppCompatActivity {

    Button btnAdd;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prod_detalle_activity);

        btnAdd = findViewById(R.id.btnAdd);
        btnVolver = findViewById(R.id.btnVolver);


    }
}