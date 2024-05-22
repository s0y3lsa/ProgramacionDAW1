/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciofutbol.ejercicio01;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAW121
 */
public class JugadorImp {
   
       private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    
    public void insertarJugador(Jugador jugador) throws SQLException {
        String sql = "INSERT INTO Jugador (id_jugador,nombre_jugador,apellidos,goles,id_equipo) VALUES (?, ?, ?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, jugador.getId_jugador());
            stmt.setString(2, jugador.getNombre_jugador());
            stmt.setString(3, jugador.getApellidos());
            stmt.setInt(4, jugador.getGoles());
            stmt.setInt(5, jugador.getIdequipo());
           
        }
    }

        public void modificarJugador(Jugador jugador) throws SQLException {
        String sql = "UPDATE Jugador SET nombre_jugador = ?, apellidos = ?, goles = ?,id_equipo= ? WHERE id_jugador = ?";
        try (PreparedStatement stmt =(PreparedStatement) getConnection()) {
              
            stmt.setString(1, jugador.getNombre_jugador());
            stmt.setString(2, jugador.getApellidos());
            stmt.setInt(3, jugador.getGoles());
            stmt.setInt(4, jugador.getIdequipo());
            stmt.setInt(5, jugador.getId_jugador());
            stmt.executeUpdate();
        }
    }

    public void eliminarJugador(int id_jugador) throws SQLException {
        String sql = "DELETE FROM Jugador WHERE id_jugador = ?";
        try (PreparedStatement stmt = (PreparedStatement) getConnection()) {
            stmt.setInt(1, id_jugador);
            stmt.executeUpdate();
        }
    }

    public Jugador obtenerJugadorPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Jugador WHERE id = ?";
        try (PreparedStatement stmt = (PreparedStatement) getConnection()) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Jugador(
                        rs.getInt("id_jugador"),
                        rs.getString("nombre_jugador"),
                        rs.getString("apellidos"),
                        rs.getInt("goles"),
                        rs.getInt("id_equipo")
                    );
                }
            }
        }
        return null;
    }

    // Método para obtener todos los jugadores
    public List<Jugador> listar() {
     List<Jugador> jugadores = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery("SELECT id_jugador,nombre_jugador,apellidos,goles FROM jugadores");) {
            while (rs.next()) {
                Jugador jugador=crearJugador(rs);
                if (!jugadores.add(jugador)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return jugadores;
      }
    
    
    // 
    public List<Jugador>listarPorEquipo(int id_equipo){
     List<Jugador> jugadores = new ArrayList<>();
     Statement stmt =null;
        try (stmt = getConnection().createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT id_jugador,nombre_jugador,apellidos,goles FROM jugadores WHERE id_equipo=?")) ;
                
            while (rs.next()) {
                Jugador jugador=crearJugador(rs);
                if (!jugadores.add(jugador)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return jugadores;
      }

    
    private Jugador crearJugador(final ResultSet rs) throws SQLException {
        return new Jugador( rs.getInt("id_jugador"),rs.getString("nombre_jugador"),rs.getString("apellidos"),rs.getInt("goles"),rs.getInt("equipo"));
    }
    
    
    
}