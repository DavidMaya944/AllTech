package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.LoginAdmin;

public class LogicaGeneral {

	public static String peticionHttpArray(String parametro) {

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

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error inesperado en la peticion HTTP", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return resultado.toString();
	}
	
	public static boolean pasarIntBoolean(int iNum) {
		boolean bExito = false;
		if(iNum != 0) {
			bExito = true;
		}else {
			bExito = false;
		}
		
		return bExito;
	}
	
	
	
	
}
