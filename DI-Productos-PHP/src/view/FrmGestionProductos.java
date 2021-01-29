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
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import java.awt.Font;

public class FrmGestionProductos extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tblResult;
	private JMenuItem mnLogOut;
	public static FrmGestionProductos frame;
	
	public FrmGestionProductos() {
		setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon/cesta.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				controller.CtrlProducto.confirmarExit(frame);
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane panelDat = new JScrollPane();
		contentPane.add(panelDat, BorderLayout.CENTER);
		
		tblResult = new JTable();
		tblResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.CtrlProducto.tableRowSelected();
			}
		});
		panelDat.setViewportView(tblResult);
		
		mnLogOut = new JMenuItem("Cerrar Sesion");
		mnLogOut.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		mnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.CtrlProducto.confirmarLogOut(frame);
				dispose();
			}
		});
		contentPane.add(mnLogOut, BorderLayout.NORTH);
	}

}
