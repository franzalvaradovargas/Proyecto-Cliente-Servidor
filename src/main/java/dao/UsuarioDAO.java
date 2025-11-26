/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Clases.Rol;
import Clases.Usuario;
import db.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Franz
 */
public class UsuarioDAO {
    
    //validar credenciales de login
    public Usuario validarLogin(String email, String contrasena) throws SQLException {
        String sql = "SELECT id, nombre, apellido, email, rol FROM usuarios WHERE email = ? AND contrasena = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, email);
            ps.setString(2, contrasena);  // TODO: Encriptar en producción
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearUsuario(rs);
                } else {
                    return null;
                }
            }
        }
    }
    
    
    //insertar un nuevo usuario (registro)
    public void insertar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, apellido, email, contrasena, rol) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getContrasena());
            ps.setString(5, usuario.getRol().name());  // Convierte enum a String
            ps.executeUpdate();
            
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    usuario.setId(rs.getInt(1));
                }
            }
        }
    }
    
    //obtener usuario por id
    public Usuario obtenerPorId(int id) throws SQLException {
        String sql = "SELECT id, nombre, apellido, email, rol FROM usuarios WHERE id = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearUsuario(rs);
                } else {
                    return null;
                }
            }
        }
    }
    
    
    //lista técnicos (para asignar tickets)
    public List<Usuario> listarTecnicos() throws SQLException {
        String sql = "SELECT id, nombre, apellido, email, rol FROM usuarios WHERE rol = 'TECNICO' OR rol = 'ADMINISTRADOR' ORDER BY nombre";
        
        List<Usuario> tecnicos = new ArrayList<>();
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                tecnicos.add(mapearUsuario(rs));
            }
        }
        return tecnicos;
    }
    
    
    //actualizar un usuario
    public void actualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, email = ?, contrasena = ?, rol = ? WHERE id = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getContrasena());
            ps.setString(5, usuario.getRol().name());
            ps.setInt(6, usuario.getId());
            ps.executeUpdate();
        }
    }
    
    //lista todos los usuarios
    public List<Usuario> listarTodos() throws SQLException {
        String sql = "SELECT id, nombre, apellido, email, rol FROM usuarios ORDER BY nombre";
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                usuarios.add(mapearUsuario(rs));
            }
        }
        return usuarios;
    }
    
    //mapea ResultSet a un objeto Usuario
    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setApellido(rs.getString("apellido"));
        usuario.setEmail(rs.getString("email"));
        usuario.setRol(Rol.valueOf(rs.getString("rol")));  // Convierte String a enum
        
        return usuario;
    }
    
    // Método para probar el DAO
    public static void main(String[] args) {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            
            // Probar login
            Usuario usuario = dao.validarLogin("empleado@test.com", "123");
            
            if (usuario != null) {
                System.out.println("✅ Login exitoso!");
                System.out.println("Nombre: " + usuario.getNombreCompleto());
                System.out.println("Rol: " + usuario.getRol().getNombre());
            } else {
                System.out.println("❌ Credenciales incorrectas");
            }
            
        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }    
    
    
    
}
