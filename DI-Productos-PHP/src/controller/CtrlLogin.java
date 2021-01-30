package controller;

import javax.swing.JOptionPane;

import logic.LogicaLogin;
import view.FrmMenuPrincipal;
import view.LoginAdmin;

public class CtrlLogin {

	LogicaLogin logLogin = new LogicaLogin();

	public void login() {
		boolean bExito = false;
		LogicaLogin.lAdmin = logLogin.leerLogin();
		String sNombre = LoginAdmin.txtUser.getText();
		String sPass = new String(LoginAdmin.txtPass.getPassword());
		
		while(LogicaLogin.iPos < LogicaLogin.lAdmin.size() && !bExito) {
			if(sNombre.equals(LogicaLogin.lAdmin.get(LogicaLogin.iPos).getsNombre()) && sPass.equals(LogicaLogin.lAdmin.get(LogicaLogin.iPos).getsPass())) {
				bExito = true;
			}
			LogicaLogin.iPos++;
		}
		
		if(bExito) {
			new FrmMenuPrincipal();
		}else {
			JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Inicio de sesión", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
