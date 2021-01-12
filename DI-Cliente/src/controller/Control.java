package controller;

import logic.LogicaUsuario;

public class Control {
	LogicaUsuario logic = new LogicaUsuario();
	
	public void guardarUsuario() {
		logic.guardar();
	}
	
	public void actualizarUsuario() {
		logic.actualizar();
	}
}
