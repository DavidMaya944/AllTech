package logic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Producto;
import view.FrmDetalleProd;
import view.FrmTienda;
import view.TarjetaProducto;

public class LogicaProd {
	
	public static List<Producto> lProductos = new ArrayList<Producto>();
	public static List<Producto> lCesta = new ArrayList<Producto>();
	public static List<TarjetaProducto> lTarjeta = new ArrayList<TarjetaProducto>();
	public static int iPos = 0;
	
	public String getProductos() {
		String sql = "http://davidmaya.atwebpages.com/ProductosPHP/get-productos-cliente.php";
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}
	
	public static String getProductoDetalle(int iCod) {
		String sql = "http://davidmaya.atwebpages.com/ProductosPHP/get-producto-detalle.php?CODIGO=" + iCod;
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}
	
	public static Producto leer(int iCod) {
		Producto p = null;
		String sRes = getProductoDetalle(iCod);
		JSONArray jArray = new JSONArray(sRes);
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			p = JsonToProductoDetalle(jObj);
		}
		
		return p;
	}
	
	private static Producto JsonToProductoDetalle(JSONObject jObj) {
		int iCod = jObj.getInt("CODIGO");
		String sNombre = jObj.getString("NOMBRE");
		String sComents = jObj.getString("COMENTARIOS");
		float fPVP = jObj.getFloat("PVP");
		int iStockActual = jObj.getInt("STOCK_ACTUAL");
		
		Producto p = new Producto(iCod, sNombre, sComents, fPVP, iStockActual);
		
		return p;
	}
	
	public List<Producto> leerProductos() {
		lProductos = new ArrayList<Producto>();
		String sRes = getProductos();
		lProductos = jasonToProductos(sRes);
		
		return lProductos;
	}
	
	public List<Producto> jasonToProductos(String respuesta){
		List<Producto> lProductos = new ArrayList<Producto>();
		JSONArray jArray = new JSONArray(respuesta);
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			Producto p = JsonToProducto(jObj);
			lProductos.add(p);
			
		}
		return lProductos;
	}
	
	private Producto JsonToProducto(JSONObject jObj) {
		String sNombre = jObj.getString("NOMBRE");
		String sComents = jObj.getString("COMENTARIOS");
		float fPVP = jObj.getFloat("PVP");
		
		Producto p = new Producto(sNombre, sComents, fPVP);
		
		return p;
	}
	
	public void llenarLista() {
		lProductos = leerProductos();
		for(int i = 0; i < lProductos.size(); i++) {
			TarjetaProducto tProd = new TarjetaProducto(lProductos.get(i));
			
			tProd.txtNombre.setText(lProductos.get(i).getsNombre());
			tProd.textDescrip.setText(lProductos.get(i).getsComents());
			tProd.txtPVP.setText(lProductos.get(i).getfPVP() + " €");
			tProd.txtCod.setText(lProductos.get(i).getiCod() + "");
			FrmTienda.panelList.add(tProd);
			lTarjeta.add(tProd);
		}
		
		FrmTienda.contentPane.repaint();
	}
	
	public void llenarCesta() {
		Producto p = lProductos.get(iPos);
		lCesta.add(p);
	}
	
	public void borrarCesta() {
		lCesta.clear();
	}
}
