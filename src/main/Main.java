package main;

// importar todas las clases necesarias
import java.util.ArrayList;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Persona;
import modelo.Profesor;
import modelo.TipoCarrera;
import servicio.GestorArchivos;
import servicio.GestorUniversidad;

public class Main {

    public static void main(String[] args) {

        // crear el gestor del sistema universitario
        GestorUniversidad gestor = new GestorUniversidad();
        System.out.println("----------------------------");

        // crear estudiantes
        Estudiante estudiante1 = new Estudiante("Jefferson", 19, "002", "2024001", TipoCarrera.INGENIERIA_SISTEMAS);
        Estudiante estudiante2 = new Estudiante("Maria", 20, "003", "2024002", TipoCarrera.MEDICINA);

        // agregar notas a los estudiantes
        estudiante1.agregarNota(85.5);
        estudiante1.agregarNota(90.0);
        estudiante1.agregarNota(78.5);
        estudiante2.agregarNota(95.0);
        estudiante2.agregarNota(88.0);

        // agregar estudiantes al gestor
        gestor.agregarEstudiante(estudiante1);
        gestor.agregarEstudiante(estudiante2);
        System.out.println("----------------------------");

        // crear y agregar un profesor
        Profesor profesor1 = new Profesor("Dr. Martinez", 45, "003", "PRF001", "Programacion", 15);
        gestor.agregarProfesor(profesor1);
        System.out.println("----------------------------");

        // crear y agregar un curso
        Curso curso1 = new Curso("Programacion 1", "PRG101", 4, TipoCarrera.INGENIERIA_SISTEMAS);
        gestor.agregarCurso(curso1);
        System.out.println("----------------------------");

        // inscribir estudiantes en el curso
        curso1.inscribirEstudiante(estudiante1.getCarnet());
        curso1.inscribirEstudiante(estudiante2.getCarnet());
        System.out.println("----------------------------");

        // buscar un estudiante por carnet usando try catch
        try {
            Estudiante encontrado = gestor.buscarEstudiante("2024001");
            System.out.println("Estudiante encontrado: " + encontrado.getNombre());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // intentar buscar un estudiante que no existe
        try {
            Estudiante noExiste = gestor.buscarEstudiante("9999");
            System.out.println("Estudiante encontrado: " + noExiste.getNombre());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("----------------------------");

        // crear el gestor de archivos para persistencia
        GestorArchivos gestorArchivos = new GestorArchivos("estudiantes.txt");

        // guardar los estudiantes en el archivo
        gestorArchivos.guardarEstudiantes(gestor.getEstudiantes());
        System.out.println("----------------------------");

        // cargar los estudiantes desde el archivo
        ArrayList<Estudiante> estudiantesCargados = gestorArchivos.cargarEstudiantes();
        System.out.println("Estudiantes cargados desde archivo: " + estudiantesCargados.size());
        System.out.println("----------------------------");

        // mostrar todos los estudiantes
        gestor.mostrarEstudiantes();

        // mostrar todos los profesores
        gestor.mostrarProfesores();

        // mostrar todos los cursos
        gestor.mostrarCursos();

        // type casting de Estudiante a Persona
        Persona personaCast = (Persona) estudiante1;
        System.out.println("Type casting exitoso: " + personaCast.getNombre());
    }
}