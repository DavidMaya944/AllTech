package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Control;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRegistro extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txtNombre;
	public static JTextField txtApellidos;
	public static JTextField txtEmail;
	public static JTextField txtDireccion;
	public static JTextField txtTelefono;
	public static JTextField txtUsuario;
	public static JPasswordField txtPassword;
	private Control ctrl = new Control();
	public static FrmRegistro frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FrmRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRegistro() {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 32, 46, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(71, 29, 110, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 64, 63, 14);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(71, 60, 110, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 94, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(71, 91, 110, 20);
		txtEmail.getText().contains("@");
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(10, 153, 78, 14);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(71, 150, 144, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 125, 63, 14);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(71, 122, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(225, 35, 46, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(301, 32, 110, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setBounds(225, 67, 86, 14);
		contentPane.add(lblPassword);
		
		JButton btnCompletar = new JButton("Completar");
		btnCompletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.guardarUsuario();
			}
		});
		btnCompletar.setBounds(201, 227, 110, 23);
		contentPane.add(btnCompletar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(322, 227, 89, 23);
		contentPane.add(btnCancelar);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(301, 64, 110, 20);
		contentPane.add(txtPassword);
	}
}
