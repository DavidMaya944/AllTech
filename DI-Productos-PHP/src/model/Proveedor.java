package model;

public class Proveedor {
	int iId;
	String sNombre;
	
	public Proveedor() {}
	
	public Proveedor(int iId, String sNombre) {
		setiId(iId);
		setsNombre(sNombre);
	}
	
	public Proveedor(String sNombre) {
		setsNombre(sNombre);
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

	@Override
	public String toString() {
		return "Proveedor [iId=" + iId + ", sNombre=" + sNombre + "]";
	}
	
	
	
}
