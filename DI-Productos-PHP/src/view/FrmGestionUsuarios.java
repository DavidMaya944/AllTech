package view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class FrmGestionUsuarios extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tableUsers;
	private JButton btnVolver;
	
	public FrmGestionUsuarios() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				new FrmMenuPrincipal();
			}
		});
		setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon/users-gest.png"));
		setTitle("Gestion de Usuarios");
		createForm();
		controller.CtrlUsuario.loadData();
		setVisible(true);
	}
	
	
	public void createForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scList = new JScrollPane();
		contentPane.add(scList, BorderLayout.CENTER);
		
		tableUsers = new JTable();
		tableUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FrmDetalleUsuario();
			}
		});
		scList.setViewportView(tableUsers);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setBackground(new Color(25, 25, 112));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new FrmMenuPrincipal();
			}
		});
		btnVolver.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		contentPane.add(btnVolver, BorderLayout.SOUTH);
	}

}
