package com.example.alltech_cliente;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class ActivityPreferencias extends AppCompatActivity {
    public static Context contextPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);
        getSupportFragmentManager().beginTransaction().replace(R.id.frmPreferencias, new PreferenciasFragment()).commit();

    }

    public static class PreferenciasFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.opciones, rootKey);
        }

    }
}