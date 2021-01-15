package view;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.CtrlProductos;
import logic.LogicaProd;
import model.Producto;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TarjetaProducto extends JPanel {
	private static final long serialVersionUID = 1L;
	public static JTextField txtNombre;
	public static JTextField txtPVP;
	public static JTextArea textDescrip;
	private LogicaProd logProd = new LogicaProd();
	private CtrlProductos ctrlProd = new CtrlProductos();
	public static int numeroTarjeta;
	public static JTextField txtNumeracion;
	public TarjetaProducto(Producto oProd) {
	
	
		setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setBounds(99, 41, 131, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		textDescrip = new JTextArea();
		textDescrip.setEnabled(false);
		textDescrip.setBounds(99, 72, 143, 38);
		add(textDescrip);
		
		txtPVP = new JTextField();
		txtPVP.setEnabled(false);
		txtPVP.setBounds(310, 90, 69, 20);
		add(txtPVP);
		txtPVP.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 27, 79, 83);
		add(panel);
		
		JSeparator separatorInf = new JSeparator();
		separatorInf.setForeground(Color.BLACK);
		separatorInf.setBounds(0, 147, 450, 2);
		add(separatorInf);
		
		JSeparator separatorSup = new JSeparator();
		separatorSup.setForeground(Color.BLACK);
		separatorSup.setBounds(0, 11, 450, 2);
		add(separatorSup);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ctrlProd.click_ver();
			}
		});
		btnVer.setBounds(311, 40, 69, 23);
		add(btnVer);
		
		txtNumeracion = new JTextField();
		txtNumeracion.setBounds(10, 116, 86, 20);
		add(txtNumeracion);
		txtNumeracion.setColumns(10);
		
		ctrlProd.cargarDatos(oProd);
		
	}
}
