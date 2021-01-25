package com.example.alltech_cliente;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import controller.CtrlUsuario;

public class LoginActivity extends AppCompatActivity {
    public static EditText txtUserEmail;
    public static EditText txtPass;
    public static Context context;
    Button btnSignIn;
    private CtrlUsuario ctrlUser = new CtrlUsuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        context = getApplicationContext();
        txtUserEmail = findViewById(R.id.txtUserEmail);
        txtPass = findViewById(R.id.txtPass);
        btnSignIn = findViewById(R.id.btnSignIn);


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctrlUser.login();
            }
        });
    }





}
