package controller;

import android.util.Log;

import com.example.alltech_cliente.LoginActivity;

import logic.LogicaUsuario;

public class CtrlUsuario {

    private LogicaUsuario logUser = new LogicaUsuario();

    public void login(){
        logUser.getUsuario();
        compararCredenciales();
    }

    public void registro(){
        logUser.registroUser();
    }

    public boolean compararCredenciales(){
        boolean bExito = false;
        String sEmail = LoginActivity.txtEmail.getText().toString();
        String sPassword = LoginActivity.txtPassword.getText().toString();

        for(int i = 0; i < LogicaUsuario.lUsuario.size(); i++){
            if(sEmail.equals(LogicaUsuario.lUsuario.get(i).getEMAIL()) && sPassword.equals(LogicaUsuario.lUsuario.get(i).getPASSWORD())){
                bExito = true;
            }else{
                bExito = false;
            }
        }
        return bExito;
    }
}
