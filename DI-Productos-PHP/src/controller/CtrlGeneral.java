package controller;

import javax.swing.JFrame;

import logic.LogicaGeneral;
import view.FrmMenuPrincipal;
import view.LoginAdmin;

public class CtrlGeneral {
	
	public static void confirmarLogOut(JFrame frame) {
		LogicaGeneral.confirmarLogOut(frame);
	}
	
	public static void confirmarExit(JFrame frame) {
		LogicaGeneral.confirmarExit(frame);
	}
}
