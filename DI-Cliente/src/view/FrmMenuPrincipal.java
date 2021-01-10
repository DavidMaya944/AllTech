package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmMenuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public FrmMenuPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Iniciar sesion");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new LoginUser();
			}
		});
		btnLogin.setBounds(71, 52, 124, 23);
		contentPane.add(btnLogin);
		
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new FrmRegistro();
			}
		});
		btnRegistro.setBounds(71, 85, 124, 23);
		contentPane.add(btnRegistro);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(91, 119, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblHead = new JLabel("\u00A1Bienvenido a nuestra macro tienda!");
		lblHead.setBounds(41, 22, 193, 14);
		contentPane.add(lblHead);
		setResizable(false);
		setVisible(true);
	}
}
