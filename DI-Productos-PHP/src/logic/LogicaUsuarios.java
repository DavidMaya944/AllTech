package logic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Usuario;
import view.FrmGestionUsuario;

public class LogicaUsuarios {

	public List<Usuario> lUsuarios = new ArrayList<Usuario>();
	public int iPos = 0;
	public String confirmarRegistro(JTextField txtID, JTextField txtNombre, JTextField txtApellidos, JTextField txtEmail,
			JTextField txtDireccion, JTextField txtUsuario, JPasswordField txtContrasenia, JTextField txtTelefono) {

		String respuesta = null;
		int iId;
		
		try {
			iId = Integer.parseInt(txtID.getText());
		}catch(Exception e) {
			iId = -1;
		}
		
		String sNombre = txtNombre.getText().replaceAll(" ", "%20");
		String sApellidos = txtApellidos.getText().replaceAll(" ", "%20");
		String sEmail = txtEmail.getText();
		String sDireccion = txtDireccion.getText().replaceAll(" ", "%20");
		String sUsuario = txtUsuario.getText();
		String sPassword = new String(txtContrasenia.getPassword());
		System.out.println(sPassword);
		String sTelefono = txtTelefono.getText();
		
		

		if(iId != -1) {
			String sqlUpdate = "http://davidmaya.atwebpages.com/UsuarioCliente/update-usuarioCliente.php?NOMBRE=" + sNombre;
			sqlUpdate += "&APELLIDOS=" + sApellidos + "&EMAIL=" + sEmail + "&DIRECCION=" + sDireccion;
			sqlUpdate += "&USUARIO=" + sUsuario + "&CONTRASEÑA=" + sPassword + "&TELEFONO=" + sTelefono + "&PERMISO=ACEPTADO&ID=" + iId;

			System.out.println(sqlUpdate);
			respuesta = LogicaGeneral.peticionHttpArray(sqlUpdate);
			System.out.println("Se le ha concedido el permiso.");
		}
		

		return respuesta;
	}
	
	public String obtenerUsuarios() {
		String sql = "http://davidmaya.atwebpages.com/UsuarioCliente/getUsuariosClientes.php";
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}
	
	public List<Usuario> leer() {
		lUsuarios = new ArrayList<Usuario>();
		String sRes = obtenerUsuarios();
		lUsuarios = jasonToUsuarios(sRes);
		
		return lUsuarios;
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
		
		Integer iId = jObj.getInt("ID");
		String sNombre = jObj.getString("NOMBRE");
		String sApellidos = jObj.getString("APELLIDOS");
		String sEmail = jObj.getString("EMAIL");
		String sDireccion = jObj.getString("DIRECCION");
		String sUsuario = jObj.getString("USUARIO");
		String sPassword = jObj.getString("CONTRASEÑA");
		String sTelefono = jObj.getString("TELEFONO");
		String sPermiso = jObj.getString("PERMISO");
		
		
		Usuario u = new Usuario(iId, sNombre, sApellidos, sEmail, sDireccion, sUsuario, sPassword, sTelefono, sPermiso);
		return u;
	}
	
	public void confirmarUsuario() {
		confirmarRegistro(FrmGestionUsuario.txtID, FrmGestionUsuario.txtNombre, FrmGestionUsuario.txtApellidos, FrmGestionUsuario.txtEmail,
				FrmGestionUsuario.txtDireccion, FrmGestionUsuario.txtUser, FrmGestionUsuario.txtPass, FrmGestionUsuario.txtTelefono);
	}
	
	public Usuario inicioLista() {
		Usuario u = null;
		iPos = 0;
		u = lUsuarios.get(iPos);
		return u;
	}

	public Usuario finLista() {
		iPos = lUsuarios.size() - 1;
		Usuario u = null;
		if (iPos >= 1)
			u = lUsuarios.get(iPos);
		return u;
	}

	public Usuario siguiente() {
		Usuario u = null;
		if (iPos != lUsuarios.size() - 1) {
			iPos++;
			u = lUsuarios.get(iPos);
		}
		return u;
	}

	public Usuario anterior() {
		Usuario u = null;
		if (iPos != 0) {
			iPos--;
			u = lUsuarios.get(iPos);
		}
		return u;

	}
}
