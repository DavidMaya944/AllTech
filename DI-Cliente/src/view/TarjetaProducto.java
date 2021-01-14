package view;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.CtrlProductos;
import logic.LogicaProd;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TarjetaProducto extends JPanel {
	private static final long serialVersionUID = 1L;
	public static JTextField txtNombre;
	public static JTextField txtPVP;
	public static JTextArea textDescrip;
	private LogicaProd logProd = new LogicaProd();
	public TarjetaProducto() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FrmDetalleProd(logProd.leer(txtNombre));
				
			}
		});
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

	}
}
