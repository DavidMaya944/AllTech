package controller;

import logic.LogicaProductos;
import model.Producto;
import view.FrmGestionProductos;

public class CtrlProducto {
	
	LogicaProductos log = new LogicaProductos();
	String FILE_NAME_OBJ = "files\\productos.data";

	public void abrir() {
		log.lProductos = log.leer();
		Producto p = log.lProductos.get(log.iPos);
		mostrar(p);
	}
	

	public void mostrar(Producto p) {
		FrmGestionProductos.txtCod.setText("" + p.getiCod());
		FrmGestionProductos.txtNombre.setText(p.getsNombre());
		if (p.getiOpcion() == 1) {
			FrmGestionProductos.rdbtnPack.setSelected(true);
		} else if (p.getiOpcion() == 2) {
			FrmGestionProductos.rdbtnUnidad.setSelected(true);
		} else if (p.getiOpcion() == 3) {
			FrmGestionProductos.rdbtnCombinado.setSelected(true);
		} else {
			System.out.println("Opcion invalida");
		}
		FrmGestionProductos.textComents.setText(p.getsComents());
		FrmGestionProductos.checkFragil.setSelected(p.isbFragil());
		FrmGestionProductos.checkObsoleto.setSelected(p.isbObsoleto());
		FrmGestionProductos.txtStockActual.setText("" + p.getiStockActual());
		FrmGestionProductos.txtStockMin.setText("" + p.getiStockMin());
		FrmGestionProductos.txtStockMax.setText("" + p.getiStockMax());
		FrmGestionProductos.cmbProveedor.setSelectedItem(p.getsProveedor());
		FrmGestionProductos.txtPVP.setText("" + p.getfPVP());
	}
	
	public void confirmarBorrar(FrmGestionProductos frame) {
		log.confirmarBorrar(frame);
	}
	
	public void guardarProducto() {
		log.guardarProducto();
	}
	
	public void finLista() {
		Producto p = log.finLista();
		if(p != null)
			mostrar(p);
	}
	
	public void siguiente() {
		Producto p = log.siguiente();
		if(p != null) {
			mostrar(p);
		}
	}
	
	public void anterior() {
		Producto p = log.anterior();
		if(p != null) {
			mostrar(p);
		}
	}
	
	public void inicioLista() {
		Producto p = log.inicioLista();
		if(p != null) {
			mostrar(p);
		}
	}


}
