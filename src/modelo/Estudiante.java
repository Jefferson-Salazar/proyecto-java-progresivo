package modelo;

// importar ArrayList para guardar las notas del estudiante
import java.util.ArrayList;

// Estudiante hereda de Persona, reutiliza nombre, edad e id
public class Estudiante extends Persona {

    // guardar el carnet del estudiante
    private String carnet;
    // guardar la carrera del estudiante usando el enum
    private TipoCarrera tipoCarrera;
    // guardar las notas del estudiante en una lista
    private ArrayList<Double> notas;

    // esto se ejecuta automaticamente antes del constructor
    {
        // inicializar la lista de notas vacia
        notas = new ArrayList<>();
        System.out.println("Nuevo estudiante registrado en el sistema");
    }

    // constructor para crear un estudiante con sus datos
    public Estudiante(String nombre, int edad, String id, String carnet, TipoCarrera tipoCarrera) {
        // llamar al constructor de Persona para no repetir codigo
        super(nombre, edad, id);
        // asignar el carnet que me pasan al atributo
        this.carnet = carnet;
        // asignar la carrera que me pasan al atributo
        this.tipoCarrera = tipoCarrera;
    }

    // devolver el carnet del estudiante
    public String getCarnet() {
        return carnet;
    }

    // cambiar el carnet del estudiante
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    // devolver la carrera del estudiante
    public TipoCarrera getTipoCarrera() {
        return tipoCarrera;
    }

    // cambiar la carrera del estudiante
    public void setTipoCarrera(TipoCarrera tipoCarrera) {
        this.tipoCarrera = tipoCarrera;
    }

    // agregar una nota a la lista del estudiante
    public void agregarNota(double nota) {
        // verificar que la nota este en el rango correcto
        if (nota >= 0 && nota <= 100) {
            notas.add(nota);
        } else {
            System.out.println("Nota invalida, debe estar entre 0 y 100");
        }
    }

    // calcular el promedio de todas las notas del estudiante
    public double calcularPromedio() {
        // verificar que haya notas para calcular
        if (notas.isEmpty()) {
            return 0;
        }
        // sumar todas las notas
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        // dividir entre la cantidad de notas y devolver el promedio
        return suma / notas.size();
    }

    // devolver la lista de notas
    public ArrayList<Double> getNotas() {
        return notas;
    }

    // sobreescribir mostrarInfo de Persona para agregar datos del estudiante
    @Override
    public void mostrarInfo() {
        // llamar al mostrarInfo de Persona primero
        super.mostrarInfo();
        System.out.println("Carnet: " + carnet);
        System.out.println("Carrera: " + tipoCarrera);
        System.out.println("Promedio: " + calcularPromedio());
    }
}
