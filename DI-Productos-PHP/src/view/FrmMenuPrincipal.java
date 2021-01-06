package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrmMenuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private FrmMenuPrincipal frame;

	public FrmMenuPrincipal() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 254, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEncabezado = new JLabel("Bienvenido. \u00BFQu\u00E9 desea gestionar?");
		lblEncabezado.setBounds(33, 11, 195, 14);
		contentPane.add(lblEncabezado);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmGestionUsuario();
			}
		});
		btnUsuarios.setBounds(72, 45, 89, 23);
		contentPane.add(btnUsuarios);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmGestionProductos();
			}
		});
		btnProductos.setBounds(72, 79, 89, 23);
		contentPane.add(btnProductos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(72, 113, 89, 23);
		contentPane.add(btnSalir);
		setVisible(true);
	}
}
