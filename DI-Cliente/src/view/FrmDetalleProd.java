package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class FrmDetalleProd extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtPVP;
	private JTextField txtStock;

	public FrmDetalleProd() {
		setTitle("Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(149, 38, 131, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JTextArea txtDescrip = new JTextArea();
		txtDescrip.setRows(3);
		txtDescrip.setBounds(149, 68, 131, 58);
		contentPane.add(txtDescrip);
		
		JPanel panelImage = new JPanel();
		panelImage.setBounds(26, 38, 96, 88);
		contentPane.add(panelImage);
		
		txtPVP = new JTextField();
		txtPVP.setBounds(338, 106, 86, 20);
		contentPane.add(txtPVP);
		txtPVP.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(338, 70, 105, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		JButton btnCancel = new JButton("CANCELAR");
		btnCancel.setBounds(360, 160, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnAniadir = new JButton("A\u00D1ADIR");
		btnAniadir.setBounds(264, 160, 86, 23);
		contentPane.add(btnAniadir);
		
		setVisible(true);
	}
}
