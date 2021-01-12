package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrmCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField txtDireccion;

	public FrmCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 509);
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
		lblUser.setBounds(30, 25, 56, 14);
		panelCentral.add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setBounds(118, 22, 137, 20);
		panelCentral.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setBounds(30, 74, 74, 14);
		panelCentral.add(lblPassword);
		
		txtPass = new JTextField();
		txtPass.setBounds(118, 71, 137, 20);
		panelCentral.add(txtPass);
		txtPass.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(30, 119, 46, 14);
		panelCentral.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(118, 116, 137, 20);
		panelCentral.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblPhone = new JLabel("Telefono");
		lblPhone.setBounds(30, 163, 46, 14);
		panelCentral.add(lblPhone);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(118, 160, 137, 20);
		panelCentral.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(30, 209, 46, 14);
		panelCentral.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(118, 206, 168, 20);
		panelCentral.add(txtDireccion);
		txtDireccion.setColumns(10);
		setResizable(false);
		setVisible(true);
	}
}
