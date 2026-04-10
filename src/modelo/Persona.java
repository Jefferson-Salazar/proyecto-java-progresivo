package modelo;

public class Persona {
    
    // guardar el nombre de la persona
    private String nombre;
    // guardar la edad de la persona
    private int edad;
    // guardar el id de la persona
    private String id;
    
    // esto se ejecuta automaticamente antes del constructor
    {
        System.out.println("Nueva persona creada en el sistema");
    }
    
    // constructor para crear una persona con sus datos
    public Persona(String nombre, int edad, String id) {
        // asignar el nombre que me pasan al atributo de la clase
        this.nombre = nombre;
        // asignar la edad que me pasan al atributo de la clase
        this.edad = edad;
        // asignar el id que me pasan al atributo de la clase
        this.id = id;
    }
    
    // devolver el nombre de la persona
    public String getNombre() {
        return nombre;
    }
    
    // cambiar el nombre de la persona
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // devolver la edad de la persona
    public int getEdad() {
        return edad;
    }
    
    // cambiar la edad de la persona
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    // devolver el id de la persona
    public String getId() {
        return id;
    }
    
    // cambiar el id de la persona
    public void setId(String id) {
        this.id = id;
    }
    
    // mostrar toda la informacion de la persona en pantalla
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("ID: " + id);
    }
}
