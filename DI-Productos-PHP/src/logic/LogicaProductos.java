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
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
	
	public static void updateProducto(String filePath, Producto p) throws Exception {
		
		String path = "https://alltech1.000webhostapp.com/Productos/update-producto.php";
		
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
		params.put("FRAGIL", ""+(p.isbFragil()?1:0));
		params.put("OBSOLETO", ""+(p.isbObsoleto()?1:0));
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
	
	public static void insertProducto(String filePath, Producto p) throws Exception {
		uploadImage(filePath);
		
		String path = LogicaGeneral.DOMINIO + "/Productos/insert-producto.php?NOMBRE=" + p.getsNombre()
		+ "&OPCION=" + p.getiOpcion() + "&COMENTARIOS=" + p.getsComents() + "&FRAGIL=" + (p.isbFragil()?1:0)
		+ "&OBSOLETO=" + (p.isbObsoleto()?1:0) + "&STOCK_ACTUAL=" + p.getiStockActual() + "&STOCK_MIN=" + p.getiStockMin()
		+ "&STOCK_MAX=" + p.getiStockMax() + "&PROVEEDOR=" + p.getsProveedor() + "&PVP=" + p.getfPVP();
		LogicaGeneral.peticionHttpArray(path);
		
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
			JOptionPane.showMessageDialog(null, "Validacion invalida", "Validacion opciones", JOptionPane.ERROR_MESSAGE);
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
		String sql = LogicaGeneral.DOMINIO + "/Productos/get-productos.php";
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}
	
	public static String getProducto(int iId) {
		String sql = LogicaGeneral.DOMINIO + "/Productos/get-producto.php?CODIGO=" + iId;
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}

	public static void confirmarBorrar(JDialog frame) {
		int iCod = Integer.parseInt(FrmDetalleProd.txtCod.getText());
		if (JOptionPane.showConfirmDialog(frame, "Confirmar el borrado del producto " + iCod,
				"Confirmar borrado", 2) == JOptionPane.YES_OPTION) {
			LogicaGeneral.peticionHttpArray(LogicaGeneral.DOMINIO + "/Productos/delete-producto.php?CODIGO=" + iCod);
		}
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
			modelo.addRow(new Object[] {p.getiCod(), p.getsNombre(), p.getOptionStr(), p.getsComents(), p.isbFragil(),
					p.isbObsoleto(), p.getiStockActual(), p.getiStockMin(), p.getiStockMax(), p.getsProveedor(), p.getfPVP()});
		}
		return modelo;
	}
	
	
	
	public static void downloadImgProd(int iId) {
		String path = LogicaGeneral.DOMINIO + "/imgProd/" + iId + ".jpg";
		try {
			URL url = new URL(path);
			Image image = ImageIO.read(url);
			view.FrmDetalleProd.lblFoto.setIcon(new ImageIcon(image));
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido descargar la imagen", "Descargar", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	
	public static void uploadImage(String filePath) {
		
		try {
			
			String path = LogicaGeneral.DOMINIO + "/productos/upload-image.php";
			
			// Establecer la conexión...
			URL url = new URL(path);
			URLConnection conn = url.openConnection();
			HttpURLConnection http = (HttpURLConnection) conn;
			http.setRequestMethod("POST");
			http.setDoOutput(true);
			
			// Parametros de envio
			Map<String, String> params = new HashMap<>();
			params.put("fileData", encodeFileToBase64(filePath));
			
			// Array de Bytes de envio
			StringJoiner sj = new StringJoiner("&");
			for(Map.Entry<String, String> entry : params.entrySet()) {
				sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
			}
			byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
			
			// Enviar el array de bytes hacia el path (URL del Web-Service)
			http.setFixedLengthStreamingMode(out.length);
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset-UTF-8");
			http.connect();
			http.getOutputStream().write(out);
			
			JOptionPane.showMessageDialog(null, "La imagen ha sido subida correctamente", "UPLOAD", JOptionPane.INFORMATION_MESSAGE);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "UPLOAD", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	

	

}













