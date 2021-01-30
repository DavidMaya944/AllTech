package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class FrmGestionProductos extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tblResult;
	public static FrmGestionProductos frame;
	private JButton btnVolver;
	
	public FrmGestionProductos() {
		setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon/cesta.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				new FrmMenuPrincipal();
			}
		});
		setTitle("Gesti\u00F3n de Productos");
		createForm();
		controller.CtrlProducto.loadData();
		setVisible(true);
	}

	public void createForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane panelDat = new JScrollPane();
		contentPane.add(panelDat, BorderLayout.CENTER);
		
		tblResult = new JTable();
		tblResult.setBackground(new Color(0, 255, 255));
		tblResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.CtrlProducto.tableRowSelected();
			}
		});
		panelDat.setViewportView(tblResult);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setBackground(new Color(46, 139, 87));
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
