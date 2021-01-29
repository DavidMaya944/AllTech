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

public class FrmGestionUsuarios extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tableUsers;
	
	public FrmGestionUsuarios() {
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
	}

}
