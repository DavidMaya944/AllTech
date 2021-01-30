package logic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Producto;
import model.Proveedor;

public class LogicaProveedor {
	public static List<Proveedor> lProveedores;
	
	public static List<Proveedor> leerProveedor() {
		lProveedores = new ArrayList<Proveedor>();
		String sRes = getProveedores();
		lProveedores = jasonToProveedores(sRes);
		
		return lProveedores;
	}
	
	
	public static List<Proveedor> jasonToProveedores(String respuesta){
		List<Proveedor> lProveedores = new ArrayList<Proveedor>();
		
		JSONArray jArray = new JSONArray(respuesta);
		for(int i = 0; i < jArray.length(); i++) {
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
	
	public static Proveedor leerProv(int iId) {
		Proveedor p = null;
		String sRes = getProveedorDetalle(iId);
		JSONArray jArray = new JSONArray(sRes);
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			p = JsonToProveedor(jObj);
		}
		return p;
	}
	
	public static String getProveedorDetalle(int iId) {
		String sql = "https://alltech1.000webhostapp.com/Proveedores/get-proveedor-detalle.php?ID_PROVEEDOR=" + iId;
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}
	
	public static String getProveedores() {
		String sql = "https://alltech1.000webhostapp.com/Proveedores/get-proveedores.php";
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}
	
	public static DefaultTableModel generarTablaProveedor(List<Proveedor> resultado) {
		DefaultTableModel modelo = new DefaultTableModel();
		// Añadir la cabecera de las columnas
		modelo.addColumn("ID_PROVEEDOR");
		modelo.addColumn("NOMBRE");
		
		// Añadir cada fila valores
		for(Proveedor p : resultado) {
			modelo.addRow(new Object[] {p.getiId(), p.getsNombre()});
		}
		return modelo;
	}
}
