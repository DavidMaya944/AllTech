package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Producto;
import view.FrmGestionProductos;

public class Logica {
	public static int iPos = 0;
	public static int iCod = 0;
	public static List<Producto> lProductos = new ArrayList<Producto>();

	public String guardarBD(JTextField txtCod, JTextField txtNombre, ButtonGroup btnOption, JTextArea textComents,
			JCheckBox checkFragil, JCheckBox checkObsoleto, JTextField txtStockActual, JTextField txtStockMin,
			JTextField txtStockMax, JComboBox cmbProveedor, JTextField txtPVP) {

		String respuesta = null;
		int iCod;

		try {
			 iCod = Integer.parseInt(txtCod.getText());
		} catch (Exception ex) {
			iCod = -1;
		}
		String sNombre = txtNombre.getText().replaceAll(" ", "%20");
		int iOpcion = validarOpcion();
		String sComents = textComents.getText().replaceAll(" ", "%20");
		boolean bFragil = checkFragil.isSelected();
		boolean bObsoleto = checkObsoleto.isSelected();
		int iStockActual = 0, iStockMin = 0, iStockMax = 0;

		if (validarStock(txtStockActual, txtStockMin, txtStockMax) == true) {
			iStockActual = Integer.parseInt(txtStockActual.getText());
			iStockMin = Integer.parseInt(txtStockMin.getText());
			iStockMax = Integer.parseInt(txtStockMax.getText());
		}

		String sProveedor = (String) cmbProveedor.getSelectedItem();
		float fPVP = 0;
		if (validarPrecio(txtPVP) == true) {
			fPVP = Float.parseFloat(txtPVP.getText());
		}		
	
		if (iCod != -1) {
			String sqlUpdate = "http://davidmaya.atwebpages.com/ProductosPHP/update-producto.php";
			sqlUpdate += "?NOMBRE=" + sNombre + "&OPCION=" + iOpcion + "&COMENTARIOS=" + sComents;
			sqlUpdate += "&FRAGIL=" + bFragil + "&OBSOLETO=" + bObsoleto + "&STOCK_ACTUAL=" + iStockActual
					+ "&STOCK_MIN=" + iStockMin;
			sqlUpdate += "&STOCK_MAX=" + iStockMax + "&PROVEEDOR=" + sProveedor + "&PVP=" + fPVP + "&CODIGO="
					+ iCod;
			respuesta = peticionHttpArray(sqlUpdate);
			System.out.println("Ha actualizado correctamente.");
		} else {
			String sqlInsert = "http://davidmaya.atwebpages.com/ProductosPHP/insert-producto.php";
			sqlInsert += "?NOMBRE=" + sNombre + "&OPCION=" + iOpcion + "&COMENTARIOS=" + sComents;
			sqlInsert += "&FRAGIL=" + bFragil + "&OBSOLETO=" + bObsoleto + "&STOCK_ACTUAL=" + iStockActual
					+ "&STOCK_MIN=" + iStockMin;
			sqlInsert += "&STOCK_MAX=" + iStockMax + "&PROVEEDOR=" + sProveedor + "&PVP=" + fPVP;
			respuesta = peticionHttpArray(sqlInsert);
			System.out.println("Ha insertado correctamente.");

		}

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

	public int validarOpcion() {
		int iOpcion = 0;
		if (FrmGestionProductos.rdbtnPack.isSelected() == true) {
			iOpcion = 1;
		} else if (FrmGestionProductos.rdbtnUnidad.isSelected() == true) {
			iOpcion = 2;
		} else if (FrmGestionProductos.rdbtnCombinado.isSelected() == true) {
			iOpcion = 3;
		} else {
			System.out.println("Opcion invalida.");
		}

		return iOpcion;
	}

	public boolean validarStock(JTextField txtStockActual, JTextField txtStockMin, JTextField txtStockMax) {
		boolean bExito = false;
		if (Integer.parseInt(txtStockMin.getText()) >= 0
				&& Integer.parseInt(txtStockMin.getText()) < Integer.parseInt(txtStockMax.getText())) {
			bExito = true;
			if (Integer.parseInt(txtStockActual.getText()) >= Integer.parseInt(txtStockMin.getText())
					&& Integer.parseInt(txtStockActual.getText()) <= Integer.parseInt(txtStockMax.getText())) {
				bExito = true;

			} else {
				bExito = false;
			}

		}
		return bExito;
	}

	public boolean validarPrecio(JTextField txtPrecio) {
		boolean bExito = false;
		if (Float.parseFloat(txtPrecio.getText()) >= 0) {
			bExito = true;
		}
		return bExito;
	}

	@SuppressWarnings("unchecked")
	public List<Producto> leer() {
		lProductos = new ArrayList<Producto>();
		String sRes = getProductos();
		lProductos = jasonToProductos(sRes);
		
		return lProductos;
	}
	
	
	
	public List<Producto> jasonToProductos(String respuesta){
		List<Producto> lProducto = new ArrayList<Producto>();
		
		JSONArray jArray = new JSONArray(respuesta);
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			Producto p = JsonToProducto(jObj);
			lProducto.add(p);
			
		}
		return lProducto;
	}
	
	private Producto JsonToProducto(JSONObject jObj) {
		boolean bFragil = false, bObsoleto = false;
		
		Integer iCod = jObj.getInt("CODIGO");
		String sNombre = jObj.getString("NOMBRE");
		Integer iOpcion = jObj.getInt("OPCION");
		String sComents = jObj.getString("COMENTARIOS");
		Integer iFragil = jObj.getInt("FRAGIL");
		Integer iObsoleto = jObj.getInt("OBSOLETO");
		Integer iStockActual = jObj.getInt("STOCK_ACTUAL");
		Integer iStockMin = jObj.getInt("STOCK_MIN");
		Integer iStockMax = jObj.getInt("STOCK_MAX");
		String sProveedor = jObj.getString("PROVEEDOR");
		Float fPVP = jObj.getFloat("PVP");
		
		bFragil = pasarIntBoolean(iFragil);
		bObsoleto = pasarIntBoolean(iObsoleto);
		
		Producto p = new Producto(iCod, sNombre, iOpcion, sComents, bFragil, bObsoleto, iStockActual, iStockMin, iStockMax, sProveedor, fPVP );
		return p;
	}
	
	public boolean pasarIntBoolean(int iNum) {
		int iFragil = 0;
		boolean bExito = false;
		if(iFragil != 0) {
			bExito = true;
		}else {
			bExito = false;
		}
		
		return bExito;
	}

	public Producto inicioLista() {
		Producto p = null;
		iPos = 0;
		p = lProductos.get(iPos);
		return p;
	}

	public Producto finLista() {
		iPos = lProductos.size() - 1;
		Producto p = null;
		if (iPos >= 1)
			p = lProductos.get(iPos);
		return p;
	}

	public Producto siguiente() {
		Producto p = null;
		if (iPos != lProductos.size() - 1) {
			iPos++;
			p = lProductos.get(iPos);
		}
		return p;
	}

	public Producto anterior() {
		Producto p = null;
		if (iPos != 0) {
			iPos--;
			p = lProductos.get(iPos);
		}
		return p;

	}
	
	public String getProductos() {
		String sql = "http://davidmaya.atwebpages.com/ProductosPHP/get-productos.php";
		String respuesta = peticionHttpArray(sql);
		
		return respuesta;
	}

	public void confirmarBorrar(FrmGestionProductos frame) {
		int iCod = Integer.parseInt(FrmGestionProductos.txtCod.getText());
		if (JOptionPane.showConfirmDialog(frame, "Confirmar el borrado del producto " + iCod,
				"Confirmar borrado", 2) == JOptionPane.YES_OPTION) {
			String sql = "http://davidmaya.atwebpages.com/ProductosPHP/delete-producto.php?CODIGO=" + iCod;
			String respuesta = peticionHttpArray(sql);
		}
	}

	public void guardarProducto() {
		guardarBD(FrmGestionProductos.txtCod, FrmGestionProductos.txtNombre, FrmGestionProductos.btnOption, FrmGestionProductos.textComents, FrmGestionProductos.checkFragil,
				FrmGestionProductos.checkObsoleto, FrmGestionProductos.txtStockActual, FrmGestionProductos.txtStockMin, FrmGestionProductos.txtStockMax,
				FrmGestionProductos.cmbProveedor, FrmGestionProductos.txtPVP);
		
	}
	
}
