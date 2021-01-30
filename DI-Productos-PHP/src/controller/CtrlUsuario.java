package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;

import logic.LogicaUsuarios;
import model.Usuario;
import view.FrmDetalleUsuario;

public class CtrlUsuario {
	public static int iId;
	LogicaUsuarios logUser = new LogicaUsuarios();
	
	public static void tableRowSelected() {
		new view.FrmDetalleProd();

	}
	
	public static void generarGrafic() {
		view.GraficUser.data = new DefaultPieDataset();
		
		double iContEspera = 0, iContAcept = 0, iContBlock = 0;
		
		for(int i = 0; i < (LogicaUsuarios.lUsuariosB.size()); i++) {
			System.out.println(LogicaUsuarios.lUsuariosB.get(i));
			if(LogicaUsuarios.lUsuariosB.get(i).getsPermiso().equals("ACEPTADO")) {
				iContAcept++;
				System.out.println(LogicaUsuarios.lUsuariosB.get(i).getsPermiso());
			}else if(LogicaUsuarios.lUsuariosB.get(i).getsPermiso().equals("EN ESPERA")) {
				iContEspera++;
				System.out.println(iContEspera);
			}else if(LogicaUsuarios.lUsuariosB.get(i).getsPermiso().equals("BLOQUEADO")){
				iContBlock++;
			}else {
				JOptionPane.showMessageDialog(null, "No se puede cargar la grafica", "Grafica", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		view.GraficUser.data.setValue("EN ESPERA", iContEspera);
		view.GraficUser.data.setValue("ACEPTADO", iContAcept);
		view.GraficUser.data.setValue("BLOQUEADO", iContBlock);
		
		
		view.GraficUser.chart = ChartFactory.createPieChart("PERMISOS", view.GraficUser.data, true, true, false);
		System.out.println("HE SALIDO DEL FOR");
		
		view.GraficUser.panelChart = new ChartPanel(view.GraficUser.chart);
		
		view.GraficUser.panelChart.setBounds(310, 0, 300, 250);
		
		view.GraficUser.contentPanel.add(view.GraficUser.panelChart);
	}

	public static void loadData() {
		try {
			List<Usuario> resultado = LogicaUsuarios.leer();
			DefaultTableModel modelo = LogicaUsuarios.generarTablaUsuario(resultado);
			view.FrmGestionUsuarios.tableUsers.setModel(modelo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido cargar los datos", "Cargar datos", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void loadDataUser() {
		iId = Integer.parseInt(view.FrmGestionUsuarios.tableUsers.getValueAt(view.FrmGestionUsuarios.tableUsers.getSelectedRow(), 0).toString());
		try {
			Usuario u = LogicaUsuarios.leerUser(iId);
			FrmDetalleUsuario.txtID.setText("" + u.getiId());
			FrmDetalleUsuario.txtNombre.setText(u.getsNombre());
			FrmDetalleUsuario.txtApellidos.setText(u.getsApellidos());
			FrmDetalleUsuario.txtEmail.setText(u.getsEmail());
			FrmDetalleUsuario.txtDireccion.setText(u.getsDireccion());
			FrmDetalleUsuario.txtUser.setText(u.getsUsuario());
			FrmDetalleUsuario.txtPass.setText(u.getsContrasenia());
			FrmDetalleUsuario.txtTelefono.setText(u.getsTelefono());
			FrmDetalleUsuario.txtPermiso.setText(u.getsPermiso());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido cargar los datos", "Cargar datos", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void confirmarUsuario() {
		logUser.confirmarUsuario();
		JOptionPane.showMessageDialog(null, "El producto ha sido registrado con exito", "UPLOAD", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void bloquearUsuario() {
		LogicaUsuarios.blouqearUsuario();
	}
	
	public static void desbloquearUsuario() {
		LogicaUsuarios.desbloquearUsuario();
	}

	public void rechazarUsuario(FrmDetalleUsuario frame) {
		LogicaUsuarios.rechazarUsuario(frame);
	}
	
	

}
