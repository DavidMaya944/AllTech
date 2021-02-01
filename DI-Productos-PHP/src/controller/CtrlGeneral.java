package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.LoginAdmin;

public class CtrlGeneral {
	
	public static void confirmarLogOut(JFrame frame) {
		if(JOptionPane.showConfirmDialog(frame, "¿Desea cerrar sesión?", "Cerrar sesión", 2) == JOptionPane.YES_OPTION) {
			frame.dispose();
			new LoginAdmin();
			
		}
	}
	
	public static void confirmarExit(JFrame frame) {
		if(JOptionPane.showConfirmDialog(frame, "¿Desea salir de la aplicación?", "Salir", 2) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
