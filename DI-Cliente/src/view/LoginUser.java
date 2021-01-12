package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

public class LoginUser extends JFrame {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JTextField txtUser;
	public static JPasswordField txtPass;
	private CtrlLogin ctrlLogin = new CtrlLogin();

	public LoginUser() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setTitle("Login");
		setBounds(100, 100, 243, 142);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBounds(10, 11, 46, 14);
		contentPanel.add(lblUser);

		txtUser = new JTextField();
		txtUser.setBounds(95, 8, 122, 20);
		contentPanel.add(txtUser);
		txtUser.setColumns(10);

		JLabel lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setBounds(10, 46, 77, 14);
		contentPanel.add(lblPass);

		txtPass = new JPasswordField();
		txtPass.setBounds(95, 39, 122, 20);
		contentPanel.add(txtPass);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("iniciar sesion");
		okButton.addActionListener(v -> {
			if (ctrlLogin.login() == true) {
				dispose();
				new FrmTienda();
				
			} else {
				System.out.println("Los datos introducidos no son validos.");
			}

		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new FrmMenuPrincipal();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		setResizable(false);
		setVisible(true);
	}
}
