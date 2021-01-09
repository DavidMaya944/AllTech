package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FrmTienda extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public FrmTienda() {
		setTitle("(Nombre de tienda)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAjustes = new JMenu("Ajustes");
		menuBar.add(mnAjustes);
		
		JMenuItem mntmCuenta = new JMenuItem("Cuenta");
		mnAjustes.add(mntmCuenta);
		
		JMenuItem mntmLeyPriv = new JMenuItem("Ley de Privacidad");
		mnAjustes.add(mntmLeyPriv);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mnAjustes.add(mntmAcercaDe);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mnAjustes.add(mntmAyuda);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar sesi\u00F3n");
		mnAjustes.add(mntmCerrarSesion);
		
		JMenu mnCompra = new JMenu("Compra");
		menuBar.add(mnCompra);
		
		JMenuItem mntmCesta = new JMenuItem("Cesta");
		mnCompra.add(mntmCesta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		setVisible(true);
	}

}
