package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Button;
import javax.swing.JButton;

public class FrmGestionUsuario extends JFrame {

	private JPanel contentPane;
	private JLabel lblID;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtUser;
	private JTextField txtPass;
	private ButtonGroup bgSexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmGestionUsuario frame = new FrmGestionUsuario();
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
		txtID.setBounds(67, 29, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 63, 46, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setBounds(67, 60, 110, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 94, 46, 14);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setEnabled(false);
		txtApellidos.setBounds(67, 91, 110, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 129, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setBounds(67, 126, 155, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 160, 46, 14);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setBounds(67, 157, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(10, 195, 46, 14);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setBounds(67, 192, 263, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBounds(352, 32, 46, 14);
		contentPane.add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setEnabled(false);
		txtUser.setBounds(422, 29, 119, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setBounds(352, 63, 63, 14);
		contentPane.add(lblPass);
		
		txtPass = new JTextField();
		txtPass.setEnabled(false);
		txtPass.setBounds(422, 60, 119, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setEnabled(false);
		rdbtnHombre.setBounds(422, 108, 109, 23);
		contentPane.add(rdbtnHombre);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(352, 112, 46, 14);
		contentPane.add(lblSexo);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setEnabled(false);
		rdbtnMujer.setBounds(422, 129, 109, 23);
		contentPane.add(rdbtnMujer);
		
		bgSexo = new ButtonGroup();
		bgSexo.add(rdbtnHombre);
		bgSexo.add(rdbtnMujer);
		
		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.setBounds(493, 263, 89, 23);
		contentPane.add(btnRechazar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(394, 263, 89, 23);
		contentPane.add(btnAceptar);
	}
}
