package logic;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Usuario;
import view.FrmCuenta;
import view.FrmRegistro;

public class LogicaUsuario {

	public String guardarUsuario(JTextField txtNombre, JTextField txtApellidos, JTextField txtEmail,
			JTextField txtDireccion, JTextField txtUsuario, JPasswordField txtContrasenia, JTextField txtTelefono) {

		String sNombre = txtNombre.getText().replaceAll(" ", "%20");
		String sApellidos = txtApellidos.getText().replaceAll(" ", "%20");
		String sEmail = txtEmail.getText();
		String sDireccion = txtDireccion.getText().replaceAll(" ", "%20");
		String sUsuario = txtUsuario.getText();
		String sPassword = new String(txtContrasenia.getPassword());
		String sTelefono = txtTelefono.getText();
		

		String sqlInsert = "http://davidmaya.atwebpages.com/UsuarioCliente/insert-usuarioCliente.php?NOMBRE=" + sNombre;
		sqlInsert += "&APELLIDOS=" + sApellidos + "&EMAIL=" + sEmail + "&DIRECCION=" + sDireccion;
		sqlInsert += "&USUARIO=" + sUsuario + "&PASSWORD=" + sPassword + "&TELEFONO=" + sTelefono + "&PERMISO=EN%20ESPERA";
		System.out.println(sqlInsert);
		String respuesta = LogicaGeneral.peticionHttpArray(sqlInsert);

		return respuesta;
	}
	
	// Metodo para la interfaz de ajustes de cuenta donde el usuario podra modificar los datos.
	public String actualizarUsuario(JTextField txtID, JTextField txtNombre, JTextField txtApellidos, JTextField txtEmail,
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
		String sTelefono = txtTelefono.getText();

		if(iId != -1) {
			String sqlUpdate = "http://davidmaya.atwebpages.com/UsuarioCliente/update-usuarioCliente.php?NOMBRE=" + sNombre;
			sqlUpdate += "&APELLIDOS=" + sApellidos + "&EMAIL=" + sEmail + "&DIRECCION=" + sDireccion;
			sqlUpdate += "&USUARIO=" + sUsuario + "&PASSWORD=" + sPassword + "&TELEFONO=" + sTelefono + "&PERMISO=ACEPTADO&ID=" + iId;

			respuesta = LogicaGeneral.peticionHttpArray(sqlUpdate);
		}
		

		return respuesta;
	}
	
	public Usuario leer(JTextField txtEmail) {
		Usuario u = null;
		String sEmail = txtEmail.getText();
		String sRes = getUsuario(sEmail);
		JSONArray jArray = new JSONArray(sRes);
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			u = JsonToUsuario(jObj);
		}
		
		return u;
	}
	
	private Usuario JsonToUsuario(JSONObject jObj) {
		int iId = jObj.getInt("ID");
		String sNombre = jObj.getString("NOMBRE");
		String sApellidos = jObj.getString("APELLIDOS");
		String sEmail = jObj.getString("EMAIL");
		String sDireccion = jObj.getString("DIRECCION");
		String sUsuario = jObj.getString("USUARIO");
		String sPassword = jObj.getString("PASSWORD");
		String sTelefono = jObj.getString("TELEFONO");
		Usuario u = new Usuario(iId, sNombre, sApellidos, sEmail, sDireccion, sUsuario, sPassword, sTelefono);
		return u;
		
	}
	
	public String getUsuario(String sEmail) {
		String sql = "http://davidmaya.atwebpages.com/UsuarioCliente/get-email.php?EMAIL=" + sEmail;
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}

	

	public void guardar() {
		guardarUsuario(FrmRegistro.txtNombre, FrmRegistro.txtApellidos, FrmRegistro.txtEmail, FrmRegistro.txtDireccion,
				FrmRegistro.txtUsuario, FrmRegistro.txtPassword, FrmRegistro.txtTelefono);
	}
	
	public boolean actualizar() {
		boolean bExito = false;
		if(actualizarUsuario(FrmCuenta.txtID, FrmCuenta.txtNombre, FrmCuenta.txtApellidos, FrmCuenta.txtEmail, FrmCuenta.txtDireccion,
				FrmCuenta.txtUser, FrmCuenta.txtPass, FrmCuenta.txtTelefono) != null) {
			
		}
		return bExito;
	}

}
