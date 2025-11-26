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
public class Tiquete {
    
    private int id;
    private String Titulo;
    private String Descripcion;
    private Prioridad prioridad; //usando el enum
    private String Categoria;
    private Estado estado;
    private LocalDateTime Fecha_Creacion; //local time de la maquina
    private LocalDateTime Fecha_Cierre; //local time de la maquina
    private Usuario usuario;
    private Usuario tecnico;
    
    
    //constructor vacio
    public Tiquete(){
        this.Fecha_Creacion = LocalDateTime.now(); //para auto inicializar
        this.estado = Estado.ABIERTO; //estado inicial
    }

    public Tiquete(int id, String Titulo, String Descripcion, Prioridad prioridad, String Categoria, Usuario usuario) {
        this.id = id;
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.prioridad = prioridad;
        this.Categoria = Categoria;
        this.estado = Estado.ABIERTO;
        this.Fecha_Creacion = LocalDateTime.now();
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setFecha_Creacion(LocalDateTime Fecha_Creacion) {
        this.Fecha_Creacion = Fecha_Creacion;
    }

    public LocalDateTime getFecha_Cierre() {
        return Fecha_Cierre;
    }

    public void setFecha_Cierre(LocalDateTime Fecha_Cierre) {
        this.Fecha_Cierre = Fecha_Cierre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getTecnico() {
        return tecnico;
    }

    public void setTecnico(Usuario tecnico) {
        this.tecnico = tecnico;
    }
    
    
}
