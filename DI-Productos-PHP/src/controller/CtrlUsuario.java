package controller;

import logic.LogicaUsuarios;
import model.Usuario;
import view.FrmGestionUsuario;

public class CtrlUsuario {

	LogicaUsuarios logUser = new LogicaUsuarios();

	public void abrir() {
		logUser.lUsuarios = logUser.leer();
		Usuario u = logUser.lUsuarios.get(logUser.iPos);
		mostrar(u);
	}

	public void mostrar(Usuario u) {
		FrmGestionUsuario.txtID.setText("" + u.getiId());
		FrmGestionUsuario.txtNombre.setText(u.getsNombre());
		FrmGestionUsuario.txtApellidos.setText(u.getsApellidos());
		FrmGestionUsuario.txtEmail.setText(u.getsEmail());
		FrmGestionUsuario.txtDireccion.setText(u.getsDireccion());
		FrmGestionUsuario.txtUser.setText(u.getsUsuario());
		FrmGestionUsuario.txtPass.setText(u.getsContrasenia());
		FrmGestionUsuario.txtTelefono.setText(u.getsTelefono());
		FrmGestionUsuario.txtPermiso.setText(u.getsPermiso());

	}

	public void confirmarUsuario() {
		logUser.confirmarUsuario();
	}

}
