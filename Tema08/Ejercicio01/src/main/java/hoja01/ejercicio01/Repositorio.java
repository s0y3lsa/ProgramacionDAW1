/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hoja01.ejercicio01;

import java.util.List;

/**
 *
 * @author DAW121
 */
public interface Repositorio<T> {
    

      //metodo para listar todos los objetos T
        // listar los registros de una tabla 
        
        public List<T> listar();
        
        //metodo para recuperar un objeto ID 
        //nos recupera un registro de la base de datos por clave primaria
        
        public T porId(int id);
        
        //metodo en este caso puede ser tanto para realizar la insercion o modificacionn de un objeto 
        //aunque tambien se pueden crear un metodo para añadir un objeto y otro para modificar
        //inserta un registro en la tabla o bien lo modfica
        
        public void guardar(T t);
        
        public void actualizar(T t);
        
        public void eliminar (int id);
}
