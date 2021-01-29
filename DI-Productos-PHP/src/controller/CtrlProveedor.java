package controller;

import java.util.List;

import logic.LogicaProveedor;
import model.Proveedor;
import view.FrmDetalleProd;

public class CtrlProveedor {
	
	@SuppressWarnings("unchecked")
	public static void llenarLista() {
		List<Proveedor> lProveedor = LogicaProveedor.leerProveedor();
		for(int i = 0; i < lProveedor.size(); i++) {
			FrmDetalleProd.cmbProveedor.addItem(lProveedor.get(i).getsNombre());
		}
	}
}
