package logic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Usuario;

public class LogicaUsuarios {

	public String confirmarRegistro(JTextField txtID, JTextField txtNombre, JTextField txtApellidos, JTextField txtEmail,
			JTextField txtDireccion, JTextField txtUsuario, JPasswordField txtContrasenia, JTextField txtTelefono) {

		String respuesta = null;
		int iId;
		
		try {
			iId = Integer.parseInt(txtID.getText());
		}catch(Exception e) {
			iId = -1;
		}
		
		String sNombre = txtNombre.getText().replaceAll(" ", "20%");
		String sApellidos = txtApellidos.getText().replaceAll(" ", "20%");
		String sEmail = txtEmail.getText();
		String sDireccion = txtDireccion.getText().replaceAll(" ", "20%");
		String sUsuario = txtUsuario.getText();
		String sPassword = txtContrasenia.getPassword().toString();
		String sTelefono = txtTelefono.getText();

		if(iId != -1) {
			String sqlUpdate = "http://davidmaya.atwebpages.com/UsuarioCliente/insert-usuarioCliente.php?NOMBRE=" + sNombre;
			sqlUpdate += "&APELLIDOS=" + sApellidos + "&EMAIL=" + sEmail.contains("@") + "&DIRECCION=" + sDireccion;
			sqlUpdate += "&USUARIO=" + sUsuario + "&CONTRASEÑA=" + sPassword + "&TELEFONO=" + sTelefono + "&PERMISO=" + 1 + "&ID=" + iId;

			respuesta = LogicaGeneral.peticionHttpArray(sqlUpdate);
			System.out.println("Se ha insertado el usuario correctamente");
		}
		

		return respuesta;
	}
	
	public String obtenerUsuarios() {
		String sql = "http://davidmaya.atwebpages.com/UsuarioCliente/getUsuariosClientes.php";
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
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
		boolean bFragil = false, bObsoleto = false;
		
		Integer iId = jObj.getInt("ID");
		String sNombre = jObj.getString("NOMBRE");
		String sApellidos = jObj.getString("APELLIDOS");
		String sEmail = jObj.getString("EMAIL");
		String sDireccion = jObj.getString("DIRECCION");
		String sUsuario = jObj.getString("USUARIO");
		String sPassword = jObj.getString("CONTRASEÑA");
		String sTelefono = jObj.getString("TELEFONO");
		
		Usuario u = new Usuario(iId, sNombre, sApellidos, sEmail, sDireccion, sUsuario, sPassword, sTelefono);
		return u;
	}
	
}
