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


}
