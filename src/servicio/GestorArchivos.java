package servicio;

// importar las clases necesarias para manejar archivos
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Estudiante;
import modelo.TipoCarrera;

// clase que maneja la persistencia de datos en archivos de texto
public class GestorArchivos {

    // guardar el nombre del archivo donde se guardaran los estudiantes
    private String nombreArchivo;

    // constructor para crear el gestor con el nombre del archivo
    public GestorArchivos(String nombreArchivo) {
        // asignar el nombre del archivo que me pasan
        this.nombreArchivo = nombreArchivo;
        System.out.println("Gestor de archivos listo: " + nombreArchivo);
    }

    // guardar la lista de estudiantes en un archivo de texto
    public void guardarEstudiantes(ArrayList<Estudiante> estudiantes) {
        // intentar escribir en el archivo
        try {
            // crear el escritor del archivo
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));
            // recorrer la lista de estudiantes
            for (Estudiante estudiante : estudiantes) {
                // escribir los datos del estudiante separados por comas
                escritor.write(estudiante.getNombre() + "," +
                               estudiante.getEdad() + "," +
                               estudiante.getId() + "," +
                               estudiante.getCarnet() + "," +
                               estudiante.getTipoCarrera());
                // saltar a la siguiente linea
                escritor.newLine();
            }
            // cerrar el archivo
            escritor.close();
            System.out.println("Estudiantes guardados correctamente en " + nombreArchivo);
        } catch (IOException e) {
            // mostrar error si no se pudo escribir el archivo
            System.out.println("Error al guardar estudiantes: " + e.getMessage());
        }
    }

    // cargar la lista de estudiantes desde el archivo de texto
    public ArrayList<Estudiante> cargarEstudiantes() {
        // crear la lista donde guardaremos los estudiantes cargados
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        // intentar leer el archivo
        try {
            // crear el lector del archivo
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            // guardar cada linea que leemos
            String linea;
            // leer linea por linea hasta que no haya mas
            while ((linea = lector.readLine()) != null) {
                // separar los datos por comas
                String[] datos = linea.split(",");
                // verificar que la linea tenga todos los datos necesarios
                if (datos.length == 5) {
                    // crear el estudiante con los datos leidos
                    String nombre = datos[0];
                    // convertir la edad de texto a numero entero
                    int edad = Integer.parseInt(datos[1]);
                    String id = datos[2];
                    String carnet = datos[3];
                    // convertir el tipo de carrera de texto a enum
                    TipoCarrera tipoCarrera = TipoCarrera.valueOf(datos[4]);
                    // crear el objeto estudiante y agregarlo a la lista
                    Estudiante estudiante = new Estudiante(nombre, edad, id, carnet, tipoCarrera);
                    estudiantes.add(estudiante);
                }
            }
            // cerrar el archivo
            lector.close();
            System.out.println("Estudiantes cargados correctamente desde " + nombreArchivo);
        } catch (IOException e) {
            // mostrar error si no se pudo leer el archivo
            System.out.println("Error al cargar estudiantes: " + e.getMessage());
        }
        // devolver la lista de estudiantes cargados
        return estudiantes;
    }

    // devolver el nombre del archivo
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    // cambiar el nombre del archivo
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
}
