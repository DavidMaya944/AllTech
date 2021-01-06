package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CtrlUsuario;
import logic.LogicaUsuarios;
import model.Usuario;

import javax.swing.SwingConstants;

public class FrmGestionUsuario extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblID;
	public static JTextField txtID;
	public static JTextField txtNombre;
	public static JTextField txtApellidos;
	public static JTextField txtEmail;
	public static JTextField txtTelefono;
	public static JTextField txtDireccion;
	public static JTextField txtUser;
	public static JPasswordField txtPass;
	private JLabel lblPermiso;
	public static JTextField txtPermiso;
	private CtrlUsuario ctrlUser = new CtrlUsuario();
	public static FrmGestionUsuario frame;


	public FrmGestionUsuario() {
		setTitle("Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblID = new JLabel("ID");
		lblID.setBounds(10, 32, 46, 14);
		contentPane.add(lblID);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(77, 29, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 63, 71, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField(30);
		txtNombre.setEnabled(false);
		txtNombre.setBounds(77, 60, 110, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 94, 71, 14);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField(40);
		txtApellidos.setEnabled(false);
		txtApellidos.setBounds(77, 91, 110, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 129, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField(70);
		txtEmail.setEnabled(false);
		txtEmail.setBounds(77, 126, 155, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 160, 71, 14);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField(9);
		txtTelefono.setEnabled(false);
		txtTelefono.setBounds(77, 157, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(10, 195, 71, 14);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setBounds(77, 192, 263, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBounds(352, 32, 46, 14);
		contentPane.add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setEnabled(false);
		txtUser.setBounds(432, 29, 119, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setBounds(352, 63, 89, 14);
		contentPane.add(lblPass);
		
		
		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlUser.rechazarUsuario();
				ctrlUser.abrir();
			}
		});
		btnRechazar.setBounds(493, 263, 89, 23);
		contentPane.add(btnRechazar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlUser.confirmarUsuario();
				ctrlUser.abrir();
			}
		});
		btnAceptar.setBounds(394, 263, 89, 23);
		contentPane.add(btnAceptar);
		
		txtPass = new JPasswordField();
		txtPass.setEnabled(false);
		txtPass.setBounds(432, 60, 119, 20);
		contentPane.add(txtPass);
		
		lblPermiso = new JLabel("Permiso");
		lblPermiso.setBounds(352, 129, 70, 14);
		contentPane.add(lblPermiso);
		
		txtPermiso = new JTextField();
		txtPermiso.setEnabled(false);
		txtPermiso.setBounds(432, 126, 119, 20);
		contentPane.add(txtPermiso);
		txtPermiso.setColumns(10);
		
		JButton btnPrimero = new JButton("|<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlUser.inicioLista();
			}
		});
		btnPrimero.setBounds(10, 263, 46, 23);
		contentPane.add(btnPrimero);
		
		JButton bntAnterior = new JButton("<<");
		bntAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlUser.anterior();
			}
		});
		bntAnterior.setBounds(66, 263, 48, 23);
		contentPane.add(bntAnterior);
		
		JButton btnSiguiente = new JButton(">>");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlUser.siguiente();
			}
		});
		btnSiguiente.setBounds(124, 263, 48, 23);
		contentPane.add(btnSiguiente);
		
		JButton btnUltimo = new JButton(">|");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlUser.finLista();
			}
		});
		btnUltimo.setBounds(182, 263, 46, 23);
		contentPane.add(btnUltimo);
		ctrlUser.abrir();
		setVisible(true);
	}
}
