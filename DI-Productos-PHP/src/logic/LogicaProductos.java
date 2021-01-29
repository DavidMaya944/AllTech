package logic;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Producto;
import view.FrmDetalleProd;

public class LogicaProductos {
	public static int iPos = 0;
	public static int iCod = 0;
	public static List<Producto> lProductos = new ArrayList<Producto>();
	
	
	private static String encodeFileToBase64(String filePath) {
		String base64Image = "";
		File file = new File(filePath);
		try(FileInputStream imageInFile = new FileInputStream(file)) {
			byte[] imageData = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "UPLOAD", JOptionPane.ERROR_MESSAGE);
		}
		
		return base64Image;
	}
	
	
	public static void insertProducto(String filePath, Producto p) throws Exception {

		
		String path = "http://davidmaya.atwebpages.com/imgProd/insert-producto.php";
		
		// Establecer la conexión...
		URL url = new URL(path);
		URLConnection conn = url.openConnection();
		HttpURLConnection http = (HttpURLConnection) conn;
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		
		// Parametros de envio
		Map<String, String> params = new HashMap<>();
		params.put("imgData", encodeFileToBase64(filePath));
		params.put("NOMBRE", p.getsNombre());
		params.put("OPCION", ""+p.getiOpcion());
		params.put("COMENTARIOS", p.getsComents());
		params.put("FRAGIL", ""+p.isbFragil());
		params.put("OBSOLETO", ""+p.isbObsoleto());
		params.put("STOCK_ACTUAL", ""+p.getiStockActual());
		params.put("STOCK_MIN", "" + p.getiStockMin());
		params.put("STOCK_MAX", ""+p.getiStockMax());
		params.put("PROVEEDOR", p.getsProveedor());
		params.put("PVP", ""+p.getfPVP());
		
		// Array de Bytes de envio
		StringJoiner sj = new StringJoiner("&");
		for(Map.Entry<String, String> entry : params.entrySet()) {
			sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
		}
		System.out.println(sj);
		byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
		
		// Enviar el array de bytes hacia el path (URL del Web-Service)
		http.setFixedLengthStreamingMode(out.length);
		http.setRequestProperty("Content-Type", "application/x-www.form-urlencoded; charset-UTF-8");
		http.connect();
		http.getOutputStream().write(out);
		
	}
	
	
	

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
			respuesta = LogicaGeneral.peticionHttpArray(sqlUpdate);
			System.out.println("Ha actualizado correctamente.");
		} else {
			String sqlInsert = "http://davidmaya.atwebpages.com/ProductosPHP/insert-producto.php";
			sqlInsert += "?NOMBRE=" + sNombre + "&OPCION=" + iOpcion + "&COMENTARIOS=" + sComents;
			sqlInsert += "&FRAGIL=" + bFragil + "&OBSOLETO=" + bObsoleto + "&STOCK_ACTUAL=" + iStockActual
					+ "&STOCK_MIN=" + iStockMin;
			sqlInsert += "&STOCK_MAX=" + iStockMax + "&PROVEEDOR=" + sProveedor + "&PVP=" + fPVP;
			respuesta = LogicaGeneral.peticionHttpArray(sqlInsert);
			System.out.println("Ha insertado correctamente.");

		}

		return respuesta;
	}
	

	public static int validarOpcion() {
		int iOpcion = 0;
		if (FrmDetalleProd.rdbtnPack.isSelected() == true) {
			iOpcion = 1;
		} else if (FrmDetalleProd.rdbtnUnidad.isSelected() == true) {
			iOpcion = 2;
		} else if (FrmDetalleProd.rdbtnCombinado.isSelected() == true) {
			iOpcion = 3;
		} else {
			System.out.println("Opcion invalida.");
		}

		return iOpcion;
	}

	public static boolean validarStock(JTextField txtStockActual, JTextField txtStockMin, JTextField txtStockMax) {
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

	public static boolean validarPrecio(JTextField txtPrecio) {
		boolean bExito = false;
		if (Float.parseFloat(txtPrecio.getText()) >= 0) {
			bExito = true;
		}
		return bExito;
	}

	@SuppressWarnings("unchecked")
	public static List<Producto> leer() {
		lProductos = new ArrayList<Producto>();
		String sRes = getProductos();
		lProductos = jasonToProductos(sRes);
		
		return lProductos;
	}
	
	public static Producto leerProd(int iCod) {
		Producto p = null;
		String sRes = getProducto(iCod);
		JSONArray jArray = new JSONArray(sRes);
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			p = JsonToProducto(jObj);
		}
		return p;
	}
	
	
	
	public static List<Producto> jasonToProductos(String respuesta){
		List<Producto> lProducto = new ArrayList<Producto>();
		
		JSONArray jArray = new JSONArray(respuesta);
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			Producto p = JsonToProducto(jObj);
			lProducto.add(p);
			
		}
		return lProducto;
	}
	
	private static Producto JsonToProducto(JSONObject jObj) {
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
		
		bFragil = LogicaGeneral.pasarIntBoolean(iFragil);
		bObsoleto = LogicaGeneral.pasarIntBoolean(iObsoleto);
		
		Producto p = new Producto(iCod, sNombre, iOpcion, sComents, bFragil, bObsoleto, iStockActual, iStockMin, iStockMax, sProveedor, fPVP );
		return p;
	}
	
	public static String getProductos() {
		String sql = "http://davidmaya.atwebpages.com/ProductosPHP/get-productos.php";
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}
	
	public static String getProducto(int iId) {
		String sql = "http://davidmaya.atwebpages.com/ProductosPHP/get-producto.php?CODIGO=" + iId;
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}

	public void confirmarBorrar(FrmDetalleProd frame) {
		int iCod = Integer.parseInt(FrmDetalleProd.txtCod.getText());
		if (JOptionPane.showConfirmDialog(frame, "Confirmar el borrado del producto " + iCod,
				"Confirmar borrado", 2) == JOptionPane.YES_OPTION) {
			String sql = "http://davidmaya.atwebpages.com/ProductosPHP/delete-producto.php?CODIGO=" + iCod;
			String respuesta = LogicaGeneral.peticionHttpArray(sql);
		}
	}

	public void guardarProducto() {
		guardarBD(FrmDetalleProd.txtCod, FrmDetalleProd.txtNombre, FrmDetalleProd.btnOption, FrmDetalleProd.textComents, FrmDetalleProd.checkFragil,
				FrmDetalleProd.checkObsoleto, FrmDetalleProd.txtStockActual, FrmDetalleProd.txtStockMin, FrmDetalleProd.txtStockMax,
				FrmDetalleProd.cmbProveedor, FrmDetalleProd.txtPVP);
		
	}
	
	public static DefaultTableModel generarTablaProducto(List<Producto> resultado) {
		DefaultTableModel modelo = new DefaultTableModel();
		// Añadir la cabecera de las columnas
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("OPCION");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("FRAGIL");
		modelo.addColumn("OBSOLETO");
		modelo.addColumn("STOCK ACTUAL");
		modelo.addColumn("STOCK MIN");
		modelo.addColumn("STOCK MAX");
		modelo.addColumn("PROVEEDOR");
		modelo.addColumn("PVP");
		
		// Añadir cada fila valores
		for(Producto p : resultado) {
			modelo.addRow(new Object[] {p.getiCod(), p.getsNombre(), p.getiOpcion(), p.getsComents(), p.isbFragil(),
					p.isbObsoleto(), p.getiStockActual(), p.getiStockMin(), p.getiStockMax(), p.getsProveedor(), p.getfPVP()});
		}
		return modelo;
	}
	
	public void downloadImgProd(int iId) {
		String path = "https://alltech1.000webhostapp.com/imgProd/" + iId + ".jpg";
		try {
			URL url = new URL(path);
			Image image = ImageIO.read(url);
			view.FrmDetalleProd.lblFoto.setIcon(new ImageIcon(image));
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	

}
