package controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import logic.LogicaProductos;
import model.Producto;
import view.FrmDetalleProd;

public class CtrlProducto {
	private static int iId;
	LogicaProductos log = new LogicaProductos();

	
	public static void tableRowSelected() {
		new view.FrmDetalleProd();

	}

	public static void loadData() {
		try {
			List<Producto> resultado = LogicaProductos.leer();
			DefaultTableModel modelo = LogicaProductos.generarTablaProducto(resultado);
			view.FrmGestionProductos.tblResult.setModel(modelo);
		} catch (Exception e) {
			System.err.println("Fallo: " + e.getMessage());
			e.getStackTrace();
		}
	}
	
	
	public static void loadDataProd() {
		iId = Integer.parseInt(view.FrmGestionProductos.tblResult.getValueAt(view.FrmGestionProductos.tblResult.getSelectedRow(), 0).toString());
		try {
			Producto p = LogicaProductos.leerProd(iId);
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
		}catch(Exception e) {
			System.err.println("Se ha producido un fallo: " + e.getMessage());
			e.getStackTrace();
		}
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



}
