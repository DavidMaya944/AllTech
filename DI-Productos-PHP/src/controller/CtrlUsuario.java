package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import logic.LogicaUsuarios;
import model.Usuario;
import view.FrmDetalleUsuario;

public class CtrlUsuario {
	public static int iId;
	LogicaUsuarios logUser = new LogicaUsuarios();
	
	public static void tableRowSelected() {
		new view.FrmDetalleProd();

	}

	public static void loadData() {
		try {
			List<Usuario> resultado = LogicaUsuarios.leer();
			DefaultTableModel modelo = LogicaUsuarios.generarTablaUsuario(resultado);
			view.FrmGestionUsuarios.tableUsers.setModel(modelo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido cargar los datos", "Cargar datos", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void loadDataUser() {
		iId = Integer.parseInt(view.FrmGestionUsuarios.tableUsers.getValueAt(view.FrmGestionUsuarios.tableUsers.getSelectedRow(), 0).toString());
		try {
			Usuario u = LogicaUsuarios.leerUser(iId);
			FrmDetalleUsuario.txtID.setText("" + u.getiId());
			FrmDetalleUsuario.txtNombre.setText(u.getsNombre());
			FrmDetalleUsuario.txtApellidos.setText(u.getsApellidos());
			FrmDetalleUsuario.txtEmail.setText(u.getsEmail());
			FrmDetalleUsuario.txtDireccion.setText(u.getsDireccion());
			FrmDetalleUsuario.txtUser.setText(u.getsUsuario());
			FrmDetalleUsuario.txtPass.setText(u.getsContrasenia());
			FrmDetalleUsuario.txtTelefono.setText(u.getsTelefono());
			FrmDetalleUsuario.txtPermiso.setText(u.getsPermiso());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido cargar los datos", "Cargar datos", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void confirmarUsuario() {
		logUser.confirmarUsuario();
		JOptionPane.showMessageDialog(null, "El producto ha sido registrado con exito", "UPLOAD", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void bloquearUsuario() {
		LogicaUsuarios.blouqearUsuario();
	}
	
	public static void desbloquearUsuario() {
		LogicaUsuarios.desbloquearUsuario();
	}

	public void rechazarUsuario(FrmDetalleUsuario frame) {
		LogicaUsuarios.rechazarUsuario(frame);
	}
	
	

}
