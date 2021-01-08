package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmMenuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	public FrmMenuPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 254, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEncabezado = new JLabel("Bienvenido. \u00BFQu\u00E9 desea gestionar?");
		lblEncabezado.setBounds(33, 11, 195, 14);
		contentPane.add(lblEncabezado);
		
		JButton btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new FrmGestionUsuario();
				
			}
		});
		btnUsuarios.setBounds(60, 47, 117, 23);
		contentPane.add(btnUsuarios);
		
		JButton btnProductos = new JButton("PRODUCTOS");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new FrmGestionProductos();
			}
		});
		btnProductos.setBounds(60, 81, 117, 23);
		contentPane.add(btnProductos);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(60, 115, 117, 23);
		contentPane.add(btnSalir);
		setResizable(false);
		setVisible(true);
	}
}
