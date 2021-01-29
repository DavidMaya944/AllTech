package logic;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

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
	
	public static String getProveedores() {
		String sql = "https://alltech1.000webhostapp.com/Proveedores/get-proveedores.php";
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}
}
