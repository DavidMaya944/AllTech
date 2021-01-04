package model;

public class Usuario {

	private int iId;
	private String sNombre, sApellidos, sEmail, sDireccion, sUsuario, sContrasenia, sTelefono;
	
	public Usuario(int iId, String sNombre, String sApellidos, String sEmail, String sDireccion, String sUsuario, String sContrasenia, String sTelefono) {
		setiId(iId);
		setsNombre(sNombre);
		setsApellidos(sApellidos);
		setsEmail(sEmail);
		setsDireccion(sDireccion);
		setsUsuario(sUsuario);
		setsContrasenia(sContrasenia);
		setsTelefono(sTelefono);
	}
	
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public String getsApellidos() {
		return sApellidos;
	}
	public void setsApellidos(String sApellidos) {
		this.sApellidos = sApellidos;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsDireccion() {
		return sDireccion;
	}
	public void setsDireccion(String sDireccion) {
		this.sDireccion = sDireccion;
	}
	public String getsUsuario() {
		return sUsuario;
	}
	public void setsUsuario(String sUsuario) {
		this.sUsuario = sUsuario;
	}
	public String getsContrasenia() {
		return sContrasenia;
	}
	public void setsContrasenia(String sContrasenia) {
		this.sContrasenia = sContrasenia;
	}
	public String getsTelefono() {
		return sTelefono;
	}
	public void setsTelefono(String sTelefono) {
		this.sTelefono = sTelefono;
	}
	@Override
	public String toString() {
		return "Usuario [iId=" + iId + ", sNombre=" + sNombre + ", sApellidos=" + sApellidos + ", sEmail=" + sEmail
				+ ", sDireccion=" + sDireccion + ", sUsuario=" + sUsuario + ", sContrasenia=" + sContrasenia
				+ ", sTelefono=" + sTelefono + "]";
	}
	
	
}
