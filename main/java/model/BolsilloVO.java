package model;

public class BolsilloVO {
    private String idCuenta, idUsuario, corresponsal, balance, ingresos, egresos;

    public BolsilloVO() {
    }

    public BolsilloVO(String idCuenta, String idUsuario, String corresponsal, String balance, String ingresos,
            String egresos) {
        this.idCuenta = idCuenta;
        this.idUsuario = idUsuario;
        this.corresponsal = corresponsal;
        this.balance = balance;
        this.ingresos = ingresos;
        this.egresos = egresos;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorresponsal() {
        return corresponsal;
    }

    public void setCorresponsal(String corresponsal) {
        this.corresponsal = corresponsal;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getIngresos() {
        return ingresos;
    }

    public void setIngresos(String ingresos) {
        this.ingresos = ingresos;
    }

    public String getEgresos() {
        return egresos;
    }

    public void setEgresos(String egresos) {
        this.egresos = egresos;
    }

    
}
