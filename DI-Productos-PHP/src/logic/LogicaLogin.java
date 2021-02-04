package logic;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Usuario;

public class LogicaLogin {

	
	
	public static String getLoginAdmin() {
		String sql = LogicaGeneral.DOMINIO + "/usuarios/get-login-admin.php";
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}
	
	public static List<Usuario> leerLogin() {
		LogicaUsuarios.lUsuariosB = new ArrayList<Usuario>();
		String sRes = getLoginAdmin();
		LogicaUsuarios.lUsuariosB = jasonToLogins(sRes);
		
		return LogicaUsuarios.lUsuariosB;
	}

	
	public static List<Usuario> jasonToLogins(String respuesta){
		List<Usuario> lAdmin = new ArrayList<Usuario>();
		JSONArray jArray = new JSONArray(respuesta);
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			Usuario a = JsonToLogin(jObj);
			lAdmin.add(a);
			
		}
		return lAdmin;
	}
	
	private static Usuario JsonToLogin(JSONObject jObj) {
		String sUsuario = jObj.getString("USUARIO");
		String sPass = jObj.getString("PASSWORD");
		String sPermiso = jObj.getString("PERMISO");
		Integer iRol = jObj.getInt("ROL");
		
		Usuario u = new Usuario(sUsuario, sPass, sPermiso, iRol);
		return u;
		
	}
}
