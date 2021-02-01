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
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class FrmMenuPrincipal {
	private JPanel contentPane;
	public static JFrame frame;
	
	public FrmMenuPrincipal() {
		frame = new JFrame();
		crearVista();
	}
	
	public void crearVista() {
		frame.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon/main.png"));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				controller.CtrlGeneral.confirmarLogOut(frame);
			}
		});
		frame.setTitle("Menu Principal");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 344, 278);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEncabezado = new JLabel("Bienvenido. \u00BFQu\u00E9 desea gestionar?");
		lblEncabezado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEncabezado.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblEncabezado.setBounds(46, 27, 248, 14);
		contentPane.add(lblEncabezado);
		
		JButton btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.setBackground(new Color(46, 139, 87));
		btnUsuarios.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmGestionUsuarios();
				frame.dispose();
				
			}
		});
		btnUsuarios.setBounds(100, 63, 141, 23);
		contentPane.add(btnUsuarios);
		
		JButton btnProductos = new JButton("PRODUCTOS");
		btnProductos.setBackground(new Color(46, 139, 87));
		btnProductos.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmGestionProductos();
				frame.dispose();
			}
		});
		btnProductos.setBounds(100, 97, 141, 23);
		contentPane.add(btnProductos);
		
		JButton btnLogOut = new JButton("CERRAR SESION");
		btnLogOut.setBackground(new Color(46, 139, 87));
		btnLogOut.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.CtrlGeneral.confirmarLogOut(frame);
			}
		});
		btnLogOut.setBounds(100, 165, 141, 23);
		contentPane.add(btnLogOut);
		
		JButton btnProveedor = new JButton("PROVEEDORES");
		btnProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmGestionProveedor();
				frame.dispose();
			}
		});
		btnProveedor.setBackground(new Color(46, 139, 87));
		btnProveedor.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnProveedor.setBounds(100, 131, 141, 23);
		contentPane.add(btnProveedor);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
