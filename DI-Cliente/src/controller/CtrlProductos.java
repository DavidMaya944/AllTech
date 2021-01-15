package controller;

import logic.LogicaProd;
import model.Producto;
import view.FrmDetalleProd;
import view.TarjetaProducto;

public class CtrlProductos {

	LogicaProd logProd = new LogicaProd();
	
	public void llenarLista() {
		logProd.llenarLista();
	}
	
	public void mostrarDetalle() {
		Producto p = logProd.leer(TarjetaProducto.txtNombre);
		mostrar(p);
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

	public void cargarDatos(Producto p) {
		TarjetaProducto.txtNombre.setText(p.getsNombre());
		TarjetaProducto.textDescrip.setText(p.getsComents());
		TarjetaProducto.txtPVP.setText(p.getfPVP() + " €");
		
	}

	public void click_ver() {
		Producto p = logProd.leer(TarjetaProducto.txtNombre);
		new FrmDetalleProd(p);
		
		
		
	}
}
