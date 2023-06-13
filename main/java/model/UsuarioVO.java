package model;

public class UsuarioVO {
    private String id, correo, nombre, telefono, pwd, corresponsal;

    public UsuarioVO() {
    }

    public UsuarioVO(String id, String correo, String nombre, String telefono, String pwd, String corresponsal) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.pwd = pwd;
        this.corresponsal = corresponsal;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCorresponsal() {
        return corresponsal;
    }

    public void setCorresponsal(String corresponsal) {
        this.corresponsal = corresponsal;
    }

    
}
