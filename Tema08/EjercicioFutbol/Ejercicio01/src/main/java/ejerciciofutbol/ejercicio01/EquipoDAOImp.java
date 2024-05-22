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
public class EquipoDAOImp implements Repositorio<Equipo>{
    
     // metodo privado que nos devuelve la conexión
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    // recuperamos todos los registros de la bd
    @Override
    public List<Equipo> listar() {
        List<Equipo> equipos = new ArrayList<>();
        
   
        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery("SELECT id_equipo,nombre_equipo,categoria,ciudad,estadio,aforo FROM equipos");) {
            while (rs.next()) {
                Equipo equipo = crearEquipo(rs);
                if (!equipos.add(equipo)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return equipos;
    }
    // recuperamos objeto por clave primaria
    @Override
    public Equipo porId(int id) {
        Equipo equipos = null;
        String sql = "SELECT id_equipo,nombre_equipo,categoria,ciudad,estadio,aforo FROM equipos WHERE id=?";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    equipos = crearEquipo(rs);
                }
            }

        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return equipos;
    }
    // implementa tanto insertar como modificar
    // distinguimos que es una inserción porque el id en la tabla se genera automáticamente
    
    @Override
    public void guardar(Equipo t) {
   String sql = null;
   
        sql = "INSERT INTO equipos(idequipo,nombre_equipo,categoria,ciudad,estadio,aforo) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1,t.getId_equipo());
            stmt.setString(2, t.getNombre_equipo());
            stmt.setString(3,t.getCategoria());
            stmt.setString(4, t.getCiudad());
            stmt.setString(5, t.getEstadio());
            stmt.setInt(6,t.getAforo());
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha insertado/modificado un solo registro");
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    // borrar en la base de datos por clave primaria
    @Override
    public void eliminar(int id) {

       String sql="DELETE FROM productos WHERE id_equipo=?";
        try ( PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha borrado un solo registro");
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    

    private Equipo crearEquipo(final ResultSet rs) throws SQLException {
        return new Equipo (rs.getInt("id_equipo"),rs.getString("nombre_equipo"),rs.getString("categoria"),
                rs.getString("ciudad"),rs.getInt("aforo"),rs.getString("estadio"));
    }
    
    
}
