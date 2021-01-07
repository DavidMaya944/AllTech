package controller;

import logic.LogicaLogin;
import model.Admin;
import view.loginAdmin;

public class CtrlLogin {

	LogicaLogin logLogin = new LogicaLogin();
	
	public boolean login() {
		logLogin.lAdmin = logLogin.leerLogin();
		Admin a = logLogin.lAdmin.get(logLogin.iPos);
		
		boolean bExito = false;
		String sNombre = loginAdmin.txtUser.getText();
		String sPass = new String(loginAdmin.txtPass.getPassword());
		if(sNombre == a.getsNombre() && sPass == a.getsPass()){
			bExito = true;
		}
		
		return bExito;
	}
	
	
	

}
