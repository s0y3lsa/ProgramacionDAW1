/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciofutbol.ejercicio01;

/**
 *
 * @author DAW121
 */
public class Equipo {
    
    private int id_equipo;
    private String nombre_equipo;
    private String categoria;
    private String ciudad;
    private int aforo;
    private String estadio;

    public Equipo() {
    }

    public Equipo(int id_equipo, String nombre_equipo, String categoria, String ciudad, int aforo, String estadio) {
        this.id_equipo = id_equipo;
        this.nombre_equipo = nombre_equipo;
        this.categoria = categoria;
        this.ciudad = ciudad;
        this.aforo = aforo;
        this.estadio = estadio;
    }

    

    
   
   

    public String getCategoria() {
        return categoria;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

   

 
    

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

 

    public String getCiudad() {
        return ciudad;
    }

    public int getAforo() {
        return aforo;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }


   

   
   
    
}
