package controller;

import logic.LogicaLogin;
import view.LoginAdmin;

public class CtrlLogin {

	LogicaLogin logLogin = new LogicaLogin();

	public boolean login() {
		boolean bExito = false;
		logLogin.lAdmin = logLogin.leerLogin();
		String sNombre = LoginAdmin.txtUser.getText();
		String sPass = new String(LoginAdmin.txtPass.getPassword());
		
		while(logLogin.iPos < logLogin.lAdmin.size() && !bExito) {
			if(sNombre.equals(logLogin.lAdmin.get(logLogin.iPos).getsNombre()) && sPass.equals(logLogin.lAdmin.get(logLogin.iPos).getsPass())) {
				bExito = true;
			}
			logLogin.iPos++;
		}
		
		return bExito;
	}

}
