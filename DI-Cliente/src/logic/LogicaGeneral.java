package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class LogicaGeneral {
	
	public static List<Usuario> lUsuario = new ArrayList<Usuario>();
	public static int iPos = 0;
	
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

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultado.toString();
	}
}
