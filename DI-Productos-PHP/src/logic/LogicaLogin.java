package logic;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Admin;

public class LogicaLogin {

	public static List<Admin> lAdmin = new ArrayList<Admin>();
	public static int iPos = 0;
	
	
	public String getLoginAdmin() {
		String sql = "http://davidmaya.atwebpages.com/UsuarioCliente/get-login-admin.php";
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}
	
	public List<Admin> leerLogin() {
		lAdmin = new ArrayList<Admin>();
		String sRes = getLoginAdmin();
		lAdmin = jasonToAdmins(sRes);
		
		return lAdmin;
	}

	
	public List<Admin> jasonToAdmins(String respuesta){
		List<Admin> lAdmin = new ArrayList<Admin>();
		JSONArray jArray = new JSONArray(respuesta);
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			Admin a = JsonToAdmin(jObj);
			lAdmin.add(a);
			
		}
		return lAdmin;
	}
	
	private Admin JsonToAdmin(JSONObject jObj) {
		String sNombre = jObj.getString("nombre");
		String sPass = jObj.getString("pass");
		
		Admin a = new Admin(sNombre, sPass);
		return a;
		
	}
}
