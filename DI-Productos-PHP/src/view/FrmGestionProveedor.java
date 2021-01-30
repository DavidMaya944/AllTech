package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmGestionProveedor extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tableProv;

	
	public FrmGestionProveedor() {
		setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		setTitle("Gesti\u00F3n de proveedores");
		createForm();
		controller.CtrlProveedor.loadData();
		setVisible(true);
	}

	public void createForm() {
		setBackground(new Color(0, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmMenuPrincipal();
				dispose();
			}
		});
		btnVolver.setBackground(new Color(46, 139, 87));
		btnVolver.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		contentPane.add(btnVolver, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tableProv = new JTable();
		tableProv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.CtrlProveedor.tableRowSelected();
			}
		});
		tableProv.setBackground(new Color(0, 255, 255));
		tableProv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(tableProv);
	}

}
