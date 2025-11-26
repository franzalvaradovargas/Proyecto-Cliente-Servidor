/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Clases;

/**
 *
 * @author Franz
 */
public enum Rol {
    
    EMPLEADO("empleado"),
    TECNICO("Técnico"),
    ADMINISTRADOR("Administrador");
    
    
    private String nombre;
    
    Rol(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    
}
