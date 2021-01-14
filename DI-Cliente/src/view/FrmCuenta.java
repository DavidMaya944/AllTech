package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Control;

public class FrmCuenta extends JFrame {
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JTextField txtUser;
	public static JTextField txtNombre;
	public static JTextField txtApellidos;
	public static JTextField txtTelefono;
	public static JTextField txtDireccion;
	public static JTextField txtEmail;
	public static JPasswordField txtPass;
	private Control ctrl = new Control();

	public FrmCuenta() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setTitle("Cuenta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 368, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panelCentral = new JPanel();
		scrollPane.setViewportView(panelCentral);
		panelCentral.setLayout(null);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBounds(31, 27, 78, 14);
		panelCentral.add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setBounds(119, 24, 137, 20);
		panelCentral.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setBounds(31, 79, 74, 14);
		panelCentral.add(lblPassword);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(31, 130, 74, 14);
		panelCentral.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(119, 124, 137, 20);
		panelCentral.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(31, 184, 74, 14);
		panelCentral.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(119, 178, 137, 20);
		panelCentral.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(31, 239, 74, 14);
		panelCentral.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(119, 233, 98, 20);
		panelCentral.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(31, 296, 78, 14);
		panelCentral.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(119, 290, 209, 20);
		panelCentral.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ctrl.actualizarUsuario();
				new FrmTienda();
			}
		});
		btnConfirmar.setBounds(40, 409, 104, 23);
		panelCentral.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FrmTienda();
			}
		});
		btnCancelar.setBounds(205, 409, 104, 23);
		panelCentral.add(btnCancelar);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(31, 351, 46, 14);
		panelCentral.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setBounds(119, 345, 209, 20);
		panelCentral.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(119, 76, 137, 20);
		panelCentral.add(txtPass);
		ctrl.abrirUserName();
		setResizable(false);
		setVisible(true);
	}
}
