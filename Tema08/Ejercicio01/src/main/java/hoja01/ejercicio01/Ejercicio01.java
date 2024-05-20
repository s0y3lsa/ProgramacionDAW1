/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package hoja01.ejercicio01;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DAW121
 */
public class Ejercicio01 {

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        
          int opc=0;
          Usuario user1= new Usuario(1, "Julia", "12345678", "julia@gmail.com");
            Usuario user2= new Usuario(2, "Marcos", "12345678", "marcos@gmail.com");
            Usuario user3= new Usuario(3, "Maria", "12345678", "maria@gmail.com");

       try (Connection conn = AccesoBaseDatos.getInstance().getConn()) {
           
            // de la interfaz
            Repositorio<Usuario> repositorio = new UsuarioDAOImp();
            
            
            do {
                System.out.println("1. Actualizar");
                System.out.println("2. Eliminar");
                System.out.println("3. Agregar");
                System.out.println("4. Listar");
                System.out.println("5. Salir");
                opc=teclado.nextInt();
                switch (opc) {
                        
                    case 1->{
                        //actualizar
                        System.out.println("Actualizando.... ");
                        repositorio.actualizar(user1);
                        break;
                    }
                            
                    case 2->{
                        //eliminar por id 
                        repositorio.eliminar(2);
                        break;
                    }
                    case 3-> {
                        //agregar usuario 
                        repositorio.guardar(user3);
                        break;
                    }
                    case 4 ->{
                             // listar un usuario
                            for (Usuario user : repositorio.listar()) {
                            System.out.println(user.toString());
                            break;
                            }
                    }
                            
                    case 5->{
                        System.out.println("Saliendo...");
                        break;
                        
                    }   
              
                }
            } while (opc!=5);

       }catch (SQLException ex) {
           System.out.println("error sql" + ex.getMessage());
        }

    }
}
