package controller;

import logic.LogicaUsuarios;
import model.Usuario;
import view.FrmGestionUsuario;
import view.FrmHistorialUsuarios;

public class CtrlUsuario {

	LogicaUsuarios logUser = new LogicaUsuarios();

	public void abrirUserEspera() {
		logUser.lUsuarios = logUser.leerEnEspera();
		Usuario u = logUser.lUsuarios.get(logUser.iPos);
		mostrarEspera(u);
	}
	
	public void abrirUserAcept() {
		logUser.lUsuariosA = logUser.leerAcept();
		Usuario u = logUser.lUsuariosA.get(logUser.iPos);
		mostrar(u);
	}
	
	public void abrirUserBlock() {
		logUser.lUsuariosB = logUser.leerBlock();
		Usuario u = logUser.lUsuariosB.get(logUser.iPos);
		mostrar(u);
	}
	
	public void abrirUsers() {
		logUser.lUsuariosT = logUser.leerBlock();
		Usuario u = logUser.lUsuariosT.get(logUser.iPos);
		mostrar(u);
	}

	public void mostrarEspera(Usuario u) {
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
	
	public void mostrar(Usuario u) {
		FrmHistorialUsuarios.txtID.setText("" + u.getiId());
		FrmHistorialUsuarios.txtNombre.setText(u.getsNombre());
		FrmHistorialUsuarios.txtApellidos.setText(u.getsApellidos());
		FrmHistorialUsuarios.txtEmail.setText(u.getsEmail());
		FrmHistorialUsuarios.txtDireccion.setText(u.getsDireccion());
		FrmHistorialUsuarios.txtUser.setText(u.getsUsuario());
		FrmHistorialUsuarios.txtPass.setText(u.getsContrasenia());
		FrmHistorialUsuarios.txtTelefono.setText(u.getsTelefono());
		FrmHistorialUsuarios.txtPermiso.setText(u.getsPermiso());
	}

	public void confirmarUsuario() {
		logUser.confirmarUsuario();
	}
	
	public void bloquearUsuario() {
		logUser.blouqearUsuario();
	}
	
	public void inicioListaAcept() {
		Usuario u = logUser.inicioListaA();
		if(u != null) {
			mostrar(u);
		}
	}
	
	public void finListaAcept() {
		Usuario u = logUser.finListaA();
		if(u != null) {
			mostrar(u);
		}
	}

	
	public void anteriorAcept() {
		Usuario u = logUser.anteriorA();
		if(u != null) {
			mostrar(u);
		}
	}
	
	public void siguienteAcept() {
		Usuario u = logUser.siguienteA();
		if(u != null) {
			mostrar(u);
		}
	}
	
	public void inicioListaEspera() {
		Usuario u = logUser.inicioLista();
		if(u != null) {
			mostrarEspera(u);
		}
	}
	
	public void finListaEspera() {
		Usuario u = logUser.finLista();
		if(u != null) {
			mostrarEspera(u);
		}
	}
	
	public void anteriorEspera() {
		Usuario u = logUser.anterior();
		if(u != null) {
			mostrarEspera(u);
		}
	}
	
	public void siguienteEspera() {
		Usuario u = logUser.siguiente();
		if(u != null) {
			mostrarEspera(u);
		}
	}
	
	public void rechazarUsuario() {
		logUser.rechazarUsuario();
	}
	
	

}
