package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.LogicaProd;
import model.Producto;

public class FrmDetalleProd extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txtNombre;
	public static JTextField txtPVP;
	public static JTextField txtStock;
	public static JTextArea txtDescrip;
	private LogicaProd logProd = new LogicaProd();

	public FrmDetalleProd(Producto p) {
		setTitle("Producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(149, 38, 199, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDescrip = new JTextArea();
		txtDescrip.setRows(3);
		txtDescrip.setBounds(149, 68, 179, 58);
		contentPane.add(txtDescrip);
		
		JPanel panelImage = new JPanel();
		panelImage.setBounds(26, 38, 96, 88);
		contentPane.add(panelImage);
		
		txtPVP = new JTextField();
		txtPVP.setBounds(407, 106, 86, 20);
		contentPane.add(txtPVP);
		txtPVP.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(338, 70, 155, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		JButton btnCancel = new JButton("CANCELAR");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(388, 160, 105, 23);
		contentPane.add(btnCancel);
		
		JButton btnAniadir = new JButton("A\u00D1ADIR");
		btnAniadir.setBounds(292, 160, 86, 23);
		contentPane.add(btnAniadir);
		setVisible(true);
		logProd.mostrar(p);
	}
}
