package controller;

import logic.LogicaUsuario;

public class CtrlUsuario {

    private LogicaUsuario logUser = new LogicaUsuario();

    public void login(){
        logUser.getUsuario();
    }

    public void registro(){
        logUser.registroUser();
    }

    public void delete_user(){
        logUser.deleteUser();
    }

    public void update_user(){
        logUser.updateUsuario();
    }

}
