package com.example.alltech_cliente;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
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

        String email = MainActivity.preferences.getString("email", "");
        String pass = MainActivity.preferences.getString("pass", "");
        txtUserEmail.setText(email);
        txtPass.setText(pass);
        final MediaPlayer sonido = MediaPlayer.create(this, R.raw.boton);


        btnSignIn.setOnClickListener(v -> {
            MainActivity.mutearSonido(sonido);
            SharedPreferences.Editor editorPreferences = MainActivity.preferences.edit();
            editorPreferences.putString("email", txtUserEmail.getText().toString());
            editorPreferences.putString("pass", txtPass.getText().toString());
            editorPreferences.apply();
            ctrlUser.login();
        });
    }


}
