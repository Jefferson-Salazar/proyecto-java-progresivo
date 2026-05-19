package servicio;

// importar las clases necesarias
import modelo.Estudiante;
import modelo.Profesor;
import modelo.Curso;
import java.util.ArrayList;

// clase que gestiona toda la logica del sistema universitario
public class GestorUniversidad {

    // guardar la lista de estudiantes registrados
    private ArrayList<Estudiante> estudiantes;
    // guardar la lista de profesores registrados
    private ArrayList<Profesor> profesores;
    // guardar la lista de cursos disponibles
    private ArrayList<Curso> cursos;

    // esto se ejecuta automaticamente antes del constructor
    {
        // inicializar las listas vacias
        estudiantes = new ArrayList<>();
        profesores = new ArrayList<>();
        cursos = new ArrayList<>();
        System.out.println("Sistema universitario iniciado");
    }

    // constructor del gestor
    public GestorUniversidad() {
        System.out.println("Gestor listo para usar");
    }

    // agregar un estudiante a la lista
    public void agregarEstudiante(Estudiante estudiante) {
        // verificar que el estudiante no sea nulo
        if (estudiante == null) {
            throw new IllegalArgumentException("El estudiante no puede ser nulo");
        }
        estudiantes.add(estudiante);
        System.out.println("Estudiante " + estudiante.getNombre() + " agregado correctamente");
    }

    // agregar un profesor a la lista
    public void agregarProfesor(Profesor profesor) {
        // verificar que el profesor no sea nulo
        if (profesor == null) {
            throw new IllegalArgumentException("El profesor no puede ser nulo");
        }
        profesores.add(profesor);
        System.out.println("Profesor " + profesor.getNombre() + " agregado correctamente");
    }

    // agregar un curso a la lista
    public void agregarCurso(Curso curso) {
        // verificar que el curso no sea nulo
        if (curso == null) {
            throw new IllegalArgumentException("El curso no puede ser nulo");
        }
        cursos.add(curso);
        System.out.println("Curso " + curso.getNombre() + " agregado correctamente");
    }

    // buscar un estudiante por su carnet
    public Estudiante buscarEstudiante(String carnet) {
        // recorrer la lista de estudiantes
        for (Estudiante estudiante : estudiantes) {
            // verificar si el carnet coincide
            if (estudiante.getCarnet().equals(carnet)) {
                return estudiante;
            }
        }
        // lanzar excepcion si no se encuentra el estudiante
        throw new RuntimeException("No se encontro ningun estudiante con el carnet: " + carnet);
    }

    // buscar un curso por su codigo
    public Curso buscarCurso(String codigo) {
        // recorrer la lista de cursos
        for (Curso curso : cursos) {
            // verificar si el codigo coincide
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        // lanzar excepcion si no se encuentra el curso
        throw new RuntimeException("No se encontro ningun curso con el codigo: " + codigo);
    }

    // mostrar todos los estudiantes registrados
    public void mostrarEstudiantes() {
        // verificar que haya estudiantes registrados
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados");
            return;
        }
        // recorrer y mostrar cada estudiante
        System.out.println("=== ESTUDIANTES REGISTRADOS ===");
        for (Estudiante estudiante : estudiantes) {
            estudiante.mostrarInfo();
            System.out.println("----------------------------");
        }
    }

    // mostrar todos los profesores registrados
    public void mostrarProfesores() {
        // verificar que haya profesores registrados
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados");
            return;
        }
        // recorrer y mostrar cada profesor
        System.out.println("=== PROFESORES REGISTRADOS ===");
        for (Profesor profesor : profesores) {
            profesor.mostrarInfo();
            System.out.println("----------------------------");
        }
    }

    // mostrar todos los cursos registrados
    public void mostrarCursos() {
        // verificar que haya cursos registrados
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados");
            return;
        }
        // recorrer y mostrar cada curso
        System.out.println("=== CURSOS REGISTRADOS ===");
        for (Curso curso : cursos) {
            curso.mostrarInfo();
            System.out.println("----------------------------");
        }
    }

    // devolver la lista de estudiantes
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    // devolver la lista de profesores
    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    // devolver la lista de cursos
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    
 // buscar un profesor por su codigo
    public Profesor buscarProfesor(String codigo) {
        // recorrer la lista de profesores
        for (Profesor profesor : profesores) {
            // verificar si el codigo coincide
            if (profesor.getCodigoProfesor().equals(codigo)) {
                return profesor;
            }
        }
        // lanzar excepcion si no se encuentra el profesor
        throw new RuntimeException("No se encontro ningun profesor con el codigo: " + codigo);
    }

    // buscar un curso por su codigo
    public Curso buscarCurso1(String codigo) {
        // recorrer la lista de cursos
        for (Curso curso : cursos) {
            // verificar si el codigo coincide
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        // lanzar excepcion si no se encuentra el curso
        throw new RuntimeException("No se encontro ningun curso con el codigo: " + codigo);
    }
}
