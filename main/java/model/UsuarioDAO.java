package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends Conexion{
    Connection conexion;
    UsuarioVO usuVo;
    BolsilloVO bolVo;
    BolsilloDAO bolDao;
    PreparedStatement puente;
    ResultSet rs;
    private String sql = "";
    private Boolean opcion = false;

    public UsuarioDAO(UsuarioVO usuVo) {
        this.usuVo = usuVo;
        this.conexion = Conexion.conectar();
    }

    public UsuarioDAO() {
    }

    public boolean registroUsuario(){
        try {
            sql = "CALL c_usuario(?, ?, ?, ?)";
            puente = conexion.prepareCall(sql);
            puente.setString(1, usuVo.getCorreo());
            puente.setString(2, usuVo.getNombre());
            puente.setString(3, usuVo.getTelefono());
            puente.setString(4, usuVo.getPwd());
            puente.executeUpdate();
            String id = obtenerId(usuVo.getTelefono());
            bolVo = new BolsilloVO("", id, usuVo.getCorresponsal(), "0", "0", "0");
            bolDao = new BolsilloDAO(bolVo);
            bolDao.registroCuenta();
            opcion = true;            
        } catch (Exception e) {
            System.out.println("Registro Usuario, error en el DAO de tipo: " + e);
        }
        return opcion;
    }

    public String obtenerId(String telefono){
        String ID = "0";
        sql = "SELECT id FROM usuario WHERE celular = ?";
        try {
            conexion = conectar();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, telefono);
            rs = puente.executeQuery();
            if (rs.next()) {
                ID = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Obtener ID - error de tipo: " + e);
        }

        return ID;
    }

    public boolean validarUsuario(){
        opcion = false;
        String id = obtenerId(usuVo.getTelefono());
        sql = "SELECT * FROM cuenta WHERE idUsuario = ? AND corresponsal = ?";
        try {
            conexion = conectar();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            puente.setString(2, usuVo.getCorresponsal());
            rs = puente.executeQuery();
            if (rs.next()) {
                opcion = true;
            }
        } catch (Exception e) {
            System.out.println("Obtener ID - error de tipo: " + e);
        }
        return opcion;
    }

    public boolean validarLogin(){
        opcion = false;
        String id = obtenerId(usuVo.getTelefono());
        sql = "SELECT * FROM usuario WHERE id = ? AND celular = ? AND pwd = ?";
        try {
            conexion = conectar();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            puente.setString(2, usuVo.getTelefono());
            puente.setString(3, usuVo.getPwd());
            rs = puente.executeQuery();
            if (rs.next()) {
                opcion = true;
            }
        } catch (Exception e) {
            System.out.println("Obtener ID - error de tipo: " + e);
        }
        return opcion;
    }

    public boolean eliminarUsuario(){
        try {
            sql = "DELETE FROM usuario WHERE id = ?";
            puente = conexion.prepareCall(sql);
            puente.setString(1, usuVo.getId());

            puente.executeUpdate();
            opcion = true;            
        } catch (Exception e) {
            System.out.println("Eliminar Usuario, error en el DAO de tipo: " + e);
        }
        return opcion;
    }

    public boolean actualizarUsuario(){
        try {
            sql = "UPDATE usuario SET correo = ?, nombre = ?, celular = ?, pwd = ? WHERE id = ?";
            puente = conexion.prepareCall(sql);
            puente.setString(1, usuVo.getCorreo());
            puente.setString(2, usuVo.getNombre());
            puente.setString(3, usuVo.getTelefono());
            puente.setString(4, usuVo.getPwd());
            puente.setString(5, usuVo.getId());

            puente.executeUpdate();
            opcion = true;            
        } catch (Exception e) {
            System.out.println("Eliminar Usuario, error en el DAO de tipo: " + e);
        }
        return opcion;
    }

    public List<UsuarioVO> listar() throws SQLException{
        List<UsuarioVO> usuarios = new ArrayList<>();        
        try {
            sql="SELECT * from usuario";
            conexion = Conexion.conectar();
            puente = conexion.prepareStatement(sql);
            rs = puente.executeQuery(sql);
            while(rs.next()){
                UsuarioVO usuario = new UsuarioVO();                
                usuario.setId(rs.getString(1));
                usuario.setCorreo(rs.getString(2));
                usuario.setNombre(rs.getString(3));
                usuario.setTelefono(rs.getString(4));
                usuario.setPwd(rs.getString(5));                
                
                usuarios.add(usuario);
            }            
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }

        return usuarios;
    }
    
    public List<UsuarioVO> mostrarUsuario() throws SQLException{
        List<UsuarioVO> usuarios = new ArrayList<>();
        String id = obtenerId(usuVo.getTelefono());
        try {
            sql="SELECT * FROM usuario WHERE id = ?;";
            conexion = Conexion.conectar();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            rs = puente.executeQuery();
            while(rs.next()){
                UsuarioVO usuario = new UsuarioVO();                
                usuario.setId(rs.getString(1));
                usuario.setCorreo(rs.getString(2));
                usuario.setNombre(rs.getString(3));
                usuario.setTelefono(rs.getString(4));
                usuario.setPwd(rs.getString(5));                
                
                usuarios.add(usuario);
            }            
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }

        return usuarios;
    }
}
