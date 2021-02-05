package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
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

import controller.CtrlLogin;
import logic.LogicaGeneral;

public class LoginAdmin {
	private final JPanel contentPanel = new JPanel();
	public static JTextField txtUser;
	public static JPasswordField txtPass;
	private CtrlLogin ctrlLogin = new CtrlLogin();
	public static JFrame frame;

	public LoginAdmin() {
		frame = new JFrame();
		crearVista();
	}
	
	public void crearVista() {
		frame.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon/usuario.png"));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				controller.CtrlGeneral.confirmarExit(frame);
			}
		});
		frame.setTitle("Login");
		frame.setBounds(100, 100, 243, 142);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblUser.setBounds(10, 11, 46, 14);
		contentPanel.add(lblUser);

		txtUser = new JTextField();
		txtUser.setText(LogicaGeneral.LOGINUSERNAME);
		txtUser.setBounds(95, 8, 122, 20);
		contentPanel.add(txtUser);
		txtUser.setColumns(10);

		JLabel lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblPass.setBounds(10, 46, 77, 14);
		contentPanel.add(lblPass);

		txtPass = new JPasswordField();
		txtPass.setText(LogicaGeneral.LOGINUSERPASS);
		txtPass.setBounds(95, 39, 122, 20);
		contentPanel.add(txtPass);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(0, 255, 255));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		frame.getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("iniciar sesion");
		okButton.setBackground(new Color(102, 205, 170));
		okButton.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		okButton.addActionListener(v -> {
			ctrlLogin.login();
			frame.dispose();
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		frame.getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Salir");
		cancelButton.setBackground(new Color(102, 205, 170));
		cancelButton.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.CtrlGeneral.confirmarExit(frame);
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
