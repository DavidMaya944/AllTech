package controller;

import logic.Logica;

public class Control {
	Logica logic = new Logica();
	
	public void guardarUsuario() {
		logic.guardar();
	}
}
