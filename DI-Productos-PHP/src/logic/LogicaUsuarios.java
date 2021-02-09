package logic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Usuario;
import view.FrmDetalleUsuario;

public class LogicaUsuarios {

	public static List<Usuario> lUsuariosB = new ArrayList<Usuario>();
	public static int iPos = 0;

	public static String confirmarRegistro(JTextField txtID, JTextField txtNombre, JTextField txtApellidos,
			JTextField txtEmail, JTextField txtDireccion, JTextField txtUsuario, JPasswordField txtContrasenia,
			JTextField txtTelefono, JTextField txtPermiso) {

		String respuesta = null;
		int iId;

		try {
			iId = Integer.parseInt(txtID.getText());
		} catch (Exception e) {
			iId = -1;
		}

		String sNombre = txtNombre.getText().replaceAll(" ", "%20");
		String sApellidos = txtApellidos.getText().replaceAll(" ", "%20");
		String sEmail = txtEmail.getText();
		String sDireccion = txtDireccion.getText().replaceAll(" ", "%20");
		String sUsuario = txtUsuario.getText();
		String sPassword = new String(txtContrasenia.getPassword());
		String sTelefono = txtTelefono.getText();

		if (iId != -1) {
			String sqlUpdate = LogicaGeneral.DOMINIO + "/usuarios/update-usuarioCliente.php?NOMBRE="
					+ sNombre;
			sqlUpdate += "&APELLIDOS=" + sApellidos + "&EMAIL=" + sEmail + "&DIRECCION=" + sDireccion;
			sqlUpdate += "&USUARIO=" + sUsuario + "&PASSWORD=" + sPassword + "&TELEFONO=" + sTelefono
					+ "&PERMISO=ACEPTADO&ID=" + iId;

			respuesta = LogicaGeneral.peticionHttpArray(sqlUpdate);
		}

		return respuesta;
	}
	
	public String getLoginAdmin() {
		String sql = LogicaGeneral.DOMINIO + "/usuarios/get-login-admin.php";
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}

	public static String bloquearUser(JTextField txtID, JTextField txtNombre, JTextField txtApellidos, JTextField txtEmail,
			JTextField txtDireccion, JTextField txtUsuario, JPasswordField txtContrasenia, JTextField txtTelefono,
			JTextField txtPermiso) {

		String respuesta = null;
		int iId;

		try {
			iId = Integer.parseInt(txtID.getText());
		} catch (Exception e) {
			iId = -1;
		}

		String sNombre = txtNombre.getText().replaceAll(" ", "%20");
		String sApellidos = txtApellidos.getText().replaceAll(" ", "%20");
		String sEmail = txtEmail.getText();
		String sDireccion = txtDireccion.getText().replaceAll(" ", "%20");
		String sUsuario = txtUsuario.getText();
		String sPassword = new String(txtContrasenia.getPassword());
		String sTelefono = txtTelefono.getText();

		if (iId != -1) {
			String sqlUpdate = LogicaGeneral.DOMINIO + "/usuarios/update-usuarioCliente.php?NOMBRE="
					+ sNombre;
			sqlUpdate += "&APELLIDOS=" + sApellidos + "&EMAIL=" + sEmail + "&DIRECCION=" + sDireccion;
			sqlUpdate += "&USUARIO=" + sUsuario + "&PASSWORD=" + sPassword + "&TELEFONO=" + sTelefono
					+ "&PERMISO=BLOQUEADO&ID=" + iId;

			respuesta = LogicaGeneral.peticionHttpArray(sqlUpdate);
		}

		return respuesta;
	}

	public static String obtenerUsuarios() {
		String sql = LogicaGeneral.DOMINIO + "/usuarios/getUsuariosClientes.php";
		String respuesta = LogicaGeneral.peticionHttpArray(sql);

		return respuesta;
	}
	
	public static String getUser(int iId) {
		String sql = LogicaGeneral.DOMINIO + "/usuarios/get-usuarioCliente.php?ID=" + iId;
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}
	
	public static void rechazarUsuario(FrmDetalleUsuario frame) {
		int iId = Integer.parseInt(FrmDetalleUsuario.txtID.getText());
		if (JOptionPane.showConfirmDialog(frame, "Confirmar el borrado del producto " + iId,
				"Confirmar borrado", 2) == JOptionPane.YES_OPTION) {
			LogicaGeneral.peticionHttpArray(LogicaGeneral.DOMINIO + "/usuarios/delete-usuarioCliente.php?ID=" + iId);
		}
		
	}
	
	public static List<Usuario> leer() {
		lUsuariosB = new ArrayList<Usuario>();
		String sRes = obtenerUsuarios();
		lUsuariosB = jasonToUsuarios(sRes);

		return lUsuariosB;
	}

	public static List<Usuario> jasonToUsuarios(String respuesta) {
		List<Usuario> lUsuario = new ArrayList<Usuario>();
		JSONArray jArray = new JSONArray(respuesta);
		for (int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			Usuario u = JsonToUsuario(jObj);
			lUsuario.add(u);

		}
		return lUsuario;
	}

	private static Usuario JsonToUsuario(JSONObject jObj) {

		Integer iId = jObj.getInt("ID");
		String sNombre = jObj.getString("NOMBRE");
		String sApellidos = jObj.getString("APELLIDOS");
		String sEmail = jObj.getString("EMAIL");
		String sDireccion = jObj.getString("DIRECCION");
		String sUsuario = jObj.getString("USUARIO");
		String sPassword = jObj.getString("PASSWORD");
		String sTelefono = jObj.getString("TELEFONO");
		String sPermiso = jObj.getString("PERMISO");
		Integer iRol = jObj.getInt("ROL");

		Usuario u = new Usuario(iId, sNombre, sApellidos, sEmail, sDireccion, sUsuario, sPassword, sTelefono, sPermiso, iRol);
		return u;
	}

	public void confirmarUsuario() {
		confirmarRegistro(FrmDetalleUsuario.txtID, FrmDetalleUsuario.txtNombre, FrmDetalleUsuario.txtApellidos,
				FrmDetalleUsuario.txtEmail, FrmDetalleUsuario.txtDireccion, FrmDetalleUsuario.txtUser,
				FrmDetalleUsuario.txtPass, FrmDetalleUsuario.txtTelefono, FrmDetalleUsuario.txtPermiso);
	}

	public static void blouqearUsuario() {
		bloquearUser(FrmDetalleUsuario.txtID, FrmDetalleUsuario.txtNombre, FrmDetalleUsuario.txtApellidos,
				FrmDetalleUsuario.txtEmail, FrmDetalleUsuario.txtDireccion, FrmDetalleUsuario.txtUser,
				FrmDetalleUsuario.txtPass, FrmDetalleUsuario.txtTelefono, FrmDetalleUsuario.txtPermiso);
	}

	public static void desbloquearUsuario() {
		confirmarRegistro(FrmDetalleUsuario.txtID, FrmDetalleUsuario.txtNombre, FrmDetalleUsuario.txtApellidos,
				FrmDetalleUsuario.txtEmail, FrmDetalleUsuario.txtDireccion, FrmDetalleUsuario.txtUser,
				FrmDetalleUsuario.txtPass, FrmDetalleUsuario.txtTelefono, FrmDetalleUsuario.txtPermiso);
		
	}


	public static DefaultTableModel generarTablaUsuario(List<Usuario> resultado) {
		DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("ID");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("EMAIL");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("USUARIO");
		modelo.addColumn("PASSWORD");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("PERMISO");
		modelo.addColumn("ROL");
		
		for(Usuario u : resultado) {
			modelo.addRow(new Object[] {u.getiId(), u.getsNombre(), u.getsApellidos(), u.getsEmail(), u.getsDireccion(),
					u.getsUsuario(), u.getsContrasenia(), u.getsTelefono(), u.getsPermiso(), u.getRolStr()});
		}
		return modelo;
	}
	
	public static Usuario leerUser(int iId) {
		Usuario u = null;
		String sRes = getUser(iId);
		JSONArray jArray = new JSONArray(sRes);
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			u = JsonToUsuario(jObj);
		}
		return u;
	}
}
