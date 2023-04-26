/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejercicio7d;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tomas
 */
public class Main {

    public static void main(String[] args) {
        // A) Crear un directorio llamado 'copias'

        System.out.println("\n Creo un directorio llamado copias \n");
        String nombreDirectorio = "./copias";
        crearDirectorios(nombreDirectorio);

        System.out.println("\n Copio los archivos al directorio creado \n");
        copiarFicheros(nombreDirectorio);

        // B) Mostrar el contenido de los archivos que hay en el directorio creado previamente. 
        System.out.println("\n Muestro el contenido que hay del directorio creado previamente \n");
        listarDirectorio(nombreDirectorio);

        // C) Creo una lista de vehiculos en la cual meto los vehiculos que leo desde el fichero. 
        // Crear una lista de vehículos para cada tipo de vehículo
        List<Vehiculos> vehiculosDeportivos = new ArrayList<>();
        List<Vehiculos> vehiculosFurgonetas = new ArrayList<>();
        List<Vehiculos> vehiculosTurismos = new ArrayList<>();

        leerFichero(nombreDirectorio + "/vehiculosDeportivos.txt", vehiculosDeportivos);
        leerFichero(nombreDirectorio + "/vehiculosFurgonetas.txt", vehiculosFurgonetas);
        leerFichero(nombreDirectorio + "/vehiculosTurismos.txt", vehiculosTurismos);
        vehiculosDeportivos.forEach(System.out::println);
        vehiculosFurgonetas.forEach(System.out::println);
        vehiculosTurismos.forEach(System.out::println);

    }

    // Es igual que el método anterior pero crea los directorios intermedios// necesarios especificados en la ruta// Si el directorio a crear ya existe no hace nada
    // Método para crear directorios.
    public static void crearDirectorios(String ruta) {
        Path directory = Paths.get(ruta);
        try {
            Files.createDirectories(directory);
            System.out.println("El directorio se ha creado correctamente");
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + e.getMessage());
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }

    }

    // Copio unos ficheros donde el directorio que se ha creado previamente. 
    public static void copiarFicheros(String rutaCopiar) {

        String[] ficheros = {"vehiculosTurismos.txt", "vehiculosDeportivos.txt", "vehiculosFurgonetas.txt"}; // Array con los nombres de los ficheros a copiar

        // Copiar los ficheros uno por uno
        for (String fichero : ficheros) {
            try {
                File origen = new File(fichero); // Fichero de origen
                File destino = new File(rutaCopiar + "/" + fichero); // Fichero de destino con la ruta completa

                Files.copy(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING); // Copiar el fichero con opción de reemplazo si ya existe
                System.out.println("Se ha copiado el fichero " + fichero + " a " + rutaCopiar);
            } catch (IOException e) {
                System.err.println("Error al copiar el fichero " + fichero + ": " + e.getMessage());
            }
        }
    }

    //Veo el contenido que hay de los ficheros. 
    public static void listarDirectorio(String ruta) {

        File f = new File(ruta);
        if (f.exists()) {
            // Obtiene los ficheros y directorios dentro de f y los 
            // devuelve en un array
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println("fichero -> " + file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
    }

    //Método para leer el contenido de los ficheros y ademas los meta dentro de una lista
    public static List<Vehiculos> leerFichero(String rutaFichero, List<Vehiculos> vehiculos) {

        try {
            File fichero = new File(rutaFichero);
            Scanner scanner = new Scanner(fichero);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(":");
                String matricula = datos[0].trim();
                String marca = datos[1].trim();
                String modelo = datos[2].trim();
                String color = datos[3].trim();
                vehiculos.add(new Vehiculos(matricula, marca, modelo, color));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo " + rutaFichero);
        }
        return vehiculos;
    }
}
