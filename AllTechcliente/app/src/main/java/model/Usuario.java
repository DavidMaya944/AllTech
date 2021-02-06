package model;

public class Usuario {
    private int ID;
    private String NOMBRE;
    private String APELLIDOS;
    private String EMAIL;
    private String DIRECCION;
    private String USUARIO;
    private String PASSWORD;
    private String TELEFONO;
    private String PERMISO;
    private int ROL;

    public Usuario(){}

    public Usuario(int ID, String NOMBRE, String APELLIDOS, String EMAIL, String DIRECCION, String USUARIO, String PASSWORD, String TELEFONO, String PERMISO, int ROL){
        setID(ID);
        setNOMBRE(NOMBRE);
        setAPELLIDOS(APELLIDOS);
        setEMAIL(EMAIL);
        setDIRECCION(DIRECCION);
        setUSUARIO(USUARIO);
        setPASSWORD(PASSWORD);
        setTELEFONO(TELEFONO);
        setPERMISO(PERMISO);
        setROL(ROL);
    }

    public Usuario(String EMAIL, String PASSWORD, String PERMISO){
        setEMAIL(EMAIL);
        setPASSWORD(PASSWORD);
        setPERMISO(PERMISO);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    public void setAPELLIDOS(String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getPERMISO() {
        return PERMISO;
    }

    public void setPERMISO(String PERMISO) {
        this.PERMISO = PERMISO;
    }

    public int getROL() {
        return ROL;
    }

    public void setROL(int ROL) {
        this.ROL = ROL;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID=" + ID +
                ", NOMBRE='" + NOMBRE + '\'' +
                ", APELLIDOS='" + APELLIDOS + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                ", DIRECCION='" + DIRECCION + '\'' +
                ", USUARIO='" + USUARIO + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", TELEFONO='" + TELEFONO + '\'' +
                ", PERMISO='" + PERMISO + '\'' +
                '}';
    }
}
