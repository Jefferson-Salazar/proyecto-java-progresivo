package main;

// importar las clases necesarias para la prueba
import modelo.Curso;
import modelo.Persona;
import modelo.TipoCarrera;

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

        System.out.println("----------------------------");

        // crear un curso usando el enum TipoCarrera
        Curso curso1 = new Curso("Programacion 1", "PRG101", 4, TipoCarrera.INGENIERIA_SISTEMAS);

        // mostrar la informacion del curso
        curso1.mostrarInfo();

        // inscribir estudiantes al curso
        curso1.inscribirEstudiante("2024001");
        curso1.inscribirEstudiante("2024002");

        // intentar inscribir un estudiante que ya existe
        curso1.inscribirEstudiante("2024001");

        // inscribir con mensaje personalizado usando overloading
        curso1.inscribirEstudiante("2024003", "Bienvenido al curso de Programacion 1");

        System.out.println("----------------------------");

        // mostrar la informacion actualizada del curso
        curso1.mostrarInfo();
    }
}