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
	
	public String getProductoDetalle(String sNombre) {
		String sql = "http://davidmaya.atwebpages.com/ProductosPHP/get-producto-detalle.php?NOMBRE=" + sNombre;
		String respuesta = LogicaGeneral.peticionHttpArray(sql);
		
		return respuesta;
	}
	
	public Producto leer(JTextField txtNombre) {
		Producto p = null;
		String sNombre = txtNombre.getText().replaceAll(" ", "%20");
		System.out.println(sNombre);
		String sRes = getProductoDetalle(sNombre);
		JSONArray jArray = new JSONArray(sRes);
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject jObj = jArray.getJSONObject(i);
			p = JsonToProductoDetalle(jObj);
		}
		
		return p;
	}
	
	public void mostrar(Producto p) {
		FrmDetalleProd.txtNombre.setText(p.getsNombre());
		FrmDetalleProd.txtDescrip.setText(p.getsComents());
		FrmDetalleProd.txtPVP.setText(p.getfPVP() + " €");
		
		if(p.getiStockActual() == 0) {
			FrmDetalleProd.txtStock.setText("AGOTADO");
		}else if(p.getiStockActual() > 0 && p.getiStockActual() <= 5){
			FrmDetalleProd.txtStock.setText("QUEDAN POCAS UNIDADES");
		}else {
			FrmDetalleProd.txtStock.setText("EN STOCK");
		}
		
	}
	
	private Producto JsonToProductoDetalle(JSONObject jObj) {
		String sNombre = jObj.getString("NOMBRE");
		String sComents = jObj.getString("COMENTARIOS");
		float fPVP = jObj.getFloat("PVP");
		int iStockActual = jObj.getInt("STOCK_ACTUAL");
		
		Producto p = new Producto(sNombre, sComents, fPVP, iStockActual);
		
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
			tProd.txtNumeracion.setText(i +"");
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
