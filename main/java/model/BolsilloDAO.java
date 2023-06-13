package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BolsilloDAO extends Conexion{
    private Connection conexion;
    private BolsilloVO bolVo;
    private ResultSet rs;
    private PreparedStatement puente;

    private String sql;
    private Boolean opcion;

    public BolsilloDAO(BolsilloVO bolVo){
        this.bolVo = bolVo;
        this.conexion = Conexion.conectar();
    }

    public BolsilloDAO(){        
    }

    public void registroCuenta(){
        try {
            sql = "INSERT INTO cuenta (idUsuario, corresponsal, balance, ingresos, egresos) VALUES (?, ?, ?, ?, ?)";
            puente = conexion.prepareCall(sql);            
            puente.setString(1, bolVo.getIdUsuario());
            puente.setString(2, bolVo.getCorresponsal());
            puente.setString(3, bolVo.getBalance());
            puente.setString(4, bolVo.getIngresos());
            puente.setString(5, bolVo.getEgresos());
            puente.executeUpdate();
            opcion = true;            
        } catch (Exception e) {
            System.out.println("Registro Cuenta, error en el DAO de tipo: " + e);
        }        
    }

    public List<BolsilloVO> mostrarCuenta() throws SQLException{
        List<BolsilloVO> lista = new ArrayList<>();        
        try {
            sql="SELECT * FROM cuenta WHERE idUsuario = ?;";
            conexion = Conexion.conectar();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, bolVo.getIdUsuario());
            rs = puente.executeQuery();
            while(rs.next()){
                BolsilloVO cuenta = new BolsilloVO();
                cuenta.setIdCuenta(rs.getString(1));
                cuenta.setIdUsuario(rs.getString(2));
                cuenta.setCorresponsal(rs.getString(3));
                cuenta.setBalance(rs.getString(4));
                cuenta.setIngresos(rs.getString(5));
                cuenta.setEgresos(rs.getString(6));
                
                lista.add(cuenta);
            }            
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }

        return lista;
    }
}
