package controller;

import logic.LogicaProd;
import model.Producto;
import view.FrmDetalleProd;

public class CtrlProductos {

	LogicaProd logProd = new LogicaProd();
	
	public void llenarLista() {
		logProd.llenarLista();
	}
	
	public void mostrar(Producto p) {
		FrmDetalleProd.txtNombre.setText(p.getsNombre());
		FrmDetalleProd.txtDescrip.setText(p.getsComents());
		FrmDetalleProd.txtPVP.setText(p.getfPVP() + " €");
		
		if(p.getiStockActual() == 0) {
			FrmDetalleProd.txtStock.setText("AGOTADO");
		}else if(p.getiStockActual() > 0 && p.getiStockActual() <= 5){
			FrmDetalleProd.txtStock.setText("QUEDAN POCAS UNIDADES");
		}else {
			FrmDetalleProd.txtStock.setText("EN STOCK");
		}
		
	}
}
