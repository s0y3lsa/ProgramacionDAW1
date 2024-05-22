```java
public class Teclado {
    /**
     * valida que la entrada por teclado sea una cadena de texto
     * @param mensaje - para indicar al usuario que dato tiene que introducir
     * @return  devuelve una cadena de texto válida
     */
    public static String introTexto(String mensaje){
        String cadena="";
        boolean valido=false;
        do{
            System.out.println(mensaje);
            cadena=new Scanner(System.in).nextLine();
            if(cadena.matches("[A-ZÑa-zñÁÉÍÓÚáéíóú]*")){
                valido=true;
            }else{
                System.out.println("Error. Solo caracteres.");
            }
        }while(!valido);
        return cadena.toLowerCase();
    }

    /**
     * valida que la entrada por teclado sea un número entero
     * @param mensaje - para indicar al usuario que dato tiene que introducir
     * @return devuelve un número entero
     */
    public static int introEnteroPositivo(String mensaje){
        int entero=0;
        boolean valido=false;
        do{
            try{
            System.out.println(mensaje);
            entero=new Scanner(System.in).nextInt();
            if(entero <1){
                throw new Exception("debe ser un entero positivo");
            }
            valido=true;
            }catch(InputMismatchException e){
                System.out.println("Error, introduce un numero");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        
        }while(!valido);
        return entero;
    }
     /**
     * valida que la entrada del dato sea SI/NO o S/N 
     * @param mensaje - para indicar al usuario que dato tiene que introducir
     * @return -devuelve un dato boolean
     */
    public static boolean introBoolean(String mensaje) {
        boolean campo = false;
        char opcion;
        do {
            System.out.println(mensaje);
            opcion = new Scanner(System.in).nextLine().charAt(0);
        } while (opcion != 'S' && opcion != 's' && opcion != 'N' && opcion != 'n');
        if (opcion == 'S' || opcion == 's') {
            campo = true;
        }
        return campo;
    }
}
```
