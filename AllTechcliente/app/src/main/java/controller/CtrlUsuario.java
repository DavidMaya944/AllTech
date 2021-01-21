package controller;

import logic.LogicaUsuario;

public class CtrlUsuario {

    private LogicaUsuario logUser = new LogicaUsuario();

    public void login(){
        logUser.getUsuario();

    }
}
