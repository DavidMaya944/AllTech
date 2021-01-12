package controller;

import logic.LogicaGeneral;
import logic.LogicaLogin;
import view.ErrorLogin;
import view.FrmTienda;
import view.LoginUser;

public class CtrlLogin {
	private LogicaLogin logLogin = new LogicaLogin();
	
	public void login() {
		boolean bExito = false;
		LogicaGeneral.lUsuario = logLogin.leerLogin();
		String sEmail = LoginUser.txtEmail.getText();
		String sPass = new String(LoginUser.txtPass.getPassword());
		
		while(LogicaGeneral.iPos < LogicaGeneral.lUsuario.size() && !bExito) {
			if(sEmail.equals(LogicaGeneral.lUsuario.get(LogicaGeneral.iPos).getsEmail()) && sPass.equals(LogicaGeneral.lUsuario.get(LogicaGeneral.iPos).getsContrasenia())) {
				bExito = true;
			}
			
			LogicaGeneral.iPos++;
		}
		if(bExito) {
			new FrmTienda();
		}else {
			new ErrorLogin();
		}
	}
	
}
