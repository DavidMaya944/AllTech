package controller;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import logic.LogicaProductos;
import model.Producto;
import view.FrmDetalleProd;

public class CtrlProducto {
	private static int iId;
	
	public static File archivo;

	public static void tableRowSelected() {
		new view.FrmDetalleProd();

	}
	
	public static void generarGraficBarra() {
		view.GraphicProd.dataBar = new DefaultCategoryDataset();
		for(Producto p : LogicaProductos.lProductos) {
			view.GraphicProd.dataBar.setValue(p.getiStockActual(), p.getsNombre(), "STOCK ACTUAL");
		}
		
		view.GraphicProd.chart = ChartFactory.createBarChart("STOCK", "PRODUCTOS", "CANTIDAD", view.GraphicProd.dataBar, PlotOrientation.VERTICAL, true, false, false);
		view.GraphicProd.contentPanel.setLayout(new BorderLayout(0, 0));
		
		view.GraphicProd.panelChart = new ChartPanel(view.GraphicProd.chart);
		
		view.GraphicProd.panelChart.setBounds(300, 100, 100, 200);
		
		view.GraphicProd.contentPanel.add(view.GraphicProd.panelChart);
	}

	public static void loadData() {
		try {
			List<Producto> resultado = LogicaProductos.leer();
			DefaultTableModel modelo = LogicaProductos.generarTablaProducto(resultado);
			view.FrmGestionProductos.tblResult.setModel(modelo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido cargar los datos", "Cargar datos", JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "Opcion inválida", "Opcion", JOptionPane.ERROR_MESSAGE);
			}
			FrmDetalleProd.textComents.setText(p.getsComents());
			FrmDetalleProd.checkFragil.setSelected(p.isbFragil());
			FrmDetalleProd.checkObsoleto.setSelected(p.isbObsoleto());
			FrmDetalleProd.txtStockActual.setText("" + p.getiStockActual());
			FrmDetalleProd.txtStockMin.setText("" + p.getiStockMin());
			FrmDetalleProd.txtStockMax.setText("" + p.getiStockMax());
			FrmDetalleProd.cmbProveedor.setSelectedItem(p.getsProveedor());
			FrmDetalleProd.txtPVP.setText("" + p.getfPVP());
			LogicaProductos.downloadImgProd(p.getiCod());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido cargar los datos", "Cargar datos", JOptionPane.ERROR_MESSAGE);
		}
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
			JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún fichero", "Seleccion de fichero", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void insertProd() {
		
		if(view.FrmDetalleProd.lblFoto.getIcon() == null) {
			JOptionPane.showMessageDialog(null, "Debes indicar un nombre de imagen", "FALLO", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int iCod; 
		try {
			iCod = Integer.parseInt(view.FrmDetalleProd.txtCod.getText());
		}catch (Exception e) {
			iCod = -1;
		}
		
		try {
			String filePath = archivo.getAbsolutePath();
			String sNombre = view.FrmDetalleProd.txtNombre.getText().replaceAll(" ", "%20");
			int iOpcion = LogicaProductos.validarOpcion();
			String sComents = view.FrmDetalleProd.textComents.getText().replaceAll(" ", "%20");
			boolean bFragil = view.FrmDetalleProd.checkFragil.isSelected();
			boolean bObsoleto = view.FrmDetalleProd.checkObsoleto.isSelected();
			int iStockActual = 0, iStockMin = 0, iStockMax = 0;

			if (LogicaProductos.validarStock(view.FrmDetalleProd.txtStockActual, view.FrmDetalleProd.txtStockMin, view.FrmDetalleProd.txtStockMax) == true) {
				iStockActual = Integer.parseInt(view.FrmDetalleProd.txtStockActual.getText());
				iStockMin = Integer.parseInt(view.FrmDetalleProd.txtStockMin.getText());
				iStockMax = Integer.parseInt(view.FrmDetalleProd.txtStockMax.getText());
			}
			
			String sProveedor = (String) view.FrmDetalleProd.cmbProveedor.getSelectedItem();
			float fPVP = 0;
			if(LogicaProductos.validarPrecio(view.FrmDetalleProd.txtPVP) == true) {
				fPVP = Float.parseFloat(view.FrmDetalleProd.txtPVP.getText());
			}
			Producto p = new Producto(sNombre, iOpcion, sComents, bFragil, bObsoleto, iStockActual, iStockMin, iStockMax, sProveedor, fPVP);
			if(iCod != -1 ) {
				logic.LogicaProductos.updateProducto(filePath, p);
			}else {
				logic.LogicaProductos.insertProducto(filePath, p);
			}
			
			
			JOptionPane.showMessageDialog(null, "El producto ha sido registrado con exito", "UPLOAD", JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No ha podido insertar el producto", "UPLOAD", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "Opcion inválida", "Opcion", JOptionPane.ERROR_MESSAGE);
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
	
	public void confirmarBorrar(JDialog frame) {
		LogicaProductos.confirmarBorrar(frame);
	}

//	public static void subirImagen() {
//		LogicaProductos.uploadImage();
//	}
}
