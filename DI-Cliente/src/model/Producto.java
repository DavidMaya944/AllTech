package model;

import java.io.Serializable;

public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iCod, iStockActual, iStockMin, iStockMax, iOpcion;
	private float fPVP;
	private String sNombre, sComents, sProveedor;
	private boolean bFragil, bObsoleto;
	
	public Producto(int iCod, String sNombre, int iOpcion, String sComents, boolean bFragil, boolean bObsoleto, int iStockActual, int iStockMin, int iStockMax,
			String sProveedor, float fPVP) {
		setiCod(iCod);
		setsNombre(sNombre);
		setiOpcion(iOpcion);
		setsComents(sComents);
		setbFragil(bFragil);
		setbObsoleto(bObsoleto);
		setiStockActual(iStockActual);
		setiStockMin(iStockMin);
		setiStockMax(iStockMax);
		setsProveedor(sProveedor);
		setfPVP(fPVP);
	}
	
	public Producto(String sNombre, int iOpcion, String sComents, boolean bFragil, boolean bObsoleto, int iStockActual, int iStockMin, int iStockMax,
			String sProveedor, float fPVP) {
		setsNombre(sNombre);
		setiOpcion(iOpcion);
		setsComents(sComents);
		setbFragil(bFragil);
		setbObsoleto(bObsoleto);
		setiStockActual(iStockActual);
		setiStockMin(iStockMin);
		setiStockMax(iStockMax);
		setsProveedor(sProveedor);
		setfPVP(fPVP);
	}
	
	public Producto(String sNombre, String sComents, float fPVP) {
		setsNombre(sNombre);
		setsComents(sComents);
		setfPVP(fPVP);
	}
	
	public Producto(String sNombre, String sComents, float fPVP, int iStockActual) {
		setsNombre(sNombre);
		setsComents(sComents);
		setfPVP(fPVP);
		setiStockActual(iStockActual);
	}
	
	public Producto(int iCod, String sNombre, String sComents, float fPVP, int iStockActual) {
		setiCod(iCod);
		setsNombre(sNombre);
		setsComents(sComents);
		setfPVP(fPVP);
		setiStockActual(iStockActual);
	}

	public int getiOpcion() {
		return iOpcion;
	}


	public void setiOpcion(int iOpcion) {
		this.iOpcion = iOpcion;
	}


	public float getfPVP() {
		return fPVP;
	}


	public void setfPVP(float fPVP) {
		this.fPVP = fPVP;
	}


	public int getiCod() {
		return iCod;
	}
	public void setiCod(int iCod) {
		this.iCod = iCod;
	}
	public int getiStockActual() {
		return iStockActual;
	}
	public void setiStockActual(int iStockActual) {
		this.iStockActual = iStockActual;
	}
	public int getiStockMin() {
		return iStockMin;
	}
	public void setiStockMin(int iStockMin) {
		this.iStockMin = iStockMin;
	}
	public int getiStockMax() {
		return iStockMax;
	}
	public void setiStockMax(int iStockMax) {
		this.iStockMax = iStockMax;
	}
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public String getsComents() {
		return sComents;
	}
	public void setsComents(String sComents) {
		this.sComents = sComents;
	}
	public String getsProveedor() {
		return sProveedor;
	}
	public void setsProveedor(String sProveedor) {
		this.sProveedor = sProveedor;
	}
	public boolean isbFragil() {
		return bFragil;
	}
	public void setbFragil(boolean bFragil) {
		this.bFragil = bFragil;
	}
	public boolean isbObsoleto() {
		return bObsoleto;
	}
	public void setbObsoleto(boolean bObsoleto) {
		this.bObsoleto = bObsoleto;
	}

	@Override
	public String toString() {
		return "Producto [iCod=" + iCod + ", iStockActual=" + iStockActual + ", iStockMin=" + iStockMin + ", iStockMax="
				+ iStockMax + ", iOpcion=" + iOpcion + ", fPVP=" + fPVP + ", sNombre=" + sNombre + ", sComents="
				+ sComents + ", sProveedor=" + sProveedor + ", bFragil=" + bFragil + ", bObsoleto=" + bObsoleto + "]";
	}
	
	
}
