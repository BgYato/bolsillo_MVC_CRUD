package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private static final String dbName = "bolsillo";        
    private static final String user="root";
    private static final String clave="";    
    private static final String driver="com.mysql.cj.jdbc.Driver";    
    private static final String route = "jdbc:mysql://localhost:3306/" + dbName;    

    private static Connection con;
    //Método para la conexión.
    public static Connection conectar() {
    //Se usa e try y catch porque la base de datos a veces manda errores.
        try {
        Class.forName(driver);
        con = DriverManager.getConnection(route, user, clave);        
        System.out.println("Conexión con la base de datos: " + dbName + ". Exitosa.");
        } catch (Exception e) {
        System.out.println("Error de conexión a la base de datos de tipo: " + e);
        }
        return con;
    }
    //Ejecución de la conexión.
    public static void main(String[] args) {
        Conexion.conectar();
    }
}