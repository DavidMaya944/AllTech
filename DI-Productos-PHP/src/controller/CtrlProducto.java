package controller;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import logic.LogicaProductos;
import model.Producto;
import view.FrmDetalleProd;

public class CtrlProducto {
	private static int iId;
	public static LogicaProductos log = new LogicaProductos();
	
	private static File archivo;

	
	public static void tableRowSelected() {
		new view.FrmDetalleProd();

	}

	public static void loadData() {
		try {
			List<Producto> resultado = LogicaProductos.leer();
			DefaultTableModel modelo = LogicaProductos.generarTablaProducto(resultado);
			view.FrmGestionProductos.tblResult.setModel(modelo);
		} catch (Exception e) {
			System.err.println("Fallo: " + e.getMessage());
			e.getStackTrace();
		}
	}
	
	
	
	public static void loadDataProd() {
		iId = Integer.parseInt(view.FrmGestionProductos.tblResult.getValueAt(view.FrmGestionProductos.tblResult.getSelectedRow(), 0).toString());
		try {
			Producto p = LogicaProductos.leerProd(iId);
			FrmDetalleProd.txtCod.setText("" + p.getiCod());
			FrmDetalleProd.txtNombre.setText(p.getsNombre());
			if (p.getiOpcion() == 1) {
				FrmDetalleProd.rdbtnPack.setSelected(true);
			} else if (p.getiOpcion() == 2) {
				FrmDetalleProd.rdbtnUnidad.setSelected(true);
			} else if (p.getiOpcion() == 3) {
				FrmDetalleProd.rdbtnCombinado.setSelected(true);
			} else {
				System.out.println("Opcion invalida");
			}
			FrmDetalleProd.textComents.setText(p.getsComents());
			FrmDetalleProd.checkFragil.setSelected(p.isbFragil());
			FrmDetalleProd.checkObsoleto.setSelected(p.isbObsoleto());
			FrmDetalleProd.txtStockActual.setText("" + p.getiStockActual());
			FrmDetalleProd.txtStockMin.setText("" + p.getiStockMin());
			FrmDetalleProd.txtStockMax.setText("" + p.getiStockMax());
			FrmDetalleProd.cmbProveedor.setSelectedItem(p.getsProveedor());
			FrmDetalleProd.txtPVP.setText("" + p.getfPVP());
			log.downloadImgProd(p.getiCod());
		}catch(Exception e) {
			System.err.println("Se ha producido un fallo: " + e.getMessage());
			e.getStackTrace();
		}
	}
	
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
	
	
	public static void seleccionarFichero() {
		JFileChooser selectorArchivo = new JFileChooser();
		selectorArchivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		selectorArchivo.showOpenDialog(null);
		try {
			archivo = selectorArchivo.getSelectedFile();
			Image image = ImageIO.read(archivo);
			view.FrmDetalleProd.lblFoto.setIcon(new ImageIcon(image));
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	public static void insertProd() {
		
		if(view.FrmDetalleProd.lblFoto.getIcon() == null) {
			JOptionPane.showMessageDialog(null, "Debes indicar un nombre de imagen", "FALLO", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try {
			String filePath = archivo.getAbsolutePath();
			String sNombre = view.FrmGestionProductos.txtNombre.getText().toStrinig();
			Integer iCantidad = view.FrmGestionProductos.txtCantidad.getText().toStrinig();
			Integer iPrecio = view.FrmGestionProductos.txtPrecio.getText().toStrinig();
			Producto p = new Producto(sNombre, iCantidad,iPrecio);
			
			logic.LogicaProductos.ins-producto(filePath, p);
			
			JOptionPane.showMessageDialog(null, "La imagen ha sido subida correctamente", "UPLOAD", JOptionPane..INFORMATION_MESSAGE);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No ha podido insertar la imagen", "UPLOAD", JOptionPane.ERROR_MESSAGE);
			
			//JOptionPane.showMessageDialog(null, e.getMessage(), "UPLOAD", JOptionPane.ERROR_MESSAGE);
		}
	}


	public void mostrar(Producto p) {
		FrmDetalleProd.txtCod.setText("" + p.getiCod());
		FrmDetalleProd.txtNombre.setText(p.getsNombre());
		if (p.getiOpcion() == 1) {
			FrmDetalleProd.rdbtnPack.setSelected(true);
		} else if (p.getiOpcion() == 2) {
			FrmDetalleProd.rdbtnUnidad.setSelected(true);
		} else if (p.getiOpcion() == 3) {
			FrmDetalleProd.rdbtnCombinado.setSelected(true);
		} else {
			System.out.println("Opcion invalida");
		}
		FrmDetalleProd.textComents.setText(p.getsComents());
		FrmDetalleProd.checkFragil.setSelected(p.isbFragil());
		FrmDetalleProd.checkObsoleto.setSelected(p.isbObsoleto());
		FrmDetalleProd.txtStockActual.setText("" + p.getiStockActual());
		FrmDetalleProd.txtStockMin.setText("" + p.getiStockMin());
		FrmDetalleProd.txtStockMax.setText("" + p.getiStockMax());
		FrmDetalleProd.cmbProveedor.setSelectedItem(p.getsProveedor());
		FrmDetalleProd.txtPVP.setText("" + p.getfPVP());
	}
	
	public void confirmarBorrar(FrmDetalleProd frame) {
		log.confirmarBorrar(frame);
	}
	
	public void guardarProducto() {
		log.guardarProducto();
	}



}
