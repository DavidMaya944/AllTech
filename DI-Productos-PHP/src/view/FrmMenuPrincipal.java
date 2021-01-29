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

public class FrmMenuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	public FrmMenuPrincipal() {
		setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon/main.png"));
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
		lblEncabezado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEncabezado.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblEncabezado.setBounds(0, 11, 248, 14);
		contentPane.add(lblEncabezado);
		
		JButton btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new FrmGestionUsuarios();
				
			}
		});
		btnUsuarios.setBounds(60, 47, 117, 23);
		contentPane.add(btnUsuarios);
		
		JButton btnProductos = new JButton("PRODUCTOS");
		btnProductos.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new FrmGestionProductos();
			}
		});
		btnProductos.setBounds(60, 81, 117, 23);
		contentPane.add(btnProductos);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
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
