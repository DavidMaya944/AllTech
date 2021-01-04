package logic;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
}
