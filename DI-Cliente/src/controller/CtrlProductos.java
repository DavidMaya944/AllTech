package controller;

import logic.LogicaProd;
import model.Producto;
import view.FrmDetalleProd;
import view.TarjetaProducto;

public class CtrlProductos {
	private static int iId;
	LogicaProd logProd = new LogicaProd();
	
	public void llenarLista() {
		logProd.llenarLista();
	}
	
	public void mostrarDetalle() {
		Producto p = logProd.leer(iId);
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
		TarjetaProducto.txtCod.setText(p.getiCod() + "");
		TarjetaProducto.txtNombre.setText(p.getsNombre());
		TarjetaProducto.textDescrip.setText(p.getsComents());
		TarjetaProducto.txtPVP.setText(p.getfPVP() + " €");
		
	}

	
	public static void loadDataProd() {
			try {
			Producto p = LogicaProd.leer(iId);
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
		}catch(Exception e) {
			System.err.println("Se ha producido un fallo: " + e.getMessage());
			e.getStackTrace();
		}
	}
}
