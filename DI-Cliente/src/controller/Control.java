package controller;

import logic.LogicaUsuario;
import model.Usuario;
import view.FrmCuenta;
import view.LoginUser;
import view.UpdateExito;
import view.UpdateFail;

public class Control {
	LogicaUsuario logic = new LogicaUsuario();
	
	public void guardarUsuario() {
		logic.guardar();
	}
	
	public void actualizarUsuario() {
		if(logic.actualizar()) {
			new UpdateExito();
			logic.actualizar();
			FrmCuenta.contentPane.repaint();
		}else {
			new UpdateFail();
		}
		
		
	}
	
	public void abrirUserName() {
		try {
			Usuario u = logic.leer(LoginUser.txtEmail);
			mostrar(u);
		}catch(Exception e) {
			e.getStackTrace();
			e.getMessage();
//			System.err.println("ERROR");
//			FrmCuenta.txtID.setText("");
//			FrmCuenta.txtNombre.setText("");
//			FrmCuenta.txtApellidos.setText("");
//			FrmCuenta.txtEmail.setText("");
//			FrmCuenta.txtDireccion.setText("");
//			FrmCuenta.txtUser.setText("");
//			FrmCuenta.txtPass.setText("");
//			FrmCuenta.txtTelefono.setText("");
		}
		
	}
	
	public void mostrar(Usuario u) {
		FrmCuenta.txtID.setText("" + u.getiId());
		FrmCuenta.txtUser.setText(u.getsUsuario());
		FrmCuenta.txtPass.setText(u.getsContrasenia());
		FrmCuenta.txtNombre.setText(u.getsNombre());
		FrmCuenta.txtApellidos.setText(u.getsApellidos());
		FrmCuenta.txtTelefono.setText(u.getsTelefono());
		FrmCuenta.txtDireccion.setText(u.getsDireccion());
		FrmCuenta.txtEmail.setText(u.getsEmail());
	}
}
