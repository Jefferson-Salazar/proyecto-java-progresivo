package main;

// importar las clases necesarias para la prueba
import modelo.Curso;
import modelo.Estudiante;
import modelo.Persona;
import modelo.Profesor;
import modelo.TipoCarrera;

public class Main {

    public static void main(String[] args) {

        // crear un objeto de tipo Persona para probar
        Persona persona1 = new Persona("Carlos", 20, "001");
        persona1.mostrarInfo();
        System.out.println("----------------------------");

        // crear un estudiante que hereda de Persona
        Estudiante estudiante1 = new Estudiante("Jefferson", 19, "002", "2024001", TipoCarrera.INGENIERIA_SISTEMAS);

        // agregar notas al estudiante
        estudiante1.agregarNota(85.5);
        estudiante1.agregarNota(90.0);
        estudiante1.agregarNota(78.5);

        // intentar agregar una nota invalida
        estudiante1.agregarNota(110);

        // mostrar info del estudiante con overriding
        estudiante1.mostrarInfo();
        System.out.println("----------------------------");

        // crear un profesor que hereda de Persona
        Profesor profesor1 = new Profesor("Dr. Martinez", 45, "003", "PRF001", "Programacion", 15);

        // mostrar info del profesor con overriding
        profesor1.mostrarInfo();
        System.out.println("----------------------------");

        // crear un curso y asignarlo
        Curso curso1 = new Curso("Programacion 1", "PRG101", 4, TipoCarrera.INGENIERIA_SISTEMAS);

        // inscribir al estudiante en el curso usando su carnet
        curso1.inscribirEstudiante(estudiante1.getCarnet());

        // mostrar info del curso
        curso1.mostrarInfo();

        // type casting de Estudiante a Persona
        Persona personaCast = (Persona) estudiante1;
        System.out.println("----------------------------");
        System.out.println("Type casting exitoso: " + personaCast.getNombre());
    }
}