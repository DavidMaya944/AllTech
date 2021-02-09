package logic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Proveedor;

public class LogicaProveedor {
	public static List<Proveedor> lProveedores;

	public static String guardarProveedor(JTextField txtNombre) {

		String respuesta = null;

		String sNombre = txtNombre.getText().replaceAll(" ", "%20");

		String sqlUpdate = LogicaGeneral.DOMINIO + "/proveedores/insert-proveedor.php?NOMBRE=" + sNombre;
		respuesta = LogicaGeneral.peticionHttpArray(sqlUpdate);

		return respuesta;
	}

	public static void guardarProveedor() {
		guardarProveedor(view.FrmDetalleProveedor.txtNombre);
	}

	public static List<Proveedor> leerProveedor() {
		lProveedores = new ArrayList<Proveedor>();
		String sRes = getProveedores();
		lProveedores = jasonToProveedores(sRes);

		return lProveedores;
	}

	public static List<Proveedor> jasonToProveedores(String respuesta) {
		List<Proveedor> lProveedores = new ArrayList<Proveedor>();

		JSONArray jArray = new JSONArray(respuesta);
		for (int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			Proveedor p = JsonToProveedor(jObj);
			lProveedores.add(p);

		}
		return lProveedores;
	}

	private static Proveedor JsonToProveedor(JSONObject jObj) {
		String sNombre = jObj.getString("NOMBRE");
		Proveedor p = new Proveedor(sNombre);
		return p;
	}

	public static Proveedor leerProv(String sNombre) {
		Proveedor p = null;
		String sRes = getProveedorDetalle(sNombre);
		JSONArray jArray = new JSONArray(sRes);
		for (int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			p = JsonToProveedor(jObj);
		}
		return p;
	}

	public static String getProveedorDetalle(String sNombre) {
		String sql = LogicaGeneral.DOMINIO + "/proveedores/get-proveedor-detalle.php?NOMBRE=" + sNombre;
		String respuesta = LogicaGeneral.peticionHttpArray(sql);

		return respuesta;
	}

	public static String getProveedores() {
		String sql = LogicaGeneral.DOMINIO + "/proveedores/get-proveedores.php";
		String respuesta = LogicaGeneral.peticionHttpArray(sql);

		return respuesta;
	}

	public static DefaultTableModel generarTablaProveedor(List<Proveedor> resultado) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("NOMBRE");

		for (Proveedor p : resultado) {
			modelo.addRow(new Object[] { p.getsNombre() });
		}
		return modelo;
	}

	public static void borrarProveedor(JDialog frame) {
		String sNombre = view.FrmDetalleProveedor.txtNombre.getText();
		if (JOptionPane.showConfirmDialog(frame, "Confirmar el borrado del proveedor " + sNombre, "Confirmar borrado",
				2) == JOptionPane.YES_OPTION) {
			LogicaGeneral
					.peticionHttpArray(LogicaGeneral.DOMINIO + "/proveedores/delete-proveedor.php?NOMBRE=" + sNombre);
		}

	}
}
