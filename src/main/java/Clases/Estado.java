/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Clases;

/**
 *
 * @author Franz
 */
public enum Estado {
    
    ABIERTO("Abierto"),
    EN_PROGRESO("En progreso"),
    RESUELTO("Resuelto"),
    CERRADO("Cerrado");
    
    
    private String nombre;
    
    Estado(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    
}
