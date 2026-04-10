package main;

// importar la clase Persona para usarla aqui
import modelo.Persona;

public class Main {

    public static void main(String[] args) {
        
        // crear un objeto de tipo Persona para probar
        Persona persona1 = new Persona("Carlos", 20, "001");
        
        // mostrar la informacion de la persona en pantalla
        persona1.mostrarInfo();
        
        // cambiar el nombre usando el setter
        persona1.setNombre("Carlos Ramirez");
        
        // mostrar el nombre actualizado usando el getter
        System.out.println("Nombre actualizado: " + persona1.getNombre());
    }
}
