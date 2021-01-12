package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Control;

import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FrmCuenta extends JFrame {

	private JPanel contentPane;
	public static JTextField txtUser;
	public static JTextField txtNombre;
	public static JTextField txtApellidos;
	public static JTextField txtTelefono;
	public static JTextField txtDireccion;
	public static JTextField txtEmail;
	public static JTextField txtID;
	public static JPasswordField txtPass;
	private Control ctrl = new Control();

	public FrmCuenta() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				new FrmTienda();
			}
		});
		setTitle("Cuenta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 368, 549);
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
		lblUser.setBounds(31, 80, 78, 14);
		panelCentral.add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setBounds(114, 74, 137, 20);
		panelCentral.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setBounds(31, 129, 74, 14);
		panelCentral.add(lblPassword);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(31, 180, 74, 14);
		panelCentral.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(114, 174, 137, 20);
		panelCentral.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(31, 234, 74, 14);
		panelCentral.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(114, 228, 137, 20);
		panelCentral.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(31, 289, 46, 14);
		panelCentral.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(114, 283, 98, 20);
		panelCentral.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(31, 346, 46, 14);
		panelCentral.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(114, 340, 209, 20);
		panelCentral.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.actualizarUsuario();
				dispose();
				new UpdateExito();
			}
		});
		btnConfirmar.setBounds(52, 465, 89, 23);
		panelCentral.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(207, 465, 89, 23);
		panelCentral.add(btnCancelar);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(31, 401, 46, 14);
		panelCentral.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setBounds(114, 395, 137, 20);
		panelCentral.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblID = new JLabel("N\u00BA Usuario");
		lblID.setBounds(31, 41, 78, 14);
		panelCentral.add(lblID);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(114, 38, 86, 20);
		panelCentral.add(txtID);
		txtID.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(114, 126, 137, 20);
		panelCentral.add(txtPass);
		setResizable(false);
		setVisible(true);
	}
}
