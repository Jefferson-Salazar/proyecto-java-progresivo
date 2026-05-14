package modelo;

// importar ArrayList para guardar lista de carnets
import java.util.ArrayList;

// clase que representa un curso de la universidad
public class Curso {

    // guardar el nombre del curso
    private String nombre;
    // guardar el codigo del curso
    private String codigo;
    // guardar los creditos del curso
    private int creditos;
    // guardar el tipo de carrera al que pertenece el curso
    private TipoCarrera tipoCarrera;
    // guardar la lista de carnets de estudiantes inscritos
    private ArrayList<String> carnetsInscritos;

    // esto se ejecuta automaticamente antes del constructor
    {
        // inicializar la lista de carnets vacia
        carnetsInscritos = new ArrayList<>();
        System.out.println("Nuevo curso creado en el sistema");
    }

    // constructor para crear un curso con sus datos
    public Curso(String nombre, String codigo, int creditos, TipoCarrera tipoCarrera) {
        // asignar el nombre que me pasan al atributo
        this.nombre = nombre;
        // asignar el codigo que me pasan al atributo
        this.codigo = codigo;
        // asignar los creditos que me pasan al atributo
        this.creditos = creditos;
        // asignar el tipo de carrera que me pasan al atributo
        this.tipoCarrera = tipoCarrera;
    }

    // devolver el nombre del curso
    public String getNombre() {
        return nombre;
    }

    // cambiar el nombre del curso
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // devolver el codigo del curso
    public String getCodigo() {
        return codigo;
    }

    // cambiar el codigo del curso
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // devolver los creditos del curso
    public int getCreditos() {
        return creditos;
    }

    // cambiar los creditos del curso
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    // devolver el tipo de carrera del curso
    public TipoCarrera getTipoCarrera() {
        return tipoCarrera;
    }

    // cambiar el tipo de carrera del curso
    public void setTipoCarrera(TipoCarrera tipoCarrera) {
        this.tipoCarrera = tipoCarrera;
    }

    // agregar un carnet a la lista de inscritos
    public void inscribirEstudiante(String carnet) {
        // verificar si el carnet ya esta inscrito
        if (carnetsInscritos.contains(carnet)) {
            System.out.println("El estudiante ya esta inscrito en este curso");
        } else {
            // agregar el carnet a la lista
            carnetsInscritos.add(carnet);
            System.out.println("Estudiante inscrito correctamente");
        }
    }

    // agregar carnet con mensaje personalizado - method overloading
    public void inscribirEstudiante(String carnet, String mensaje) {
        // verificar si el carnet ya esta inscrito
        if (carnetsInscritos.contains(carnet)) {
            System.out.println("El estudiante ya esta inscrito en este curso");
        } else {
            // agregar el carnet a la lista
            carnetsInscritos.add(carnet);
            System.out.println(mensaje);
        }
    }

    // devolver la lista de carnets inscritos
    public ArrayList<String> getCarnetsInscritos() {
        return carnetsInscritos;
    }

    // mostrar toda la informacion del curso en pantalla
    public void mostrarInfo() {
        System.out.println("Curso: " + nombre);
        System.out.println("Codigo: " + codigo);
        System.out.println("Creditos: " + creditos);
        System.out.println("Carrera: " + tipoCarrera);
        // recorrer la lista de carnets inscritos
        System.out.println("Estudiantes inscritos: ");
        for (String carnet : carnetsInscritos) {
            System.out.println("  - " + carnet);
        }
    }
}