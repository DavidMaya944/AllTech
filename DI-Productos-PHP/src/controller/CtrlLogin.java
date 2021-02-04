package controller;

import javax.swing.JOptionPane;

import logic.LogicaLogin;
import logic.LogicaUsuarios;
import view.FrmMenuPrincipal;
import view.LoginAdmin;

public class CtrlLogin {

	LogicaLogin logLogin = new LogicaLogin();

	public void login() {
		boolean bExito = false;
		LogicaUsuarios.lUsuariosB = LogicaLogin.leerLogin();
		String sNombre = LoginAdmin.txtUser.getText();
		String sPass = new String(LoginAdmin.txtPass.getPassword());
		
		while(LogicaUsuarios.iPos < LogicaUsuarios.lUsuariosB.size() && !bExito) {
			if(sNombre.equals(LogicaUsuarios.lUsuariosB.get(LogicaUsuarios.iPos).getsUsuario()) && sPass.equals(LogicaUsuarios.lUsuariosB.get(LogicaUsuarios.iPos).getsContrasenia())
					&& "ACEPTADO".equals(LogicaUsuarios.lUsuariosB.get(LogicaUsuarios.iPos).getsPermiso()) && 1 == LogicaUsuarios.lUsuariosB.get(LogicaUsuarios.iPos).getiRol()) {
				bExito = true;
			}
			LogicaUsuarios.iPos++;
		}
		
		if(bExito) {
			new FrmMenuPrincipal();
		}else {
			JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Inicio de sesión", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
