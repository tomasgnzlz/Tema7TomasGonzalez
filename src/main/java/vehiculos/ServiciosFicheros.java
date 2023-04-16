/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculos;

import ejerciciopuntoscardinales.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tomas
 */
// Clase con los métodos principales del ejercicio en cuestión. 
public class ServiciosFicheros {

    // Con este método voy a leer el fichero. 
    public static List<String> leerFichero(String ArchivoALeer) {
        // Creo el array donde voy a guardar el contenido al leer el fichero. 
        List<String> contenidoFichero = new ArrayList<>();

        try ( BufferedReader buffer = new BufferedReader(new FileReader(ArchivoALeer))) {
            String contenidoLineaLinea;
            while ((contenidoLineaLinea = buffer.readLine()) != null) { // Si hay lineas dentro del fichero sigue dentro del bucle
                contenidoFichero.add(contenidoLineaLinea); // Estas lineas las meto dentro del array de String creado previamente. 
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return contenidoFichero;
        // Devuelvo una lista con todo el contenido del fichero. 
        // Apartir de ésta lista obtengo lo que busco y saco solo lo que me interesa. 
    }

    public static void crearArchivoDeVehiculos(String nombreArchivo, List<Vehiculos> listaVehiculos) {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Vehiculos v : listaVehiculos) {
                writer.write(v.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se ha creado el archjivo" + e.getMessage());
        }
    }

}
