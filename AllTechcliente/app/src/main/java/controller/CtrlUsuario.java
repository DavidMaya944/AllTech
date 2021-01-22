package controller;

import android.content.Intent;
import android.util.Log;

import com.example.alltech_cliente.LoginActivity;
import com.example.alltech_cliente.Tienda_activity;

import logic.LogicaUsuario;

public class CtrlUsuario {

    private LogicaUsuario logUser = new LogicaUsuario();

    public void login(){
        logUser.getUsuario();
    }

    public void registro(){
        logUser.registroUser();
    }

   /* public boolean compararCredenciales(){
        boolean bExito = false;
        String sEmail = LoginActivity.txtUserEmail.getText().toString();
        Log.i("MAYA", "Email por teclado = " + sEmail);
        String sPassword = LoginActivity.txtPass.getText().toString();
        Log.i("MAYA", "Password por tecladdo = " + sPassword);

        for(int i = 0; i < LogicaUsuario.lUsuario.size(); i++){
            if(sEmail.equals(LogicaUsuario.lUsuario.get(i).getEMAIL()) && sPassword.equals(LogicaUsuario.lUsuario.get(i).getPASSWORD())
            && "ACEPTADO".equals(LogicaUsuario.lUsuario.get(i).getPERMISO())){
                Log.i("MAYA", "Email BD: " + LogicaUsuario.lUsuario.get(i).getEMAIL());
                Log.i("MAYA","Password BD: " + LogicaUsuario.lUsuario.get(i).getPASSWORD());
                Log.i("MAYA", "Permiso: " + LogicaUsuario.lUsuario.get(i).getPERMISO());
                bExito = true;
            }else{
                bExito = false;
            }
        }

        Log.i("MAYA", "bExito = " + bExito);
        return bExito;
    }*/
}
