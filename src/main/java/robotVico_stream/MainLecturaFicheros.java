/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package robotVico_stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author tomas
 */
public class MainLecturaFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }

    // Con este método voy a leer el fcihero. 
    public static void leerFicheros(String nombrefichero, String formato) {

        // Fichero a leer con datos de ejemplo
        String idFichero = nombrefichero + "." + formato; // nombrefichero.Formatofichero

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        
        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                
                System.out.println("Robot: " + tokens[0] + "- Vida: " + tokens[1]);
                
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    
    

}
