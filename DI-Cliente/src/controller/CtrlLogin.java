package controller;

import logic.LogicaLogin;
import view.LoginUser;

public class CtrlLogin {
	LogicaLogin logLogin = new LogicaLogin();

	public boolean login() {
		boolean bExito = false;
		logLogin.lUsuario = logLogin.leerLogin();
		String sUsuario = LoginUser.txtUser.getText();
		String sPass = new String(LoginUser.txtPass.getPassword());
		
		while(logLogin.iPos < logLogin.lUsuario.size() && !bExito) {
			if(sUsuario.equals(logLogin.lUsuario.get(logLogin.iPos).getsUsuario()) && sPass.equals(logLogin.lUsuario.get(logLogin.iPos).getsContrasenia())) {
				bExito = true;
			}
			logLogin.iPos++;
		}
		
		return bExito;
	}
}
