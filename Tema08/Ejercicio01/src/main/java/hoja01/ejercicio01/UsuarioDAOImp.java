/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hoja01.ejercicio01;

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
public class UsuarioDAOImp implements Repositorio<Usuario> {

    // metodo privado que nos devuelve la conexión
    private Connection getConnection() {
        return AccesoBaseDatos.getInstance().getConn();
    }
    // recuperamos todos los registros de la bd

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuario = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs
                = stmt.executeQuery("SELECT id,nombre,cantidad FROM productos");) {
            while (rs.next()) {
                Usuario user = crearUsuario(rs);
                if (!usuario.add(user)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return usuario;
    }
    //Crear Usuario

    private Usuario crearUsuario(final ResultSet rs) throws SQLException {
        return new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"));
    }

    // recuperamos objeto por clave primaria
    @Override
    public Usuario porId(int id) {
        Usuario user = null;
        String sql = "SELECT id,nombre,cantidad FROM productos WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    user = crearUsuario(rs);
                }
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return user;
    }

    // implementa tanto insertar como modificar
    // distinguimos que es una inserción porque el id en la tabla se genera automáticamente
    
    @Override
    public void guardar(Usuario user) {
        String sql = null;
        if (user.getId() > 0) {
            sql = "UPDATE Usuario SET Username=?,password=?,email=? WHERE id=?";
        } else {
            sql = "INSERT INTO Usuario (username,password,email) VALUES (?,md5 (?),?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            if (user.getId() > 0) {
                stmt.setInt(3, user.getId());
            }
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
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
    
    //Actualizar
   
    @Override
    public void actualizar(Usuario usuario) {
        String sql = null;
        if (usuario.getId() > 0) {
            sql = "UPDATE usuarios SET username=?,password=?,email=? WHERE id=?";
        } else {
            System.out.println("No se pudo actualizar");
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            if (usuario.getId() > 0) {
                stmt.setInt(4, usuario.getId());
            }
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setString(3, usuario.getEmail());
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

       String sql="DELETE FROM productos WHERE id=?";
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
    
    
    
    

}
