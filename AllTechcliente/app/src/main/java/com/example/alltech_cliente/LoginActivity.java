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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        context = getApplicationContext();
        txtUserEmail = findViewById(R.id.txtUserEmail);
        txtPass = findViewById(R.id.txtPass);
        btnSignIn = findViewById(R.id.btnSignIn);


        // Acceso a las preferencias
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Leer de las preferencias
        String email = preferences.getString("@string/key_email_pref", "@string/value_email_pref");
        String pass = preferences.getString("@string/key_pass_pref", "@string/value_pass_pref");
        txtUserEmail.setText(email);
        txtPass.setText(pass);
        final MediaPlayer sonido = MediaPlayer.create(this, R.raw.boton);

        btnSignIn.setOnClickListener(v -> {
            sonido.start();

            SharedPreferences.Editor editorPreferences = preferences.edit();
            editorPreferences.putString("@string/key_email_pref", txtUserEmail.getText().toString());
            editorPreferences.putString("@string/key_pass_pref", txtPass.getText().toString());
            editorPreferences.apply();
            ctrlUser.login();
        });
    }
}
