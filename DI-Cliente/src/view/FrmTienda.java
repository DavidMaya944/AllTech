package view;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlProductos;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmTienda extends JFrame {
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JPanel panelList;
	private CtrlProductos ctrlProd = new CtrlProductos();

	public FrmTienda() {
		setTitle("(Nombre de tienda)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 900);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAjustes = new JMenu("Ajustes");
		menuBar.add(mnAjustes);
		
		JMenuItem mntmCuenta = new JMenuItem("Cuenta");
		mntmCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FrmCuenta();
			}
		});
		mnAjustes.add(mntmCuenta);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mnAjustes.add(mntmAcercaDe);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mnAjustes.add(mntmAyuda);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar sesi\u00F3n");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FrmMenuPrincipal();
			}
		});
		mnAjustes.add(mntmCerrarSesion);
		
		JMenu mnCompra = new JMenu("Compra");
		menuBar.add(mnCompra);
		
		JMenuItem mntmCesta = new JMenuItem("Cesta");
		mnCompra.add(mntmCesta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		panelList = new JPanel();
		scrollPane.setViewportView(panelList);
		panelList.setLayout(new BoxLayout(panelList, BoxLayout.Y_AXIS));
		ctrlProd.llenarLista();
		setResizable(false);
		setVisible(true);
	}

}
