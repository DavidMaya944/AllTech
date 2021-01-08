package controller;

import logic.LogicaUsuarios;
import model.Usuario;
import view.FrmGestionUsuario;
import view.FrmHistorialUsuarios;

public class CtrlUsuario {

	LogicaUsuarios logUser = new LogicaUsuarios();

	public void abrirUserEspera() {
		try {
			logUser.lUsuarios = logUser.leerEnEspera();
			Usuario u = logUser.lUsuarios.get(logUser.iPos);
			mostrarEspera(u);
		}catch(Exception e) {
			FrmGestionUsuario.txtID.setText("");
			FrmGestionUsuario.txtNombre.setText("");
			FrmGestionUsuario.txtApellidos.setText("");
			FrmGestionUsuario.txtEmail.setText("");
			FrmGestionUsuario.txtDireccion.setText("");
			FrmGestionUsuario.txtUser.setText("");
			FrmGestionUsuario.txtPass.setText("");
			FrmGestionUsuario.txtTelefono.setText("");
			FrmGestionUsuario.txtPermiso.setText("");
		}
		
	}
	
	public void abrirUserAcept() {
		try {
			logUser.lUsuariosA = logUser.leerAcept();
			Usuario u = logUser.lUsuariosA.get(logUser.iPos);
			mostrar(u);
		}catch(Exception e) {
			FrmHistorialUsuarios.txtID.setText("");
			FrmHistorialUsuarios.txtNombre.setText("");
			FrmHistorialUsuarios.txtApellidos.setText("");
			FrmHistorialUsuarios.txtEmail.setText("");
			FrmHistorialUsuarios.txtDireccion.setText("");
			FrmHistorialUsuarios.txtUser.setText("");
			FrmHistorialUsuarios.txtPass.setText("");
			FrmHistorialUsuarios.txtTelefono.setText("");
			FrmHistorialUsuarios.txtPermiso.setText("");
		}
		
	}
	
	public void abrirUserBlock() {
		try {
			logUser.lUsuariosB = logUser.leerBlock();
			Usuario u = logUser.lUsuariosB.get(logUser.iPos);
			mostrar(u);
		}catch(Exception e) {
			FrmHistorialUsuarios.txtID.setText("");
			FrmHistorialUsuarios.txtNombre.setText("");
			FrmHistorialUsuarios.txtApellidos.setText("");
			FrmHistorialUsuarios.txtEmail.setText("");
			FrmHistorialUsuarios.txtDireccion.setText("");
			FrmHistorialUsuarios.txtUser.setText("");
			FrmHistorialUsuarios.txtPass.setText("");
			FrmHistorialUsuarios.txtTelefono.setText("");
			FrmHistorialUsuarios.txtPermiso.setText("");
		}
		
	}
	
	public void abrirUsers() {
		try {
			logUser.lUsuariosT = logUser.leerBlock();
			Usuario u = logUser.lUsuariosT.get(logUser.iPos);
			mostrar(u);
		}catch(Exception e) {
			FrmHistorialUsuarios.txtID.setText("");
			FrmHistorialUsuarios.txtNombre.setText("");
			FrmHistorialUsuarios.txtApellidos.setText("");
			FrmHistorialUsuarios.txtEmail.setText("");
			FrmHistorialUsuarios.txtDireccion.setText("");
			FrmHistorialUsuarios.txtUser.setText("");
			FrmHistorialUsuarios.txtPass.setText("");
			FrmHistorialUsuarios.txtTelefono.setText("");
			FrmHistorialUsuarios.txtPermiso.setText("");
		}
		
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
	
	public void desbloquearUsuario() {
		logUser.desbloquearUsuario();
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
