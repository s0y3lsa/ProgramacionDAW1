/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciofutbol.ejercicio01;

/**
 *
 * @author DAW121
 */
public class Jugador {
    
    private int id_jugador;
    private String nombre_jugador;
    private String apellidos;
    private int goles;
    private int idequipo;

    public Jugador(int id_jugador, String nombre_jugador, String apellidos, int goles, int idequipo) {
        this.id_jugador = id_jugador;
        this.nombre_jugador = nombre_jugador;
        this.apellidos = apellidos;
        this.goles = goles;
        this.idequipo = idequipo;
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombre_jugador() {
        return nombre_jugador;
    }

    public void setNombre_jugador(String nombre_jugador) {
        this.nombre_jugador = nombre_jugador;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }
    
    
}
