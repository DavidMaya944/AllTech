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

	public FrmCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		txtUser.setBounds(96, 22, 137, 20);
		panelCentral.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setBounds(30, 74, 74, 14);
		panelCentral.add(lblPassword);
		setResizable(false);
		setVisible(true);
	}
}
