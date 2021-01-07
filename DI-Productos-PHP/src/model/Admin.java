package model;

public class Admin {
	private String sNombre, sPass;
	
	public Admin(String sNombre, String sPass) {
		setsNombre(sNombre);
		setsPass(sPass);
	}

	public  String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public  String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}
	
	
}
