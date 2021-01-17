package controller;

import logic.LogicaProductos;
import model.Producto;
import view.FrmDetalleProd;

public class CtrlProducto {
	
	LogicaProductos log = new LogicaProductos();
	String FILE_NAME_OBJ = "files\\productos.data";

	public void abrir() {
		log.lProductos = log.leer();
		Producto p = log.lProductos.get(log.iPos);
		mostrar(p);
	}
	

	public void mostrar(Producto p) {
		FrmDetalleProd.txtCod.setText("" + p.getiCod());
		FrmDetalleProd.txtNombre.setText(p.getsNombre());
		if (p.getiOpcion() == 1) {
			FrmDetalleProd.rdbtnPack.setSelected(true);
		} else if (p.getiOpcion() == 2) {
			FrmDetalleProd.rdbtnUnidad.setSelected(true);
		} else if (p.getiOpcion() == 3) {
			FrmDetalleProd.rdbtnCombinado.setSelected(true);
		} else {
			System.out.println("Opcion invalida");
		}
		FrmDetalleProd.textComents.setText(p.getsComents());
		FrmDetalleProd.checkFragil.setSelected(p.isbFragil());
		FrmDetalleProd.checkObsoleto.setSelected(p.isbObsoleto());
		FrmDetalleProd.txtStockActual.setText("" + p.getiStockActual());
		FrmDetalleProd.txtStockMin.setText("" + p.getiStockMin());
		FrmDetalleProd.txtStockMax.setText("" + p.getiStockMax());
		FrmDetalleProd.cmbProveedor.setSelectedItem(p.getsProveedor());
		FrmDetalleProd.txtPVP.setText("" + p.getfPVP());
	}
	
	public void confirmarBorrar(FrmDetalleProd frame) {
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
