package logic;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
		System.out.println("Se ha insertado el usuario correctamente");

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
		String sPassword = txtContrasenia.getPassword().toString();
		String sTelefono = txtTelefono.getText();

		if(iId != -1) {
			String sqlUpdate = "http://davidmaya.atwebpages.com/UsuarioCliente/insert-usuarioCliente.php?NOMBRE=" + sNombre;
			sqlUpdate += "&APELLIDOS=" + sApellidos + "&EMAIL=" + sEmail + "&DIRECCION=" + sDireccion;
			sqlUpdate += "&USUARIO=" + sUsuario + "&PASSWORD=" + sPassword + "&TELEFONO=" + sTelefono + "&PERMISO=ACEPTADO&ID=" + iId;

			respuesta = LogicaGeneral.peticionHttpArray(sqlUpdate);
			System.out.println("Se ha insertado el usuario correctamente");
		}
		

		return respuesta;
	}

	

	public void guardar() {
		guardarUsuario(FrmRegistro.txtNombre, FrmRegistro.txtApellidos, FrmRegistro.txtEmail, FrmRegistro.txtDireccion,
				FrmRegistro.txtUsuario, FrmRegistro.txtPassword, FrmRegistro.txtTelefono);
	}

}
