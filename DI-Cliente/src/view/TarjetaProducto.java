package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.TextArea;
import javax.swing.JTextArea;

public class TarjetaProducto extends JPanel {
	private JTextField txtNombre;
	private JTextField txtPVP;

	/**
	 * Create the panel.
	 */
	public TarjetaProducto() {
		setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setBounds(138, 41, 131, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JTextArea textDescrip = new JTextArea();
		textDescrip.setEnabled(false);
		textDescrip.setBounds(138, 72, 143, 38);
		add(textDescrip);
		
		txtPVP = new JTextField();
		txtPVP.setEnabled(false);
		txtPVP.setBounds(371, 90, 69, 20);
		add(txtPVP);
		txtPVP.setColumns(10);

	}
}
