package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDetalleProveedor extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JTextField txtIdProv;
	public static JTextField txtNombre;
	
	public FrmDetalleProveedor() {
		setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		createForm();
		controller.CtrlProveedor.loadDataProv();
		setResizable(false);
		setModal(true);
		setVisible(true);
	}
	
	
	public void createForm() {
		setBounds(100, 100, 450, 148);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblIdProv = new JLabel("ID");
		lblIdProv.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblIdProv.setBounds(29, 28, 46, 14);
		contentPanel.add(lblIdProv);
		
		txtIdProv = new JTextField();
		txtIdProv.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtIdProv.setEnabled(false);
		txtIdProv.setBounds(70, 26, 86, 20);
		contentPanel.add(txtIdProv);
		txtIdProv.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		txtNombre.setColumns(10);
		txtNombre.setBounds(314, 25, 86, 20);
		contentPanel.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNombre.setBounds(249, 29, 46, 14);
		contentPanel.add(lblNombre);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVolver = new JButton("VOLVER");
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnVolver.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
				btnVolver.setBackground(new Color(46, 139, 87));
				buttonPane.add(btnVolver);
			}
			{
				JButton btnGuardar = new JButton("GUARDAR");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						controller.CtrlProveedor.guardarProveedor();
						controller.CtrlProveedor.loadData();
						dispose();
					}
				});
				btnGuardar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
				btnGuardar.setBackground(new Color(46, 139, 87));
				btnGuardar.setActionCommand("OK");
				buttonPane.add(btnGuardar);
				getRootPane().setDefaultButton(btnGuardar);
			}
			{
				JButton btnEliminar = new JButton("ELIMINAR");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						controller.CtrlProveedor.guardarProveedor();
						controller.CtrlProveedor.loadData();
						dispose();
					}
				});
				btnEliminar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
				btnEliminar.setBackground(new Color(46, 139, 87));
				btnEliminar.setActionCommand("Cancel");
				buttonPane.add(btnEliminar);
			}
			{
				JButton btnNuevo = new JButton("NUEVO");
				btnNuevo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						txtIdProv.setText("");
						txtNombre.setText("");
					}
				});
				btnNuevo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
				btnNuevo.setBackground(new Color(46, 139, 87));
				buttonPane.add(btnNuevo);
			}
		}
	}
}
