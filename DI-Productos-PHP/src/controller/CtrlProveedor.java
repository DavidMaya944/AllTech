package controller;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import logic.LogicaProveedor;
import model.Proveedor;
import view.FrmDetalleProd;
import view.FrmDetalleProveedor;

public class CtrlProveedor {
	
	public static void guardarProveedor() {
		LogicaProveedor.guardarProveedor();
	}
	
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
		String sNombre = view.FrmGestionProveedor.tableProv.getValueAt(view.FrmGestionProveedor.tableProv.getSelectedRow(), 0).toString();
		try {
			Proveedor p = LogicaProveedor.leerProv(sNombre);
			FrmDetalleProveedor.txtNombre.setText(p.getsNombre());
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido cargar los datos", "Cargar datos", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void confirmarBorrar(JDialog frame) {
		LogicaProveedor.borrarProveedor(frame);
	}
}
