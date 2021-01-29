package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CtrlUsuario;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class FrmDetalleUsuario extends JFrame {
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
	public static FrmDetalleUsuario frame;
	public static JButton btnBlock;
	public static JButton btnUnBlock;
	private JPanel panel;
	private JLabel lblFoto;

	
	public FrmDetalleUsuario() {
		setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon/users-gest.png"));
		createForm();
		controller.CtrlUsuario.loadDataUser();
		setVisible(true);
	}

	public void createForm() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setTitle("Usuarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 635, 352);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblID = new JLabel("ID");
		lblID.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblID.setBounds(10, 32, 46, 14);
		contentPane.add(lblID);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(77, 29, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNombre.setBounds(10, 63, 71, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField(30);
		txtNombre.setEnabled(false);
		txtNombre.setBounds(77, 60, 110, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblApellidos.setBounds(10, 94, 71, 14);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField(40);
		txtApellidos.setEnabled(false);
		txtApellidos.setBounds(77, 91, 110, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblEmail.setBounds(10, 129, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField(70);
		txtEmail.setEnabled(false);
		txtEmail.setBounds(77, 126, 155, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblTelefono.setBounds(10, 160, 71, 14);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField(9);
		txtTelefono.setEnabled(false);
		txtTelefono.setBounds(77, 157, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblDireccion.setBounds(10, 195, 71, 14);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setBounds(77, 192, 248, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblUser.setBounds(394, 32, 46, 14);
		contentPane.add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setEnabled(false);
		txtUser.setBounds(479, 32, 119, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblPass.setBounds(394, 63, 89, 14);
		contentPane.add(lblPass);
		
		
		JButton btnRechazar = new JButton("RECHAZAR");
		btnRechazar.setBackground(new Color(46, 139, 87));
		btnRechazar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnRechazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlUser.rechazarUsuario(frame);
				controller.CtrlUsuario.loadData();
			}
		});
		btnRechazar.setBounds(498, 263, 100, 23);
		contentPane.add(btnRechazar);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBackground(new Color(46, 139, 87));
		btnAceptar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrlUser.confirmarUsuario();
				controller.CtrlUsuario.loadData();
			}
		});
		btnAceptar.setBounds(399, 263, 89, 23);
		contentPane.add(btnAceptar);
		
		txtPass = new JPasswordField();
		txtPass.setEnabled(false);
		txtPass.setBounds(479, 63, 119, 20);
		contentPane.add(txtPass);
		
		lblPermiso = new JLabel("Permiso");
		lblPermiso.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblPermiso.setBounds(394, 107, 70, 14);
		contentPane.add(lblPermiso);
		
		txtPermiso = new JTextField();
		txtPermiso.setEnabled(false);
		txtPermiso.setBounds(479, 107, 119, 20);
		contentPane.add(txtPermiso);
		txtPermiso.setColumns(10);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBackground(new Color(46, 139, 87));
		btnVolver.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new FrmMenuPrincipal();
			}
		});
		btnVolver.setBounds(300, 263, 89, 23);
		contentPane.add(btnVolver);
		
		btnBlock = new JButton("BLOQUEAR");
		btnBlock.setBackground(new Color(46, 139, 87));
		btnBlock.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.CtrlUsuario.bloquearUsuario();
				controller.CtrlUsuario.loadData();
				dispose();
			}
		});
		btnBlock.setBounds(10, 263, 100, 23);
		contentPane.add(btnBlock);
		
		btnUnBlock = new JButton("DESBLOQUEAR");
		btnUnBlock.setBackground(new Color(46, 139, 87));
		btnUnBlock.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnUnBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.CtrlUsuario.desbloquearUsuario();
				controller.CtrlUsuario.loadData();
				dispose();
			}
		});
		btnUnBlock.setBounds(120, 263, 134, 23);
		contentPane.add(btnUnBlock);
		
		panel = new JPanel();
		panel.setBounds(512, 140, 86, 87);
		contentPane.add(panel);
		
		lblFoto = new JLabel("Foto:");
		lblFoto.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblFoto.setBounds(394, 173, 46, 14);
		contentPane.add(lblFoto);
		
	}
}
