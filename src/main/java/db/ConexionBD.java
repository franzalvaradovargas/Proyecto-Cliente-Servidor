/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Franz
 */
public class ConexionBD {
    
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_tiquetes?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CLAVE = "$%ADrgwt3q3t3t"; //cambiar por clave propia
            
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println("No se pudo cargar el driver de mysql: " + ex.getMessage());
        }
    }
    
    
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO,CLAVE);
    }
    
    //probar conexion
    public static void main(String[] args){
        try{
            Connection conn = ConexionBD.obtenerConexion();
            if(conn!=null){
                System.out.println("Conexion existosa.");
                conn.close();
            }
        }catch(SQLException e){
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
    
    
    
}
