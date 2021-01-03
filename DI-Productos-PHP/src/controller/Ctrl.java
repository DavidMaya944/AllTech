package controller;

import logic.Logica;
import model.Producto;
import view.FrmMain;

public class Ctrl {
	
	Logica log = new Logica();
	String FILE_NAME_OBJ = "files\\productos.data";

	public void abrir() {
		log.lProductos = log.leer();
		Producto p = log.lProductos.get(log.iPos);
		mostrar(p);
	}
	

	public void mostrar(Producto p) {
		FrmMain.txtCod.setText("" + p.getiCod());
		FrmMain.txtNombre.setText(p.getsNombre());
		if (p.getiOpcion() == 1) {
			FrmMain.rdbtnPack.setSelected(true);
		} else if (p.getiOpcion() == 2) {
			FrmMain.rdbtnUnidad.setSelected(true);
		} else if (p.getiOpcion() == 3) {
			FrmMain.rdbtnCombinado.setSelected(true);
		} else {
			System.out.println("Opcion invalida");
		}
		FrmMain.textComents.setText(p.getsComents());
		FrmMain.checkFragil.setSelected(p.isbFragil());
		FrmMain.checkObsoleto.setSelected(p.isbObsoleto());
		FrmMain.txtStockActual.setText("" + p.getiStockActual());
		FrmMain.txtStockMin.setText("" + p.getiStockMin());
		FrmMain.txtStockMax.setText("" + p.getiStockMax());
		FrmMain.cmbProveedor.setSelectedItem(p.getsProveedor());
		FrmMain.txtPVP.setText("" + p.getfPVP());
	}
	
	public void confirmarBorrar(FrmMain frame) {
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
