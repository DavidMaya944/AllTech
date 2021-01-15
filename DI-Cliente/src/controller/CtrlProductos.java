package controller;

import javax.swing.JTextField;

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
		FrmDetalleProd.txtPVP.setText(p.getfPVP() + " �");
		
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
		TarjetaProducto.txtPVP.setText(p.getfPVP() + " �");
		
	}

//	public void click_ver(JTextField txtNombre) {
//		Producto p = logProd.leer(txtNombre);
//		new FrmDetalleProd(p);
//	}
	
	public void click_ver() {
		int numero = 0;
		Producto p = null;
		for(int i = 0; i < logProd.lTarjeta.size(); i++) {
			numero = Integer.parseInt(logProd.lTarjeta.get(i).txtNumeracion.getText());
		}
		
		for(numero = 0; numero < logProd.lProductos.size(); numero++) {
			p = logProd.lProductos.get(numero);
		}
		new FrmDetalleProd(p);
		
	}
}
