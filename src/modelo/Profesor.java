package modelo;

// Profesor hereda de Persona, reutiliza nombre, edad e id
public class Profesor extends Persona {

    // guardar el codigo del profesor
    private String codigoProfesor;
    // guardar la especialidad del profesor
    private String especialidad;
    // guardar los años de experiencia del profesor
    private int aniosExperiencia;

    // esto se ejecuta automaticamente antes del constructor
    {
        System.out.println("Nuevo profesor registrado en el sistema");
    }

    // constructor para crear un profesor con sus datos
    public Profesor(String nombre, int edad, String id, String codigoProfesor, String especialidad, int aniosExperiencia) {
        // llamar al constructor de Persona para no repetir codigo
        super(nombre, edad, id);
        // asignar el codigo que me pasan al atributo
        this.codigoProfesor = codigoProfesor;
        // asignar la especialidad que me pasan al atributo
        this.especialidad = especialidad;
        // asignar los años de experiencia que me pasan al atributo
        this.aniosExperiencia = aniosExperiencia;
    }

    // devolver el codigo del profesor
    public String getCodigoProfesor() {
        return codigoProfesor;
    }

    // cambiar el codigo del profesor
    public void setCodigoProfesor(String codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    // devolver la especialidad del profesor
    public String getEspecialidad() {
        return especialidad;
    }

    // cambiar la especialidad del profesor
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // devolver los años de experiencia del profesor
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    // cambiar los años de experiencia del profesor
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    // sobreescribir mostrarInfo de Persona para agregar datos del profesor
    @Override
    public void mostrarInfo() {
        // llamar al mostrarInfo de Persona primero
        super.mostrarInfo();
        System.out.println("Codigo: " + codigoProfesor);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Años de experiencia: " + aniosExperiencia);
    }
}
