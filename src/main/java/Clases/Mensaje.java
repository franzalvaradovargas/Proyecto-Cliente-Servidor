/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDateTime;

/**
 *
 * @author Franz
 */
public class Mensaje {
    
    private int id;
    private String Contenido;
    private LocalDateTime Fecha_envío;
    private boolean Leido;
    private int Idtiquete;
    private Usuario usuario;

    public Mensaje() {
        this.Fecha_envío = LocalDateTime.now();
        this.Leido = false;
    }

    public Mensaje(int id, String Contenido, int Idtiquete, Usuario usuario) {
        this.id = id;
        this.Contenido = Contenido;
        this.Fecha_envío = LocalDateTime.now();
        this.Leido = false;
        this.Idtiquete = Idtiquete;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }

    public LocalDateTime getFecha_envío() {
        return Fecha_envío;
    }

    public void setFecha_envío(LocalDateTime Fecha_envío) {
        this.Fecha_envío = Fecha_envío;
    }

    public boolean isLeido() {
        return Leido;
    }

    public void setLeido(boolean Leido) {
        this.Leido = Leido;
    }

    public int getIdtiquete() {
        return Idtiquete;
    }

    public void setIdtiquete(int Idtiquete) {
        this.Idtiquete = Idtiquete;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
}
