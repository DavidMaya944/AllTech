package com.example.alltech_cliente;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import controller.CtrlUsuario;

public class LoginActivity extends AppCompatActivity {
    public static EditText txtUserEmail;
    public static EditText txtPass;
    public static Context context;
    Button btnSignIn;
    private CtrlUsuario ctrlUser = new CtrlUsuario();
    public static SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        context = getApplicationContext();
        txtUserEmail = findViewById(R.id.txtUserEmail);
        txtPass = findViewById(R.id.txtPass);
        btnSignIn = findViewById(R.id.btnSignIn);


        // Acceso a las preferencias
        preferences = PreferenceManager.getDefaultSharedPreferences(context);

        // Leer de las preferencias
        String email = preferences.getString("email", "");
        String pass = preferences.getString("pass", "");
        txtUserEmail.setText(email);
        txtPass.setText(pass);
        final MediaPlayer sonido = MediaPlayer.create(this, R.raw.boton);


        btnSignIn.setOnClickListener(v -> {
            if(preferences.getBoolean("vol",true)){
                sonido.start();
            }else{
                sonido.stop();
            }
            SharedPreferences.Editor editorPreferences = preferences.edit();
            editorPreferences.putString("email", txtUserEmail.getText().toString());
            editorPreferences.putString("pass", txtPass.getText().toString());
            editorPreferences.apply();
            ctrlUser.login();
        });
    }
}
