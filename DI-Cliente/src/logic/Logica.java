package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Usuario;
import view.FrmRegistro;

public class Logica {
	public static List<Usuario> lUsuarios = new ArrayList<Usuario>();

	public String guardarUsuario(JTextField txtNombre, JTextField txtApellidos, JTextField txtEmail,
			JTextField txtDireccion, JTextField txtUsuario, JPasswordField txtContrasenia, JTextField txtTelefono) {
		String sNombre = txtNombre.getText().replaceAll(" ", "20%");
		String sApellidos = txtApellidos.getText().replaceAll(" ", "20%");
		String sEmail = txtEmail.getText();
		String sDireccion = txtDireccion.getText().replaceAll(" ", "20%");
		String sUsuario = txtUsuario.getText();
		String sPassword = txtContrasenia.getPassword().toString();
		String sTelefono = txtTelefono.getText();

		String sqlInsert = "http://davidmaya.atwebpages.com/UsuarioCliente/insert-usuarioCliente.php?NOMBRE=" + sNombre;
		sqlInsert += "&APELLIDOS=" + sApellidos + "&EMAIL=" + sEmail.contains("@") + "&DIRECCION=" + sDireccion;
		sqlInsert += "&USUARIO=" + sUsuario + "&CONTRASEÑA=" + sPassword + "&TELEFONO=" + sTelefono;

		String respuesta = peticionHttpArray(sqlInsert);
		System.out.println("Se ha insertado el usuario correctamente");

		return respuesta;
	}

	public String peticionHttpArray(String parametro) {

		StringBuilder resultado = new StringBuilder();

		try {

			URL url = new URL(parametro);
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("GET");

			BufferedReader bf = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String linea;

			while ((linea = bf.readLine()) != null) {
				resultado.append(linea + "\n");
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultado.toString();
	}

	public void guardar() {
		guardarUsuario(FrmRegistro.txtNombre, FrmRegistro.txtApellidos, FrmRegistro.txtEmail,
				FrmRegistro.txtDireccion, FrmRegistro.txtUsuario, FrmRegistro.txtPassword, FrmRegistro.txtTelefono);
	}

}
