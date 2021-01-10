package logic;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Usuario;

public class LogicaLogin {
	
	
	public String getLoginAdmin() {
		String sql = "http://davidmaya.atwebpages.com/UsuarioCliente/get-login-user.php";
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}
	
	public List<Usuario> leerLogin() {
		LogicaGeneral.lUsuario = new ArrayList<Usuario>();
		String sRes = getLoginAdmin();
		LogicaGeneral.lUsuario = jasonToUsuarios(sRes);
		
		return LogicaGeneral.lUsuario;
	}

	
	public List<Usuario> jasonToUsuarios(String respuesta){
		List<Usuario> lUsuario = new ArrayList<Usuario>();
		JSONArray jArray = new JSONArray(respuesta);
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			Usuario u = JsonToUsuario(jObj);
			lUsuario.add(u);
			
		}
		return lUsuario;
	}
	
	private Usuario JsonToUsuario(JSONObject jObj) {
		String sNombre = jObj.getString("USUARIO");
		String sPass = jObj.getString("PASSWORD");
		String sPermiso = jObj.getString("PERMISO");
		
		Usuario u = new Usuario(sNombre, sPass, sPermiso);
		return u;
		
	}
}
