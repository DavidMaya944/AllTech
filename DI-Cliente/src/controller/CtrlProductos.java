package controller;

import logic.LogicaProd;

public class CtrlProductos {

	LogicaProd logProd = new LogicaProd();
	
	public void llenarLista() {
		logProd.llenarLista();
	}
}
