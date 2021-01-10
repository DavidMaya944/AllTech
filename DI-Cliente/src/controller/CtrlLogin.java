package controller;

import logic.LogicaGeneral;
import logic.LogicaLogin;
import view.LoginUser;

public class CtrlLogin {
	LogicaLogin logLogin = new LogicaLogin();
	public boolean login() {
		boolean bExito = false;
		LogicaGeneral.lUsuario = logLogin.leerLogin();
		String sUsuario = LoginUser.txtUser.getText();
		String sPass = new String(LoginUser.txtPass.getPassword());
		
		while(LogicaGeneral.iPos < LogicaGeneral.lUsuario.size() && !bExito) {
			if(sUsuario.equals(LogicaGeneral.lUsuario.get(LogicaGeneral.iPos).getsUsuario()) && sPass.equals(LogicaGeneral.lUsuario.get(LogicaGeneral.iPos).getsContrasenia())) {
				bExito = true;
			}
			LogicaGeneral.iPos++;
		}
		
		return bExito;
	}
}
