package com.example.alltech_cliente;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import controller.CtrlUsuario;

public class LoginActivity extends AppCompatActivity {
    public static EditText txtEmail;
    public static EditText txtPassword;
    Button btnSignIn;
    private CtrlUsuario ctrlUser = new CtrlUsuario();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctrlUser.login();
               // Intent appIn = new Intent(getApplicationContext(), Tienda.class);
               // startActivity(appIn);
            }
        });
    }





}
