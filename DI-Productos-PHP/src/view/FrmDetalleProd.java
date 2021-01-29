package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.CtrlProducto;
import logic.LogicaProductos;

public class FrmDetalleProd extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txtCod;
	public static JTextField txtNombre;
	public static JTextField txtStockActual;
	public static JTextField txtStockMin;
	public static JTextField txtStockMax;
	public static JTextField txtPVP;
	public static JRadioButton rdbtnPack;
	public static JRadioButton rdbtnUnidad;
	public static JRadioButton rdbtnCombinado;
	public static JCheckBox checkObsoleto;
	public static JCheckBox checkFragil;
	public static JTextArea textComents;
	public static JLabel lblFoto;
	@SuppressWarnings("rawtypes")
	public static JComboBox cmbProveedor;
	public static CtrlProducto ctrl = new CtrlProducto();
	public static LogicaProductos log = new LogicaProductos();
	public static FrmDetalleProd frame;
	public static final ButtonGroup btnOption = new ButtonGroup();

	public FrmDetalleProd() {
		createForm();
		controller.CtrlProducto.loadDataProd();
		setVisible(true);
	}
	
	
	@SuppressWarnings({ "rawtypes"})
	public void createForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon\\cesta.png"));
		setTitle("Detalle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 703, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(28, 34, 54, 14);
		contentPane.add(lblCodigo);

		txtCod = new JTextField();
		txtCod.setBounds(138, 31, 219, 20);
		txtCod.setEnabled(false);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(28, 65, 54, 14);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(138, 62, 219, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setBounds(28, 101, 46, 14);
		contentPane.add(lblGrupo);

		rdbtnPack = new JRadioButton("Pack");
		btnOption.add(rdbtnPack);
		rdbtnPack.setSelected(true);
		rdbtnPack.setBounds(138, 99, 72, 18);
		contentPane.add(rdbtnPack);

		rdbtnUnidad = new JRadioButton("Unidad");
		btnOption.add(rdbtnUnidad);
		rdbtnUnidad.setBounds(138, 120, 109, 23);
		contentPane.add(rdbtnUnidad);

		rdbtnCombinado = new JRadioButton("Combinado");
		btnOption.add(rdbtnCombinado);
		rdbtnCombinado.setBounds(138, 146, 109, 23);
		contentPane.add(rdbtnCombinado);

		JLabel lblComen = new JLabel("Comentarios:");
		lblComen.setBounds(28, 188, 101, 14);
		contentPane.add(lblComen);

		JScrollPane spComents = new JScrollPane();
		spComents.setBounds(139, 182, 218, 78);
		contentPane.add(spComents);

		textComents = new JTextArea();
		textComents.setTabSize(15);
		textComents.setSize(140, 100);
		spComents.setViewportView(textComents);

		JLabel lblOtro = new JLabel("Otro: ");
		lblOtro.setBounds(28, 281, 46, 14);
		contentPane.add(lblOtro);

		checkFragil = new JCheckBox("es fr\u00E1gil");
		checkFragil.setBounds(137, 277, 97, 23);
		contentPane.add(checkFragil);

		checkObsoleto = new JCheckBox("Obsoleto");
		checkObsoleto.setBounds(236, 277, 97, 23);
		contentPane.add(checkObsoleto);

		JLabel lblStockActual = new JLabel("Stock Actual: ");
		lblStockActual.setBounds(446, 34, 78, 14);
		contentPane.add(lblStockActual);

		txtStockActual = new JTextField();
		txtStockActual.setBounds(568, 31, 86, 20);
		contentPane.add(txtStockActual);
		txtStockActual.setColumns(10);

		JLabel lblStockMin = new JLabel("Stock minimo: ");
		lblStockMin.setBounds(446, 65, 97, 14);
		contentPane.add(lblStockMin);

		txtStockMin = new JTextField();
		txtStockMin.setBounds(568, 62, 86, 20);
		contentPane.add(txtStockMin);
		txtStockMin.setColumns(10);

		JLabel lblStockMax = new JLabel("Stock maximo: ");
		lblStockMax.setBounds(446, 101, 97, 14);
		contentPane.add(lblStockMax);

		txtStockMax = new JTextField();
		txtStockMax.setBounds(568, 98, 86, 20);
		contentPane.add(txtStockMax);
		txtStockMax.setColumns(10);

		JLabel lblProveedor = new JLabel("Proveedor: ");
		lblProveedor.setBounds(446, 133, 78, 14);
		contentPane.add(lblProveedor);

		cmbProveedor = new JComboBox();
		controller.CtrlProveedor.llenarLista();
		cmbProveedor.setBounds(568, 129, 86, 22);
		contentPane.add(cmbProveedor);

		JLabel lblPVP = new JLabel("PVP: ");
		lblPVP.setBounds(446, 281, 46, 14);
		contentPane.add(lblPVP);

		txtPVP = new JTextField();
		txtPVP.setBounds(568, 278, 86, 20);
		contentPane.add(txtPVP);
		txtPVP.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 330, 687, 2);
		contentPane.add(separator);

		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtCod.setText("");
				txtCod.setEnabled(false);
				lblFoto.setIcon(null);
				txtNombre.setText("");
				textComents.setText("");
				checkFragil.setSelected(false);
				checkObsoleto.setSelected(false);
				txtStockActual.setText("");
				txtStockMin.setText("");
				txtStockMax.setText("");
				cmbProveedor.setSelectedIndex(0);
				txtPVP.setText("");
			}
		});
		btnNuevo.setBounds(588, 343, 89, 23);
		contentPane.add(btnNuevo);

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CtrlProducto.insertProd();
				controller.CtrlProducto.loadData();
				dispose();
				
			}
		});
		btnGuardar.setBounds(481, 343, 97, 23);
		contentPane.add(btnGuardar);

		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.confirmarBorrar(frame);
			}
		});
		btnBorrar.setBounds(374, 343, 97, 23);
		contentPane.add(btnBorrar);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVolver.setBounds(278, 343, 86, 23);
		contentPane.add(btnVolver);
		
		JLabel lblImagen = new JLabel("Imagen:");
		lblImagen.setBounds(446, 210, 46, 14);
		contentPane.add(lblImagen);
		
		lblFoto = new JLabel("nueva imagen");
		lblFoto.setBorder(new LineBorder(Color.black));
		lblFoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CtrlProducto.seleccionarFichero();
			}
		});
		lblFoto.setBounds(553, 162, 101, 105);
		contentPane.add(lblFoto);
		
		
		
	}
}
