/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ejerciciofutbol.ejercicio01;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DAW121
 */
public class Ejercicio01 {

    public static void main(String[] args) throws SQLException {
       
        Scanner teclado= new Scanner(System.in);
        int opc=0;
        
        Equipo e1= new Equipo(67, "Arenteiro", "juvenil", "Carballiño", 45000, "Municipal Espiñedo");
        Jugador j1= new Jugador(10, "Juanito", "Serrano", 0,12);
        
        Repositorio<Equipo> repositorio= new EquipoDAOImp();
        JugadorImp jugador= new JugadorImp();
        
        do{
            System.out.println("-- MENU --");
            System.out.println("1.Listar los equipos y los jugadores que actualmente tiene la BD");
            System.out.println("2.Crear un equipo e insertarlo");
            System.out.println("3.Crear un jugador e insertar");
            System.out.println("4.Listar los equipos seguidos de los jugadores que tiene en la BD");
            System.out.println("5.Crea un método que modifique el nombre del campo de fútbol de un equipo pedido por teclado.");
            System.out.println("6.Crear un método que nos borre un equipo (comprobar limitaciones");
            System.out.println("7.Crear un método que nos borre un equipo (comprobar limitaciones");
            System.out.println("8.Mostrar los goles que ha marcado cada equipo");
            System.out.println("9.Método que nos permita el traspaso de un jugador entre equipos presentes en la BD");
            System.out.println("10.Salir");
             opc=teclado.nextInt();
            
          switch(opc){
              case 1:{

                  //listar equipo
                  for (Equipo equip : repositorio.listar()) {
                    System.out.println(equip.toString());
                    }
                  //listar jugador
                    
                    List <Jugador> todosJugadores= jugador.listar();
                     for (Jugador j : todosJugadores) {
                      System.out.println(j.toString());
                    }   
              }
              case 2:{
                  repositorio.guardar(e1);  
              }
              case 3:{
                  jugador.insertarJugador(j1);
              }
              case 4:{
                  for (Equipo equipo : listado) {
                      List<Jugador>plantilla=jugador.
                  }
              }
          }  
            
        }while(opc!=10);
        
        
        
        
        
        
        
        
        
        
        
    }
}
