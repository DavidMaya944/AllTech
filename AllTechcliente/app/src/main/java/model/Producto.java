package model;

public class Producto {
    private int CODIGO;
    private String NOMBRE;
    private int OPCION;
    private String COMENTARIOS;
    private int FRAGIL;
    private int OBSOLETO;
    private int STOCK_ACTUAL;
    private int STOCK_MIN;
    private int STOCK_MAX;
    private String PROVEEDOR;
    private float PVP;

    public Producto(){}

    public Producto(int CODIGO, String NOMBRE, int OPCION, String COMENTARIOS, int FRAGIL, int OBSOLETO, int STOCK_ACTUAL,
                    int STOCK_MIN, int STOCK_MAX, String PROVEEDOR, float PVP){
        setCODIGO(CODIGO);
        setNOMBRE(NOMBRE);
        setOPCION(OPCION);
        setCOMENTARIOS(COMENTARIOS);
        setFRAGIL(FRAGIL);
        setOBSOLETO(OBSOLETO);
        setSTOCK_ACTUAL(STOCK_ACTUAL);
        setSTOCK_MIN(STOCK_MIN);
        setSTOCK_MAX(STOCK_MAX);
        setPROVEEDOR(PROVEEDOR);
        setPVP(PVP);
    }

    public int getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(int CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getOPCION() {
        return OPCION;
    }

    public void setOPCION(int OPCION) {
        this.OPCION = OPCION;
    }

    public String getCOMENTARIOS() {
        return COMENTARIOS;
    }

    public void setCOMENTARIOS(String COMENTARIOS) {
        this.COMENTARIOS = COMENTARIOS;
    }

    public int getFRAGIL() {
        return FRAGIL;
    }

    public void setFRAGIL(int FRAGIL) {
        this.FRAGIL = FRAGIL;
    }

    public int getOBSOLETO() {
        return OBSOLETO;
    }

    public void setOBSOLETO(int OBSOLETO) {
        this.OBSOLETO = OBSOLETO;
    }

    public int getSTOCK_ACTUAL() {
        return STOCK_ACTUAL;
    }

    public void setSTOCK_ACTUAL(int STOCK_ACTUAL) {
        this.STOCK_ACTUAL = STOCK_ACTUAL;
    }

    public int getSTOCK_MIN() {
        return STOCK_MIN;
    }

    public void setSTOCK_MIN(int STOCK_MIN) {
        this.STOCK_MIN = STOCK_MIN;
    }

    public int getSTOCK_MAX() {
        return STOCK_MAX;
    }

    public void setSTOCK_MAX(int STOCK_MAX) {
        this.STOCK_MAX = STOCK_MAX;
    }

    public String getPROVEEDOR() {
        return PROVEEDOR;
    }

    public void setPROVEEDOR(String PROVEEDOR) {
        this.PROVEEDOR = PROVEEDOR;
    }

    public float getPVP() {
        return PVP;
    }

    public void setPVP(float PVP) {
        this.PVP = PVP;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "CODIGO=" + CODIGO +
                ", NOMBRE='" + NOMBRE + '\'' +
                ", OPCION=" + OPCION +
                ", COMENTARIOS='" + COMENTARIOS + '\'' +
                ", FRAGIL=" + FRAGIL +
                ", OBSOLETO=" + OBSOLETO +
                ", STOCK_ACTUAL=" + STOCK_ACTUAL +
                ", STOCK_MIN=" + STOCK_MIN +
                ", STOCK_MAX=" + STOCK_MAX +
                ", PROVEEDOR='" + PROVEEDOR + '\'' +
                ", PVP=" + PVP +
                '}';
    }
}
