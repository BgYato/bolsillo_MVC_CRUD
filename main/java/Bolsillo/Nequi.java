package Bolsillo;

public class Nequi extends Bolsillo{
    private double saldoTotal = 0;
    private double celular;
    private double pwd;
    private String nombre;
    private String correo;
    /* ATRIBUTOS PARA EL MÉTODO DE RECARGAR - INGRESAR DINERO */
    private double recarga = 0;
    /* ATRIBUTOS PARA EL MÉTODO DE RECARGAR - INGRESAR DINERO */
    private double retiro;
    
    public Nequi() {
    }

    public Nequi(double saldoTotal, double celular, double pwd, String nombre, String correo, double recarga, double retiro) {
        this.saldoTotal = saldoTotal;
        this.celular = celular;
        this.pwd = pwd;
        this.nombre = nombre;
        this.correo = correo;
        this.recarga = recarga;
        this.retiro = retiro;
    }    

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public double getCelular() {
        return celular;
    }

    public void setCelular(double celular) {
        this.celular = celular;
    }

    public double getPwd() {
        return pwd;
    }

    public void setPwd(double pwd) {
        this.pwd = pwd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getRecarga() {
        return recarga;
    }

    public void setRecarga(double recarga) {
        this.recarga = recarga;
    }

    public double getRetiro() {
        return retiro;
    }

    public void setRetiro(double retiro) {
        this.retiro = retiro;
    }

    public void iniciarSesion() {


        validarSesion();
    }

    public void validarSesion(){        

        
    }

    public double mostrarBolsillo() {
        return saldoTotal;
    }
    
    public double ingresarDinero() {
        saldoTotal += recarga;
        
        return recarga;
    }
    
    public double retirarDinero() {
        if (saldoTotal < retiro) {
            return 0;
        } else {
            saldoTotal -= retiro;
            return retiro;
        }
    }    

}
