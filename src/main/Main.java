package main;

// importar todas las clases necesarias
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Profesor;
import modelo.TipoCarrera;
import servicio.GestorArchivos;
import servicio.GestorUniversidad;

public class Main {

    // crear el scanner para leer la entrada del usuario
    static Scanner scanner = new Scanner(System.in);
    // crear el gestor principal del sistema
    static GestorUniversidad gestor = new GestorUniversidad();
    // crear el gestor de archivos para persistencia
    static GestorArchivos gestorArchivos = new GestorArchivos("estudiantes.txt");

    public static void main(String[] args) {

        // cargar estudiantes guardados anteriormente
        ArrayList<Estudiante> estudiantesCargados = gestorArchivos.cargarEstudiantes();
        // agregar cada estudiante cargado al gestor
        for (Estudiante e : estudiantesCargados) {
            gestor.agregarEstudiante(e);
        }

        // variable para controlar si el usuario quiere salir
        boolean ejecutando = true;

        // mostrar el menu mientras el usuario no salga
        while (ejecutando) {
            System.out.println("\n=============================");
            System.out.println("  SISTEMA UNIVERSITARIO");
            System.out.println("=============================");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar profesor");
            System.out.println("3. Registrar curso");
            System.out.println("4. Inscribir estudiante en curso");
            System.out.println("5. Agregar nota a estudiante");
            System.out.println("6. Buscar estudiante por carnet");
            System.out.println("7. Mostrar todos los estudiantes");
            System.out.println("8. Mostrar todos los profesores");
            System.out.println("9. Mostrar todos los cursos");
            System.out.println("0. Salir y guardar");
            System.out.println("=============================");
            System.out.print("Elige una opcion: ");

            // leer la opcion que elige el usuario
            int opcion = scanner.nextInt();
            scanner.nextLine();

            // ejecutar la accion segun la opcion elegida
            switch (opcion) {
                case 1:
                    // registrar un nuevo estudiante
                    registrarEstudiante();
                    break;
                case 2:
                    // registrar un nuevo profesor
                    registrarProfesor();
                    break;
                case 3:
                    // registrar un nuevo curso
                    registrarCurso();
                    break;
                case 4:
                    // inscribir estudiante en un curso
                    inscribirEstudiante();
                    break;
                case 5:
                    // agregar nota a un estudiante
                    agregarNota();
                    break;
                case 6:
                    // buscar estudiante por carnet
                    buscarEstudiante();
                    break;
                case 7:
                    // mostrar todos los estudiantes
                    gestor.mostrarEstudiantes();
                    break;
                case 8:
                    // mostrar todos los profesores
                    gestor.mostrarProfesores();
                    break;
                case 9:
                    // mostrar todos los cursos
                    gestor.mostrarCursos();
                    break;
                case 0:
                    // guardar estudiantes y salir
                    gestorArchivos.guardarEstudiantes(gestor.getEstudiantes());
                    System.out.println("Datos guardados. Hasta luego!");
                    ejecutando = false;
                    break;
                default:
                    // opcion no valida
                    System.out.println("Opcion no valida, intenta de nuevo");
            }
        }
        // cerrar el scanner al salir
        scanner.close();
    }

    // metodo para registrar un nuevo estudiante
    static void registrarEstudiante() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Carnet: ");
        String carnet = scanner.nextLine();

        // mostrar las carreras disponibles
        System.out.println("Carreras disponibles:");
        // recorrer el enum para mostrar las opciones
        for (TipoCarrera carrera : TipoCarrera.values()) {
            System.out.println("  - " + carrera);
        }
        System.out.print("Carrera (escribe exactamente): ");
        String carreraTexto = scanner.nextLine();

        // intentar crear el estudiante con la carrera elegida
        try {
            // convertir el texto a enum
            TipoCarrera tipoCarrera = TipoCarrera.valueOf(carreraTexto);
            Estudiante estudiante = new Estudiante(nombre, edad, id, carnet, tipoCarrera);
            gestor.agregarEstudiante(estudiante);
        } catch (IllegalArgumentException e) {
            System.out.println("Carrera no valida");
        }
    }

    // metodo para registrar un nuevo profesor
    static void registrarProfesor() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Codigo de profesor: ");
        String codigo = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        System.out.print("Anos de experiencia: ");
        int anios = scanner.nextInt();
        scanner.nextLine();

        // crear el profesor y agregarlo al gestor
        Profesor profesor = new Profesor(nombre, edad, id, codigo, especialidad, anios);
        gestor.agregarProfesor(profesor);
    }

    // metodo para registrar un nuevo curso
    static void registrarCurso() {
        System.out.print("Nombre del curso: ");
        String nombre = scanner.nextLine();
        System.out.print("Codigo del curso: ");
        String codigo = scanner.nextLine();
        System.out.print("Creditos: ");
        int creditos = scanner.nextInt();
        scanner.nextLine();

        // mostrar las carreras disponibles
        System.out.println("Carreras disponibles:");
        for (TipoCarrera carrera : TipoCarrera.values()) {
            System.out.println("  - " + carrera);
        }
        System.out.print("Carrera (escribe exactamente): ");
        String carreraTexto = scanner.nextLine();

        // intentar crear el curso con la carrera elegida
        try {
            TipoCarrera tipoCarrera = TipoCarrera.valueOf(carreraTexto);
            Curso curso = new Curso(nombre, codigo, creditos, tipoCarrera);
            gestor.agregarCurso(curso);
        } catch (IllegalArgumentException e) {
            System.out.println("Carrera no valida");
        }
    }

    // metodo para inscribir un estudiante en un curso
    static void inscribirEstudiante() {
        System.out.print("Carnet del estudiante: ");
        String carnet = scanner.nextLine();
        System.out.print("Codigo del curso: ");
        String codigoCurso = scanner.nextLine();

        // buscar el estudiante y el curso usando try catch
        try {
            Estudiante estudiante = gestor.buscarEstudiante(carnet);
            Curso curso = gestor.buscarCurso(codigoCurso);
            curso.inscribirEstudiante(estudiante.getCarnet());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // metodo para agregar una nota a un estudiante
    static void agregarNota() {
        System.out.print("Carnet del estudiante: ");
        String carnet = scanner.nextLine();

        // buscar el estudiante usando try catch
        try {
            Estudiante estudiante = gestor.buscarEstudiante(carnet);
            System.out.print("Nota (0-100): ");
            double nota = scanner.nextDouble();
            scanner.nextLine();
            estudiante.agregarNota(nota);
            System.out.println("Nota agregada correctamente");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // metodo para buscar un estudiante por carnet
    static void buscarEstudiante() {
        System.out.print("Carnet del estudiante: ");
        String carnet = scanner.nextLine();

        // buscar el estudiante usando try catch
        try {
            Estudiante estudiante = gestor.buscarEstudiante(carnet);
            estudiante.mostrarInfo();
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}