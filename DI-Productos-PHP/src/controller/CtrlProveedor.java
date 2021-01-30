package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import logic.LogicaProductos;
import logic.LogicaProveedor;
import model.Producto;
import model.Proveedor;
import view.FrmDetalleProd;
import view.FrmDetalleProveedor;

public class CtrlProveedor {
	public static int iId;
	public static void tableRowSelected() {
		new view.FrmDetalleProveedor();

	}
	
	@SuppressWarnings("unchecked")
	public static void llenarLista() {
		List<Proveedor> lProveedor = LogicaProveedor.leerProveedor();
		for(int i = 0; i < lProveedor.size(); i++) {
			FrmDetalleProd.cmbProveedor.addItem(lProveedor.get(i).getsNombre());
		}
	}
	
	public static void loadData() {
		try {
			List<Proveedor> resultado = LogicaProveedor.leerProveedor();
			DefaultTableModel modelo = LogicaProveedor.generarTablaProveedor(resultado);
			view.FrmGestionProveedor.tableProv.setModel(modelo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido cargar los datos", "Cargar datos", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void loadDataProv() {
		iId = Integer.parseInt(view.FrmGestionProveedor.tableProv.getValueAt(view.FrmGestionProveedor.tableProv.getSelectedRow(), 0).toString());
		try {
			Proveedor p = LogicaProveedor.leerProv(iId);
			FrmDetalleProveedor.txtIdProv.setText("" + p.getiId());
			FrmDetalleProveedor.txtNombre.setText(p.getsNombre());
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
			//JOptionPane.showMessageDialog(null, "No se ha podido cargar los datos", "Cargar datos", JOptionPane.ERROR_MESSAGE);
		}
	}
}
